package com.appsdeveloperblog.rentacar.api.rental.models.carModels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequestModel {
	
	@JsonIgnore
	private int id;
	
	@NotNull @Positive
	private int brandId;
	@NotNull @Positive
	private int colorId;
	@NotNull @Min(0) @PositiveOrZero
	private double dailyPrice;
	@Min(value = 1890) @Max(value = 2021)
	private int modelYear;
	@Size(min = 2,max = 50 )
	private String description;

}
