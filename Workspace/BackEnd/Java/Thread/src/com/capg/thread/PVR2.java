package com.capg.thread;

public class PVR2 
{
	synchronized void confirm()
	{
		for(int i = 0;i < 5;i++)
		{
			System.out.println(i);
			
			try 
			{
				wait();
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	synchronized void leaveme()
	{
		System.out.println("Notify me ");
		notifyAll();
	}
	
	

}
