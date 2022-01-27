package com.recapProject.WoodWorldBeta.business.abstracts;

import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.CategorySearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.CreateCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.DeleteCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.UpdateCategoryDto;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;

import java.util.List;

public interface CategoryService {

    Result add(CreateCategoryDto createCategoryDto);
    Result update(UpdateCategoryDto updateCategoryDto);
    Result delete(DeleteCategoryDto deleteCategoryDto);
    DataResult<List<CategorySearchListDto>> getAll();
    DataResult<CategorySearchListDto> getById(int id);

}
