package com.create.exceptionhandling;

public class InvalidAgeException extends RuntimeException 
//Unchecked Exception
{
	
	private String message = "Invalid Age to procceed";
	
	
	
	public InvalidAgeException(String message) 
	{
	
		this.message = message;
	}



	public InvalidAgeException() {
		this.message = message;
	}



	@Override
	public String getMessage() 
	{
		return message;
	}
}
