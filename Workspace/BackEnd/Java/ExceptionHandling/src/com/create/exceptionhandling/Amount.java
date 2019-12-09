package com.create.exceptionhandling;

public class Amount 
{
	void check(int amt) throws InvalidLimitException
	{
		if(amt > 40000)
		{
			throw new InvalidLimitException();
		}
	}

}
