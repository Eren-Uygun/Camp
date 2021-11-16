package NtierD5A1.core.externalAuths.concretes;

import NtierD5A1.core.externalAuths.Abstracts.ExternalAuthService;
import NtierD5A1.core.externalAuths.ExternalService.GoogleLoginService;

public class ExternalLoginAdapter implements ExternalAuthService  {

	@Override
	public void signIn(String email) {
		GoogleLoginService googleLoginService = new GoogleLoginService();
		googleLoginService.signInWithGoogle(email);
		
	}

}
