package com.appsdeveloperblog.rentacar.users.dataAccess;

import com.appsdeveloperblog.rentacar.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<User,Integer> {
	
	User getByEmail(String email);
	
	boolean existsUserByEmail(String email);

}
