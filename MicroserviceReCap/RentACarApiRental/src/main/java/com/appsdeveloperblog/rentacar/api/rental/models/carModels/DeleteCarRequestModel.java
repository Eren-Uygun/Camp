package com.appsdeveloperblog.rentacar.api.rental.models.carModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCarRequestModel {
	
	@NotNull
	private int id;

}
