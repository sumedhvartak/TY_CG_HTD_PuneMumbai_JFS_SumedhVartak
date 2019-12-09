package com.capg.stream.que;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestArray3 {

	public static void main(String[] args) 
	{
		ArrayList<Integer> a1 = new ArrayList<Integer>(); 
		
		a1.add(5);
		a1.add(10);
		a1.add(6);
		a1.add(3);
		a1.add(4);
		
		List<Integer> li = a1.stream().map(i -> i*2).collect(Collectors.toList());
		
		for (Integer k : li)
		{
			System.out.println(k);
		}
		
	}

}
