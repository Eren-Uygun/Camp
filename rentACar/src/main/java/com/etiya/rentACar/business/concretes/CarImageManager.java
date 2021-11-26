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
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.dtos.CarImageSearchListDto;
import com.etiya.rentACar.business.dtos.CarImagesDto;
import com.etiya.rentACar.business.dtos.CarSearchListDto;
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
	private CarService carService;

	

	@Autowired
	public CarImageManager(CarImageDao carImageDao, ModelMapperService modelMapperService, CarService carService) {
		super();
		this.carImageDao = carImageDao;
		this.modelMapperService = modelMapperService;
		this.carService = carService;
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

		//İş kurallarında null hatası alıyorum ? Neden ?????
		Result result = BusinessRules.run(
				checkCountCarImages(createCarImageRequest.getCarId()),checkIsCarExists(createCarImageRequest.getCarId()),
				checkImageTypeIsOk(createCarImageRequest.getMultipartFile()));
		if (result != null) { //Is success geldiği zaman null hatası ????
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
		
		Result result = BusinessRules.run(checkIsCarExists(updateCarImageRequest.getCarId()));
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
		Result result = BusinessRules.run(checkIsCarImageExists(deleteCarImageRequest.getId()));
		if (!result.isSuccess()) {
			return result;
		}
		this.carImageDao.delete(this.carImageDao.getById(deleteCarImageRequest.getId()));
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
	public DataResult<List<CarImagesDto>> getCarImagesByCarId(int id) {
		return new SuccessDataResult<List<CarImagesDto>>(this.checkIfCarImageIsEmpty(id));
	}

	private Result checkCountCarImages(int carId) {
		if (this.carImageDao.countCarImagesByCar_Id(carId) <= 5) {
			return new SuccessResult();
		}
		return new ErrorResult("Bir araç için en fazla 5 adet resim eklenebilir.");

	}

	private List<CarImagesDto> checkIfCarImageIsEmpty(int id) {

		if (this.carImageDao.getByCar_Id(id).isEmpty()) {
			CarImagesDto carImageDao = new CarImagesDto();
			carImageDao.setImagePath(
					"C:\\Users\\eren.uygun\\eclipse-workspace\\rentACar\\src\\main\\resources\\static\\images\\default.png");
			List<CarImagesDto> tempArray = new ArrayList<>();
			tempArray.add(carImageDao);
			return tempArray;
		}

		List<CarImage> carImages = this.carImageDao.getByCar_Id(id);//BU bölüme kazara getAll yazılır ise hepsini getiriyor.

		List<CarImagesDto> response = carImages.stream()
				.map(carImage -> modelMapperService.forDto().map(carImage, CarImagesDto.class))
				.collect(Collectors.toList());
		return new ArrayList<CarImagesDto>(response);
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

	private Result checkIsCarImageExists(int id) {
		var result = this.carImageDao.existsById(id);
		if (!result) {
			return new ErrorResult("Resim bulunamadı");
		}
		return new SuccessResult();
	}

	private Result checkIsCarExists(int carId) {
		Result result = this.carService.getCar(carId);
		if (!result.isSuccess()) {
			return new ErrorResult("Araç bulunamadı.");
		}
		return new SuccessResult();
	}
}
