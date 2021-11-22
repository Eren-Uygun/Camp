package com.etiya.northwindSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwindSpring.entities.Product;


//Jpa Repository tüm veri tabanı işlemlerini yapabildiğimiz pakettir.
//Jpa oldukça ekstra concrete metot yazmamıza gerek kalmıyor.
public interface ProductDao extends JpaRepository<Product,Integer> {

}
