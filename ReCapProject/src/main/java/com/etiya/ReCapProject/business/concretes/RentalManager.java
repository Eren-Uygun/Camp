package com.etiya.ReCapProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CarMaintenanceService;
import com.etiya.ReCapProject.business.abstracts.CarService;
import com.etiya.ReCapProject.business.abstracts.IndividualCustomerService;
import com.etiya.ReCapProject.business.abstracts.RentalService;
import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.business.dtos.CarMaintenanceSearchListDto;
import com.etiya.ReCapProject.business.dtos.CarSearchListDto;
import com.etiya.ReCapProject.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.ReCapProject.business.dtos.RentalSearchListDto;
import com.etiya.ReCapProject.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.ReCapProject.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.ReCapProject.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorDataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.core.utilities.services.findex.FindexService;
import com.etiya.ReCapProject.dataAccess.abstracts.RentalDao;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.CarMaintenance;
import com.etiya.ReCapProject.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;
	private FindexService findexService;
	private CarService carService;
	private IndividualCustomerService individualCustomerService;
	@org.springframework.context.annotation.Lazy
	private CarMaintenanceService carMaintenanceService;
	private UserService userService;

	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, FindexService findexService,
			CarService carService, IndividualCustomerService individualCustomerService, @Lazy CarMaintenanceService carMaintenanceService, UserService userService) {
		super();
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.findexService = findexService;
		this.carService = carService;
		this.individualCustomerService = individualCustomerService;
		this.carMaintenanceService = carMaintenanceService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<RentalSearchListDto>> getAll() {
		List<Rental> result = this.rentalDao.findAll();
		List<RentalSearchListDto> response = result.stream()
				.map(rental -> modelMapperService.forDto().map(rental, RentalSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<RentalSearchListDto>>(response, Messages.RENTALLIST);
	}

//	,checkIfReturnDateIsNull(createRentalRequest.getCarId())

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		Result result = BusinessRules.run(
				checkIfUserIdExists(createRentalRequest.getCustomerId()),
				checkIfCarIdExists(createRentalRequest.getCarId()),
				checkIfReturnDateIsNull(createRentalRequest.getCarId()),
				compareFindexScores(createRentalRequest.getCarId()),
				checkIfCarInMaintenance(createRentalRequest.getCarId())
				);
		if (result != null) {
			return result;
		}
		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		rental.setRentDate(LocalDate.now());
		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALADD);
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		var result = BusinessRules.run(checkRentalExists(deleteRentalRequest.getId()));
			if (result!= null) {
				return result;
			}
		Rental rental = modelMapperService.forRequest().map(deleteRentalRequest, Rental.class);
		this.rentalDao.delete(rental);
		return new SuccessResult(Messages.RENTALDELETE);
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		var result = BusinessRules.run(checkRentalExists(updateRentalRequest.getId()),
				checkIfUserIdExists(updateRentalRequest.getCustomerId()),
				checkIfCarIdExists(updateRentalRequest.getCarId()),
				checkIfReturnDateIsNull(updateRentalRequest.getCarId()),
				checkIfCarInMaintenance(updateRentalRequest.getCarId()));
		if (result != null) {
			return result;
		}
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
		rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALUPDATE);
	}

	public Result checkIfReturnDateIsNull(int carId) {
		RentalSearchListDto rental = this.rentalDao.getByCarIdWhereReturnDateIsNull(carId);
		if (rental != null) {
			return new ErrorResult(Messages.RENTALDATEERROR);
		}
		return new SuccessResult();
	}

	private Result compareFindexScores(int id) {
		var resultCar = carService.isCarExists(id);
		if (!resultCar.isSuccess()) {
			return new ErrorResult(Messages.CARNOTFOUND);
		}
		var car = carService.getById(id);
		if (car==null) {
			return new ErrorResult(Messages.CARNOTFOUND);
		}
		int findexScore = car.getData().getFindexScore();
		int customerFindexScore = findexService.calculateCustomerFindexScore();
		if (customerFindexScore < findexScore) {
			return new ErrorResult(Messages.RENTALFINDEXSCOREERROR + customerFindexScore);
		}
		return new SuccessResult(" " + customerFindexScore);
	}
	@Override
	public DataResult<Rental> getByCar_Id(int carId) {
		var rental = this.rentalDao.getByCarId(carId);
		if (rental == null) {
			return new ErrorDataResult(Messages.CARNOTFOUND);
		}
		return new SuccessDataResult<Rental>(rental);
	}

	private Result checkIfCarInMaintenance(int carId) {
		var result = this.carMaintenanceService.getByCar(carId);
		if (result != null) {
			return new ErrorResult(Messages.RENTALMAINTENANCEERROR);
		}
		return new SuccessResult();
	}

	private Result checkIfCarIdExists(int carId) {
		var result = this.carService.isCarExists(carId);
		if (!result.isSuccess()) {
			return new ErrorResult(Messages.CARNOTFOUND);
		}
		return new SuccessResult();
	}

	private Result checkIfUserIdExists(int carId) {
		var result = this.userService.isUserExists(carId);
		if (!result.isSuccess()) {
			return new ErrorResult(Messages.USERNOTFOUND);
		}
		return new SuccessResult();
	}
	
	private Result checkRentalExists(int id) {
		var result = this.rentalDao.existsById(id);
		if (!result) {
			return new ErrorResult(Messages.RENTALNOTFOUND);
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<Rental> getById(int id) {
		var result=this.rentalDao.getById(id);
		if (result==null) {
			return new ErrorDataResult<Rental>(Messages.RENTALNOTFOUND,null);
		}
		return new SuccessDataResult<Rental>(result);
	}

}
