package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACar.entities.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {
	
	List<Color> getColorsByColorNameContains(String colorName);
	

}
