package com.appsdeveloperblog.rentacar.api.rental.cqrsPackage.features.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Aggregate
public class CreateRentalAggregate {
	
	@AggregateIdentifier
	private String rentalId;
	private int carId;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private int rentKilometer;
	private int returnKilometer;

	public CreateRentalAggregate() {
		
	}
	
	@CommandHandler
	public CreateRentalAggregate(CreateRentalCommand createRentalCommand) {
		
		if (createRentalCommand.getCarId()<1) {
			throw new IllegalArgumentException("Araba listede yok");
		}
		
		
		
		
		RentalCreatedEvent rentalCreatedEvent = new RentalCreatedEvent();
		BeanUtils.copyProperties(createRentalCommand, rentalCreatedEvent);
		AggregateLifecycle.apply(rentalCreatedEvent);
		
		
	}
	
	
	@EventSourcingHandler
	public void on(RentalCreatedEvent createdEvent) {
		this.carId = createdEvent.getCarId();
		this.rentalId = createdEvent.getRentalId();
		this.rentDate = createdEvent.getRentDate();
		this.returnDate = createdEvent.getReturnDate();
		this.rentKilometer = createdEvent.getRentKilometer();
		this.returnKilometer = createdEvent.getReturnKilometer();
		
	}
	

}
