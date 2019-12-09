package com.cpg.corejava.methods;

public class MethodOverloadingExample {

	public static void main(String[] args) 
	{
		System.out.println(add(5,6));
		System.out.println(add(6,5,7));
		System.out.println(add(6,7,45.789));
		System.out.println(add(6,7.876,2));
	}
	
	public static int add(int i, int j)  // Method two argument and return type int
	{
		return i+j;
	}
	
	public static int add(int i,int j, int k) { //Method with three integer argument with double return type
		return i+j+k;
	}
	
	public static double add(int i, int j, double d) //Method with three argument,1 double and 2 integer with double return type
	{
		return i+j+d;
	}
	
	public static double add(int i, double d, int j) //Method with three arguments,1 double and 2 integer with double return type
	{
		return i+j+d;
	}
	
	

}
