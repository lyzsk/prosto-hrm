package cn.sichu.security.config;

import cn.sichu.security.component.AccessDeniedHandler;
import cn.sichu.security.component.AuthenticationEntryPoint;
import cn.sichu.security.component.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity 相关配置, 仅用于配置 SecurityFilterChain
 * <p>
 * TODO: 添加 dynamicSecurityService 和 dynamicSecurityFilter
 *
 * @author sichu
 * @date 2023/01/10
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
            httpSecurity.authorizeRequests();
        // 白名单
        for (String url : ignoreUrlsConfig.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        // 允许跨域请求的 OPTIONS 请求
        registry.antMatchers(HttpMethod.OPTIONS).permitAll();
        registry.and().authorizeRequests().anyRequest().authenticated()
            // 关闭跨域保护, 不使用 session
            .and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            // 自定义权限 accessDeniedHandler
            .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
            .authenticationEntryPoint(authenticationEntryPoint)
            // 自定义权限filter
            .and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
