package com.capgemini.exception.first;

public class Exception4 {

	public static void main(String[] args) 
	{
		System.out.println("Real Madrid Match Begin");
		try
		{
			System.out.println("Eden Hazard Scored");
			System.out.println("Real Madrid 1-0");
			System.out.println("Real Madrid conceded 1-1");
			System.out.println(10/0);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Hopefully Viniscus Scored");
			System.out.println("Real Madrid wins");
		}
		
		System.out.println("Real Madrid Ends");
	}

}
