package com.etiya.northwindSpring;

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

import com.etiya.northwindSpring.core.utils.results.ErrorDataResult;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.http.HttpStatus;

@SpringBootApplication //@ile başlayan bölüm anotasyondur.
@EnableSwagger2
@RestControllerAdvice //Aop'u aktive etmek için
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
	
	//Global exception handling - AOP
	
	@ExceptionHandler(MethodArgumentNotValidException.class) // İlgili hata geldiği zaman globalde calısmaya başlar.
	@ResponseStatus(HttpStatus.BAD_REQUEST) //metot içinde code bölümü içinde de yazabiliriz.
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		
		//methodArgumentNotValidException.getBindingResult().getFieldErrors(); //Tüm hataları array olarak verir.
		
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	
		}
	
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors,"Validation Errors");
		return errorDataResult;
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



//Validation : Verinin doğrulanması
//Validation elimizdeki verinin yapısallığı ile ilgilenir. örn field'lerin zorunlu olması

//Örn business'de araba alıcak kişinin skorunun kontrol edilmesi

//Validasyon crud işlemi yapıcak request dto gibi yapılara eklenmelidir.

//Aop nedir -> uygulamada metot calısmadan önce yada calıstıkdan sonra yada calısırken kontrol eden yapı


