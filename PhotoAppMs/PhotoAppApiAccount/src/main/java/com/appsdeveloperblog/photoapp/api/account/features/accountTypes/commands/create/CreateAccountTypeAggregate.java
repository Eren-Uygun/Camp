package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

//Bunun bir aggregate fonksiyon oldugunu göstermek için bu anotasyonu eklenir.

@Aggregate
public class CreateAccountTypeAggregate {
	
	//Evente konu olan datalar, hepsinin olması zorunlu değil.
	
	@AggregateIdentifier
	private String accountTypeId;
	private String accountName; 
	private double price;
	private String description;
	

	public CreateAccountTypeAggregate() {

	}

	// Komut olduğundan emin olmak için commandhandler yerleştirmemiz gereklidir.

	@CommandHandler
	public CreateAccountTypeAggregate(CreateAccountTypeCommand createAccountTypeCommand) {
		// Validation kodu da yazılabilir ama cok tercih edilmemesi gerekir.
		if (createAccountTypeCommand.getPrice() < 0) {
			throw new IllegalArgumentException("fiyat 0'dan küçük olamaz.");
		}

		

		// business Kodu yazılır.

		
		// Event fire
		AccountTypeCreatedEvent accountTypeCreatedEvent = new AccountTypeCreatedEvent();
		
		// Event varken dataların hepsini atmak zorunda değiliz.
				// Dosyaları çevirmek için modelMapper kullanabiliriz veya builder
				// kullanabiliriz.
				// 3. bir eşleştirme ancak herşey %100 aynı ise bean utils alternatifi
				// kullanılabilir.
		BeanUtils.copyProperties(createAccountTypeCommand, accountTypeCreatedEvent);
		
		AggregateLifecycle.apply(accountTypeCreatedEvent);

	}
	
	
	@EventSourcingHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		
		//Gönderilecek data sayımız az ise map araçları kullanmayız.Hepsini eşlemeye çalışıp programı çökertebilir.
		this.accountTypeId = accountTypeCreatedEvent.getAccountTypeId();
		this.accountName = accountTypeCreatedEvent.getAccountName();
		this.price = accountTypeCreatedEvent.getPrice();
		this.description = accountTypeCreatedEvent.getDescription();
		
	}
	
	

}
