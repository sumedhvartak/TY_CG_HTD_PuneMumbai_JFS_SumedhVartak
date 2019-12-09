package com.cpg.corejava.cfs;

public class IfElseIfLadderExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marks = 50;
		if(marks>=75)
		{
			System.out.println("Grade A");
		}
		
		else if(marks>=50 && marks <75)
		{
			System.out.println("Grade B");
		}
		
		else if(marks>25 && marks<50)
		{
			System.out.println("Grade C");
		}
		else
		{
			System.out.println("Fail");
		}

	}

}
