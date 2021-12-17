package com.appsdeveloperblog.rentacar.api.rental.dataAccess;

import com.appsdeveloperblog.rentacar.api.rental.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
	

}
