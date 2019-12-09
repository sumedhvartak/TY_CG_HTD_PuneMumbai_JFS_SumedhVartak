package com.capg.collections;

import java.util.TreeSet;

public class Test1 
{

	public static void main(String[] args) 
	{
		Byid im = new Byid();
		TreeSet<Student1> ts = new TreeSet<Student1>(im);
		
		Student1 s1 = new Student1();
		s1.setId(1);
		s1.setName("Samurai");
		s1.setPrecentage(56.987);
		s1.setGender('M');
		
		Student1 s2 = new Student1();
		s2.setId(2);
		s2.setName("Samurai");
		s2.setPrecentage(56.987);
		s2.setGender('M');
		
		Student1 s3 = new Student1();
		s3.setId(3);
		s3.setName("Mandy");
		s3.setPrecentage(45.87);
		s3.setGender('M');
		
		Student1 s4 = new Student1();
		s4.setId(4);
		s4.setName("Deepa");
		s4.setPrecentage(96.987);
		s4.setGender('F');
		
		Student1 s5 = new Student1();
		s5.setId(5);
		s5.setName("Madhu");
		s5.setPrecentage(86.987);
		s5.setGender('F');
		
		
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);
		
		
			for(Student1 s : ts)
			{
			System.out.println("The Id is " + s.getId());
			System.out.println("The Name is" + s.getName());
			System.out.println("The Percentage is "+ s.getPrecentage());
			System.out.println("The Gender is " + s.getGender());
			System.out.println("*****************************************");
			}
			
		}
		
	}


