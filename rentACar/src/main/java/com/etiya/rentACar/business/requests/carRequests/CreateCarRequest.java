package com.etiya.rentACar.business.requests.carRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	@NotNull
	private int brandId;
	@NotNull
	@Min(1)
	private int colorId;
	@NotNull
	@PastOrPresent
	private int modelYear;
	
	@Min(0)
	private double dailyPrice;
	
	@NotNull
	@NotBlank
	@Size(min = 2,max = 20)
	private String description;	

}
