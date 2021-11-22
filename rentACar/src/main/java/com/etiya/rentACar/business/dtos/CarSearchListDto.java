package com.etiya.rentACar.business.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchListDto {
	
	
	private int carId;

	private int brandId;
	
	private int colorId;
	
	private int modelYear;

	private double dailyPrice;
	
	private String description;
	

}
