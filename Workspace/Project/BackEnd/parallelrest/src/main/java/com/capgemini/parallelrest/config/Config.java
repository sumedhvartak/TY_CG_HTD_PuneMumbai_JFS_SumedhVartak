package com.capgemini.parallelrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class Config {
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactory() {
		
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("OnlineMedicalApp");
		return factoryBean;
		
	}//End of getEntityManagerFactory()

}//End of Config
