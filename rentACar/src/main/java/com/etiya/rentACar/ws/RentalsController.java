package com.etiya.rentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.dtos.RentalSearchListDto;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

	private RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}
	
	@GetMapping(path = "/getRentals")
	public DataResult<List<RentalSearchListDto>> getRentals(){
		return this.rentalService.getAll();
	}
	
	@PostMapping(path = "/add")
	public Result add(CreateRentalRequest createRentalRequest) {
		return this.rentalService.add(createRentalRequest);
		
	}
	
	@PutMapping(params = "/update")
	public Result update(UpdateRentalRequest updateRentalRequest) {
		return this.update(updateRentalRequest);
	}
	
	@DeleteMapping(params = "/delete")
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		return this.delete(deleteRentalRequest);
	}
	
	

}
