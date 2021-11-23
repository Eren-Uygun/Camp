package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACar.entities.Color;
import com.etiya.rentACar.entities.complexTypes.ColorWithBrandAndCar;

public interface ColorDao extends JpaRepository<Color, Integer> {
	
	List<Color> getColorsByColorNameContains(String colorName);
	
	
	@Query("select new com.etiya.rentACar.entities.complexTypes.ColorWithBrandAndCar "+
	"(co.colorName,c.carId,c.modelYear)"+
			"From Color co Inner Join co.cars c")
	List<ColorWithBrandAndCar> getColorsWithExistsBrandsAndCars();
	

}
