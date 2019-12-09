package com.capg.stream.que;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;;
public class TestArray6 
{

	public static void main(String[] args) 
	{
		ArrayList<Student> a1 = new ArrayList<Student>(); 
		Comparator<Student> comp = (s1,s2) ->
		{
			if(s1.id > s2.id)
			{
				return 1;
			}
			else if(s1.id < s2.id)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		};
		
		//s1.name.compareTo(s2.name);
		/*
		 * { if(s1.percentage > s2.percentage) { return 1; } else if(s1.percentage <
		 * s2.percentage) { return -1; } else { return 0; } };
		 */
		
		
		
		
		
		a1.add(new Student(1,"Sumedh" , 45.67));
		a1.add(new Student (2, "Ram", 67.67));
		a1.add(new Student (3,"Aamurai",89.67));
		
		List<Student> li = a1.stream().sorted(comp).collect(Collectors.toList());
		
		for(Student s : li)
		{
			System.out.println("The name  of student " + s.name);
			System.out.println("The id of student " +s.id);
			System.out.println("The percentage of student is " + s.percentage);
			System.out.println("***************************************");
			System.out.println();
		}
		
		
		
	}

}
