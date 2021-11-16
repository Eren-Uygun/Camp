package D5A1;

public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		user.setId(1);
		user.setFirstName("Eren");
		user.setLastName("Uygun");
		user.setNationalIdentityNumber("11111111111");
		user.setEmail("eren@testmail.com");
		user.setPassword("123456");
		
		UserService userService = new UserManager(new JpaUserDao(),new DbLoggerManager());
		UserService externalUserService = new UserManager(new CustomLoginManager(),new DbLoggerManager());
		//userService.loginWithGoogle(user.getEmail());
		userService.register(user);
		userService.login(user.getEmail(), user.getPassword());
		externalUserService.loginWithGoogle(user.getEmail());
		
		
		

	}

}
