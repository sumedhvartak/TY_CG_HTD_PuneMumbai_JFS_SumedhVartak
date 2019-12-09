package com.cpg.inheritance;

public class Son extends Father implements InterfaceExamples
{
	String sname ="Robb";
	
	public static void main(String[] args) 
	{
		
		 Son son = new Son(); 
		 son.printName();
		  son.display();
		  son.show();
	}
	@Override
	public void printName()
	{
		System.out.println(sname + " "+ fname + " "+ name + " "+ lastname);
		super.printName();
	}
	
	@Override
	public void display()
	{
	System.out.println("Display method in son");	
	}
	@Override
	public void show() 
	{
	System.out.println("Show method in son");	
	}

}
