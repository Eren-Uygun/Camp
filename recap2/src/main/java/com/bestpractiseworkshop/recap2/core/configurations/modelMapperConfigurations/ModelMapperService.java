package com.bestpractiseworkshop.recap2.core.configurations.modelMapperConfigurations;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forDtos();
    ModelMapper forRequests();

    
}
