package com.recapProject.WoodWorldBeta.utils.configurations.swaggerConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2 3.0.0 ile bu anotasyonu yazmamıza gerek kalmadı.
public class SwaggerConfg {

    //spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER -> 3.0.0'da eklendiği takdirde proje ayağa kalkıyor. Yoksa Nullpointer Exception

    //http://localhost:8080/swagger-ui/ -> Yeni Swagger 3.0.0 adresi

    @Bean(name = "SwaggerApi")
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.recapProject.WoodWorldBeta"))
                .paths(PathSelectors.any())
                .build();
    }


}
