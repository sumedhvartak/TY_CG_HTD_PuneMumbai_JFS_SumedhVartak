package com.capgemini.spring.code.anotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.Sports;

public class SportsTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sport.xml");
		Sports sport = context.getBean("sport", Sports.class);
		
		System.out.println("The Sport Name = " + sport.getName());
		System.out.println("The No. of Players it has " + sport.getTotalPlayers());
		System.out.println("Team Info " + sport.getTeamInfo());
		
		
	}//End of Main Method

}//End of SportsTest
