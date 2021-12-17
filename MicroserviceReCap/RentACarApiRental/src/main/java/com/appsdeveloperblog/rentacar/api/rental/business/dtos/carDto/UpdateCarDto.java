package com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarDto {
	
	@NotNull @Positive
	private int id;
	@NotNull @Positive
	private int brandId;
	@NotNull @Positive
	private int colorId;
	@NotNull @PositiveOrZero
	private double dailyPrice;
	@Min(1890) @Max(2021)
	private int modelYear;
	@Size(min = 2,max = 25)
	private String description;

}
