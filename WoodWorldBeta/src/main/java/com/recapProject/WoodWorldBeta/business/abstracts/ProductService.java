package com.recapProject.WoodWorldBeta.business.abstracts;

import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.CreateProductDto;
import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.DeleteProductDto;
import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.ProductSearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.UpdateProductDto;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;

public interface ProductService {

    Result add(CreateProductDto createProductDto);
    Result update(UpdateProductDto updateProductDto);
    Result delete(DeleteProductDto deleteProductDto);
    DataResult<ProductSearchListDto> getById(int id);
    DataResult<ProductSearchListDto> getAll();

}
