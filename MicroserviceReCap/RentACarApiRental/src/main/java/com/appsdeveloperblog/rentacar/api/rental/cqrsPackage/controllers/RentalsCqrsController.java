package com.appsdeveloperblog.rentacar.api.rental.cqrsPackage.controllers;

import com.appsdeveloperblog.rentacar.api.rental.cqrsPackage.features.commands.create.CreateRentalCommand;
import com.appsdeveloperblog.rentacar.api.rental.cqrsPackage.features.restModels.CreateRentalRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/rentalscqrs")
public class RentalsCqrsController {
	
	private CommandGateway commandGateway;

	@Autowired
	public RentalsCqrsController(CommandGateway commandGateway) {
		super();
		this.commandGateway = commandGateway;
	}
	
	@PostMapping
	public String createRental(@RequestBody CreateRentalRestModel createRentalRestModel) {
		CreateRentalCommand command = CreateRentalCommand.builder()
				.rentalId(UUID.randomUUID().toString())
				.carId(createRentalRestModel.getCarId())
				.rentDate(LocalDate.now())
				.returnDate(null)
				.rentKilometer(0)
				.returnKilometer(0).build();
		
		String returnValue = this.commandGateway.sendAndWait(command);
		return returnValue;
	}
	
	
	
	

}
