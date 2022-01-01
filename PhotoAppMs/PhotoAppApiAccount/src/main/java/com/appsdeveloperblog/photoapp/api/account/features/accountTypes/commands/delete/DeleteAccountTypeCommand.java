package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateVersion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteAccountTypeCommand {
	
	
	@TargetAggregateIdentifier
	private final String accountTypeId;

}
