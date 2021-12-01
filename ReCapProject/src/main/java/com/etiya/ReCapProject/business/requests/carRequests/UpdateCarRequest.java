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
public class UpdateCarRequest {

	@JsonIgnore
	private int id;

	@NotNull
	int colorId;

	@NotNull
	private int brandId;

	@NotNull
	@Min(10)
	@Max(1000)
	private double dailyPrice;

	@NotNull
	@Min(500)
	@Max(1000)
	private int findexScore;

	@NotNull
	private int modelYear;

	@NotNull
	@NotBlank
	@Size(min = 3, max = 20)
	private String description;

}
