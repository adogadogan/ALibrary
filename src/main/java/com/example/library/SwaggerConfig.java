package com.example.library;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@SecurityScheme(name = "mySecurityScheme", type= SecuritySchemeType.HTTP,
                bearerFormat = "JWT",scheme = "bearer")
public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.OAS_30)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.example.library"))
                    .paths(PathSelectors.ant("/*/*"))
                    .build()
                    .apiInfo(apiDetails());
        }

        private ApiInfo apiDetails(){
            return new ApiInfoBuilder()
                    .title("library API")
                    .version("1.0.1")
                    .build();//more detail can be added
        }
}
