package D5A1;

import java.util.Arrays;
import java.util.Iterator;

public class JpaUserDao implements UserDao {

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getNationalIdentityNumber() +" : "+ user.getFirstName() +" : "+ user.getLastName() + " kullanıcı sisteme kaydedildi.");
		System.out.println( user.getEmail() + user.getPassword() + " bilgileri ile sisteme giriş yapabilirsiniz.");
		
	}

	@Override
	public void login(String email, String password) {
		System.out.println("Giriş yapıldı: " +email);
		
	}
	


}
