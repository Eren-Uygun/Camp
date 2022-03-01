package com.recapProject.WoodWorldBeta.utils.configurations.modelMapperConfiguration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperServiceImpl implements ModelMapperService {

     private ModelMapper modelMapper;

     @Autowired
    public ModelMapperServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //Set Ambiguity -> Eşleşememe durumunu ignore edecek ve kendini eşleştirecektir.

    @Override
    public ModelMapper forCUDRequest() {
      this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
      return modelMapper;
    }

    @Override
    public ModelMapper forGetRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}
