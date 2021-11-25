package com.etiya.rentACar.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACar.business.dtos.RentalSearchListDto;
import com.etiya.rentACar.entities.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {
	
	
	
	
	
	Rental getRentalByIndividualCustomer_Id(int id);
	

	/*
	@Query("Select new com.etiya.rentACar.business.dtos.RentalSearchListDto"
            + "(c.Id, r.returnDate) " 
            +     "From Car c Inner Join c.rentals r where c.Id=:r.carId and r.returnDate is null")
    RentalSearchListDto getByCarIdWhereReturnDateIsNull(int carId);
*/
	
	
	
}


/*private int id;
	private int individualCustomerId;
	private int carId;
	
	private LocalDate rentDate;
	private LocalDate returnDate;*/