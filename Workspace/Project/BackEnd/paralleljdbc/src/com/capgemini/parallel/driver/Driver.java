package com.capgemini.parallel.driver;

import java.util.Scanner;

import com.capgemini.parallel.controller.AdminModuleMethod;
import com.capgemini.parallel.controller.LoginUser;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;

public class Driver {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;


	public static void main(String[] args) {
		try {
		System.out.println("We welocome you to our Online Medical Store.");
		System.out.println("Here you can find variety of product.");
		System.out.println("Enter Your choice");
		System.out.println("Enter 1 to login");
		System.out.println("Enter 2 to Register");
		System.out.println("Enter 3 to view medicine");
		valid = true;
		while (valid) {
			String choice = sc.nextLine();
			try {
				choiceNum = ExceptionHandling.choiceValidation2(choice);
				valid = false;
			}catch(ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		switch (choiceNum) {

		case 1:{
			//Login
			new LoginUser().loginUser();	
			main(null);
			break;
		}//End of case 1
		
		case 2:{
			//Register
			new AdminModuleMethod().userRegister();
			main(null);
			//new Register().userRegister();
			break;
		}//End of case 2
		
		case 3:{
			//To View
			new AdminModuleMethod().viewAllProductMethod();
			//new ViewAllProductClass().viewAllProductMethod();
			//System.out.println("Please do Register");
			//new Driver().main(null);
			main(null);
			break;
		}//End of case 3
		
		default:{
			System.out.println("Invalid Value. Please Enter Proper Value");
			main(null);
			break;
		}//End of Default	
		
		}//End of Switch
		
		sc.close();
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			main(null);
		}
	}//End of main()

}//End of Driver
