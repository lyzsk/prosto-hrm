package cn.sichu.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringSecurity 白名单资源路径配置
 *
 * @author sichu
 * @date 2023/01/10
 **/
@ConfigurationProperties(prefix = "security.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
