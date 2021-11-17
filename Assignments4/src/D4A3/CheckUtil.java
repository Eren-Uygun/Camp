package D4A3;

import java.util.Date;

public class CheckUtil {
	
	public static boolean isRealPerson(String firstName,String lastName,String nationalIdentityNumber) {
		if (firstName.isBlank() || lastName.isBlank()||nationalIdentityNumber.isBlank()) {
			return false;
		}
		return true;
	}

}
