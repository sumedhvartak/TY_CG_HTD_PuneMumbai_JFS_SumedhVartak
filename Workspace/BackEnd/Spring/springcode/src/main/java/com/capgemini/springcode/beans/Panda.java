package com.capgemini.springcode.beans;

import com.capgemini.springcode.interfaces.Animal;

public class Panda implements Animal {

	@Override
	public void eat() {
		System.out.println("Eat Bamboo");
	}

	@Override
	public void speak() {
		System.out.println("whee whee");
	}

	@Override
	public void walk() {
		System.out.println("tik tok");
	}

	
}
