package com.etiya.rentACar.business.requests.carRequests;

import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	
	private int brandId;
	private int colorId;
	private int modelYear;
	private double dailyPrice;
	private String description;	

}
