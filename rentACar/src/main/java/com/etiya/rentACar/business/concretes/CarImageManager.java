package com.etiya.rentACar.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACar.business.abstracts.CarImageService;
import com.etiya.rentACar.business.dtos.CarImageSearchListDto;
import com.etiya.rentACar.business.requests.carImageRequest.CreateCarImageRequest;
import com.etiya.rentACar.business.requests.carImageRequest.DeleteCarImageRequest;
import com.etiya.rentACar.business.requests.carImageRequest.UpdateCarImageRequest;
import com.etiya.rentACar.core.utilities.business.BusinessRules;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.ErrorResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CarImageDao;
import com.etiya.rentACar.entities.CarImage;

@Service
public class CarImageManager implements CarImageService {

	private CarImageDao carImageDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CarImageManager(CarImageDao carImageDao, ModelMapperService modelMapperService) {
		super();
		this.carImageDao = carImageDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarImageSearchListDto>> getAll() {
		// TODO Auto-generated method stub
		List<CarImage> result = this.carImageDao.findAll();
		List<CarImageSearchListDto> response = result.stream()
				.map(carImage -> modelMapperService.forDto().map(carImage, CarImageSearchListDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CarImageSearchListDto>>(response);
	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) throws IOException {
		var result = BusinessRules.run(checkCountCarImages(createCarImageRequest.getCarId()),
				checkCountCarImages(createCarImageRequest.getCarId()),
				checkImageTypeIsOk(createCarImageRequest.getMultipartFile()));
		if (result != null) {
			return result;
		}
		CarImage carImage = modelMapperService.forRequest().map(createCarImageRequest, CarImage.class);
		carImage.setImageDate(LocalDate.now());
		carImage.setImagePath(generateImage(createCarImageRequest.getMultipartFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("Resim eklendi.");
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException {
		var result = BusinessRules.run(checkImageIsNull(updateCarImageRequest.getMultipartFile()),checkIsCarExists(updateCarImageRequest.getCarId()));
		if (!result.isSuccess()) {
			return result;
		}
		CarImage carImage = modelMapperService.forRequest().map(updateCarImageRequest, CarImage.class);
		carImage.setImageDate(LocalDate.now());
		carImage.setImagePath(generateImage(updateCarImageRequest.getMultipartFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("Resim güncellendi.");
	}

	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		CarImage carImage = this.carImageDao.getById(deleteCarImageRequest.getId());
		this.carImageDao.delete(carImage);
		return new SuccessResult("Resim silindi.");
	}

	private File generateImage(MultipartFile file) throws IOException {

		String imagePathGuid = java.util.UUID.randomUUID().toString();

		File imageFile = new File(
				"C:\\Users\\eren.uygun\\eclipse-workspace\\rentACar\\src\\main\\resources\\static\\images\\"
						+ imagePathGuid + "."
						+ file.getContentType().substring(file.getContentType().indexOf("/") + 1));

		imageFile.createNewFile();
		FileOutputStream outputImage = new FileOutputStream(imageFile);
		outputImage.write(file.getBytes());
		outputImage.close();

		return imageFile;
	}

	@Override
	public DataResult<List<CarImageSearchListDto>> getCarImagesByCarId(int id) {
		return new SuccessDataResult<List<CarImageSearchListDto>>(this.checkIfCarImageIsEmpty(id));
	}

	private Result checkCountCarImages(int id) {
		var result = this.carImageDao.countCarImageByCarId(id);
		if (result >= 5) {
			return new SuccessResult("Bir araç için en fazla 5 adet resim eklenebilir.");
		}
		return new SuccessResult("Resim eklendi.");

	}

	private List<CarImageSearchListDto> checkIfCarImageIsEmpty(int id) {
		var result = this.carImageDao.getCarImagesByCarId(id);
		if (result.isEmpty()) {
			CarImageSearchListDto carImageSearchListDto = new CarImageSearchListDto();
			carImageSearchListDto.setImagePath(
					"C:\\Users\\eren.uygun\\eclipse-workspace\\rentACar\\src\\main\\resources\\static\\images\\default.png");
			List<CarImageSearchListDto> tempArray = new ArrayList<CarImageSearchListDto>();
			tempArray.add(carImageSearchListDto);
			return tempArray;
		}

		List<CarImage> carImages = this.carImageDao.findAll();

		List<CarImageSearchListDto> response = carImages.stream()
				.map(carImage -> modelMapperService.forDto().map(carImages, CarImageSearchListDto.class))
				.collect(Collectors.toList());
		return new ArrayList<CarImageSearchListDto>(response);
	}

	private Result checkImageIsNull(MultipartFile file) {
		if (file == null || file.isEmpty() || file.getSize() == 0) {
			return new ErrorResult("Resim sisteme yüklenemedi.");
		}
		return new SuccessResult();
	}

	private Result checkImageTypeIsOk(MultipartFile multipartFile) {
		if (!(checkImageIsNull(multipartFile).isSuccess())) {
			return new ErrorResult(this.checkImageIsNull(multipartFile).getMessage());
		}
		if (!multipartFile.getContentType().toString().substring(multipartFile.getContentType().indexOf("/") + 1)
				.equals("jpeg")
				&& !multipartFile.getContentType().toString().substring(multipartFile.getContentType().indexOf("/") + 1)
						.equals("jpg")
				&& !multipartFile.getContentType().toString().substring(multipartFile.getContentType().indexOf("/") + 1)
						.equals("png")) {
			return new ErrorResult("Resim uzantısı uygun değil");
		}
		return new SuccessResult();
	}
	
	private Result checkIsCarExists(int carId) {
	
		var result = this.carImageDao.getCarImagesByCarId(carId);
		if (result == null) {
			return new ErrorResult("Araca ait resim bulunamadı.");
		}
		return new SuccessResult("Resim bulundu.");
	}
	

}
