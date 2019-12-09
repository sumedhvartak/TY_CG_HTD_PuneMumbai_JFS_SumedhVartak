package com.cpg.corejava.sep30;

public class HDFC implements ATM {

	@Override
	public void validateCard() {
		System.out.println(".................Connecting ");
		System.out.println("Validating the HDFC Bank Card");
	}

	@Override
	public void getInfo() {
		System.out.println("..................Connecting to HDFC BANK");
		System.out.println("Getting the consumer information");
	}

}
