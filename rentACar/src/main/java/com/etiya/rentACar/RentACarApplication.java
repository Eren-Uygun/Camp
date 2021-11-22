package com.etiya.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	@Bean
	   public Docket rentACarApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.etiya.rentACar")).build();
	   }
	
	@Bean
	public ModelMapper getModelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
//RentACar için
//Swagger Desteği,Dto,Request desteği(Model Mapper)
//Brand,car,color -> GetAll,Add,Update,Delete
//Tüm Operasyonlar REsult sitemli olacak.

/*//http://localhost:8080/api/products/check
//Car,Brand,Color Join--> CarId, BrandName,ColorName, DailyPrice , ModelYear, Description
//Tüm Crud operasyonları çalışsın
//Tüm operasyonlar Result destekli olacak
//GetByBrandName-->Car,Brand,Color Join--> CarId, BrandName,ColorName, DailyPrice , ModelYear, Description
*/

//Car,Brand,Color Join --> CardId,BrandName,ColorName,DailyPrice,ModelYear,Description

//GetByBrandName gibi sorgular yazarak branddeki araçları getireceğiz.