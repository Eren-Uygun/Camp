package NtierD5A1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import NtierD5A1.dataAccess.abstracts.UserRepository;
import NtierD5A1.entities.concretes.User;

public class JpaUserDao implements UserRepository {
	
	List<User> users;
	
	

	public JpaUserDao() {
		super();
		this.users = new ArrayList<User>();
	}

	@Override
	public void add(User entity) {
		users.add(entity);
		
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

}
