package com.etiya.rentACar.business.requests.individualCustomerRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate birthDate;

}
