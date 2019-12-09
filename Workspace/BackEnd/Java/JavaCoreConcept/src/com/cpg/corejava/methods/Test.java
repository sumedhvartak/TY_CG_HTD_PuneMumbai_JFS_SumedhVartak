package com.cpg.corejava.methods;

public class Test {
	
	public static void main(String []args)
	{
		Car car1 = new Car("Muatang GT","Yellow", 4798543.987);
		System.out.println(print(car1));
	}
	
	public static Car print(Car car)
	{
		return car;
	}

}
