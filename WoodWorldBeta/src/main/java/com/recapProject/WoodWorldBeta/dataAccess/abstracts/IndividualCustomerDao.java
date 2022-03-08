package com.recapProject.WoodWorldBeta.dataAccess.abstracts;

import com.recapProject.WoodWorldBeta.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, String> {

}
