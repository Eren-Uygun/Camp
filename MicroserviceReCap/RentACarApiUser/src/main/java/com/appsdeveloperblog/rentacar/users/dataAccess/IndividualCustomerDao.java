package com.appsdeveloperblog.rentacar.users.dataAccess;

import com.appsdeveloperblog.rentacar.users.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, Integer>{

}
