package com.capgemini.spring.code.anotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcode.anotation.bean.Pet;
import com.capgemini.springcode.anotation.config.PetConfig;

public class AnimalTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(PetConfig.class);
		Pet pet = context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().eat();
		pet.getAnimal().walk();
		pet.getAnimal().speak();
		
	}//End of main method

}//End of main class
