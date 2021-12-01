package com.etiya.ReCapProject.business.requests.carMaintenanceRequess;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarMaintenanceRequest {
	
	@NotNull
	private int id;	
	
	@NotNull
	private int carId;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String description;

}
