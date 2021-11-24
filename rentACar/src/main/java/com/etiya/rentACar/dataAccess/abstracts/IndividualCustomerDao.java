package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACar.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.rentACar.entities.IndividualCustomer;


public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer,Integer> {
	
	

}
