package com.capgemini.exception.first;

public class TestJ {

	public static void main(String[] args) {

		System.out.println("Main Method Begins");

		int a[] = new int[3];
		String s = null;

		try
		{
			System.out.println(10/0);
			
			System.out.println(s.length());
			System.out.println(a[9]);
			System.out.println(10/0);
		}
		catch(ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e)
		{
			e.printStackTrace();
		}

		System.out.println("Main Method Ends");
	}

}
