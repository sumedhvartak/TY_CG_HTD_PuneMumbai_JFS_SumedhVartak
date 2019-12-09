package com.capg.maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Helper 
{
	void displayAll(ArrayList<Student1> a1)
	{
		Iterator<Student1> it = a1.iterator();
		while(it.hasNext())
		{
			Student1 s = it.next();
			System.out.println("Name is " + s.name);
			System.out.println("Percentage is" + s.percentage);
			System.out.println("The id is " +s.id);
			System.out.println("Gender is " +s.gender);
			System.out.println("*******************");
		}
	}
	
	void displayFail(ArrayList<Student1> a1)
	{
		List<Student1> li = a1.stream().filter(i -> i.percentage < 35).collect(Collectors.toList());
		
		Iterator<Student1> it = li.iterator();
		while(it.hasNext())
		{
			Student1 s = it.next();
			System.out.println("Name is " + s.name);
			System.out.println("Percentage is" + s.percentage);
			System.out.println("The id is " +s.id);
			System.out.println("Gender is " +s.gender);
			System.out.println("*******************");
		}
	}
	
	void displayPassed(ArrayList<Student1> a1)
	{
		List<Student1> li = a1.stream().filter(i -> i.percentage < 35).collect(Collectors.toList());
		
		Iterator<Student1> it = li.iterator();
		while(it.hasNext())
		{
			Student1 s = it.next();
			System.out.println("Name is " + s.name);
			System.out.println("Percentage is" + s.percentage);
			System.out.println("The id is " +s.id);
			System.out.println("Gender is " +s.gender);
			System.out.println("*******************");
		}
	}
	
	void displayPassedGender(ArrayList<Student1> a1)
	{
		List<Student1> li = a1.stream().filter(i -> (i.percentage < 35 && i.gender == 'F')).collect(Collectors.toList());
		
		Iterator<Student1> it = li.iterator();
		while(it.hasNext())
		{
			Student1 s = it.next();
			System.out.println("Name is " + s.name);
			System.out.println("Percentage is" + s.percentage);
			System.out.println("The id is " +s.id);
			System.out.println("Gender is " +s.gender);
			System.out.println("*******************");
		}
	}
	
	void displayFailedGender(ArrayList<Student1> a1)
	{
		List<Student1> li = a1.stream().filter(i -> (i.percentage > 35 && i.gender == 'F')).collect(Collectors.toList());
		
		Iterator<Student1> it = li.iterator();
		while(it.hasNext())
		{
			Student1 s = it.next();
			System.out.println("Name is " + s.name);
			System.out.println("Percentage is" + s.percentage);
			System.out.println("The id is " +s.id);
			System.out.println("Gender is " +s.gender);
			System.out.println("*******************");
		}
	}
	
	Comparator<Student1> comp = (s1,s2) ->
	{
		Double i = s1.percentage;
		Double j = s2.percentage;
		return i.compareTo(j);
	};
	
	
	void GetTopper(ArrayList<Student1> a1)
	{
		
		Student1 r = a1.stream().max(comp).get();
		Iterator<Student1> it = a1.iterator();
		while(it.hasNext())
		{
			Student1 s1 = it.next();
			System.out.println("Name is " + s1.name);
			System.out.println("Percentage is" + s1.percentage);
			System.out.println("The id is " +s1.id);
			System.out.println("Gender is " +s1.gender);
			System.out.println("*******************");
		}
	}
		
	
						

	
}

