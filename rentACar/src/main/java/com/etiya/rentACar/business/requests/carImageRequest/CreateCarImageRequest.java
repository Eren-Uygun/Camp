package com.etiya.rentACar.business.requests.carImageRequest;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageRequest {
	
	@JsonIgnore
	private int id;
	
	private int carId;
	@JsonIgnore
	private String imagePath;
	@JsonIgnore
	private MultipartFile multipartFile;
	@JsonIgnore
	private LocalDate imageDate;

}
