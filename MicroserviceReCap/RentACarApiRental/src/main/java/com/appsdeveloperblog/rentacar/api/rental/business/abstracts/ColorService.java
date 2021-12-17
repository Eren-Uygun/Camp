package com.appsdeveloperblog.rentacar.api.rental.business.abstracts;

import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.ColorSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.CreateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.DeleteColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.UpdateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;

import java.util.List;

public interface ColorService {
	
	Result add(CreateColorDto createColorDto);
	Result update(UpdateColorDto updateColorDto);
	Result delete(DeleteColorDto deleteColorDto);
	DataResult<ColorSearchListDto> getById(int id);
	DataResult<List<ColorSearchListDto>> getAll();

}
