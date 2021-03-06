package com.etiya.rentACar.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.dtos.RentalSearchListDto;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.core.utilities.business.BusinessRules;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.ErrorResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.rentACar.dataAccess.abstracts.RentalDao;
import com.etiya.rentACar.entities.Rental;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;
	private CarDao carDao;
	private IndividualCustomerDao individualCustomerDao;

	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, CarDao carDao,
			IndividualCustomerDao individualCustomerDao) {
		super();
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.carDao = carDao;
		this.individualCustomerDao = individualCustomerDao;
	}

	@Override
	public DataResult<List<RentalSearchListDto>> getAll() {
		List<Rental> result = this.rentalDao.findAll();
		List<RentalSearchListDto> response = result.stream()
				.map(rental -> modelMapperService.forDto().map(rental, RentalSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<RentalSearchListDto>>(response);
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		var result = BusinessRules.run(checkCarIsExists(createRentalRequest.getCarId()),
				checkIndividualCustomerIsExists(createRentalRequest.getIndividualCustomerId()),checkRentalReturnDateByIndividualCustomerId(createRentalRequest.getIndividualCustomerId()));
		if (result != null) {
			return result;
		}
		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		this.rentalDao.save(rental);
		return new SuccessResult("Kiralama ger??ekle??ti.");
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		Result result = BusinessRules.run(checkCarIsExists(updateRentalRequest.getCarId()),
				checkIndividualCustomerIsExists(updateRentalRequest.getIndividualCustomerId()),
				checkRentalIdIsExists(updateRentalRequest.getId()));
		if (result != null) {
			return result;
		}
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
		this.rentalDao.save(rental);
		return new SuccessResult("Kiralama bilgileri g??ncellendi.");
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		this.rentalDao.delete(this.rentalDao.getById(deleteRentalRequest.getId()));
		return new SuccessResult("Kiralama bilgileri silindi.");
	}

	private Result checkCarIsExists(int id) {
		if (!this.carDao.existsById(id)) {
			return new ErrorResult("Ara?? bulunamad??.");
		}
		return new SuccessResult("Ara?? bulundu.");

	}

	private Result checkIndividualCustomerIsExists(int id) {
		var result = this.individualCustomerDao.existsById(id);
		if (!result) {
			return new ErrorResult("M????teri bulunamad??.");
		} else {
			return new SuccessResult("M????teri bulundu.");
		}
	}
//Engin hoca geldi??inde sorulacak.
	private Result checkRentalReturnDateByIndividualCustomerId(int id) {
		Rental result = this.rentalDao.getRentalByIndividualCustomer_Id(id);
		if (result != null) {
			return new ErrorResult("Kiralad??????n??z arac?? teslim etmeden yeni ara?? kiralayamass??n??z.");
		}
		return new SuccessResult("Ara?? kiralamas?? yap??ld??.");
	}
	
	private Result checkRentalIdIsExists(int id) {
		var result = this.rentalDao.existsById(id);
		if (!result) {
			return new ErrorResult("Kiralama bilgileri bulunamad??.");
		}
		return new SuccessResult("Bilgiler bulundu.");
	}
}
