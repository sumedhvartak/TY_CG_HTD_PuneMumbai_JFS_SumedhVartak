package com.capgemini.arraylist;

import java.util.Collections;
import java.util.LinkedList;

public class Test3 {

	public static void main(String[] args) 
	{
		LinkedList<Double> li = new LinkedList<Double>();
		li.add(3.6);
		li.add(2.6);
		li.add(6.7);
		li.add(3.9);
		System.out.println("Before*****" + li);
		
		Collections.sort(li);
		System.out.println("After   "+ li);
		
	}
}
