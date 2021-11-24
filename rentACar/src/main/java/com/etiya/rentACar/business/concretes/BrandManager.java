package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.dtos.BrandSearchListDto;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.core.utilities.business.BusinessRules;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.ErrorResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.complexTypes.CarBrandDetail;

@Service
public class BrandManager implements BrandService {
	
	
	private BrandDao brandDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}



	@Override
	public DataResult<List<BrandSearchListDto>> getBrands() {
		
		List<Brand> result = this.brandDao.findAll();
		List<BrandSearchListDto> response = result.stream().map(product->modelMapperService.forDto().map(product, BrandSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<BrandSearchListDto>>(response);
		
	}



	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		
		
		Result businessResult =BusinessRules.run(checkBrandNameDuplicated(createBrandRequest.getBrandName()));
		if (businessResult != null) {
			return businessResult;
		}
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandDao.save(brand);
		
		return new SuccessResult("Marka eklendi.");
		
	}



	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Result businessResult = BusinessRules.run(checkBrandNameDuplicated(updateBrandRequest.getBrandName()),checkBrandforIdExist(updateBrandRequest.getBrandId()));
		if (businessResult != null) {
			return businessResult;
		}
		
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult("Marka güncellendi.");
		
	}



	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		
		var result = BusinessRules.run(checkBrandforIdExist(deleteBrandRequest.getBrandId()));
		if (result != null) {
			return result;
			
		}
		Brand brand = modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		this.brandDao.delete(brand);
		return new SuccessResult("Marka silindi.");
		
	}



	@Override
	public DataResult<List<CarBrandDetail>> getBrandsWithExistsCar() {
		var result = this.brandDao.getBrandsWithCarBrandDetail();
		return new SuccessDataResult<List<CarBrandDetail>>(result);
	}
	
	
	private Result checkBrandNameDuplicated(String brandName) {
		var result = this.brandDao.getByBrandName(brandName);
		if (result != null) {
			return new ErrorResult("Marka adı sistemde mevcut");
		}
		return new SuccessResult("Marka sisteme eklendi.");
	}
	
	private Result checkBrandforIdExist(int id) {
		var result = this.brandDao.existsById(id);
		if (!result) {
			return new ErrorResult("Marka bulunamadı.");
		}
		return new SuccessResult("Marka bulundu. ");
	}



/*
	@Override
	public DataResult<List<BrandSearchListDto>> getBrandsWithCar(String brandName) {
		
		List<BrandSearchListDto> result = this.brandDao.getBrandsByBrandNameContains(brandName).stream()
				.map(brand->modelMapperService.forDto().map(brand, BrandSearchListDto.class)).collect(Collectors.toList());
		
		
		var result = this.brandDao.getBrandsByBrandNameContains(brandName);
		return new SuccessDataResult(result);
	}

*/

	/*
	@Override
	public DataResult<List<BrandSearchListDto>> getBrandsByBrandName(String brandName) {
		
		List<BrandSearchListDto> result = this.brandDao(brandName).stream()
				.map(brand->modelMapperService.forDto().map(brand, BrandSearchListDto.class)).collect(Collectors.toList());
				
		return null; //SuccessDataResult<List<BrandSearchListDto>>(result);
	}
*/
}
