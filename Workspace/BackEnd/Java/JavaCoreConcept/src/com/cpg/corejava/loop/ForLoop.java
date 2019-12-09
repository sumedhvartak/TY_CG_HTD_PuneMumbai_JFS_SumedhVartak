package com.cpg.corejava.loop;

public class ForLoop 
{
	public static void main(String[] args) 
	{
		for (int i = 1; i <= 10; i++) 
		{
			if(i%2==0)
			{
				System.out.println("i is even");
			}
			else
			{
				System.out.println("i is odd");
			}
		}
		System.out.println("Code outside loop ");
	}

}
