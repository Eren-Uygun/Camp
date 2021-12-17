package com.appsdeveloperblog.rentacar.users.business.abstracts;

import com.appsdeveloperblog.rentacar.users.business.dtos.UserDtos.UserDto;
import com.appsdeveloperblog.rentacar.users.business.requests.UserRequests.LoginUserRequest;
import com.appsdeveloperblog.rentacar.users.core.utils.results.Result;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	
	Result login(LoginUserRequest loginUserRequest);
	Result isUserExists(int userId);
	Result isUserEmailExists(String email);
	
	UserDto getUserDetailsByEmail(String email);

}
