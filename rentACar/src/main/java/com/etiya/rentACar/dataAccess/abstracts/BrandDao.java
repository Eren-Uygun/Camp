package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.entities.Brand;

public interface BrandDao extends JpaRepository<Brand,Integer> {
	
	DataResult<List<Brand>> getBrandsByBrandNameContains(String brandName);

}
