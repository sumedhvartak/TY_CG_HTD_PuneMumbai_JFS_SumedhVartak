package com.cpg.corejava.methods;

public class MethodsExamples {
	static int i =1;
	int j =34;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print();
		System.out.println("The area of Square is "+ areaOfSquare(2));
		//MethodsExamples me = new MethodsExamples();  More code but not to create object everytime
		//int area = me.areaOfRec(2,5);
		System.out.println(new MethodsExamples().areaOfRec(2, 5));//Line of code is saved but need to create an object

	}
	 
	public static void print()
	{
		System.out.println("Print() methods");
	}
	 
	public static int areaOfSquare(int side)
	{
		return side*side;
	}
	
	public int areaOfRec(int length, int width)
	{
		return length*width;
	}
}
