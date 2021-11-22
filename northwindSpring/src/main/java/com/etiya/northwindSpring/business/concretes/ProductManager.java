package com.etiya.northwindSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwindSpring.business.Dtos.ProductSearchListDto;
import com.etiya.northwindSpring.business.abstracts.ProductService;
import com.etiya.northwindSpring.business.requests.CreateProductRequest;
import com.etiya.northwindSpring.business.requests.DeleteProductRequest;
import com.etiya.northwindSpring.business.requests.UpdateProductRequest;
import com.etiya.northwindSpring.core.utils.mapping.ModelMapperService;
import com.etiya.northwindSpring.core.utils.results.DataResult;
import com.etiya.northwindSpring.core.utils.results.Result;
import com.etiya.northwindSpring.core.utils.results.SuccessDataResult;
import com.etiya.northwindSpring.core.utils.results.SuccessResult;
import com.etiya.northwindSpring.dataAccess.abstracts.ProductDao;
import com.etiya.northwindSpring.entities.Product;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	private ModelMapperService modelMapperService;
	
	
	@Autowired
	public ProductManager(ProductDao productDao, ModelMapperService modelMapperService) {
		this.productDao = productDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ProductSearchListDto>> getAll() {
		//List<Product> products = new ArrayList<Product>();
		//products.add(new Product(1,"elma",1,10,2,"dsf"));
		//return this.productDao.findAll();
		
		//Stream foreach gibi dolaşır.
		//List<ProductSearchListDto> response = new ArrayList<ProductSearchListDto>();
		List<Product> result = this.productDao.findAll();
		
		//Her bir product'u yeni bir ProductSearchListDto listesine çevirir.
		//Class'daki isimleri kontrol eder aynı ise eşleştirir.
		
		List<ProductSearchListDto> response = result.stream().map(product->modelMapperService.forDto().map(product, ProductSearchListDto.class /*c#*/)).collect(Collectors.toList());
		
		/*
		for (Product product : result) {
			response.add(new ProductSearchListDto(product.getId(),product.getProductName(), product.getUnitPrice(),product.getUnitsInStock()));
			
		}
		*/
		return new SuccessDataResult<List<ProductSearchListDto>>(response);
		
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {
		
		Product product = modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productDao.save(product);
		
		return new SuccessResult("Product Added");
		
	}

	@Override
	public Result update(UpdateProductRequest updateProductRequest) {
		Product product = modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productDao.save(product);
		
		return new SuccessResult("Product Updated");
		
	}

	@Override
	public Result delete(DeleteProductRequest deleteProductRequest) {
		//Product product = modelMapperService.forRequest().map(deleteProductRequest, Product.class);
		//Product product = this.productDao.getById(deleteProductRequest.getId());
		//this.productDao.delete(product);
		this.productDao.getById(deleteProductRequest.getId());
		
		return new SuccessResult("Product Deleted");
		
	}

}

//Getireceğimiz dataları direkt olarak entity'den döndürmemek gerekiyor
//Dto yazılması gereklidir.Yani data transformation object
//GElecek nesnelerimi dto ya dönüştürüp getirmem gerekiyor.

//Dto'ların yeri business ve entities olabilir.
//Clean architecture ve sqrs tarafında business'de olması gerekiyor.
