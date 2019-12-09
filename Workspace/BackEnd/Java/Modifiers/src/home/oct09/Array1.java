package home.oct09;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class Array1 {

	public static void main(String[] args)
	{
		LinkedList a1 = new LinkedList();
		
		a1.add("Sumedh Vartak");
		a1.add(34);
		a1.add('M');
		
		for(int i = 0;i<3;i++)
		{
			Object r = a1.get(i);
			System.out.println(r);
		}
		
		for(Object r: a1)
		{
			System.out.println(r);
		}
		
		Iterator it = a1.iterator();
		while(it.hasNext())
		{
			Object r = it.next();
			System.out.println(r);
		}
		
		ListIterator lit =a1.listIterator();
		while(it.hasNext())
		{
			Object r = lit.next();
			System.out.println(r);
		}
		
	}
	

}
