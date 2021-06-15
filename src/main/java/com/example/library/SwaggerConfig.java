package com.example.library;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration// A must. If not exist, the swagger is not configured, the changes below will not reflect so it will be default ui.
public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.example.library"))
                    .paths(PathSelectors.ant("/*/*"))
                    .build()
                    .apiInfo(apiDetails());
        }

        private ApiInfo apiDetails(){
            return new ApiInfo(
                    "Library API",
                    "Application for borrowing books from the library",
                    "1.0",
                    "https://youtube.com",
                    "Ali dogan",
                    "API License",
                    "https://github.com"
                    );
        }
}
