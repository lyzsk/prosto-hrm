package cn.sichu.system;

import cn.sichu.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sichu
 */
@SpringBootApplication
@EntityScan("cn.sichu.model")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ProstoHrmSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProstoHrmSystemApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
