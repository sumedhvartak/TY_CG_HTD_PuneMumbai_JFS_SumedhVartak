package com.create.exceptionhandling;

import java.io.ObjectInputStream.GetField;

public class Testm 
{

	public static void main(String[] args)
	{
		Validator a = new Validator();
		try
		{
		a.check(48000);
		System.out.println("Here u cab have money");
		}
		catch(InvalidLimitException in)
		{
			System.out.println(in.getMessage());
		}
	}

}
