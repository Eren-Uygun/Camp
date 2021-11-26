package com.etiya.rentACar.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImagesDto {
	
	private int Id;
	private String imagePath;
	private LocalDate date;

}
