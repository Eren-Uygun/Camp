package com.recapProject.WoodWorldBeta.business.concretes;

import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.CreateProductDto;
import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.DeleteProductDto;
import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.ProductSearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.productDtos.UpdateProductDto;
import com.recapProject.WoodWorldBeta.business.abstracts.ProductService;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public Result add(CreateProductDto createProductDto) {
        return null;
    }

    @Override
    public Result update(UpdateProductDto updateProductDto) {
        return null;
    }

    @Override
    public Result delete(DeleteProductDto deleteProductDto) {
        return null;
    }

    @Override
    public DataResult<ProductSearchListDto> getById(int id) {
        return null;
    }

    @Override
    public DataResult<ProductSearchListDto> getAll() {
        return null;
    }
}
