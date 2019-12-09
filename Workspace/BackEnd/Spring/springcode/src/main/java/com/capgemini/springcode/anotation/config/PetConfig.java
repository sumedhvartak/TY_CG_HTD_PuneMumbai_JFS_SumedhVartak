package com.capgemini.springcode.anotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.capgemini.springcode.anotation.bean.Pet;
@Import(AnimalConfig.class)
@Configuration

public class PetConfig {
	@Bean
	public Pet getPet() {
		Pet myPet = new Pet();
		myPet.setName("Rocky");
		return myPet;
	}// End of getPet()

}//End of PetConfig
