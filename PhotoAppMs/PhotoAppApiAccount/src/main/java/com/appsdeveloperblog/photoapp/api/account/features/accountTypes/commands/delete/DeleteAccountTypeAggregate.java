package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateRoot;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create.AccountTypeCreatedEvent;

@Aggregate
public class DeleteAccountTypeAggregate {

	private String accountTypeId;
	
	@AggregateIdentifier
	private String identifier = UUID.randomUUID().toString();
	
	//yeni uuid atama sebebimiz Aggregate identifierlerin çakışması yüzündendir.

	public DeleteAccountTypeAggregate() {

	}

	@CommandHandler
	public DeleteAccountTypeAggregate(DeleteAccountTypeCommand deleteAccountTypeCommand) {
		AccountTypeDeletedEvent accountTypeDeletedEvent = new AccountTypeDeletedEvent();

		BeanUtils.copyProperties(deleteAccountTypeCommand, accountTypeDeletedEvent);

		AggregateLifecycle.apply(accountTypeDeletedEvent);
	}

	@EventSourcingHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {

		this.accountTypeId = accountTypeDeletedEvent.getAccountTypeId();

	}

}
