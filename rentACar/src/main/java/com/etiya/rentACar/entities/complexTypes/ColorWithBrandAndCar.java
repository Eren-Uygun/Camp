package com.etiya.rentACar.entities.complexTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorWithBrandAndCar {
	
	private String colorName;
	//private String brandName;
	private int carId;
	private int modelYear;

}
