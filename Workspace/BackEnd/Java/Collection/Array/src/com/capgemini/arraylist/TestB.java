package com.capgemini.arraylist;

import java.util.ArrayList;

public class TestB 
{

	public static void main(String[] args) 
	{
		ArrayList<Double> a1 = new ArrayList<Double>();
		a1.add(3.6);
		a1.add(2.4);
		a1.add(4.7);
		a1.add(1.6);
		
		System.out.println("Forward***************");
		System.out.println(a1);
		a1.add(4,6.7);
		System.out.println(a1);
	}
}
