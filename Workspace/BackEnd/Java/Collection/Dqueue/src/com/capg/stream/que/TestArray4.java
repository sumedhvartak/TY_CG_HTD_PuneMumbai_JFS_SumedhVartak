package com.capg.stream.que;

import java.util.ArrayList;
import java.util.Comparator;

public class TestArray4 {

	public static void main(String[] args)
	{
		ArrayList<Integer> a1 = new ArrayList<Integer>(); 
		
		a1.add(5);
		a1.add(10);
		a1.add(6);
		a1.add(3);
		a1.add(4);
		
		Comparator<Integer> comp = (i,j) -> i.compareTo(j);
		
		Integer small = a1.stream().min(comp).get();
		System.out.println("Smallest is " + small);
		
		Integer large = a1.stream().max(comp).get();
		System.out.println("Largets is " + large);
		
	}

}
