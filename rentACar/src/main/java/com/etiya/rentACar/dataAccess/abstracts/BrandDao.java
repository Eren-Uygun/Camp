package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACar.entities.Brand;

public interface BrandDao extends JpaRepository<Brand,Integer> {
	
	@Query("Select b.brandName from Brand b where b.brandName like %?1%")
	List<Brand> getBrandsByBrandNameContains(String brandName);

}
