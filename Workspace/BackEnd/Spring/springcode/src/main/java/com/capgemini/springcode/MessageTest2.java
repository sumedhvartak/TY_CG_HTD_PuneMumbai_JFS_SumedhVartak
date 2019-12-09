package com.capgemini.springcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.MessageBean2;


public class MessageTest2 {

	public static void main(String[] args) {
		
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");//Name of xml file from where data to be retrieved
	
	MessageBean2 messageBean2 = context.getBean("messageBean2",MessageBean2.class);
	System.out.println("Message is " + messageBean2.getMessage());
	
	MessageBean2 Bean2 = context.getBean("messageBean2",MessageBean2.class);
	System.out.println("Message is " + Bean2.getMessage());
	 
	((AbstractApplicationContext)context).close();
	}//End of main()
}//End of main class
