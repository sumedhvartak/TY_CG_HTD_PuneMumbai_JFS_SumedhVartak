package com.capgemini.spring.code.anotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.Medicine;

public class MedicineTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("medicineConfig.xml");
		Medicine medicine = context.getBean("medicine", Medicine.class);
		
		System.out.println("The Medicine Name = " + medicine.getName());
		System.out.println("The Medicine Type = " + medicine.getType());
		System.out.println("The Medicine Price = " + medicine.getPrice());
		//System.out.println("The Medicine Drug = " + medicine.getDrugs());
		System.out.println("The Medicine Drug = " + medicine.getDrugSet());
		
 		
	}//End of main class

}//End of MedicineTest
