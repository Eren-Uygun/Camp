package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create;

import lombok.Data;

@Data
public class AccountTypeCreatedEvent {
	//Event yazarken önce nesnenin adı ne ona bakılır sonra bu nesne ile ne yapılmış geçmiş zamandaki versiyonu ile yazılır.
	//Örnek class Adı
	
	//Event'de final keywordü değişiklik yapma gereksinimi ortaya çıkabileceğinden kullanılmaz.
	
	private String accountTypeId;
	private String accountName; 
	private double price;
	private String description;
	
	
	
	
	
	
	

}
