package com.appsdeveloperblog.rentacar.users.business.abstracts;

import com.appsdeveloperblog.rentacar.users.business.dtos.CorporateCustomerSearchListDto;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.CreateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.DeleteCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.business.requests.corporateCustomerRequests.UpdateCorporateCustomerRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.DataResult;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;

import java.util.List;

public interface CorporateCustomerService {
	
	Result add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
	Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);
	Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest);
	DataResult<CorporateCustomerSearchListDto> getById(int corporateCustomerId);
	DataResult<List<CorporateCustomerSearchListDto>> getAll();

}
