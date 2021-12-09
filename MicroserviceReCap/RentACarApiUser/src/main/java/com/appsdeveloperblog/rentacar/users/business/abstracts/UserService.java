package com.appsdeveloperblog.rentacar.users.business.abstracts;

import com.appsdeveloperblog.rentacar.users.business.requests.UserRequests.LoginUserRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;

public interface UserService {
	
	Result login(LoginUserRequest loginUserRequest);
	Result isUserExists(int userId);
	Result isUserEmailExists(String email);

}
