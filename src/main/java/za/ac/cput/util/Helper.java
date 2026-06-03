package za.ac.cput.util;
import org.apache.commons.validator.routines.EmailValidator;

public class Helper {
	private static final EmailValidator emailValidator = EmailValidator.getInstance();

	public static boolean isValid(String email){
		return email != null && email.contains("@") && emailValidator.isValid(email);
	}

	public static boolean isNullOrEmpty(String anyString){
		if(anyString == null || anyString.isEmpty()){
			return true;
		}
		return false;
	}

	public static boolean isNull(Object object){
		if (object == null){
			return true;
		}
		return false;
	}
}
