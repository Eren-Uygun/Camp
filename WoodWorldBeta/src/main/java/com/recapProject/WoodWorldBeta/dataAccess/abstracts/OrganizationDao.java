package com.recapProject.WoodWorldBeta.dataAccess.abstracts;

import com.recapProject.WoodWorldBeta.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationDao  extends JpaRepository<Organization,String> {
}
