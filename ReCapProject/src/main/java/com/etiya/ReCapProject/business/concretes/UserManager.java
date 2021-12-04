package com.etiya.ReCapProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.business.requests.UserRequests.LoginUserRequest;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.UserDao;

@Service
public class UserManager implements UserService {
	private UserDao userDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public UserManager(UserDao userDao, ModelMapperService modelMapperService) {
		super();
		this.userDao = userDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result login(LoginUserRequest loginUserRequest) {
		Result result = BusinessRules.run(checkCredentials(loginUserRequest.getEmail(), loginUserRequest.getPassword()));
		if (result!=null) {
			return result;
		}
		return new SuccessResult(Messages.LOGINSUCCESS);
		/*
		User user= this.userDao.getByEmail(loginUserRequest.getEmail());
		if (user==null) {
			return new ErrorResult("email sisteme kayıtlı değil");
		}
		if (user.getEmail().equals(loginUserRequest.getEmail())&&user.getPassword().equals(loginUserRequest.getPassword())) {
			return new SuccessResult(Messages.LOGINSUCCESS);
		}
		return new ErrorResult("Kullanıcı bilgileri hatalı");
		*/
	}
	private Result checkCredentials(String email,String password) {
		var user =  this.userDao.getByEmail(email);
		if (user == null) {
			return new ErrorResult(Messages.LOGINEMAILERROR);
		}
		
		if (!(user.getPassword().equals(password))) {
			return new ErrorResult(Messages.LOGINPASSWORDERROR);
		}
		return new SuccessResult();	
	}
	@Override
	public Result isUserExists(int userId) {
		var result=this.userDao.existsById(userId);
		if (!result) {
			return new ErrorResult(Messages.USERNOTFOUND);
		}
		return new SuccessResult();
	}

	@Override
	public Result isUserEmailExists(String email) {
		var existsResult = this.userDao.existsUserByEmail(email);
		if (existsResult){
			return new ErrorResult(Messages.EMAILERROR);
		}
		return new SuccessResult();
	}
}
