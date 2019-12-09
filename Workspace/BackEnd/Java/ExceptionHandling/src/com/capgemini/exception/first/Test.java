package com.capgemini.exception.first;

public class Test {

	public static void main(String[] args) {
		System.out.println("Main Method");
		Paytm p = new Paytm();
		try {
			p.book();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception caught in main method");
		}
		finally
		{
			System.out.println("Main Ended");
		}
	}
}
