package com.etiya.rentACar.business.abstracts;

import java.io.IOException;
import java.util.List;

import com.etiya.rentACar.business.dtos.CarImageSearchListDto;
import com.etiya.rentACar.business.dtos.CarImagesDto;
import com.etiya.rentACar.business.requests.carImageRequest.CreateCarImageRequest;
import com.etiya.rentACar.business.requests.carImageRequest.DeleteCarImageRequest;
import com.etiya.rentACar.business.requests.carImageRequest.UpdateCarImageRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.dataAccess.abstracts.CarImageDao;



public interface CarImageService {
	
	DataResult<List<CarImageSearchListDto>> getAll();
	Result add(CreateCarImageRequest createCarImageRequest) throws IOException;
	Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException;
	Result delete(DeleteCarImageRequest deleteCarImageRequest);
	DataResult<List<CarImagesDto>> getCarImagesByCarId(int id);

}
