package com.capg.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class TestLinkedArray {

	public static void main(String[] args) 
	{
		
		
		
		Student s1 = new Student(1,"Mandy", 45.78);
		Student s2 = new Student(2,"Sandy", 55.78);
		Student s3 = new Student(3,"Bandy", 65.78);
		Student s4 = new Student(4,"Candy", 75.78);
		Student s5 = new Student(5,"Handy", 85.78);
		Student s6 = new Student(6,"Nandy", 95.78);
		Student s7 = new Student(7,"Oandy", 15.78);
		Student s8 = new Student(8,"Qandy", 25.78);
		Student s9 = new Student(9,"Vandy", 35.78);
		
		ArrayList<Student> al1 = new ArrayList<Student>();
		al1.add(s1);
		al1.add(s2);
		al1.add(s3);
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		al2.add(s4);
		al2.add(s5);
		ArrayList<Student> al3 = new ArrayList<Student>();
		al3.add(s6);
		al3.add(s7);
		al3.add(s8);
		
		LinkedHashMap<String, ArrayList<Student>> hm = new LinkedHashMap<String, ArrayList<Student>>();
		
		hm.put("first", al1);
		hm.put("second", al2);
		hm.put("third", al3);
		
		ArrayList<Student> al = hm.get("third");
		Iterator<Student> it = al.iterator();
		
		while(it.hasNext())
		{
			Student s = it.next();
			System.out.println("The name is " + s.name);
			System.out.println("The id is" + s.id);
			System.out.println("The percentage is "+ s.percentage);
			System.out.println("***********************************");
			System.out.println();
		}
		
	}

}
