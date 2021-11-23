package com.etiya.northwindSpring.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
	
	private int productId;
	private String productName;
	private int categoryId;
	private double unitPrice;
	private int unitsInStock;
	private String quantityPerUnit;

}
