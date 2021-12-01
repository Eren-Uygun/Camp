package com.etiya.ReCapProject.ws;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.RentalService;
import com.etiya.ReCapProject.business.dtos.RentalSearchListDto;
import com.etiya.ReCapProject.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.ReCapProject.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.ReCapProject.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
	private RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}

	@GetMapping("/getAll")
	public DataResult<List<RentalSearchListDto>> getAll() {
		return this.rentalService.getAll();
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest) {
		return this.rentalService.update(updateRentalRequest);

	}

	@PostMapping("/add")
	public Result add(@RequestBody  @Valid CreateRentalRequest createRentalRequest) {
		return this.rentalService.add(createRentalRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteRentalRequest  deleteRentalRequest) {
		return this.rentalService.delete(deleteRentalRequest);
	}
}
