package com.etiya.ReCapProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.ReCapProject.business.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.IndividualCustomerService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.ReCapProject.business.requests.individualRequests.CreateIndividualCustomerRequest;
import com.etiya.ReCapProject.business.requests.individualRequests.DeleteIndividualCustomerRequest;
import com.etiya.ReCapProject.business.requests.individualRequests.UpdateIndividualCustomerRequest;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorDataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.ReCapProject.entities.concretes.IndividualCustomer;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {
	private IndividualCustomerDao individualCustomerDao;
	private ModelMapperService modelMapperService;
	private UserService userService;


	@Autowired
	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao, ModelMapperService modelMapperService,@Lazy UserService userService) {
		this.individualCustomerDao = individualCustomerDao;
		this.modelMapperService = modelMapperService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
		List<IndividualCustomer> result = this.individualCustomerDao.findAll();
		List<IndividualCustomerSearchListDto> response = result.stream().map(individualCustomer->modelMapperService.forDto().map(individualCustomer,IndividualCustomerSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<IndividualCustomerSearchListDto>>(response,Messages.CUSTOMERLIST);
	}

	@Override
	public Result add(CreateIndividualCustomerRequest createIndividualRequest) {
		var result = BusinessRules.run(checkIsIndividualCustomerEmailExists(createIndividualRequest.getEmail()));
		if(result != null){
			return result;
		}
		IndividualCustomer individualCustomer = modelMapperService.forRequest().map(createIndividualRequest,IndividualCustomer.class);
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERADD);
			}

	@Override
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualRequest) {
		Result result = BusinessRules.run(checkIsIndividualCustomerExists(deleteIndividualRequest.getId()));
		if(result != null){
			return result;
		}
		IndividualCustomer individualCustomer=modelMapperService.forRequest().map(deleteIndividualRequest, IndividualCustomer.class);
		this.individualCustomerDao.delete(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERDELETE);
	}

	@Override
	public Result update(UpdateIndividualCustomerRequest updateIndividualRequest) {
		Result result = BusinessRules.run(checkIsIndividualCustomerExists(updateIndividualRequest.getId()),checkIsIndividualCustomerEmailExists(updateIndividualRequest.getEmail()));
		if(result != null){
			return result;
		}
		IndividualCustomer individualCustomer=modelMapperService.forRequest().map(updateIndividualRequest, IndividualCustomer.class);
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERUPDATE);
	}

	@Override
	public DataResult<IndividualCustomerSearchListDto> getByIndividualCustomerId(int individualCustomerId) {
		
		var existsIndividualCustomer = this.individualCustomerDao.existsById(individualCustomerId);
		if (!existsIndividualCustomer) {
			return new ErrorDataResult(Messages.CUSTOMERNOTFOUND);
		}

		IndividualCustomer individualCustomer = this.individualCustomerDao.getById(individualCustomerId);
		IndividualCustomerSearchListDto customerSearchListDto = modelMapperService.forDto().map(individualCustomer,IndividualCustomerSearchListDto.class);
			return new SuccessDataResult<IndividualCustomerSearchListDto>(customerSearchListDto,Messages.CUSTOMERGET);
	}
	
	private Result checkIsIndividualCustomerEmailExists(String email){
		var result = this.userService.isUserEmailExists(email);
		if(result.isSuccess()){
			return new ErrorResult(Messages.CUSTOMERISALREADYEXISTS);
		}
		return new SuccessResult();		
	}
	
	private Result checkIsIndividualCustomerExists(int id){
		var result = this.individualCustomerDao.existsById(id);
		if(!result){
			return new ErrorResult(Messages.CUSTOMERNOTFOUND);
		}
		return new SuccessResult();
	}
	

	}
