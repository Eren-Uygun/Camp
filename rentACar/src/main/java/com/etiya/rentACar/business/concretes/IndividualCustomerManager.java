package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.IndividualCustomerService;
import com.etiya.rentACar.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.rentACar.business.requests.individualCustomerRequests.CreateIndividualCustomerRequest;
import com.etiya.rentACar.business.requests.individualCustomerRequests.DeleteIndividualCustomerRequest;
import com.etiya.rentACar.business.requests.individualCustomerRequests.UpdateIndividualCustomerRequest;
import com.etiya.rentACar.core.utilities.business.BusinessRules;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.ErrorResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.rentACar.entities.IndividualCustomer;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {
	
	private IndividualCustomerDao individualCustomerDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao,
			ModelMapperService modelMapperService) {
		super();
		this.individualCustomerDao = individualCustomerDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
		List<IndividualCustomer> result = this.individualCustomerDao.findAll();
		List<IndividualCustomerSearchListDto> response = result.stream()
				.map(individualCustomer -> modelMapperService.forDto()
				.map(individualCustomer, IndividualCustomerSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<IndividualCustomerSearchListDto>>(response);
	}

	@Override
	public Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		
		IndividualCustomer individualCustomer = modelMapperService.forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
		this.individualCustomerDao.save(individualCustomer);		
		return new SuccessResult("Bireysel müşteri sisteme eklendi.");
	}

	@Override
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		var result = BusinessRules.run(checkUserExists(updateIndividualCustomerRequest.getId()));
		if (result!= null) {
			return result;
		}
		IndividualCustomer individualCustomer = modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class);
		this.individualCustomerDao.save(individualCustomer);		
		return new SuccessResult("Bireysel müşteri bilgileri güncellendi.");
	}

	@Override
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		var result = BusinessRules.run(checkUserExists(deleteIndividualCustomerRequest.getId()));
		if (result!= null) {
			return result;
		}
		this.individualCustomerDao.delete(this.individualCustomerDao.getById(deleteIndividualCustomerRequest.getId()));
		return new SuccessResult("Bireysel müşteri bilgileri silindi.");
	}
	
	private Result checkUserExists(int id) {
		var result = this.individualCustomerDao.existsById(id);
		if (!result) {
			return new ErrorResult("Kullanıcı bulunamadı.");
			
		}
		
		return new SuccessResult("Kullanıcı bulundu.");
	}

}
