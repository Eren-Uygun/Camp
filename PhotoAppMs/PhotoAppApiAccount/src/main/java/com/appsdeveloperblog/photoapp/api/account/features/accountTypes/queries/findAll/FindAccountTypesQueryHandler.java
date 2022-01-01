package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.findAll;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.AccountTypeListRestModel;
import com.appsdeveloperblog.photoapp.api.account.persistance.AccountTypeRepository;

@Component //Singleton format anlamına gelir.
public class FindAccountTypesQueryHandler {
	
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public FindAccountTypesQueryHandler(AccountTypeRepository accountTypeRepository) {

		this.accountTypeRepository = accountTypeRepository;
	}
	
	@QueryHandler
	public List<AccountTypeListRestModel> findAccountTypes(FindAccountTypesQuery findAccountTypesQuery){
		
		List<AccountTypeListRestModel> result = new ArrayList<>();
		
		List<AccountType> accountTypes = this.accountTypeRepository.findAll();
		
		for (AccountType accountType : accountTypes) {
			AccountTypeListRestModel accountTypeListRestModel = new AccountTypeListRestModel();
			BeanUtils.copyProperties(accountType, accountTypeListRestModel);
			result.add(accountTypeListRestModel);	
		}
		
		return result;
		
		
		
		
		
	}
	
	

}
