package com.capgemini.exception.first;

public class Exception2 {

	public static void main(String[] args)
	{
		System.out.println("Milan Method");
		try
		{
		int a[] = new int[3];
		int b[] = {5,4,3,2};
		int c = b.length;
		System.out.println(c);
		System.out.println(b[3]);
		
		System.out.println(a[2]);
		}
		catch(ArrayIndexOutOfBoundsException i)
		{
			System.out.println("Please do not cross the bondary of exception");
		}
		
		System.out.println("Milan Ended");
	}

}
