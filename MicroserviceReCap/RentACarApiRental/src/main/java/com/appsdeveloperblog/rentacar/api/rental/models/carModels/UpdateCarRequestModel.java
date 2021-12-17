package com.appsdeveloperblog.rentacar.api.rental.models.carModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequestModel {
	
	@NotNull @Positive
	private int id;
	@NotNull @Positive
	private int brandId;
	@NotNull @Positive
	private int colorId;
	@PositiveOrZero @NotNull
	private double dailyPrice;
	@Min(value = 1890) @Max(value = 2021)
	private int modelYear;
	@Size(min = 2,max = 50)
	private String description;

}
