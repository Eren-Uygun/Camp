package NtierD5A1.business.concretes;

import java.util.List;

import NtierD5A1.business.abstracts.UserService;
import NtierD5A1.dataAccess.abstracts.UserRepository;
import NtierD5A1.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserRepository userRepository;
	
	

	public UserManager(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public void register(User user) {
		
		 userRepository.add(user);
		
	}



	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAll();
	}

}
