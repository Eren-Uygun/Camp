package com.appsdeveloperblog.rentacar.users.business.requests.individualRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
}
