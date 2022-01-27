package com.recapProject.WoodWorldBeta.dataAccess.abstracts;

import com.recapProject.WoodWorldBeta.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,String> {
}
