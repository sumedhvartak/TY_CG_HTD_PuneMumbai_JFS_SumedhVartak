package com.cpg.corejava.sep30;

public class ICICI implements ATM {

	@Override
	public void validateCard() {
		System.out.println(".................Connecting ");
		System.out.println("Validating the ICICI Bank Card");
	}

	@Override
	public void getInfo() {
		System.out.println("..................Connecting to ICICI BANK");
		System.out.println("Getting the consumer information");
		
	}

}
