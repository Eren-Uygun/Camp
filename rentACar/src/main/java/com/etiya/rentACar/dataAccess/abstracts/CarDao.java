package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACar.business.dtos.CarSearchListDto;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.complexTypes.CarDetail;

public interface CarDao extends JpaRepository<Car,Integer> {
	
	
	@Query("Select new com.etiya.rentACar.entities.complexTypes.CarDetail "+
	"(c.carId,b.brandName,co.colorName,c.modelYear,c.dailyPrice,c.description)" +
			"From Car c Inner Join c.color co Inner Join c.brand b ")
	List<CarDetail> getCarsWithBrandAndColor();
	
	/*@Query("Select new com.etiya.rentACar.entities.complexTypes.CarDetail "+
	"(c.carId,b.brandName,co.colorName,c.modelYear,c.dailyPrice,c.description)" +
			"From Car c Inner Join c.color co Inner Join c.brand b ")
	List<CarDetail> getCarsWithBrandAndColor();*/
	
	//Çalışmıyor ?????
	@Query(value = "Select c From Car c where c.brand.brandName like '%?1'",nativeQuery = true)
	List<Car> getCarsByBrand(String brandName);
	
	
	
	
	
	


}
	