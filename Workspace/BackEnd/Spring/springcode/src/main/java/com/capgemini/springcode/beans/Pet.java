package com.capgemini.springcode.beans;

import com.capgemini.springcode.interfaces.Animal;

public class Pet {
	
	private String name;
	private Animal animal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	

}
