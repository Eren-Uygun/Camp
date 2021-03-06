package D5A1;

public class UserManager implements UserService {

	private UserDao userDao;
	private CustomLoginService customLoginService;
	private BaseLoggerService baseLoggerService;


	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
		
	}
	
	

	public UserManager(UserDao userDao, BaseLoggerService baseLoggerService) {
		super();
		this.userDao = userDao;
		this.baseLoggerService = baseLoggerService;
	}
	

	public UserManager(CustomLoginService customLoginService, BaseLoggerService baseLoggerService) {
		super();
		this.customLoginService = customLoginService;
		this.baseLoggerService = baseLoggerService;
	}



	@Override
	public void register(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Şifreniz 6 karakterden az olamaz.");
		}else if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("Adınız ve soyadınız 2 karakterden fazla olmalıdır.");
		}else if (!UserValidatorUtil.checkEmail(user.getEmail())) {
			System.out.println("Mail adresinizi kontrol ediniz.");
		}
		else {
			userDao.register(user);
			baseLoggerService.log();
		}
		
		

	}

	@Override
	public void login(String email, String password) {
		if (password.length()<6) {
			System.out.println("Giriş bilgileriniz hatalı");	
		}else {
			userDao.login(email, password);
			baseLoggerService.log();
		}
		
	}

	@Override
	public void loginWithGoogle(String email) {
		customLoginService.CustomService(email);
		baseLoggerService.log();
		
	}

}
