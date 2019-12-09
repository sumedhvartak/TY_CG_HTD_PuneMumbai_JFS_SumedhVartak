package com.capgemini.corejava.array;

public class Exception5 {

	public static void main(String[] args) 
	{
		System.out.println("Milan METHOD");
		int a[] = {3,2,3,4};
		
		try 
		{
			System.out.println(a[78]);
			System.out.println(10/0);
			System.out.println(a[8]);
		}
		catch(ArrayIndexOutOfBoundsException i)
		{
			System.out.println("Thos is out of your capacity");
		}
		catch(ArithmeticException i)
		{
			System.out.println("dont divide by zero or arthmetic expressins will catch u duffer");
		}
		System.out.println("Shut up baster");
	}

}
