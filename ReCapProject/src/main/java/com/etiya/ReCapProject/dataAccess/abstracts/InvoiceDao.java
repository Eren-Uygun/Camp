package com.etiya.ReCapProject.dataAccess.abstracts;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.ReCapProject.business.dtos.InvoiceSearchListDto;
import com.etiya.ReCapProject.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceDao extends JpaRepository<Invoice, Integer>{
	
	List<Invoice> getByCustomer_Id(int id);
	
	

	@Query("select i from Invoice i where i.createDate between ?1 and ?2")
	List<Invoice> getByCreateDateBetween(LocalDate beginDate, LocalDate endDate);
	
	
	

}
