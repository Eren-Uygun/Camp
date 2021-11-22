package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.dtos.CarSearchListDto;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.complexTypes.CarDetail;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;
	private BrandDao brandDao;
	private ColorDao colorDao;

	

	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService, BrandDao brandDao, ColorDao colorDao) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
		this.brandDao = brandDao;
		this.colorDao = colorDao;
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

		
		Car result = modelMapperService.forRequest().map(createCarRequest, Car.class);
		
		var brandItem = brandDao.getById(createCarRequest.getBrandId());
		var colorItem = colorDao.getById(createCarRequest.getColorId());
		result.setBrand(brandItem);
		result.setColor(colorItem);
	
		this.carDao.save(result);
		return new SuccessResult("Araç eklendi.");

	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Car result = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		var brandItem = brandDao.getById(updateCarRequest.getBrandId());
		var colorItem = colorDao.getById(updateCarRequest.getColorId());
		result.setBrand(brandItem);
		result.setColor(colorItem);
		this.carDao.save(result);
		return new SuccessResult("Araç güncellendi.");

	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		Car result = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		this.carDao.delete(result);
		return new SuccessResult("Araç silindi.");

	}

	@Override
	public DataResult<List<CarDetail>> getCarDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CarDetail>>(this.carDao.getCarsWithBrandAndColor());
	}

	@Override
	public DataResult<List<Car>> getCarss() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Car>>(this.carDao.findAll());
	}

	@Override
	public DataResult<List<Car>> getCarsByBrandName(String brandName) {
		var result =  this.carDao.getCarsByBrand(brandName);
		return new SuccessDataResult<List<Car>>(result);
	}


}
