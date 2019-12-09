package com.cpg.inheritance;

public class Daughter extends Father implements InterfaceExamples{
	
	String sname = "Sansa";
	
	public static void main(String[] args) 
	{
		Daughter d = new Daughter();
		d.printName();
		d.display();
		d.show();
	}
	@Override
	public void printName()
	{
		System.out.println(sname + " " + fname + " " + name + " " + lastname);
	}
	
	@Override
	public void display()
	{
		System.out.println("Display method in daughter");
	}
	
	@Override
	public void show()
	{
		System.out.println("Show method in daughter");
	}

}
