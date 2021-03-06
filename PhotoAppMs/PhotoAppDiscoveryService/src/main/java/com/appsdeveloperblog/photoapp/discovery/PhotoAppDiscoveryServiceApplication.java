package com.appsdeveloperblog.photoapp.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoAppDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppDiscoveryServiceApplication.class, args);
	}

}


//Ms'de yükü dağıtıp küçültme işlemine scaling deniyor bunuda kubernetes ile yapıyoruz.

//Sadece discovery service olarak eureka kullanılmaz, ancak şuan'da en çok kullanılan eureka ds dir.








//21-12-2021 Ödevler

/*Lambda Expression
 *Stream Api 
 * Java Multithreading & Concurency
 */



/*22-12-2021 
 * SQL ve Modelleme konuları -> Çok dil desteği */


//27-12 itibariyle RentACar a dönüş olucak ve bitirme hazırlıkları yapılacak.