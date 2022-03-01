package com.recapProject.WoodWorldBeta.utils.configurations.extServices.mernisService.abstracts;

import com.recapProject.WoodWorldBeta.core.utils.results.Result;

public interface MernisService {
   Result verifyPerson(Long natinonalIdentity, String firstName,String lastName,int birthYear);
}
