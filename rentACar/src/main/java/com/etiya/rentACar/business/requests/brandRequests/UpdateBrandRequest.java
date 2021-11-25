package com.etiya.rentACar.business.requests.brandRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
	
	@NotNull
	@Min(1)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2,max = 50)
	private String brandName;

}
