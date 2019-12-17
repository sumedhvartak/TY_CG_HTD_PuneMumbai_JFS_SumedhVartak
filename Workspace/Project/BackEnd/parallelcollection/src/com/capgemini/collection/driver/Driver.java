package com.capgemini.collection.driver;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.controller.AdminModuleMethod;
import com.capgemini.collection.controller.Login;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;

public class Driver {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;

	public static void main(String[] args) {

		try {

			AdminBean adminBean = new AdminBean();
			System.out.println();
			System.out.println("Welcome to medical online Store");
			System.out.println("Here you will find wide range of item of your daily need");
			System.out.println("Press 1 to login");
			System.out.println("Press 2 to view wide range of item");
			System.out.println("Press 3 to register");
			valid = true;
			while (valid) {
				String choice = sc.nextLine();
				try {
					choiceNum = ExceptionHandling.choiceValidation2(choice);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while

			switch (choiceNum) {
			case 1: {
				new Login().login(adminBean);
				main(null);

				break;
			} // End of case 1
			case 2: {
				new AdminModuleMethod().viewAllProduct();
				main(null);
				break;
			} // End of case 2
			case 3: {
				new AdminModuleMethod().register();

				main(null);
				break;
			} // End of case 3
			default: {
				System.out.println("You have entered Invalid credentials");

				main(null);
			} // End of default
				// sc.close();//Closing of scanner
			}// End of switch()

		} catch (Exception e) {
			e.printStackTrace();
			main(null);
		} // End of catch()
	}// End of main method

}// End of main class
