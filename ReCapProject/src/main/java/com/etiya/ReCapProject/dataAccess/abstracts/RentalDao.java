package com.etiya.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.ReCapProject.business.dtos.RentalSearchListDto;
import com.etiya.ReCapProject.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {
	
	Rental getByCarId(int carId);

	boolean existsByCarId(int id);


	@Query(" select ass.dailyPrice from Rental r inner join AdditionalRentalItem ari on r.id = ari.rental.id inner join AdditionalService ass on ari.additionalService.id = ass.id where r.id=:rentalId")
	List<Integer> getAdditionalItemsOfRelevantRental(int rentalId);
}
