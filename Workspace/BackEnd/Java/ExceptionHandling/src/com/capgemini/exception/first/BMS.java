package com.capgemini.exception.first;

public class BMS {

	public static void main(String[] args) 
	{
		System.out.println("BMS started");
		PVR p = new PVR();
		try
		{
		p.confirm();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception caught in BMS");
		}

		System.out.println("Book my Show ended properly");
	}

}
