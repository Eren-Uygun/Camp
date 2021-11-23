package com.etiya.rentACar;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.etiya.rentACar.core.utilities.results.ErrorDataResult;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestControllerAdvice
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException argumentNotValidException){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : argumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors,"Validation Errors");
		
		return errorDataResult;
		
		
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