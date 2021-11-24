package com.etiya.rentACar.business.requests.individualCustomerRequests;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
	
	@NotBlank@NotNull@Size(min = 2,max = 30)
	private String firstName;
	@NotBlank@NotNull@Size(min = 2,max = 30)
	private String lastName;
	@Email@NotBlank@NotNull
	private String email;
	@NotBlank@NotNull@Size(min = 6,max = 30)
	private String password;
	@Past
	private LocalDate birthDate;

}
