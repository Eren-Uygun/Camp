package com.etiya.rentACar.business.requests.carImageRequest;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarImageRequest {
	private int Id;
	private int carId;
	private MultipartFile multipartFile;
	private LocalDate imageDate;

}
