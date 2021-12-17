package com.appsdeveloperblog.rentacar.users.dataAccess;

import com.appsdeveloperblog.rentacar.users.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
