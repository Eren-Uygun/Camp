package com.etiya.northwindSpring.business.abstracts;

import java.util.List;

import com.etiya.northwindSpring.business.Dtos.ProductSearchListDto;
import com.etiya.northwindSpring.business.requests.CreateProductRequest;
import com.etiya.northwindSpring.business.requests.DeleteProductRequest;
import com.etiya.northwindSpring.business.requests.UpdateProductRequest;
import com.etiya.northwindSpring.core.utils.results.DataResult;
import com.etiya.northwindSpring.core.utils.results.Result;
import com.etiya.northwindSpring.entities.complexTypes.ProductDetail;

public interface ProductService {
	
	DataResult<List<ProductSearchListDto>> getAll();

	Result add(CreateProductRequest createProductRequest);

	Result update(UpdateProductRequest updateProductRequest);

	Result delete(DeleteProductRequest deleteProductRequest);
	
	DataResult<List<ProductSearchListDto>> getByProductName(String productName);
	
	DataResult<List<ProductDetail>> getProductWithCategoryDetails();
}
