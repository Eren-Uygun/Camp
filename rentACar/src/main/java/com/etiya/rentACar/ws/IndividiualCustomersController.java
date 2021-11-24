package com.etiya.rentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.etiya.rentACar.business.abstracts.IndividualCustomerService;
import com.etiya.rentACar.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.rentACar.business.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiya.rentACar.business.requests.individualCustomerRequests.DeleteIndividualCustomerRequest;
import com.etiya.rentACar.business.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.IndividualCustomer;

@RestController
@RequestMapping("/api/individualCustomers")
public class IndividiualCustomersController {
	
	private IndividualCustomerService individualCustomerService;

	@Autowired
	public IndividiualCustomersController(IndividualCustomerService individualCustomerService) {
		super();
		this.individualCustomerService = individualCustomerService;
	}
	
	@GetMapping(path = "/getIndividualCustomers")
	public DataResult<List<IndividualCustomerSearchListDto>> getAll(){
		
		return this.individualCustomerService.getAll();
		
	}
	
	@PostMapping(path = "/add")
	public Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		return this.individualCustomerService.add(createIndividualCustomerRequest);
		
	}
	
	@PutMapping(path = "/update")
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		return this.individualCustomerService.update(updateIndividualCustomerRequest);
		
	}
	
	@DeleteMapping(path = "/delete")
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
	}
	
	

}
