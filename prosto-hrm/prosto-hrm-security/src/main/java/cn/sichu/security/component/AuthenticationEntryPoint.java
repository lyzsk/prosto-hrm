package cn.sichu.security.component;

import cn.hutool.json.JSONUtil;
import cn.sichu.common.api.Result;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义未登录或登陆过期的返回结果
 *
 * @author sichu
 * @date 2023/01/10
 **/
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(Result.unauthenticated(authException.getMessage())));
        response.getWriter().flush();
    }
}
