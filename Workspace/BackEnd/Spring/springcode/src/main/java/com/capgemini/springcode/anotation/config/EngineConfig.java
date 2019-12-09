package com.capgemini.springcode.anotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.capgemini.springcode.anotation.bean.ISuzu;
import com.capgemini.springcode.anotation.bean.Volkswagen;
import com.capgemini.springcode.interfaces.Engine;

@Configuration
public class EngineConfig {
	@Bean(name="isuzu")
	@Primary
	public Engine getISuzu() {
		return new ISuzu();
	}
	
	@Bean(name="vw")
	public Engine getVolkswagen() {
		return new Volkswagen();
	}

}//End of class
