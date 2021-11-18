package com.etiya.rentACar.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.entities.Car;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	
	
	@GetMapping("/getCars")
	public List<Car> getCars(){
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car(1,1,1,1997,30,"Eski Model Toros"));
		cars.add(new Car(2,1,1,2021,400,"2021 Model Audi"));
		cars.add(new Car(3,1,1,2012,400,"2012 Model Modifiyeli Fort Fiesta"));
		cars.add(new Car(4,1,1,1990,400,"90 Model Murat 131 Modifiyeli"));
		
		return cars;
	}
	

}
