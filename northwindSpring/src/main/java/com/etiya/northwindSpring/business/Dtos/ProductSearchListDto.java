package com.etiya.northwindSpring.business.Dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.etiya.northwindSpring.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Getter ve Setter lombok ile otomatikleşir.
@AllArgsConstructor //Dolu Constructor
@NoArgsConstructor //Boş Constructor
public class ProductSearchListDto {
	
	
	private int id;

	private int categoryId;
	
	private String productName;
		
	private double unitPrice;
		
	private int unitsInStock;



}

//Getireceğimiz dataları direkt olarak entity'den döndürmemek gerekiyor
//Dto yazılması gereklidir.Yani data transformation object
//GElecek nesnelerimi dto ya dönüştürüp getirmem gerekiyor.

//Dto'ların yeri business ve entities olabilir.
//Clean architecture ve sqrs tarafında business'de olması gerekiyor.

	