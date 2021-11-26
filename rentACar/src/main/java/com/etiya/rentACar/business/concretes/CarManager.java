package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.dtos.CarSearchListDto;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.core.utilities.business.BusinessRules;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.ErrorDataResult;
import com.etiya.rentACar.core.utilities.results.ErrorResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.complexTypes.CarDetail;
import com.fasterxml.jackson.annotation.OptBoolean;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	// Brand ve color dao'lar burada getirilemez.
	//Car Managerde sadece CarDao getirilebilir.
	//Brand ve color Service getirilerek çözülebilir.
	private BrandDao brandDao;
	private ColorDao colorDao;
	private ModelMapperService modelMapperService;


	@Autowired
	public CarManager(CarDao carDao, BrandDao brandDao, ColorDao colorDao, ModelMapperService modelMapperService) {
		super();
		this.carDao = carDao;
		this.brandDao = brandDao;
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarSearchListDto>> getCars() {

		List<Car> result = this.carDao.findAll();
		List<CarSearchListDto> response = result.stream()
				.map(Car -> modelMapperService.forDto().map(Car, CarSearchListDto.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<CarSearchListDto>>(response);

	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {

		var result = BusinessRules
				.run(checkExistsBrandId(createCarRequest.getBrandId()),checkExistsColorId(createCarRequest.getColorId()));
		
		if (result != null) {
			return result;
		}
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		/*
		var brandItem = brandDao.getById(createCarRequest.getBrandId());
		var colorItem = colorDao.getById(createCarRequest.getColorId());
		result.setBrand(brandItem);
		result.setColor(colorItem);	
		*/
		this.carDao.save(car);
		return new SuccessResult("Araç eklendi.");

	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		var result = BusinessRules
				.run(checkExistsBrandId(updateCarRequest.getBrandId()),checkExistsColorId(updateCarRequest.getColorId()),checkexistsCarId(updateCarRequest.getId()));
		if (result != null) {
			return result;
		}
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		/*
		var brandItem = brandDao.getById(updateCarRequest.getBrandId());
		var colorItem = colorDao.getById(updateCarRequest.getColorId());
		result.setBrand(brandItem);
		result.setColor(colorItem);
		*/
		this.carDao.save(car);
		return new SuccessResult("Araç güncellendi.");

	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		var result = BusinessRules.run(checkexistsCarId(deleteCarRequest.getId()));
		if (result != null) {
			return result;
		}
		
		
		this.carDao.delete(this.carDao.getById(deleteCarRequest.getId()));
		return new SuccessResult("Araç silindi.");

	}

	@Override
	public DataResult<List<CarDetail>> getCarDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CarDetail>>(this.carDao.getCarsWithBrandAndColor());
	}

	@Override
	public DataResult<List<Car>> getCarsByBrandName(String brandName) {
		var result =  this.carDao.getCarsByBrand(brandName);
		return new SuccessDataResult<List<Car>>(result);
	}
	
	
	private Result checkExistsColorId(int id) {
		
		var result = this.colorDao.existsById(id);
		if (!result) {
			return new ErrorResult("Renk bulunamadı.");
			
		}
		return new SuccessResult("Renk bulundu.");
		
	}
	
	private Result checkExistsBrandId(int id) {
		var result = this.brandDao.existsById(id);
		if (!result) {
			return new ErrorResult("Marka bulunamadı.");	
		}
		return new SuccessResult("Marka bulundu.");
	}
	
	private Result checkexistsCarId(int id) {
		var result = this.carDao.existsById(id);
		if (!result) {
			return new ErrorResult("Araç bulunamadı.");
		}
		return new SuccessResult("Araç bulundu.");
	}

	@Override
	public DataResult<CarSearchListDto> getCar(int carId) {
		Car car = this.carDao.findById(carId).get();
		if (car != null) {
			CarSearchListDto carSearchListDto = modelMapperService.forDto().map(car, CarSearchListDto.class);
			return new SuccessDataResult<CarSearchListDto>(carSearchListDto);
		}
		return null;
	}


}
