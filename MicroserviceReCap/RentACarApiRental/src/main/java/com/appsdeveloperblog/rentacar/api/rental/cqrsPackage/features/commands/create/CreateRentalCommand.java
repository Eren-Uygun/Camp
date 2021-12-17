package com.appsdeveloperblog.rentacar.api.rental.cqrsPackage.features.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Data
@Builder
public class CreateRentalCommand {
	
	@TargetAggregateIdentifier
	private final String rentalId;
	private final int carId;
	private final LocalDate rentDate;
	private final LocalDate returnDate;
	private final int rentKilometer;
	private final int returnKilometer;
	
	
	

}
