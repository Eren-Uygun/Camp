package com.recapProject.WoodWorldBeta.business.concretes;

import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.CreateOrganizationDto;
import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.DeleteOrganizationDto;
import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.OrganizationSearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.organizationDtos.UpdateOrganizationDto;
import com.recapProject.WoodWorldBeta.business.abstracts.OrganizationService;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {




    @Override
    public Result add(CreateOrganizationDto createOrganizationDto) {
        return null;
    }

    @Override
    public Result update(UpdateOrganizationDto updateOrganizationDto) {
        return null;
    }

    @Override
    public Result delete(DeleteOrganizationDto deleteOrganizationDto) {
        return null;
    }

    @Override
    public DataResult<OrganizationSearchListDto> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<OrganizationSearchListDto>> getAll() {
        return null;
    }
}
