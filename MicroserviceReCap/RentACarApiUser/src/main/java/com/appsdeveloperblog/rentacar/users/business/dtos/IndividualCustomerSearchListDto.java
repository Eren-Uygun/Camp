package com.appsdeveloperblog.rentacar.users.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomerSearchListDto {
	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private String email;
	private String password;
	
	
}
