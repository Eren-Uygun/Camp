package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.complexTypes.CarDetail;

public interface CarDao extends JpaRepository<Car,Integer> {
	
	
	@Query("Select new package com.etiya.rentACar.entities.complexTypes.CarDetail "+
	"(c.carId,b.brandName,co.colorName,c.modelYear,c.dailyPrice,c.description)" +
			"From Car c Inner Join c.color Inner Join c.brand ")
	List<CarDetail> getCarsWithBrandAndColor();

}
