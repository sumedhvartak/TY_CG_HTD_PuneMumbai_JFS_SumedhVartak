package com.capg.thread;

public class Test1Pen {

	public static void main(String[] args) 
	{
		System.out.println("Main Method Begin");
		
		Pen1 p = new Pen1();
		p.start();
		try 
		{
			p.join();
			Thread.sleep(9000);
			
			
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		Pen1 p1 = new Pen1();
		p1.start();
		
		System.out.println("Main Method End");
	}

}
