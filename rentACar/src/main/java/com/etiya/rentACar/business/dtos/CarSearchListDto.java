package com.etiya.rentACar.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchListDto {
	
	
	private int carId;

	private int brandId;
	
	private int colorId;
	
	private int modelYear;

	private double dailyPrice;
	
	private String description;
	

}
