package com.capgemini.springcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.EmployeeBean;

public class EmployeeTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");//Intantiatiate the object using ApplicationContext
		
		EmployeeBean employeeBean = (EmployeeBean) context.getBean("employee");
		System.out.println("Employee Id: " + employeeBean.getEmpid());
		System.out.println("Employee Name: " + employeeBean.getEmpName());
		
		EmployeeBean employeeBean1 = context.getBean("employee1", EmployeeBean.class);
		System.out.println("Employee Id: " + employeeBean1.getEmpid());
		System.out.println("Employee Name: " + employeeBean1.getEmpName());	
		
	}//end of main method
}//End of Main
