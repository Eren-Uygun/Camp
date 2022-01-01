package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder //
public class CreateAccountTypeCommand {
	

	//Final = Const final verildiyse bir daha değişmez
	
	//Final varsa getter ve setter yazmak gerekiyor. Ondada kurtarıcı olarak lombok'da datayı kullanıyoruz.
	
	@TargetAggregateIdentifier //Axon için birleştirirken en önemli parçamız olan id yi işaretliyoruz.
	private final String accountTypeId;
	private final String accountName; 
	private final double price;
	private final String description;

	
	
	

}

//Aggregeation => Bir araya getirmek toplamak anlamındadır.
//Bu sürecin ana bileşeni id dir;