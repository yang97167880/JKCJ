package com.jkcj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther:Xhy
 * @Date:2020/2/17 20:49
 * @Description:
 **/
@RestController
@MapperScan("com.jkcj.dao")
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.jkcj"})
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}
