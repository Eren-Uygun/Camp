package com.etiya.ReCapProject.business.concretes;

import com.etiya.ReCapProject.business.abstracts.CarDamageService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.business.dtos.CarDamageSearchListDto;
import com.etiya.ReCapProject.business.requests.carDamageRequests.CreateCarDamageRequest;
import com.etiya.ReCapProject.business.requests.carDamageRequests.DeleteCarDamageRequest;
import com.etiya.ReCapProject.business.requests.carDamageRequests.UpdateCarDamageRequest;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.CarDamageDao;
import com.etiya.ReCapProject.dataAccess.abstracts.CarDao;
import com.etiya.ReCapProject.entities.concretes.CarDamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarDamageManager implements CarDamageService {


    private ModelMapperService modelMapperService;
    private CarDamageDao carDamageDao;

    @Autowired
 public CarDamageManager(ModelMapperService modelMapperService, CarDamageDao carDamageDao) {
        this.modelMapperService = modelMapperService;
        this.carDamageDao = carDamageDao;
    }


    @Override
    public DataResult<List<CarDamageSearchListDto>> getAll() {
        List<CarDamage> carDamages = this.carDamageDao.findAll();
        List<CarDamageSearchListDto> response = carDamages.stream().map(carDamage -> modelMapperService.forDto().map(carDamage , CarDamageSearchListDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<CarDamageSearchListDto>>(response);
    }

    @Override
    public Result add(CreateCarDamageRequest createCarDamageRequest) {
        CarDamage carDamage = modelMapperService.forRequest().map(createCarDamageRequest, CarDamage.class);
        this.carDamageDao.save(carDamage);
        return new SuccessResult(Messages.DAMAGEADD);
    }

    @Override
    public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
        CarDamage carDamage = modelMapperService.forRequest().map(updateCarDamageRequest, CarDamage.class);
        this.carDamageDao.save(carDamage);
        return new SuccessResult(Messages.DAMAGEUPDATE);
    }

    @Override
    public Result delete(DeleteCarDamageRequest deleteCarDamageRequest) {
        CarDamage carDamage = modelMapperService.forRequest().map(deleteCarDamageRequest, CarDamage.class);
        this.carDamageDao.save(carDamage);
        return new SuccessResult(Messages.DAMAGEDELETE);
    }

    @Override
    public DataResult<CarDamageSearchListDto> getById(int id) {

        CarDamage result = this.carDamageDao.getById(id);
        CarDamageSearchListDto response = modelMapperService.forDto().map(result,CarDamageSearchListDto.class);
        return new SuccessDataResult<CarDamageSearchListDto>(response);
    }

    @Override
    public DataResult<List<CarDamageSearchListDto>> getByCarId(int carId) {
        List<CarDamage> carDamageList = this.carDamageDao.getByCar_Id(carId);
        List<CarDamageSearchListDto> response = carDamageList.stream().map(carDamage -> modelMapperService.forDto().map(carDamage,CarDamageSearchListDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CarDamageSearchListDto>>(response);
    }
}
