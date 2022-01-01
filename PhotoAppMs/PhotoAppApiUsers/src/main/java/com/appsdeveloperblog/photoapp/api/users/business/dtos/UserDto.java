package com.appsdeveloperblog.photoapp.api.users.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	//Data transformation object -> Veri dönüşüm nesneleri Veri çekerken veya veri gönderirken istediğimiz şekle dönüştürmek için kullanılır.
	//Dto'da validation veri tabanından veri döndüğü zaman bir sıkıntı oluyorsa diye validasyon burada yapılabilir.
	
	
	private String userId;
	
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private String encryptedPassword;
	


}
