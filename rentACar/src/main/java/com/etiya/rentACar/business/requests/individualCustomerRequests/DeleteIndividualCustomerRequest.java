package com.etiya.rentACar.business.requests.individualCustomerRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteIndividualCustomerRequest {
	@NotNull
	@Min(1)
	private int id;

}
