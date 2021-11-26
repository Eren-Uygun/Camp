package com.etiya.rentACar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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
import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACar.core.utilities.results.ErrorDataResult;
import com.etiya.rentACar.core.utilities.results.ErrorResult;

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
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResult handleValidationException(NoSuchElementException noSuchElementException){
		
		ErrorResult errorResult = new ErrorResult("Kayıt bulunamadı.");
		
		return errorResult;
		
		
		
	}
	
	
	
	// Araca resim yüklecektir
	/**
	 * bir aracın birden fazla resmi olabilir.
	 * Resim Crud
	 * Apiden REsim yükleme
	 * default resimi göndereceğiz.
	 * Bir arabanın en fazla 5 resmi olabilir.
	 * apiye image ekleme ve img gönderme.
	 * listelenirkende image dönecek
	 */
	
	
	
	//Max normalizasyonlu bir tabloda kaç kolon olabilir. => 2
	
	
	
	
	
	
	//Login / register user serviceden true yada false dönecek.
	//Findex puanını sorgulayacak sahte servis eklenecek.
	
	
	
	
	
	
	

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