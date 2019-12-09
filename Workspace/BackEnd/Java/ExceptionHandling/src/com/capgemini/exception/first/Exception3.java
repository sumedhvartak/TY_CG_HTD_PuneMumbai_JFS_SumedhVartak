package com.capgemini.exception.first;

public class Exception3 
{

	public static void main(String[] args)
	{
		System.out.println("Juventus Match Begin");
		
		try
		{
			System.out.println("Juventus 1-0");
			System.out.println("Juventus 2-0");
			System.out.println(10/0);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cristiano scored");
			System.out.println("Juventus wins");

		}
		System.out.println("Juventus Match Ends");
		
	}

}
