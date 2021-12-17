package com.appsdeveloperblog.rentacar.api.rental.cqrsPackage.features.restModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRestModel {
	
	
	private int carId;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private int rentKilometer;
	private int returnKilometer;

}
