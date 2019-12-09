package com.capgemini.exception.first;

public class Exception5 
{
	public static void main(String[] args)
	{
		System.out.println("Array bana pahele");
		String s = "Cristiano Ronaldo ";
		try
		{
			int a[] = {3,4,5,6,7};
			int b =a.length;
			int c= s.length();
			System.out.println(s);
			System.out.println(s.toUpperCase());
			System.out.println(c + "The length of string note string comes with ()");
			System.out.println("The length of array is " + b);
			System.out.println(a[98]);
			System.out.println(3/0);
			System.out.println(7/8);
		}
		catch(ArithmeticException i)
		{
			System.out.println("Arithmetic Exception caught me");
		}
		catch(ArrayIndexOutOfBoundsException o)
		{
			System.out.println("Array out of excepton caught me help me");
		}
		System.out.println("Ud Ud DABANG DABANG");
	}


}
