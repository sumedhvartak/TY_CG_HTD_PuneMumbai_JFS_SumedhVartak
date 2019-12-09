package com.create.exceptionhandling;

public class Testj {

	public static void main(String[] args)
	{
		Validator v = new Validator();
		
		try
		{
			v.verify(7);
			System.out.println("Welcome to pub");
		}
		catch(InvalidAgeException in)
		{
			System.err.println(in.getMessage());
		}
	}

}
