package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACar.entities.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer> {

	List<CarImage> getCarImagesByCarId(int id);
	
	CarImage getCarImageByCarId(int Id);

	int countCarImageByCarId(int id);

}
