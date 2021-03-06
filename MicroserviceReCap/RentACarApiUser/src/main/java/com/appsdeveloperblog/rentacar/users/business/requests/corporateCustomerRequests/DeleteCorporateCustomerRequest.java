package com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCorporateCustomerRequest {

	@NotNull
	private int customerId;
}
