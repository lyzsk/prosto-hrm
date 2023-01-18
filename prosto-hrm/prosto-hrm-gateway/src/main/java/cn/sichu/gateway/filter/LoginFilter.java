package cn.sichu.gateway.filter;

import cn.sichu.common.api.Result;
import cn.sichu.common.api.ResultCode;
import cn.sichu.common.constant.Consts;
import cn.sichu.gateway.config.AuthFilterConfig;
import cn.sichu.gateway.utils.JwtUtil;
import cn.sichu.gateway.utils.PathUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义过滤器
 * 拦截登录方法，登录成功时创建token，返回给前端
 *
 * @author sichu
 * @date 2023/01/17
 **/
@Component
@Slf4j
public class LoginFilter extends ZuulFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthFilterConfig authFilterConfig;

    /**
     * pre: 在执行路由请求之前执行
     * routing: 在路由请求时调用
     * post: 在routing和error过滤器之后执行
     * error: 处理请求出现异常的时候执行
     *
     * @return FilterConstants.POST_TYPE，在路由方法响应之后拦截
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 定义过滤器的优先级: 数字越小, 优先级越高
     *
     * @return 过滤器的优先级
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 2;
    }

    /**
     * 判断过滤器是否需要执行
     *
     * @return true/false
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        for (String url : authFilterConfig.getLoginUrls()) {
            if (PathUtil.isPathMatch(url, ctx.getRequest().getRequestURI())) {
                log.info("路径: {} 需要生成token, 执行LoginFilter", url);
                return true;
            }
        }
        return false;
    }

    /**
     * 过滤器中负责的具体业务逻辑:
     * 登陆成功时给响应内容增加token
     *
     * @return 返回null, 继续向后执行
     * @throws ZuulException ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            InputStream inputStream = ctx.getResponseDataStream();
            String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            log.info("body内容: {}", body);
            Result<Map<String, Object>> result =
                objectMapper.readValue(body, new TypeReference<Result<Map<String, Object>>>() {
                });
            // 如果Result是成功
            if (result.getCode() == ResultCode.SUCCESS.getCode()) {
                Map<String, Object> jwtClaims = new HashMap<String, Object>(2) {{
                    put("id", result.getData().get("id"));
                }};
                Calendar calendar = Calendar.getInstance();
                Date currentTime = new Date();
                calendar.setTime(currentTime);
                calendar.add(Calendar.DATE, 7);
                Date expTime = calendar.getTime();
                // response body 添加 token
                String token = jwtUtil.generateToken(expTime, jwtClaims);
                result.getData().put("token", token);
                log.info("登陆后返回的json型result: {}", result);
                // 序列化 response body json
                body = objectMapper.writeValueAsString(result);
                // 添加到response body中
                ctx.setResponseBody(body);
                // response header 设置 token
                ctx.addZuulResponseHeader(Consts.JWT_HEADER, token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
