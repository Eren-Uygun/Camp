package com.etiya.rentACar.ws;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACar.business.abstracts.CarImageService;
import com.etiya.rentACar.business.dtos.CarImageSearchListDto;
import com.etiya.rentACar.business.requests.carImageRequest.CreateCarImageRequest;
import com.etiya.rentACar.business.requests.carImageRequest.DeleteCarImageRequest;
import com.etiya.rentACar.business.requests.carImageRequest.UpdateCarImageRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/carImages/")
public class CarImagesController {
	
	
	private CarImageService carImageService;

	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}
	
	@GetMapping(path = "/getAll")
	public DataResult<List<CarImageSearchListDto>> getAll(){
		return this.carImageService.getAll();
	}
	
	
	@GetMapping(path = "/getImagesByCarId")
	public DataResult<List<CarImageSearchListDto>> getImagesByCarId(int carId){
		return null;
		
	}
	
	@PostMapping(path = "/add")
	public Result add(int carId,MultipartFile file) throws IOException {
		CreateCarImageRequest createCarImageRequest = new CreateCarImageRequest();
		createCarImageRequest.setCarId(carId);
		createCarImageRequest.setMultipartFile(file);
		return this.carImageService.add(createCarImageRequest);
		
	}
	
	@PutMapping(path = "/update")
	public Result update(@RequestParam("id") int id,@RequestParam("carId") int carId,MultipartFile multipartFile) throws IOException {
	
		UpdateCarImageRequest updateCarImageRequest = new UpdateCarImageRequest();
		updateCarImageRequest.setId(id);
		updateCarImageRequest.setCarId(carId);
		updateCarImageRequest.setMultipartFile(multipartFile);
		return this.carImageService.update(updateCarImageRequest);
		
	}
	
	@DeleteMapping(path = "/delete")
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) throws IOException {
		return this.carImageService.delete(deleteCarImageRequest);
		
	}
	
	
	

}
