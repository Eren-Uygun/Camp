package com.appsdeveloperblog.rentacar.api.rental.dataAccess;

import com.appsdeveloperblog.rentacar.api.rental.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {

}
