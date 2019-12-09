package com.capgemini.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class Helper 
{
	void hello(ArrayList<Student1> a)
	{
		System.out.println("******For Loop**************");
		for(int i = 0;i<3;i++)
		{
			Student1  r = a.get(i);
			System.out.println(r.name);
			System.out.println(r.id);
			System.out.println(r.percentage);
		}
		
		
		System.out.println("**********For Each*****************");
		for(Student1 s :a)
		{
			System.out.println(s.name);
			System.out.println(s.id);
			System.out.println(s.percentage);
		}
	}
	
	
	void onlyPass(ArrayList<Student1> k)
	{
		
		for(Student1 s: k)
		{
			
		}
	
		Iterator<Student1> a1 = k.iterator();
		
		System.out.println("");
		while(a1.hasNext())
		{
			System.out.println("The Passed students are:");
			Student1 s = a1.next();
			if(s.percentage >= 35)
			{
				System.out.println(s.name);
				System.out.println(s.id);
				System.out.println(s.percentage);
			}
		}
		
	}
	
	void getDist(ArrayList<Student1> a)
	{
		Iterator<Student1> a1 = a.iterator();
		
		while(a1.hasNext())
		{
			System.out.println("The distinction achieved student are");
			Student1 s = a1.next();
			if(s.percentage >=75)
			{
				System.out.println(s.name);
				System.out.println(s.id);
				System.out.println(s.percentage);

			}
		} 
		
	}

}
