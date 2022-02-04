package com.recapProject.WoodWorldBeta.business.abstracts;

import com.recapProject.WoodWorldBeta.core.utils.results.DataResult;
import com.recapProject.WoodWorldBeta.core.utils.results.Result;

public interface ProductService {

    Result add();
    Result update();
    Result delete();
    DataResult<?> getById(int id);
    DataResult<?> getAll();

}
