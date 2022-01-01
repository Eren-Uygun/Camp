package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountTypeRestModel {
	
	private String accountName; //Free,Business,Team,Family
	private double price; //BigDecimal'da olabilir büyük fiyatlar olabileceği zaman
	private String description;

}
