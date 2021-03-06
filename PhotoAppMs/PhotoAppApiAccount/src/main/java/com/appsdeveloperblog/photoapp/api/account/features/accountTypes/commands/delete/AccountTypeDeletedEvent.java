package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import org.axonframework.modelling.command.AggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTypeDeletedEvent {
	
	private String accountTypeId;

}
