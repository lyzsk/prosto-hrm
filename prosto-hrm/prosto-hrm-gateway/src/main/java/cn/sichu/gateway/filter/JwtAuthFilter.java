package cn.sichu.gateway.filter;

import cn.sichu.common.api.Result;
import cn.sichu.gateway.config.AuthFilterConfig;
import cn.sichu.gateway.utils.JwtUtil;
import cn.sichu.gateway.utils.PathUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * 过滤器验证token
 * 根据yml判断uri是否需要身份验证,
 * 判断token验证是否通过，通过则路由，不通过返回错误提示
 *
 * @author sichu
 * @date 2023/01/18
 **/
@Component
@Slf4j
public class JwtAuthFilter extends ZuulFilter {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthFilterConfig authFilterConfig;

    /**
     * 拦截类型是FilterConstants.PRE_TYPE，在调用业务接口之前拦截
     *
     * @return FilterConstants.PRE_TYPE
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤顺序, 参考 https://blog.csdn.net/u010963948/article/details/100146656
     *
     * @return 2
     */
    @Override
    public int filterOrder() {
        return 2;
    }

    /**
     * 逻辑判断是否要过滤
     *
     * @return true/false
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        for (String url : authFilterConfig.getAuthUrls()) {
            if (PathUtil.isPathMatch(url, ctx.getRequest().getRequestURI())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证token
     *
     * @return null
     * @throws ZuulException ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // String token = request.getHeader(Consts.JWT_HEADER);
        String token = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        Claims claims;
        try {
            claims = jwtUtil.parseToken(token);
            log.info("token验证通过");
            // 对请求进行路由
            ctx.setSendZuulResponse(true);
            Long id = (Long)claims.get("id");
            // 请求头加入user id, 传给业务服务
            ctx.addZuulRequestHeader("id", id.toString());
        } catch (ExpiredJwtException expiredJwtException) {
            log.error("token过期");
            // token过期, 不对请求进行路由
            ctx.setSendZuulResponse(false);
            responseError(ctx, -402, "token expired");
        } catch (Exception e) {
            log.error("token验证失败");
            ctx.setSendZuulResponse(false);
            responseError(ctx, -401, "invalid token");
        }
        return null;
    }

    /**
     * 将异常信息响应给前端
     *
     * @param ctx     request context
     * @param code    code
     * @param message message
     */
    private void responseError(RequestContext ctx, int code, String message) {
        HttpServletResponse response = ctx.getResponse();
        Result errorResult = new Result();
        errorResult.setCode(code);
        errorResult.setMessage(message);
        ctx.setResponseBody(toJsonString(errorResult));
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json;charset=utf-8");
    }

    /**
     * 序列化json to string
     *
     * @param obj obj
     * @return string
     */
    private String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json序列化失败", e);
            return null;
        }
    }
}
