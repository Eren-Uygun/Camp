package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.dtos.CarSearchListDto;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.entities.Car;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
	 	super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<CarSearchListDto> getCars() {

		List<Car> result = this.carDao.findAll();
		List<CarSearchListDto> response = result.stream()
				.map(Car -> modelMapperService.forDto().map(Car, CarSearchListDto.class)).collect(Collectors.toList());

		return response;

	}

	@Override
	public void add(CreateCarRequest createCarRequest) {

		Car result = modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(result);

	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car result = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(result);

	}

	@Override
	public void delete(DeleteCarRequest deleteCarRequest) {
		Car result = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		this.carDao.delete(result);

	}

}
