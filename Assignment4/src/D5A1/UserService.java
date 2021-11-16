package D5A1;

public interface UserService {
	
	public void register(User user);
	
	public void login(String email,String password);
	
	public void loginWithGoogle(String email);
	

}
