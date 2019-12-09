package com.capg.string11oct;

import java.util.Comparator;
import java.util.TreeSet;

public class Test2 {

	public static void main(String[] args) 
	{
		Comparator<Employee> com = (e1,e2) ->
		{
			if(e1.id > e2.id)
			{
				return 1;
			}
			else if(e1.id < e2.id)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		};
		TreeSet<Employee> ts = new TreeSet<Employee>(com);
		
		Employee e1 = new Employee(1,"Samurai",6.7);
		Employee e2 = new Employee(2,"Harmanpreet",4.7);
		Employee e3 = new Employee(3,"Mandhana",5.7);
		
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		
		for(Employee e : ts)
		{
			System.out.println("The id is " + e.id);
			System.out.println("The name is "+ e.name);
			System.out.println("The id is " + e.height);
			System.out.println("*******************************");
			System.out.println();
		}

	}

}
