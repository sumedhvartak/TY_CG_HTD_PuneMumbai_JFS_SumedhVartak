package com.capgemini.springcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.MessageBean;

public class MessageTest {

	public static void main(String[] args) {
		
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");//Name of xml file from where data to be retrieved
	//((AbstractApplicationContext)context).registerShutdownHook();
	MessageBean message = (MessageBean)context.getBean("messageBean");
	
	System.out.println(message.getMessage());
	((AbstractApplicationContext)context).close();
	}//End of main()
}//End of main class
