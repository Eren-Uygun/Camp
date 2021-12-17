package com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteBrandDto {
	
	@NotNull @Positive
	private int id; 

}
