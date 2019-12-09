package com.capgemini.corejava.array;

public class ArrayMouseObject {

	public static void main(String[] args) 
	{
		ArrayMouse1 m = new ArrayMouse1();
		double t[] = {4.5,6.7,5.6,5.4};
		m.walk(t);
		System.out.println("-------------------------");
		int[] y = {4,5,6,7};
		m.run(y);
	}

}