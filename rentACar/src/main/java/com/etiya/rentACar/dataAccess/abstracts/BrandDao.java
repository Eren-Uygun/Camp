package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACar.entities.Brand;

public interface BrandDao extends JpaRepository<Brand,Integer> {
	
	
	/*
	List<Brand> getBrandsByBrandNameContains(String brandName);
	
	
	
	@Query("select new com.etiya.rentACar.entities.complexTypes.BrandAndCarDetail "+
	"(c.carId,b.brandName,c.modelYear) "+
			"From Brand b Inner Join b.cars c")
	List<Brand> getBrandsWithBrandAndCarDetail(String brandName);
	
	
	*/
	

}
