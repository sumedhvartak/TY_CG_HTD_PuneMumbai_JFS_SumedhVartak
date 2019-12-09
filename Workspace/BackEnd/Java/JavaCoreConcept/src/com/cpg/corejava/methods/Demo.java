package com.cpg.corejava.methods;

public class Demo {
	
	static MethodsExamples me = new MethodsExamples();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsExamples me1 = new MethodsExamples();
		System.out.println(me);
		System.out.println(me1);
		me.print();
		System.out.println(MethodsExamples.areaOfSquare(6));
		System.out.println(me.areaOfRec(6, 7));
		System.out.println(me1.areaOfRec(6, 7));
		System.out.println(me.i);
		System.out.println(me1.i);
		
		System.out.println(me1.j);
		System.out.println(me.j);
		
	}
}
