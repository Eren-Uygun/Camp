package com.etiya.northwindSpring.entities.complexTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Bu entity product ve category'nin joinidir. O yüzden complex types olarak geçer.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
	
	private int productId;
	
	private String productName;
	
	private String categoryName;
		
	private double unitPrice;
		
	private int unitsInStock;

}
