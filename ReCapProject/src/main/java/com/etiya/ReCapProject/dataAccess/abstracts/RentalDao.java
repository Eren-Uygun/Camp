package com.etiya.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.ReCapProject.business.dtos.RentalSearchListDto;
import com.etiya.ReCapProject.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {

	@Query("select new com.etiya.ReCapProject.business.dtos.RentalSearchListDto"
			+ "(c.id, r.rentDate, r.returnDate,r.car.id ,r.customer.id,r.rentedCityId,r.returnCityId) "
			+ "From Car c Inner Join c.rentals r where c.id=:carId and r.returnDate is null")
	RentalSearchListDto getByCarIdWhereReturnDateIsNull(int carId);
	
	Rental  getByCarId(int carId);


}
