package com.capgemini.springcode;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcode.beans.EmployeeBean;

public class EmployeeTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employeeConfig.xml");
		EmployeeBean emp1 = context.getBean("employee", EmployeeBean.class);
		
		System.out.println("Enter Employee Id: ");
		int empId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Employee Name");
		String name = sc.nextLine();
		
		emp1.setEmpid(empId);
		emp1.setEmpName(name);
		
		//Employee 2-----------------------
		EmployeeBean emp2 = context.getBean("employee", EmployeeBean.class);
		
		System.out.println("Enter Employee Id: ");
		int empId2 = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Employee Name");
		String name2 = sc.nextLine();
		
		emp2.setEmpid(empId2);
		emp2.setEmpName(name2);
		
		System.out.println("Emp-1 Id = " + emp1.getEmpid());
		System.out.println("Emp-1 Name = " + emp1.getEmpName());
		
		System.out.println("Emp-2 Id = " + emp2.getEmpid());
		System.out.println("Emp-2 Name = " + emp2.getEmpName());
		
		}//End of main method

}//End of Main class
