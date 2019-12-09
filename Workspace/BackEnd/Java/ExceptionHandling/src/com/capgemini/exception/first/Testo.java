package com.capgemini.exception.first;

import java.io.Closeable;

import java.util.*;

public class Testo {

	public static void main(String[] args)
	{
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the name");
		String name =  sc.next();
		
		System.out.println("The name is " + name);
		 sc.close();
	}

}
