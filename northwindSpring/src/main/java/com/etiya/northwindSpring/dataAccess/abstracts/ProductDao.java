package com.etiya.northwindSpring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.northwindSpring.entities.Product;
import com.etiya.northwindSpring.entities.complexTypes.ProductDetail;


//Jpa Repository tüm veri tabanı işlemlerini yapabildiğimiz pakettir.
//Jpa oldukça ekstra concrete metot yazmamıza gerek kalmıyor.
public interface ProductDao extends JpaRepository<Product,Integer> {
	
	List<Product> getByProductNameContains(String productName);
	
	@Query("Select new com.etiya.northwindSpring.entities.complexTypes.ProductDetail "+
	"(p.id,p.productName,c.categoryName,p.unitPrice,p.unitsInStock) "+
			"From Category c Inner Join c.products p")
	List<ProductDetail> getProductWithCategoryDetails();
	
	
	//JPQL -> .Net'de bu LINQ

}

//Daoda sqldeki tüm sorguları kullanabiliriz.