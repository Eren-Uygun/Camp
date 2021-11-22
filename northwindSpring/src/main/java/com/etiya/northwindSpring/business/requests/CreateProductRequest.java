package com.etiya.northwindSpring.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Ekleme silme güncelleme için ayrı request classları


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	

	private String productName;
	

	private int categoryId;
	
	
	private double unitPrice;
	
	
	private int unitsInStock;
	
	
	private String quantityPerUnit;


}
