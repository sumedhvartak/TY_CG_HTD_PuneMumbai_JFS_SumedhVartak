package com.capgemini.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Test4 {

	public static void main(String[] args) 
	{
		ArrayList a1 = new ArrayList();
		a1.add('o');
		a1.add('h');
		a1.add('g');
		a1.add('n');
		System.out.println(a1+"    before");
		Collections.sort(a1);
		
		Collections.shuffle(a1);
		System.out.println(a1);
		
		
		

	}

}
