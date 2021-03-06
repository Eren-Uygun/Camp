package com.appsdeveloperblog.photoapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}


//Kural kontrollerini gateway' de yaparız. ÖRn token doğru mu ?
//Json Validation

//Gateway giriş kapısıdır.Bir güvenlikli sitenin girşi gibi örneklendirilebilir.
//Gateway ne yapabilir -> örn Jwt doğrulaması yapılabilir.


//Gateway'lar her zaman sabit bir  port'a sahip olmalıdır.

//Token secretimizi kimsenin bilmemesi gerekir.
//Gelecek requestleri bile sınırlamamız gereklidir.