package com.appsdeveloperblog.photoapp.api.users.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestModel {
	
	@NotBlank @NotNull @Size(min = 2)
	private String firstName;
	@NotBlank @NotNull @Size(min = 2)
	private String lastName;
	@Email @NotNull
	private String email;
	@NotBlank @NotNull @Size(min = 2,max = 16)
	private String password;

}
