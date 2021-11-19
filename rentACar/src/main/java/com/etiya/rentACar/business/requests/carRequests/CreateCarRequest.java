package com.etiya.rentACar.business.requests.carRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	private int brandId;
	private int colorId;
	private int year;
	private double dailyPrice;
	private String description;
	

}
