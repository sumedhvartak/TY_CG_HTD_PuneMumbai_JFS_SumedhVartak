package com.capgemini.springcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.EmployeeBean;

public class DepartmentTest {

	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext("employeeConfig.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("employeeConfig2.xml");
		EmployeeBean employeeBean = context.getBean("employee", EmployeeBean.class);

		System.out.println("Employee Id  = " + employeeBean.getEmpid());
		System.out.println("Employee Name = " + employeeBean.getEmpName());
		System.out.println("Department Id = " + employeeBean.getDeptBean().getDeptId());
		System.out.println("Department Name = " + employeeBean.getDeptBean().getDeptName());

	}// End of main method

}// End of main class
