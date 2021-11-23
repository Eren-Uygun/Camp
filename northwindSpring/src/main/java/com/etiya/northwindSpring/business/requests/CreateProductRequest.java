package com.etiya.northwindSpring.business.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Ekleme silme güncelleme için ayrı request classları


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	
	@JsonIgnore
	private int productId;

	@NotNull
	@Size(min = 2,max = 50)
	private String productName;
	

	@NotNull
	private int categoryId;
	
	@NotNull
	@Min(10)
	private double unitPrice;
	
	@NotNull
	@Min(1)
	private int unitsInStock;
	
	@NotNull
	private String quantityPerUnit;


}
