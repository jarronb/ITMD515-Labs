package jb_customer_package;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class emailValidator implements ConstraintValidator<email, String>{

	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(value);
		if (m.find()) {
		    // match
		return true;
		} else {
			return false;
		}
	}

}
