package com.cpg.corejava.loop;

public class DoWhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;

		/*
		 * do { System.out.println("Display at least once"); }while(false);
		 */

		do {
			System.out.println(" i = " + i);
			i++;
		} while (i <= 10);

		System.out.println("Code outside do while loop");
	}

}
