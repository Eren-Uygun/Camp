package com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteColorDto {
	
	@NotNull @Positive
	private int id;

}
