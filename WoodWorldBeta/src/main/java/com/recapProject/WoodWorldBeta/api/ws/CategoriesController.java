package com.recapProject.WoodWorldBeta.api.ws;

import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.CreateCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.DeleteCategoryDto;
import com.recapProject.WoodWorldBeta.business.Dtos.CategoryDtos.UpdateCategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoriesController {


    @RequestMapping(name = "getCategories",method = RequestMethod.GET)
    public ResponseEntity<List<?>> getAll(){
        return ResponseEntity.ok(null);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/getById")
    public ResponseEntity<?> getById(int id){
        return ResponseEntity.ok(null);
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST,consumes = "application/json",name = "AddCategory")
    public ResponseEntity<?> add(CreateCategoryDto createCategoryDto){
        return ResponseEntity.ok(null);
    }

    @RequestMapping(path = "/update",method = RequestMethod.PUT,consumes = "application/json",produces = "application/json",name = "UpdateCategory")
    public ResponseEntity<?> update(UpdateCategoryDto updateCategoryDto){
        return ResponseEntity.ok(null);
    }

    @RequestMapping(path = "/delete",method = RequestMethod.DELETE ,name = "DeleteCategory")
    public ResponseEntity<?> delete(DeleteCategoryDto deleteCategoryDto){
        return ResponseEntity.ok(null);
    }

}
