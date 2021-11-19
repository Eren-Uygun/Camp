package com.etiya.rentACar.business.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchListDto {
	
	
	private int id;

	private int brandId;
	
	private int colorId;
	
	private int year;

	private double dailyPrice;
	
	private String description;
	

}
