package com.recapProject.WoodWorldBeta.dataAccess.abstracts;

import com.recapProject.WoodWorldBeta.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,String> {


}
