package com.cpg.corejava.basics;

public class IncrementDecrementOperators {

	public static void main(String[] args) 
	{
		int i = 10;
		int j = 20;
		
		i = ++i;
		System.out.println(i);
		
		int k = j++;
		System.out.println(k); //Utilization of k
		System.out.println(j); //Utilization of j
		
		int m = i--;
		System.out.println(m); //Utilization of m
		System.out.println(i); //Utilization of i

	}

}
