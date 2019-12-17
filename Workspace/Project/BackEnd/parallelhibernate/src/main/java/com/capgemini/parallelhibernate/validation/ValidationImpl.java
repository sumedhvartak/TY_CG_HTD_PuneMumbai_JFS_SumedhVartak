package com.capgemini.parallelhibernate.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationImpl implements Validation {

	Pattern pat = null;
	Matcher mat = null;

	@Override
	public Integer idValidation(String id) {
		pat = Pattern.compile("\\d{1,10}");
		mat = pat.matcher(id);
		if (mat.matches()) {
			return Integer.parseInt(id);
		}
		return null;
	}// End of idValidation

	@Override
	public String nameValidation(String name) {
		pat = Pattern.compile("\\w+\\s\\w+");
		mat = pat.matcher(name);
		if (mat.matches()) {
			return name;
		}
		return null;
	}// End of nameValidation

	@Override
	public String emailValidation(String email) {
		pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		mat = pat.matcher(email);
		if (mat.matches()) {
			return email;
		}
		return null;
	}// End of emailValidation

	@Override
	public String passValidation(String pass) {
		pat = Pattern.compile("\\w+");
		mat = pat.matcher(pass);
		if (mat.matches()) {
			return pass;
		}
		return null;
	}// End of passValidation

	@Override
	public Integer choiceValidation(String num) {
		pat = Pattern.compile("\\d{1,2}");
		mat = pat.matcher(num);
		if (mat.matches()) {
			return Integer.parseInt(num);
		}
		return null;
	}// End of choiceValidation

	@Override
	public String productNameType(String nameType) {
		pat = Pattern.compile("\\D+");
		mat = pat.matcher(nameType);
		if (mat.matches()) {
			return nameType;
		}
		return null;
	}// End of productNameType()

	@Override
	public Integer choice2Validation(String num) {
		pat = Pattern.compile("\\d{1}");
		mat = pat.matcher(num);
		if (mat.matches()) {
			return Integer.parseInt(num);
		}
		return null;
	}//End of choice2Validation

	@Override
	public Integer cvvValidation(String cvv) {
		pat = Pattern.compile("\\d{3}");
		mat = pat.matcher(cvv);
		if (mat.matches()) {
			return Integer.parseInt(cvv);
		}
		return null;
	}//End of cvvValidation

	@Override
	public String creditValidation(String credit) {
		pat = Pattern.compile("\\d{16}");
		mat = pat.matcher(credit);
		if (mat.matches()) {
			return credit;
		}
		return null;
	}//End of creditValidation

}// Enter Validation
