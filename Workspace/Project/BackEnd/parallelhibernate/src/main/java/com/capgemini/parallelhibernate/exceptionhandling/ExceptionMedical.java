package com.capgemini.parallelhibernate.exceptionhandling;

public class ExceptionMedical extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionMedical(String exp) {
		System.err.println(exp);
	}// End of ExceptionMedical

}// End of ExceptionMedical
