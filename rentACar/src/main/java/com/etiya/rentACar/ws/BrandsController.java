package com.etiya.rentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.dtos.BrandSearchListDto;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	
	private BrandService brandService;
	
	
	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@PostMapping(path = "/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PutMapping(path = "/update")
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
	this.brandService.update(updateBrandRequest);	
	}
	
	@DeleteMapping(path = "/delete")
	public void delete(@RequestBody DeleteBrandRequest brandRequest) {
		this.brandService.delete(brandRequest);
	}


	@GetMapping(path = "/getBrands")
	public List<BrandSearchListDto> getBrands(){
		/*
		List<Brand> brands = new ArrayList<Brand>();
		brands.add(new Brand(1,"Nissan"));
		brands.add(new Brand(2,"Audi"));	
		brands.add(new Brand(3,"Tofaş"));	
		brands.add(new Brand(4,"Opel"));	
		*/
		return brandService.getBrands();
		
	}

}
