package com.appsdeveloperblog.photoapp.api.account.controllers;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create.CreateAccountTypeCommand;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete.DeleteAccountTypeCommand;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update.UpdateAccountTypeCommand;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.findAll.FindAccountTypesQuery;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.getById.FindAccountTypeQuery;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.AccountTypeListRestModel;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.CreateAccountTypeRestModel;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.DeleteAccountTypeRestModel;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.UpdateAccountTypeRestModel;

@RestController
@RequestMapping("/accounttypes")
public class AccountTypesController {
	
	//Axon'dan gelir ancak CQRS de kendiliğinden var olan yapıdır.
	//Commandgateway mediator pattern'i kullanır.
	//Bir operasyonumuz oldugunu varsayalım.Bu operasyonu çalıştırıcak handleri bulmaya yarar.
	
	//Create update delete operasyonları -> command | Veri getirme operasyonları -> querry
	private CommandGateway commandGateway;
	private QueryGateway queryGateway;
	
	@Autowired
	public AccountTypesController(CommandGateway commandGateway, QueryGateway queryGateway) {
		this.commandGateway = commandGateway;
		this.queryGateway = queryGateway;
	}
	
	@PostMapping
	public String createAccountType(@RequestBody CreateAccountTypeRestModel createAccountTypeRestModel) {
		
		

		//Builder pattern ile çalışmak.
		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder()
		.price(createAccountTypeRestModel.getPrice())
		.accountName(createAccountTypeRestModel.getAccountName())
		.description(createAccountTypeRestModel.getDescription())
		.accountTypeId(UUID.randomUUID().toString()).build();
		
		String returnValue = this.commandGateway.sendAndWait(command); //sendAndWait yaşam döngüsünün bitmesini bekler.
		//Find Command Handler and run it
		return returnValue;
		//Rest modeli command'a çevir
		//Axon cqrs bus ile yaşam döngüsüne dahil et
		
		//Btk akademide c# kursunda 94'den itibaren izleyin.
		//Birde tasarım kalıpları 36'yı izleyin. hepsini ve örnekler yapılabilir.
	}
	@PutMapping
	public String updateAccountType(@RequestBody UpdateAccountTypeRestModel updateAccountTypeRestModel) {
		UpdateAccountTypeCommand command = UpdateAccountTypeCommand.builder()
				.accountTypeId(updateAccountTypeRestModel.getAccountTypeId())
				.accountName(updateAccountTypeRestModel.getAccountName())
				.price(updateAccountTypeRestModel.getPrice())
				.description(updateAccountTypeRestModel.getDescription())
				.build();
		
		String returnValue = this.commandGateway.sendAndWait(command);
		return returnValue;
	}
	
	@DeleteMapping
	public String deleteAccountType(@RequestBody DeleteAccountTypeRestModel deleteAccountTypeRestModel) {
		
		DeleteAccountTypeCommand command = DeleteAccountTypeCommand.builder().accountTypeId(deleteAccountTypeRestModel.getAccountTypeId()).build();
		String returnValue = this.commandGateway.sendAndWait(command);
		
		return returnValue;
		
	}
	
	@GetMapping
	public List<AccountTypeListRestModel> listAccountTypes() {
		
		//Axonda list veremeyeceğimiz için ResponseTypes(Axondan geliyor) kullanıyoruz sonundada join diyoruz liste olduğu için
		
		FindAccountTypesQuery findAccountTypesQuery = new FindAccountTypesQuery();
		List<AccountTypeListRestModel> accountTypeListRestModels = this
				.queryGateway.query(findAccountTypesQuery, ResponseTypes.multipleInstancesOf(AccountTypeListRestModel.class))
				.join();
		
		return accountTypeListRestModels;
		}
	
	@GetMapping("/getById")
	public AccountTypeListRestModel getById(@RequestParam String accountTypeId) {
		FindAccountTypeQuery accountTypeQuery = new FindAccountTypeQuery();
		accountTypeQuery.setAccountTypeId(accountTypeId);
		AccountTypeListRestModel model = this.queryGateway.query(accountTypeQuery, ResponseTypes.instanceOf(AccountTypeListRestModel.class)).join();
		return model;
	}

}
