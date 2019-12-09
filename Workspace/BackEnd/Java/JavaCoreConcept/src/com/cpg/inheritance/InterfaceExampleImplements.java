package com.cpg.inheritance;

public class InterfaceExampleImplements implements Interface {

	
	
	public static void main(String []args)
	{
		new InterfaceExampleImplements().print();
		new InterfaceExampleImplements().display();
		new InterfaceExampleImplements().printNum();
		
		Interface ie = new InterfaceExampleImplements();
		ie.print();
		ie.printNum();
		ie.display();
		Interface.show();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Implements is not possible");
	}
	
	@Override
	public void display()
	{
		System.out.println("This is default method in Interface");
	}

	@Override
	public void printNum() {
		System.out.println("1234");
	}

}
