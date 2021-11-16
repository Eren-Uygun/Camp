package NtierD5A1.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import NtierD5A1.business.abstracts.UserService;
import NtierD5A1.core.externalAuths.Abstracts.ExternalAuthService;
import NtierD5A1.core.externalAuths.concretes.ExternalLoginAdapter;
import NtierD5A1.core.utilities.VerificationMailSender;
import NtierD5A1.dataAccess.abstracts.UserRepository;
import NtierD5A1.entities.concretes.User;

public class UserManager implements UserService {

	private UserRepository userRepository;
	private ExternalAuthService authService;

	public UserManager(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	

	public UserManager(UserRepository userRepository, ExternalAuthService authService) {
		super();
		this.userRepository = userRepository;
		this.authService = authService;
	}



	@Override
	public void register(User user) {
		if (checkCredentials(user.getFirstName(), user.getLastName())) {
			System.out.println("Ad ve soyad 2 karakterden fazla olmalıdır.");
		} else if (checkEmail(user.getEmail())) {
			System.out.println("Mail adresiniz düzgün formatta değil mail adresinizi kontrol ediniz.");
		} else if (isEmailExists(user.getEmail())) {
			System.out.println("Mail adresi sistemde mevcut");
		} else if (checkLoginCredentials(user.getEmail(), user.getPassword())) {
			System.out.println("Mail adresiniz ve şifreniz boş geçilemez");
			System.out.println("Şifreniz 6 karakterden fazla olmalıdır.");
		}

		else {
			userRepository.add(user);
			VerificationMailSender.sendVerificationMail(user.getEmail());
			VerificationMailSender.verifyVerificationMail(user.getEmail());

		}

	}
	

	@Override
	public void signInWithGoogle(String email) {
		 if (checkEmail(email)) {
			System.out.println("Mail adresiniz düzgün formatta değil mail adresinizi kontrol ediniz.");
		} else if (isEmailExists(email)) {
			System.out.println("Mail adresi sistemde mevcut");
		} else {
			authService.signIn(email);
			VerificationMailSender.sendVerificationMail(email);
			VerificationMailSender.verifyVerificationMail(email);
		}
	
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAll();
	}

	private boolean checkCredentials(String firstName, String lastName) {

		if (firstName.length() < 2 && lastName.length() < 2) {
			return true;
		}
		return false;
	}

	private boolean checkEmail(String email) {

		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches()) {
			return false;
		}
		return true;
	}

	private boolean isEmailExists(String email) {
		boolean isExists = false;
		for (User iterableUser : userRepository.getAll()) {

			if (iterableUser.getEmail().equals(email)) {
				isExists = true;
			}
		}
		return isExists;

	}

	private boolean checkLoginCredentials(String email, String password) {
		if (email.isBlank() || (password.isBlank() && password.length() < 6)) {
			return true;
		}
		return false;

	}




}
