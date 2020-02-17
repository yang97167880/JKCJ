package com.jkcj.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Hashtable;

/**
 * @author Ck
 * Swagger2 配置类
 */
@Configuration
public class Swagger {
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("API list and test")
                        .description("积坑沉降-API文档")
                        .termsOfServiceUrl("http://localhost:8088/swagger-ui.html")
                        .version("1.0.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jkcj"))
                .paths(PathSelectors.any())
                .build();
    }
}
