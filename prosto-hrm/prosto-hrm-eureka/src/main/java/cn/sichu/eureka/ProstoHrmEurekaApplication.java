package cn.sichu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author sichu
 * @date 2023/01/17
 **/
@SpringBootApplication
@EnableEurekaServer
public class ProstoHrmEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProstoHrmEurekaApplication.class, args);
    }
}
