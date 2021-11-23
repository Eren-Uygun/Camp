package com.etiya.rentACar.ws;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.dtos.ColorSearchListDto;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.Color;
import com.etiya.rentACar.entities.complexTypes.ColorWithBrandAndCar;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {
	
	private ColorService colorService;
	
	
	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}



	@GetMapping( path = "/getColors")
	public DataResult<List<ColorSearchListDto>> getColors(){
		
		
		return colorService.getColors();
		
	}
	
	@PostMapping(path = "/add")
	public Result add(@RequestBody @Valid CreateColorRequest createColorRequest) {
		return this.colorService.add(createColorRequest);
	}
	
	@PutMapping(path = "/update")
	public Result update(@RequestBody @Valid UpdateColorRequest updateColorRequest) {
		return this.colorService.update(updateColorRequest);
	}
	@DeleteMapping(path = "/delete")
	public Result delete(@RequestBody @Valid DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}
	
	@GetMapping(path = "/getColorsWithBrandsAndCars")
	public DataResult<List<ColorWithBrandAndCar>> getColorsWithBrandsAndCars(){
		return this.colorService.getColorsWithExistsBrandsAndCars();
	}

}
