package com.create.exceptionhandling;

public class InvalidLimitException extends Exception
{
	String message = "Day limit is reched chal nikal fursat se nikal";
	
	
	public InvalidLimitException(String message) {
		this.message = message;
	}
	public InvalidLimitException()
	{
		this.message = message;
	}
	
	
	public String getMessage() 
	{
		return message;
	}

}
