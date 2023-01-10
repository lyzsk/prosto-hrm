package cn.sichu.security.component;

import cn.hutool.json.JSONUtil;
import cn.sichu.common.api.Result;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义没有权限访问时 AccessDenied 返回结果
 *
 * @author sichu
 * @date 2023/01/10
 **/
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
        AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(Result.unauthorized(accessDeniedException.getMessage())));
        response.getWriter().flush();
    }
}
