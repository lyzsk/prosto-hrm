package cn.sichu.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sichu
 * @date 2023/01/18
 **/
@Component
@ConfigurationProperties(prefix = "auth-filter", ignoreUnknownFields = false)
public class AuthFilterConfig {

    /**
     * 需要验证token的请求地址, 会触发JwtAuthFilter, 验证token
     */
    private List<String> authUrls;

    /**
     * 登录请求地址, 会触发LoginFilter, 生成token
     */
    private List<String> loginUrls;

    public AuthFilterConfig() {
    }

    public AuthFilterConfig(List<String> authUrls, List<String> loginUrls) {
        this.authUrls = authUrls;
        this.loginUrls = loginUrls;
    }

    public List<String> getAuthUrls() {
        return authUrls;
    }

    public void setAuthUrls(List<String> authUrls) {
        this.authUrls = authUrls;
    }

    public List<String> getLoginUrls() {
        return loginUrls;
    }

    public void setLoginUrls(List<String> loginUrls) {
        this.loginUrls = loginUrls;
    }

    @Override
    public String toString() {
        return "AuthFilterConfig{" + "authUrls=" + authUrls + ", loginUrls=" + loginUrls + '}';
    }
}
