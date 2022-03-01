package com.recapProject.WoodWorldBeta.utils.configurations.extServices.mernisService.concretes;

import com.recapProject.WoodWorldBeta.core.utils.results.Result;
import com.recapProject.WoodWorldBeta.core.utils.results.SuccessResult;
import com.recapProject.WoodWorldBeta.utils.configurations.extServices.mernisService.abstracts.MernisService;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements MernisService {

    @Override
    public Result verifyPerson(Long natinonalIdentity, String firstName, String lastName, int birthYear) {
        return new SuccessResult("Kullanıcı doğrulandı.");
    }
}
