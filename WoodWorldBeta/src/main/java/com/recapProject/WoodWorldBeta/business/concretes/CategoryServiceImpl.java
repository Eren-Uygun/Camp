package com.recapProject.WoodWorldBeta.business.concretes;

import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.CategorySearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.CreateCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.DeleteCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.UpdateCategoryDto;
import com.recapProject.WoodWorldBeta.business.abstracts.CategoryService;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;
import com.recapProject.WoodWorldBeta.dataAccess.abstracts.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Result add(CreateCategoryDto createCategoryDto) {
        return null;
    }

    @Override
    public Result update(UpdateCategoryDto updateCategoryDto) {
        return null;
    }

    @Override
    public Result delete(DeleteCategoryDto deleteCategoryDto) {
        return null;
    }

    @Override
    public DataResult<List<CategorySearchListDto>> getAll() {
        return null;
    }

    @Override
    public DataResult<CategorySearchListDto> getById(int id) {
        return null;
    }
}
