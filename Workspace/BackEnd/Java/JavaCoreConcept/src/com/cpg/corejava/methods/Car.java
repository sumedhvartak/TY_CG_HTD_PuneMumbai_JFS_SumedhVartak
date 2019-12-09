package com.cpg.corejava.methods;

public class Car 
{
	String name;
	String color;
	double price;
	
	public Car(String name, String color, double price) { //Parametrised Constructor
		this.name = name;
		this.color = color;
		this.price = price;
	}
	
	public Car(String name)
	{
		this.name = name;
	}
	
	public Car(double price) {
		super();
		this.price = price;
	}
	
	public Car(double price, String name)
	{
		
	}
	
	public Car(String name, double price)
	{
		
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", price=" + price + "]";
	}


	public static void main(String[] args) 
	{
		

	}

}
