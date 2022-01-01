package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.getById;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.findAll.FindAccountTypesQuery;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.AccountTypeListRestModel;
import com.appsdeveloperblog.photoapp.api.account.persistance.AccountTypeRepository;

@Component
public class FindAccountTypeQueryHandler {
	
	private AccountTypeRepository accountTypeRepository;
	
	@Autowired
	public FindAccountTypeQueryHandler(AccountTypeRepository accountTypeRepository) {
		super();
		this.accountTypeRepository = accountTypeRepository;
	}




	@QueryHandler
	public AccountTypeListRestModel findAccountType(FindAccountTypeQuery findAccountTypeQuery){
		
		AccountTypeListRestModel accountTypeListRestModel = new AccountTypeListRestModel(); 
		
		AccountType accountType = this.accountTypeRepository.getById(findAccountTypeQuery.getAccountTypeId());
		
		BeanUtils.copyProperties(accountType,accountTypeListRestModel);
		
		return accountTypeListRestModel;
		
		
		
		
		
	}
	

}
