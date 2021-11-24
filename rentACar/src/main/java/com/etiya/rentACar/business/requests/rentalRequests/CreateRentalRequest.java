package com.etiya.rentACar.business.requests.rentalRequests;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
	
	@JsonIgnore
	private int id;
	
	@NotNull
	@Min(1)
	private int individualCustomerId;
	@NotNull
	@Min(1)
	private int carId;
	@PastOrPresent
	private LocalDate rentDate;
	@FutureOrPresent
	private LocalDate returnDate;

}
