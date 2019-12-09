package com.capgemini.spring.code.anotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.anotation.bean.Car;

public class CarTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("carConfig.xml");
		Car myCar = context.getBean("myCar", Car.class);
		
		
		  System.out.println("Model Name = "+ myCar.getModelName());
		  System.out.println("Model Num ="+myCar.getModelNum());
		 System.out.println("Engine Detail "); 
		 System.out.println("CC ="+ myCar.getEngine().getCC());
		 System.out.println("Type ="+myCar.getEngine().getType());
		 
		
	}//End of main()

}//End of class
