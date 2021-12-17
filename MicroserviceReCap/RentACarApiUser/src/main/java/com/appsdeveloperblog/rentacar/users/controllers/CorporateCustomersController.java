package com.appsdeveloperblog.rentacar.users.controllers;

import com.appsdeveloperblog.rentacar.users.business.abstracts.CorporateCustomerService;
import com.appsdeveloperblog.rentacar.users.business.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.CreateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.DeleteCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.UpdateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.DataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/corporateCustomers/")
public class CorporateCustomersController {
	
	private CorporateCustomerService corporateCustomerService;
	
	@Autowired
	public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
		super();
		this.corporateCustomerService = corporateCustomerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCorporateCustomerRequest createCorporateCustomerRequest){
		return this.corporateCustomerService.add(createCorporateCustomerRequest);
	}
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCorporateCustomerRequest updateCorporateCustomerRequest){
		return this.corporateCustomerService.update(updateCorporateCustomerRequest);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCorporateCustomerRequest deleteCorporateCustomerRequest){
		//DeleteCorporateCustomerRequest deleteCorporateCustomerRequest=new DeleteCorporateCustomerRequest();
		//deleteCorporateCustomerRequest.setCustomerId(customerId);
		return this.corporateCustomerService.delete(deleteCorporateCustomerRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CorporateCustomerSearchListDto>> getAll(){
		return this.corporateCustomerService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<CorporateCustomerSearchListDto> getById(@RequestParam("customerId") int id){
		return this.corporateCustomerService.getById(id);
	}
	

}
