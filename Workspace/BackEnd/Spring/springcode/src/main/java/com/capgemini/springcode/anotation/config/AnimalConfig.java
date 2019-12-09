package com.capgemini.springcode.anotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.capgemini.springcode.anotation.bean.Dog;
import com.capgemini.springcode.anotation.bean.Panda;

@Configuration
public class AnimalConfig {
	
	@Bean(name="dog")
	public Dog getDog() {
		return new Dog();
	}//End of getDog()
	
	@Bean(name="panda")
	@Primary
	public Panda getPanda() {
		return new Panda();
	}//End of Panda()

}//End of AnimalCofig()
