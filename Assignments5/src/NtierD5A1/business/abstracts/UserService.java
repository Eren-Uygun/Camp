package NtierD5A1.business.abstracts;

import java.util.List;

import NtierD5A1.entities.concretes.User;

public interface UserService {

	void register(User user);
	
	List<User> getUsers();
	
	void signInWithGoogle(String email);
 
}
