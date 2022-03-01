package com.recapProject.WoodWorldBeta.utils.configurations.extServices.orgCheckService.concretes;

import com.recapProject.WoodWorldBeta.core.utils.results.Result;
import com.recapProject.WoodWorldBeta.core.utils.results.SuccessResult;
import com.recapProject.WoodWorldBeta.utils.configurations.extServices.orgCheckService.abstracts.CheckOrganizationService;
import org.springframework.stereotype.Service;

@Service
public class CheckOrganizationAdapter implements CheckOrganizationService {
    @Override
    public Result checkOrganization(String taxNumber) {
        return new SuccessResult("Organizasyon Doğrulandı.");
    }
}
