package com.etiya.northwindSpring.ws;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwindSpring.business.Dtos.ProductSearchListDto;
import com.etiya.northwindSpring.business.abstracts.ProductService;
import com.etiya.northwindSpring.business.requests.CreateProductRequest;
import com.etiya.northwindSpring.business.requests.DeleteProductRequest;
import com.etiya.northwindSpring.business.requests.UpdateProductRequest;
import com.etiya.northwindSpring.core.utils.results.DataResult;
import com.etiya.northwindSpring.core.utils.results.Result;
import com.etiya.northwindSpring.entities.complexTypes.ProductDetail;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	//PostMapping = Ekleme işlemleri
	//PutMapping = Güncelleme işlemleri
	//DeleteMappning = Silme işlemleri için kullanılır.
	ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

/*
	@GetMapping(path = "/check",name = "Product Check")
	public String check() {
		return "API up";
	}
	
	*/
	
	@PostMapping(path = "/add")
	public Result add(@RequestBody @Valid CreateProductRequest createProductRequest) {
		return productService.add(createProductRequest);
		
	}
	
	@PutMapping(path = "/update")
	public Result update(@RequestBody @Valid UpdateProductRequest updateProductRequest) {
		return productService.update(updateProductRequest);
		
	}
	
	@DeleteMapping(path = "/delete")
	public Result save(@RequestBody @Valid DeleteProductRequest deleteProductRequest) {
		return productService.delete(deleteProductRequest);
		
	}
	
	@GetMapping(path = "/getProductsByName")
	public DataResult<List<ProductSearchListDto>> getProductByName(@RequestParam("productName")  String productName){
		
		//List<Product> products = new ArrayList<Product>();
		//Bu bölüm kullanılan spring versiyonuna göre hata verebilir.
		return this.productService.getByProductName(productName);
	}
	
	
	//Bu bölümde zaten complex bi yapıdan çektiğimiz için maplemeye gerek yok.
	@GetMapping(path = "/getProductWithCategoryDetails")
	public DataResult<List<ProductDetail>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	
	
	
	
	@GetMapping(path = "/getProducts")
	public DataResult<List<ProductSearchListDto>> getAll(){
		
		//List<Product> products = new ArrayList<Product>();
		//Bu bölüm kullanılan spring versiyonuna göre hata verebilir.
		return this.productService.getAll();
	}

}
//http://localhost:8080/api/products/check
