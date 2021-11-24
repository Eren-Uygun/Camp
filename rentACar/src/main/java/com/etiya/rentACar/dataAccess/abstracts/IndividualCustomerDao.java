package com.etiya.rentACar.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;



import com.etiya.rentACar.entities.IndividualCustomer;
import com.etiya.rentACar.entities.Rental;


public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer,Integer> {
	

	
	

}
