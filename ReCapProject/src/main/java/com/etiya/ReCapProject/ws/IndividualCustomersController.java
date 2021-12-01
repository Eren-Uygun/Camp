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

import com.etiya.ReCapProject.business.abstracts.IndividualCustomerService;
import com.etiya.ReCapProject.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.ReCapProject.business.requests.individualRequests.CreateIndividualCustomerRequest;
import com.etiya.ReCapProject.business.requests.individualRequests.DeleteIndividualCustomerRequest;
import com.etiya.ReCapProject.business.requests.individualRequests.UpdateIndividualCustomerRequest;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/individualCustomers")
public class IndividualCustomersController {

	private IndividualCustomerService individualCustomerService;

	@Autowired
	public IndividualCustomersController(IndividualCustomerService individualCustomerService) {
		super();
		this.individualCustomerService = individualCustomerService;
	}

	@GetMapping("getAll")
	public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
		return this.individualCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		return this.individualCustomerService.add(createIndividualCustomerRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid  UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		return this.individualCustomerService.update(updateIndividualCustomerRequest);
	}

	@GetMapping("/getByIndividualCustomerById")
	public DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerById(int id) {
		return this.individualCustomerService.getByIndividualCustomerId(id);
	}

}
