package com.capgemini.exception.first;

import java.io.File;
import java.io.IOException;

public class TestF {

	public static void main(String[] args) 
	{
		System.out.println("Main started");
		File f = new File("D:/Sumedh from exception Handling.txt");

		try
		{
			f.createNewFile();
			System.out.println("File Created");
		}

		catch(IOException e)
		{
			System.out.println("Sorry not able to create the table");
		}

		System.out.println("Mian Ended");
	}
}
