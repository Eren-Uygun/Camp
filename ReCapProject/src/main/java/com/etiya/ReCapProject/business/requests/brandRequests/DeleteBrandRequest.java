package com.etiya.ReCapProject.business.requests.brandRequests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.etiya.ReCapProject.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBrandRequest {


	@NotNull(message = Messages.DATANOTFOUND)
	@PositiveOrZero(message = Messages.DATANOTFOUND)
	private int id;
}
