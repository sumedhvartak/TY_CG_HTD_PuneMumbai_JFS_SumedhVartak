package com.cpg.corejava.sep30;

public class Testmarkerpen 
{
	public static void main(String [] args )
	{
		Pen p = new Marker();  // up-casting
		
		
		Marker m = (Marker)p;// down-casting
		
		m.color();
		m.size = 10;
		System.out.println(m.size);
		
		m.cost =3400;
		p.write();
		System.out.println(p.cost);
		
	}

}
