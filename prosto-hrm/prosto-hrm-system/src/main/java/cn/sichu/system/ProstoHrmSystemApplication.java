package cn.sichu.system;

import cn.sichu.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("cn.sichu.model")
@ComponentScan(basePackages = "cn.sichu")
public class ProstoHrmSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProstoHrmSystemApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
