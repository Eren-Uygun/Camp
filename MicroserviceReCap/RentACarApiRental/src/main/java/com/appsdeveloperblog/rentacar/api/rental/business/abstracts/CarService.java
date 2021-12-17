package com.appsdeveloperblog.rentacar.api.rental.business.abstracts;

import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CarSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CreateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.DeleteCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.UpdateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;

import java.util.List;

public interface CarService {
	
	Result add(CreateCarDto createCarDto);
	Result update(UpdateCarDto updateCarDto);
	Result delete(DeleteCarDto deleteCarDto);
	DataResult<CarSearchListDto> getById(int id);
	DataResult<List<CarSearchListDto>> getAll();

}
