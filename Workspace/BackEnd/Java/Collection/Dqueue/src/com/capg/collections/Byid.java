package com.capg.collections;

import java.util.Comparator;

public class Byid implements Comparator<Student1> 
{

	@Override
	public int compare(Student1 a1, Student1 a2) 
	{
		Integer k = a1.getId();
		Integer m = a2.getId();
		return k.compareTo(m);
	}

}
