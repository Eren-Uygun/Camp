package com.appsdeveloperblog.rentacar.users.business.abstracts;

import com.appsdeveloperblog.rentacar.users.business.dtos.IndividualCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.CreateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.DeleteIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.individualRequests.UpdateIndividualCustomerRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.DataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;

import java.util.List;

public interface IndividualCustomerService {
	
	Result add(CreateIndividualCustomerRequest individualCustomerRequest);
	Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
	Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);
	DataResult<IndividualCustomerSearchListDto> getById(int individualCustomerId);
	DataResult<List<IndividualCustomerSearchListDto>> getAll();

}
