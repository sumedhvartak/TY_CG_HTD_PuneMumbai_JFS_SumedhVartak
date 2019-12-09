package com.capg.maps;

import java.util.ArrayList;

public class TestE {

	public static void main(String[] args) 
	{
		Student1 s1 = new Student1(1,"Sumedh",78.98,'M');
		Student1 s2 = new Student1(2,"Samruddhi",35.98,'F');
		Student1 s3 = new Student1(3,"Dipanshu",88.98,'M');
		Student1 s4 = new Student1(4,"Brandi",28.98,'F');
		Student1 s5 = new Student1(5,"Vijuu",18.98,'M');
		Student1 s6 = new Student1(6,"Sheetal",68.98,'F');
		Student1 s7 = new Student1(7,"Manoj",67.98,'M');
		Student1 s8 = new Student1(8,"Monica",58.98,'F');
		
		ArrayList<Student1> a1 = new ArrayList<Student1>();
		a1.add(s1);
		a1.add(s2);
		a1.add(s3);
		a1.add(s4);
		a1.add(s5);
		a1.add(s6);
		a1.add(s7);
		a1.add(s8);
		
		Helper hp = new Helper();
		//hp.displayFail(a1);
		//hp.displayAll(a1);
		hp.GetTopper(a1);
	}

}
