package com.example.Laptop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
/*
html: http://localhost:8082/swagger-ui/index.html
Json: http://localhost:8082/v2/api-docs
 */

@EnableSwagger2
@EnableWebMvc
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails() {
        return new ApiInfo("Documentacion oficial de Softvert",
                "En esta pagina encuentas informacion para realiza la consumicion de la API REST",
                "1.0",
                "http://www.softvert.net",
                new Contact("Cosme","http://www.softvert.net","cosmedam26@gmail.com"),
                "premiun",
                "http://www.softvert.net",
                Collections.emptyList());
    }
}
