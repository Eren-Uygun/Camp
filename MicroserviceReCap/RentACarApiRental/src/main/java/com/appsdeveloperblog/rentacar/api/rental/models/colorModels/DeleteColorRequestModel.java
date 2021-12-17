package com.appsdeveloperblog.rentacar.api.rental.models.colorModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteColorRequestModel {
	
	@NotNull
	private int id;

}
