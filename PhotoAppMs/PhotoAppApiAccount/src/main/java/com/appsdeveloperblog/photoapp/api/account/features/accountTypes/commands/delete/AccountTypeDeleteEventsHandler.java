package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import org.axonframework.eventhandling.EventHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create.AccountTypeCreatedEvent;
import com.appsdeveloperblog.photoapp.api.account.persistance.AccountTypeRepository;

@Component
public class AccountTypeDeleteEventsHandler {
	
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public AccountTypeDeleteEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	//On'daki metot event olarak fırlatıldığında bunu on'un içi çalışıyor.
	@EventHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		var accountType = this.accountTypeRepository.getById(accountTypeDeletedEvent.getAccountTypeId());
		//Burda modelmapper'de kullanılabilir.
		

		
		this.accountTypeRepository.delete(accountType);
		
	

}
}
