package com.capgemini.exception.first;

public class Paytm
{
	void book()
	{
		System.out.println("Book Started");
		IRCTC i = new IRCTC();
		try {
		i.confirm();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception also caught in book");
			throw e;
		}
		finally
		{
		System.out.println("Book Ended");
		}
		
		
	}

}
