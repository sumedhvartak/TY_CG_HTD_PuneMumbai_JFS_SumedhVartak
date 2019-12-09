package com.capgemini.spring.code.anotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcode.anotation.bean.MessageBean;
import com.capgemini.springcode.anotation.config.MessageConfig;

public class MessageTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
		MessageBean messageBean = context.getBean(MessageBean.class); 
		System.out.println("Message1 = " + messageBean.getMessage());
		
		MessageBean messageBean2 = context.getBean(MessageBean.class);
		System.out.println("Message2 = " + messageBean2.getMessage());
		
		messageBean.setMessage("IT is new message");
		System.out.println("Message1 = " + messageBean.getMessage());
		System.out.println("Message2 = " + messageBean2.getMessage());

	}//End of main method

}//End of main class
