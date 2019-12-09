package com.cpg.inheritance;

public interface Interface 
{
	public void print();
	public void printNum();
	default void display()
	{
		System.out.println("Default Method of Interface");
	}
	
	public static void show()
	{
		System.out.println("Static Method of Interface");
	}
	
	

}
