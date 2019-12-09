package com.capgemini.exception.first;
public class PVR 
{
	void confirm() 
	{
		System.out.println("confirm started");
		try
		{
			System.out.println(10/2);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception caught at confirm");
			throw e;
		}
		finally
		{
			System.out.println("confirm ended");
		}
	}
}
