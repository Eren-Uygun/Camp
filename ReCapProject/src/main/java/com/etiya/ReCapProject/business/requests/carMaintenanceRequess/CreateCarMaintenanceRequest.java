package com.etiya.ReCapProject.business.requests.carMaintenanceRequess;


import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarMaintenanceRequest {
	
	@NotNull
	private int car_Id;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String description;


	@FutureOrPresent
	private LocalDate returnDate;

}
