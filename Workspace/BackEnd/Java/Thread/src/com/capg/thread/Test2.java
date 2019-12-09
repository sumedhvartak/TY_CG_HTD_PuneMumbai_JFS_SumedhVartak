package com.capg.thread;

public class Test2 {

	public static void main(String[] args) 
	{
		PVR2 a = new PVR2();
		
		Paytm2 t1 = new Paytm2(a);
		Paytm2 t2 = new Paytm2(a);
		
		t1.start();
		t2.start();
		try 
		{
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		a.leaveme();
		
		
	}

}
