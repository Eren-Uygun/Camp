package com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateCustomerRequest {
	
	
	@NotNull
	private int id;
	
	@NotNull@NotBlank
	@Size(min=2,max = 25)
	private String companyName;
	
	@NotNull@NotBlank
	@Size(min=10,max = 10)
	private String taxNumber;
	
	@Email
	private String email;
	@Size(min = 6,max = 20)
	private String password;
	

}
