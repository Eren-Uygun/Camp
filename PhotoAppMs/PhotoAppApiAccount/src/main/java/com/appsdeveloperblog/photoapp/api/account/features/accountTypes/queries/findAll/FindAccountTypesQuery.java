package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.findAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FindAccountTypesQuery {
	
	private String accountName; 
	private double price; 
	private String description;


}
