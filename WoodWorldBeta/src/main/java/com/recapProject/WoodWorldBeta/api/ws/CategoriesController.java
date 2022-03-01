package com.recapProject.WoodWorldBeta.api.ws;

import com.recapProject.WoodWorldBeta.business.Dtos.categoryDtos.CategorySearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.categoryDtos.CreateCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.categoryDtos.DeleteCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.categoryDtos.UpdateCategoryDto;
import com.recapProject.WoodWorldBeta.business.abstracts.CategoryService;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(name = "getCategories",method = RequestMethod.GET)
    public ResponseEntity<List<?>> getAll(){
        DataResult<List<CategorySearchListDto>> dataResult = this.categoryService.getAll();
        return ResponseEntity.ok().body(dataResult.getData());
    }

    @RequestMapping(method = RequestMethod.GET,path = "/getById")
    public ResponseEntity<?> getById(int id){
        DataResult<?> result = this.categoryService.getById(id);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST,consumes = "application/json",name = "AddCategory")
    public ResponseEntity<?> add(CreateCategoryDto createCategoryDto){
        this.categoryService.add(createCategoryDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(path = "/update",method = RequestMethod.PUT,consumes = "application/json",produces = "application/json",name = "UpdateCategory")
    public ResponseEntity<?> update(UpdateCategoryDto updateCategoryDto){
        this.categoryService.update(updateCategoryDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(path = "/delete",method = RequestMethod.DELETE ,name = "DeleteCategory")
    public ResponseEntity<?> delete(DeleteCategoryDto deleteCategoryDto){
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
