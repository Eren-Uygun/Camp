package com.etiya.ReCapProject.business.requests.carRequests;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    
    @JsonIgnore
    private int id;
	
    int colorId;
	private int brandId;
	@NotNull
	@Min(10)
	@Max(1000)
	private double dailyPrice;
	
	@NotNull
	@Min(0)
	@Max(1900)
	private int findexScore;
	
	@NotNull
	private int modelYear;
	
	@NotNull
	@NotBlank
	@Size(min = 3,max = 20)
	private String description;

	@NotNull
	private int kilometer;

}
