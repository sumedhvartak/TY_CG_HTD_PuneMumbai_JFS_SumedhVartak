package com.capg.home;

public class Pen1 extends Thread 
{
	public synchronized void run() 
	{
		for(int i = 1;i<5;i++)
		{
			System.out.println(i);
			try 
			{
				sleep(1000);
				
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}

	}
}
