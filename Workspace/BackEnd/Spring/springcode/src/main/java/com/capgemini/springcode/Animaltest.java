package com.capgemini.springcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.Pet;

public class Animaltest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("petconfig.xml");
		
		Pet pet = context.getBean("pet", Pet.class);
		pet.getAnimal().eat();
		pet.getAnimal().speak();
		pet.getAnimal().walk();

	}//End of main()

}//End of Animaltest class
