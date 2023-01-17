package cn.sichu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author sichu
 * @date 2023/01/17
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ProstoHrmGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProstoHrmGatewayApplication.class, args);
    }
}
