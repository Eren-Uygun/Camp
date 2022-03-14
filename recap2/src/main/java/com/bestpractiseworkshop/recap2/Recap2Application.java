package com.bestpractiseworkshop.recap2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Recap2Application {

	public static void main(String[] args) {
		SpringApplication.run(Recap2Application.class, args);
	}


	@Bean(name = "ModelMapper")
	public ModelMapper getModelMapperBean(){
		return new ModelMapper();
	}

}
