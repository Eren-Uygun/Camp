package com.appsdeveloperblog.rentacar.users.dataAccess;

import com.appsdeveloperblog.rentacar.users.entities.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer,Integer> {

}
