package com.etiya.rentACar.business.requests.carRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	
	private int id;
	private int brandId;
	private int colorId;
	private int modelYear;
	private double dailyPrice;
	private String description;

}
