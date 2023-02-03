package cn.sichu.common.shiro.session;

import cn.sichu.common.constant.Consts;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * 自定义shiro会话管理
 *
 * @author sichu
 * @date 2023/01/19
 **/
public class CustomSessionManager extends DefaultWebSessionManager {
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        // 获取request header Authorization中的数据
        String sessionId = WebUtils.toHttp(request).getHeader(Consts.AUTHORIZATION_HEADER);
        if (StringUtils.isEmpty(sessionId)) {
            return super.getSessionId(request, response);
        } else {
            // 请求头中数据: Bearer sessionId
            sessionId = sessionId.replaceAll(Consts.BEARER_PREFIX, "");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;
        }
    }
}
