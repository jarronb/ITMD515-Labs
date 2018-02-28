package jb_customer_package;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class zipcodeValidator implements ConstraintValidator<zipcode, String>{

	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("^[0-9]{5}-[0-9]{4}?$");
		Matcher m = p.matcher(value);
		if (m.find()) {
		    // match
		return true;
		} else {
			return false;
		}
	}

}
