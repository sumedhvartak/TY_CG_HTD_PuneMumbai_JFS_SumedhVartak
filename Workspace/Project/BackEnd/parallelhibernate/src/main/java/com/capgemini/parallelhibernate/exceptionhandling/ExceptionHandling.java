package com.capgemini.parallelhibernate.exceptionhandling;

import com.capgemini.parallelhibernate.validation.Validation;
import com.capgemini.parallelhibernate.validation.ValidationImpl;

public class ExceptionHandling {

	static Validation val = new ValidationImpl();

	// Choice
	public static Integer choiceValidation(String num) throws ExceptionMedical {
		Integer choiceVal = val.choiceValidation(num);
		if (choiceVal != null) {
			return choiceVal;
		} else {
			throw new ExceptionMedical("Invalid Integer\nPlease enter the value from the given range");
		} // End of else
	}// End of choiceValidation()

	// Choice2
	public static Integer choiceValidation2(String num) throws ExceptionMedical {
		Integer choiceVal = val.choice2Validation(num);
		if (choiceVal != null) {
			return choiceVal;
		} else {
			throw new ExceptionMedical("Invalid Integer\nPlease enter the value from the given range");
		} // End of else
	}// End of choiceValidation()

	// UserEmail
	public static String emailValidation(String email) throws ExceptionMedical {
		String emailVal = val.emailValidation(email);
		if (emailVal != null) {
			return emailVal;
		} else {
			throw new ExceptionMedical("Invalid Email\nThe format must be abc@cde.mvc ");
		} // End of else

	}// End of emailValidation()

	// UserName
	public static String nameValidation(String name) throws ExceptionMedical {
		String nameVal = val.nameValidation(name);
		if (nameVal != null) {
			return nameVal;
		} else {
			throw new ExceptionMedical("Invalid Name \nThe Format must be like ex.abc def");
		} // End of else
	}// End of nameValidation

	// UserPass
	public static String passValidation(String pass) throws ExceptionMedical {
		String passVal = val.passValidation(pass);
		if (passVal != null) {
			return passVal;
		} else {
			throw new ExceptionMedical("Invalid Password \nThe Format must be like ex.asc123");
		}
	}// End of passValidation

	// User/Product Integer
	public static Integer numValidation(String id) throws ExceptionMedical {
		Integer numVal = val.idValidation(id);
		if (numVal != null) {
			return numVal;
		} else {
			throw new ExceptionMedical("Invalid Integer \nIt can accept 10 digit");
		} // End of catch()
	}// End of numValidation()

	// Product Name/Type
	public static String productNameTypeVal(String nameType) throws ExceptionMedical {
		String productNameType = val.productNameType(nameType);
		if (productNameType != null) {
			return productNameType;
		} else {
			throw new ExceptionMedical("Invalid String \nThe format must be ex. abc");
		}//End of else
	}// End of productNameTypeVal()
	
	public static String creditValidation(String credit) throws ExceptionMedical {
		String creditVal = val.creditValidation(credit);
		if(creditVal != null) {
			return creditVal;
		}else {
			throw new ExceptionMedical("Invalid Input \nPlease enter 16 digits");
		}//End of else
	}//End of creditValidation
	
	public static Integer cvvValidation(String cvv) throws ExceptionMedical {
		Integer cvvVal = val.cvvValidation(cvv);
		if(cvvVal!=null) {
			return cvvVal;
		}else {
			throw new ExceptionMedical("Invalid Input \nPlease enter 3 digits");
		}//End of else
	}//End of cvvValidation

}// End of ExceptionHandling
