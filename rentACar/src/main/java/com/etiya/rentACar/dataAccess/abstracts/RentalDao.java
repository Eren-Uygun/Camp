package com.etiya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACar.entities.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {
	
	Rental getRentalByIndividualCustomer_Id(int id);

}
