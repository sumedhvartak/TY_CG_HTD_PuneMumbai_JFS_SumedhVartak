package com.capgemini.springcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.Mobile;

public class MobileDisplayTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("mobile.xml");
		Mobile mobile = context.getBean("mobile", Mobile.class);
		
		System.out.println("Brand Name is " + mobile.getBrandName());
		System.out.println("Model Name is " + mobile.getModelName());
		System.out.println("Price is  " + mobile.getPrice());
		System.out.println("Size is "+ mobile.getMobileDisplay().getDisplaySize());
		System.out.println("Resolution is " + mobile.getMobileDisplay().getResolution());
	}

}
