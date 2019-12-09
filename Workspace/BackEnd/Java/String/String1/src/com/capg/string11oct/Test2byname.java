package com.capg.string11oct;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Test2byname {

	public static void main(String[] args) 
	{
		Comparator<Employee> comp = (e1,e2)-> e1.name.compareTo(e2.name);
			
		
		TreeSet<Employee> ts = new TreeSet<Employee>(comp);

		Employee e1 = new Employee(1,"Samurai",6.7);
		Employee e2 = new Employee(2,"Harmanpreet",4.7);
		Employee e3 = new Employee(3,"Mandhana",5.7);

		ts.add(e1);
		ts.add(e2);
		ts.add(e3);

		Iterator<Employee> it = ts.iterator();
		while(it.hasNext())
		{
			Employee e = it.next();
			System.out.println("The id is " + e.id);
			System.out.println("The name is "+ e.name);
			System.out.println("The id is " + e.height);
			System.out.println("*******************************");
			System.out.println();
		}

	}

}
