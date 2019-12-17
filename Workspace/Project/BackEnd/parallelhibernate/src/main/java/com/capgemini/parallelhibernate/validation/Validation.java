package com.capgemini.parallelhibernate.validation;

public interface Validation {
	public Integer idValidation(String id);

	public String nameValidation(String name);

	public String emailValidation(String email);

	public String passValidation(String pass);

	public Integer choiceValidation(String num);

	public Integer choice2Validation(String num);

	public String productNameType(String nameType);
	
	public Integer cvvValidation(String cvv);
	
	public String creditValidation(String credit);
	
}// End of Validation
