package com.etiya.northwindSpring.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwindSpring.entities.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	//PostMapping = Ekleme işlemleri
	//PutMapping = Güncelleme işlemleri
	//DeleteMappning = Silme işlemleri için kullanılır.
	
	
	@GetMapping(path = "/check",name = "Product Check")
	public String check() {
		return "API up";
	}
	
	
	@GetMapping(path = "/getProducts")
	public List<Product> getAll(){
		
		//List<Product> products = new ArrayList<Product>();
		
		
		
		return null;
	}

}
//http://localhost:8080/api/products/check
