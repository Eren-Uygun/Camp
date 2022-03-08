package com.recapProject.WoodWorldBeta.business.abstracts;

import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.CreateIndividualCustomerDto;
import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.DeleteIndividualCustomerDto;
import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.IndividualCustomerSearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.UpdateIndividualCustomerDto;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;

import java.util.List;

public interface IndividualCustomerService {

    Result add(CreateIndividualCustomerDto createIndividualCustomerDto);
    Result update(UpdateIndividualCustomerDto updateIndividualCustomerDto);
    Result delete(DeleteIndividualCustomerDto deleteIndividualCustomerDto);
    DataResult<IndividualCustomerSearchListDto> getById(int id);
    DataResult<List<IndividualCustomerSearchListDto>> getAll();
}
