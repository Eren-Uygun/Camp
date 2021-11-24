package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.dtos.ColorSearchListDto;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.core.utilities.business.BusinessRules;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.ErrorResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Color;
import com.etiya.rentACar.entities.complexTypes.ColorWithBrandAndCar;

@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		super();
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ColorSearchListDto>> getColors() {

		List<Color> result = this.colorDao.findAll();
		List<ColorSearchListDto> response = result.stream()
				.map(Color -> modelMapperService.forDto().map(Color, ColorSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ColorSearchListDto>>(response);

	}

	@Override
	public Result add(CreateColorRequest createColorRequest) {
		var result = BusinessRules.run(checkExistsColorName(createColorRequest.getColorName()));
		if (result != null) {
			return result;
			
		}
		Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult("Renk eklendi.");

	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		var result = BusinessRules.run(checkColorByExistColorId(updateColorRequest.getColorId()),checkExistsColorName(updateColorRequest.getColorName()));
		if (result != null) {
			return result;
		}
		Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult("Renk güncellendi.");

	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		var result = BusinessRules.run(checkColorByExistColorId(deleteColorRequest.getColorId()));
		if (result != null) {
			return result;
		}
		Color color = modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		this.colorDao.delete(color);
		return new SuccessResult("Renk silindi.");

	}

	@Override
	public DataResult<List<ColorWithBrandAndCar>> getColorsWithExistsBrandsAndCars() {
		var result = this.colorDao.getColorsWithExistsBrandsAndCars();
		return new SuccessDataResult<List<ColorWithBrandAndCar>>(result);
	}

	private Result checkExistsColorName(String colorName) {

		var result = this.colorDao.getByColorName(colorName);
		if (result != null) {
			return new ErrorResult("Bu renk adı sistemde mevcut");
		} else {
			return new SuccessResult("Renk sisteme kaydedildi.");
		}

	}

	private Result checkColorByExistColorId(int id) {
		var result = this.colorDao.existsById(id);
		if (!result) {
			return new ErrorResult("İlgili id sistemde mevcut değil");
		}
		return new SuccessResult("İlgili id sistemde bulundu.");

	}

}
