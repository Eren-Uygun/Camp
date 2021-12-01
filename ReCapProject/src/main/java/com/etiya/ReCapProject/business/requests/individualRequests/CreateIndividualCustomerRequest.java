package com.etiya.ReCapProject.business.requests.individualRequests;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {
	
	@JsonIgnore
	private int id;
	
	@NotNull
	@Size(min = 2,max = 10)
	private String firstName;
	
	@NotNull
	@Size(min = 2,max = 10)
	private String lastName;
	
	@NotNull
	private LocalDate birthdate;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String password;
}
