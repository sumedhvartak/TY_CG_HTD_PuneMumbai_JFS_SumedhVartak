package com.capgemini.exception.first;

public class Exception 
{
	public static void main(String[] args)
	{
		System.out.println("Main Method started");

		try 
		{
			System.out.println(10/0);
		}

		catch(ArithmeticException a)
		{
			System.out.println("Please do not divide by zero");
		}

		System.out.println("Main Method Ended");
	}
}
