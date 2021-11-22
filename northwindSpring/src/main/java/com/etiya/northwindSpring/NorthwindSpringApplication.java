package com.etiya.northwindSpring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //@ile başlayan bölüm anotasyondur.
@EnableSwagger2
public class NorthwindSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindSpringApplication.class, args);
	}
	
	//Nesne oluşturur request geldiği zaman verir. @Bean
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.etiya.northwindSpring")).build();
	   }
	
	@Bean
	public ModelMapper getModelMapper() {
		//return new ModelMapper(); çalışıyor.
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}

//Jsp = .Net de Asp nin karşılığı

//LSP:Sırf nesneler birbirine benziyor diye aynı özelliklere sahip olacak değildir.

//Veri tabanı ilişkileri

/*
 * Örneğin Bir kategorinin ürünleri vardır. 1'e Çok ilişki
 * 
 * 
 */




