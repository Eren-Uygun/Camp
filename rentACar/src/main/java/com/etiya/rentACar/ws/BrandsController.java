package com.etiya.rentACar.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.entities.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	
	@GetMapping("/getBrands")
	public List<Brand> getBrands(){
		List<Brand> brands = new ArrayList<Brand>();
		brands.add(new Brand(1,"Nissan"));
		brands.add(new Brand(2,"Audi"));	
		brands.add(new Brand(3,"Tofaş"));	
		brands.add(new Brand(4,"Opel"));	
		
		return brands;
		
	}

}
