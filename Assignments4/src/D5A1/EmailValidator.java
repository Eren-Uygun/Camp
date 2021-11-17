package D5A1;

public class EmailValidator {
	
	static void sendValidation(User user) {
		System.out.println(user.getEmail() + " adresinize aktivasyon linki gönderilmiştir.");
		
	}
	
	static void confirmValidation(String email) {
		System.out.println(email+" hesabınız onaylanmıştır.");
		
	}

}
