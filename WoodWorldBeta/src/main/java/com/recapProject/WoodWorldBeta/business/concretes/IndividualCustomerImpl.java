package com.recapProject.WoodWorldBeta.business.concretes;

import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.CreateIndividualCustomerDto;
import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.DeleteIndividualCustomerDto;
import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.IndividualCustomerSearchListDto;
import com.recapProject.WoodWorldBeta.business.Dtos.individualCustomerDtos.UpdateIndividualCustomerDto;
import com.recapProject.WoodWorldBeta.business.abstracts.IndividualCustomerService;
import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;
import com.recapProject.WoodWorldBeta.dataAccess.abstracts.IndividualCustomerDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualCustomerImpl implements IndividualCustomerService {

    private IndividualCustomerDao individualCustomerDao;
    private ModelMapper modelMapper;

    @Override
    public Result add(CreateIndividualCustomerDto createIndividualCustomerDto) {
        return null;
    }

    @Override
    public Result update(UpdateIndividualCustomerDto updateIndividualCustomerDto) {
        return null;
    }

    @Override
    public Result delete(DeleteIndividualCustomerDto deleteIndividualCustomerDto) {
        return null;
    }

    @Override
    public DataResult<IndividualCustomerSearchListDto> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
        return null;
    }
}
