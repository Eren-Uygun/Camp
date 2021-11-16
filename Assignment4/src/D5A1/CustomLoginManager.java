package D5A1;

public class CustomLoginManager implements CustomLoginService {

	@Override
	public void CustomService(String email) {
		GoogleAuth googleAuth = new GoogleAuth();
		googleAuth.loginWithGoogle(email);
		
	}

}
