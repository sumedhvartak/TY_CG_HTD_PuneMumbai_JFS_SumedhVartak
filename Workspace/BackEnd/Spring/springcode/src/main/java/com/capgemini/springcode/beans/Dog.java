package com.capgemini.springcode.beans;

import com.capgemini.springcode.interfaces.Animal;

public class Dog implements Animal{

	@Override
	public void eat() {
		System.out.println("Pedigree");
	}

	@Override
	public void speak() {
		System.out.println("bow bow");
	}

	@Override
	public void walk() {
		System.out.println("thom thom");
	}

}
