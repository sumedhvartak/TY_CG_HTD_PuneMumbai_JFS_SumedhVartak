package com.capgemini.exception.first;

public class IRCTC 
{
	void confirm()
	{
		System.out.println("Confirm started");
		try
		{
		System.out.println(10/0);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception caught in confirm");
			throw e;
		}
		finally
		{
		
		System.out.println("Confirm Ended");
		}
	}

}
