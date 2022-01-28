package com.recapProject.WoodWorldBeta;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WoodWorldBetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoodWorldBetaApplication.class, args);
	}

	@Bean(name = "ModelMapper")
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
