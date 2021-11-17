package D5A1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorUtil {
	
	private static final String emailPattern = "^(.+)@(.+)$";
	
	public static boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	

}
