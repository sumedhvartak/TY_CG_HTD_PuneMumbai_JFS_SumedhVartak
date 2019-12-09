package com.create.exceptionhandling;

public class Validator 
{
	void verify(int age)
	{
		if(age < 18)
		{
			throw new InvalidAgeException("Please come after ur 20");
		}
	}

}
