package com.recapProject.WoodWorldBeta.utils.configurations.modelMapperConfiguration;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {


ModelMapper forCUDRequest();  //Create Update Delete Request
ModelMapper forGetRequest();

}
