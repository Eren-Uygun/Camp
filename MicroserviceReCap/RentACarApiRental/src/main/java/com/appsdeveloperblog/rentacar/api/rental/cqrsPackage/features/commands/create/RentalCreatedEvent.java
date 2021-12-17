package com.appsdeveloperblog.rentacar.api.rental.cqrsPackage.features.commands.create;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalCreatedEvent {

	private String rentalId;
	private int carId;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private int rentKilometer;
	private int returnKilometer;

}
