package com.appsdeveloperblog.photoapp.api.users.dataAccess;

import org.springframework.data.repository.CrudRepository;

import com.appsdeveloperblog.photoapp.api.users.entities.UserEntity;


//CrudRepository -> JpaRepository'nin yerine kullanılabilen Crud odaklı bir yapıdır.
public interface UserRepository extends CrudRepository<UserEntity, String> {
	
	UserEntity findByEmail(String email);

}
