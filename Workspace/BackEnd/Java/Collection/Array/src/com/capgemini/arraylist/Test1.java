package com.capgemini.arraylist;

import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) 
	{
		ArrayList<Student1> a1 = new ArrayList<Student1>();
		
		Student1 s1 = new Student1(1,"Sumedh",78.897,'M');
		Student1 s2 = new Student1(2,"Ronaldo",88.897,'M');
		Student1 s3 = new Student1(3,"Higuan",68.897,'M');
		
		
		a1.add(s1);
		a1.add(s2);
		a1.add(s3);
		
		Helper h = new Helper();
		h.hello(a1);
		h.onlyPass(a1);
		h.getDist(a1);
		
	}

}
