package com.bestpractiseworkshop.recap2.core.configurations.swaggerConfigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    
    @Bean(name = "Swagger-Api")
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bestpractiseworkshop.recap2"))
               //.paths(PathSelectors.any())
                .build();
    }
}
