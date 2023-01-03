package cn.sichu.company;

import cn.sichu.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * 1. 配置SpringBoot包扫描
 * 2. 配置JPA注解的扫描
 *
 * @author sichu
 * @date 2023/01/03
 **/
@SpringBootApplication(scanBasePackages = "cn.sichu")
@EntityScan(value = "cn.sichu.domain.company")
public class ProstoHrmCompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProstoHrmCompanyApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
