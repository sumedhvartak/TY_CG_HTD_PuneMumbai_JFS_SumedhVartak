package com.capg.stream.que;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Testpriorityqueq {

	public static void main(String[] args)
	{
		PriorityQueue<Integer> p =new PriorityQueue<Integer>();
		
		p.add(23);
		p.add(45);
		p.add(201);
		p.add(97);
		p.add(67);
		
		Iterator<Integer> it = p.iterator();
		while(it.hasNext())
		{
			Integer r = it.next();
			System.out.println(r);
		}
	}
}
