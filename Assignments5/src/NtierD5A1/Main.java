package NtierD5A1;

import NtierD5A1.business.abstracts.UserService;
import NtierD5A1.business.concretes.UserManager;
import NtierD5A1.core.externalAuths.concretes.ExternalLoginAdapter;
import NtierD5A1.core.utilities.VerificationMailSender;
import NtierD5A1.dataAccess.concretes.JpaUserDao;
import NtierD5A1.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService service = new UserManager(new JpaUserDao());
		UserService service2 = new UserManager(new JpaUserDao(),new ExternalLoginAdapter());
		service.register(new User(1,"Eren","Uygun","11111111111","eu@testmail.com","12345678"));
		service2.register(new User(1,"Eren","Uygun","11111111111","eu@testmail.com","12345678"));
		service2.signInWithGoogle("test@testmail.com");

	}

}
