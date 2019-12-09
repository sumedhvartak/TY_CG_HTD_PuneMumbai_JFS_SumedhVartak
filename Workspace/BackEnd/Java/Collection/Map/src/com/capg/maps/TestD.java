package com.capg.maps;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public class TestD {

	public static void main(String[] args) 
	{
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
		
		hm.put("Ondu", 1);
		hm.put("Idhu", 5);
		hm.put("Hathu",10);
		hm.put("Eredu",2);
		
		System.out.println("***************Keys*****************");
		
		Set<String> s = hm.keySet();
		for(String r : s)
		{
			System.out.println(r);
		}
		
		System.out.println("************Values*******************");
		
		Collection<Integer> col = hm.values();
		
		for(Integer r : col)
		{
			System.out.println(r);
		}
		
	}

}
