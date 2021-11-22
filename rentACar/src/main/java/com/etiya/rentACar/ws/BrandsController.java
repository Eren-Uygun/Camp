package com.etiya.rentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.dtos.BrandSearchListDto;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

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
	public Result add(@RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}
	
	@PutMapping(path = "/update")
	public Result update(@RequestBody UpdateBrandRequest updateBrandRequest) {
	return this.brandService.update(updateBrandRequest);	
	}
	
	@DeleteMapping(path = "/delete")
	public Result delete(@RequestBody DeleteBrandRequest brandRequest) {
		return this.brandService.delete(brandRequest);
	}


	@GetMapping(path = "/getBrands")
	public DataResult<List<BrandSearchListDto>> getBrands(){
		/*
		List<Brand> brands = new ArrayList<Brand>();
		brands.add(new Brand(1,"Nissan"));
		brands.add(new Brand(2,"Audi"));	
		brands.add(new Brand(3,"Tofaş"));	
		brands.add(new Brand(4,"Opel"));	
		*/
		return brandService.getBrands();
		
	}
	
	/*
	@GetMapping(path = "/getBrandsByName")
	public DataResult<List<BrandSearchListDto>> getByBrandName(@RequestParam("brandName") String brandName){
		return this.brandService.getBrandsByBrandName(brandName);
	}
	
	@GetMapping(path = "/GetBrandsAndCarDetails")
	public DataResult<List<BrandSearchListDto>> GetBrandsAndCarDetails(String brandName){
		return this.brandService.getBrandsWithCar(brandName);
	}
*/
	
}
