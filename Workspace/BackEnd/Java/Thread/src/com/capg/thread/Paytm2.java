package com.capg.thread;

public class Paytm2 extends Thread
{
	PVR2 ref;
	
	Paytm2 (PVR2 r)
	{
		ref = r;
			
	}
	
	public void run()
	{
		ref.confirm();
	}
}
	

