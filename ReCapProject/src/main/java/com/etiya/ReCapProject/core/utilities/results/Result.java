package com.etiya.ReCapProject.core.utilities.results;


import com.etiya.ReCapProject.business.abstracts.LanguageService;
import com.etiya.ReCapProject.business.abstracts.TranslationService;
import com.etiya.ReCapProject.business.abstracts.WordService;
import com.etiya.ReCapProject.business.concretes.WordManager;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperManager;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.dataAccess.abstracts.LanguageDao;
import com.etiya.ReCapProject.dataAccess.abstracts.WordDao;
import com.etiya.ReCapProject.entities.concretes.Word;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class Result {

	private boolean success;
	private String message;


	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}


	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return get(this.message);
	}
	
	private String get(String message){
		return LanguageSelector.languageSelector(message);
	}
}
