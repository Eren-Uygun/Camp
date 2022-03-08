package com.recapProject.WoodWorldBeta.business.abstracts;

import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.CreateOrganizationDto;
import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.DeleteOrganizationDto;
import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.OrganizationSearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.UpdateOrganizationDto;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;

import java.util.List;

public interface OrganizationService {

    Result add(CreateOrganizationDto createOrganizationDto);
    Result update(UpdateOrganizationDto updateOrganizationDto);
    Result delete(DeleteOrganizationDto deleteOrganizationDto);
    DataResult<OrganizationSearchListDto> getById(int id);
    DataResult<List<OrganizationSearchListDto>> getAll();

}
