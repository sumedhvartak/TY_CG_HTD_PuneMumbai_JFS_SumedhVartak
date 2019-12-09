package com.capg.maps;

import java.util.Map;
import java.util.TreeMap;

public class Test3TreeMap {

	public static void main(String[] args)
	{
		TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
		
		hm.put("Ondu", 1);
		hm.put("Idhu", 5);
		hm.put("Hathu",10);
		hm.put("Eredu",2);
		
		
		for(Map.Entry<String,Integer> r : hm.entrySet())
		{
			String k = r.getKey();
			Integer v = r.getValue();
			System.out.println("Key is " + k);
			System.out.println("Value is " + v);
			System.out.println("*****************");
		
		}

	}

}
