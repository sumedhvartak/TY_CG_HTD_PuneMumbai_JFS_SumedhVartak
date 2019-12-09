package com.capgemini.spring.code.anotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.capgemini.springcode.anotation.bean.EmployeeBean;
import com.capgemini.springcode.anotation.config.EmployeeConfig;

public class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
		
		System.out.println("Employee Id is " + employeeBean.getEmpId());
		System.out.println("Employee Name is " + employeeBean.getEmpName());
		
		System.out.println("Department Info");
		System.out.println("Dept Id " + employeeBean.getDeptBean().getDepId());
		System.out.println("Dept Name " + employeeBean.getDeptBean().getDeptName());
		((AbstractApplicationContext)context).registerShutdownHook();//It can be written anywhere
		//((AbstractApplicationContext)context).close();//Its must be at the last
	}//End of main method
}//End of main class
