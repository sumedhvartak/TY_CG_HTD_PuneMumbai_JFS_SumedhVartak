package com.capg.thread;

public class Teat1pen 
{
	public static void main(String[] args) 
	{
		System.out.println("Main method begins");
		
		Pen1 p = new Pen1();
		p.start();
		try 
		{
			p.join();//It makes main thread to wait until child thread join
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		Pen1 t = new Pen1();
		t.start();
		/*
		 * try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
		 */
		
		System.out.println("Main Method Ends");
	}

}
