package com.etiya.ReCapProject.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.BrandService;
import com.etiya.ReCapProject.business.dtos.BrandSearchListDto;
import com.etiya.ReCapProject.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.ReCapProject.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.ReCapProject.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@GetMapping("getAll")
	public DataResult<List<BrandSearchListDto>> getAll() {
		return this.brandService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}
	@PutMapping("update")
	public Result update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		return this.brandService.update(updateBrandRequest);
	}
	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		return this.brandService.delete(deleteBrandRequest);
	}
	@GetMapping("getById")
	public DataResult<BrandSearchListDto> getByBrandId(int brandId){
		return this.brandService.getByBrandId(brandId);
	}
}
