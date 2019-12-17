package com.capgemini.parallelhibernate.main;

import java.util.Scanner;

import com.capgemini.parallelhibernate.controller.Admin;
import com.capgemini.parallelhibernate.controller.LoginUser;
import com.capgemini.parallelhibernate.controller.Register;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;

public class Driver {
	static ExceptionHandling except = new ExceptionHandling();
	static Integer choiceNum;
	static boolean valid;
	
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Online Medical Store");
		System.out.println("This our Home Page");
		System.out.println("Please Do Register");
		System.out.println("Here you can find wide range of item of your day to day need");
		System.out.println("Press 1 to Login");
		System.out.println("Press 2 to register");
		System.out.println("Press 3 to view all product ");
		valid = true;
		while(valid) {
			String choice = sc.nextLine();
			try {
				choiceNum = ExceptionHandling.choiceValidation2(choice);
				valid = false;
			}catch(ExceptionMedical e) {
				e.getMessage();
			}//End of catch()
		}//End of while
		
		switch(choiceNum) {
		case 1:{
			new LoginUser().loginUser();
			
			
			break;
		}//End of case 1
		case 2:{
			new Register().register();
			new Driver().main(null);
			break;
		}
		case 3:{
			new Admin().allProduct();
			new Driver().main(null);
			break;
		}//End of case 3
		default:{
			System.out.println("You have Entered Invalid Credentials");
			new Driver().main(null);
		}//End of default
		}//End of switch()
		}catch(Exception e) {
			System.out.println("Trying to Enter invalid value");
			new Driver().main(null);
		}//End of catch
	}//End of main()

}//End of Driver
