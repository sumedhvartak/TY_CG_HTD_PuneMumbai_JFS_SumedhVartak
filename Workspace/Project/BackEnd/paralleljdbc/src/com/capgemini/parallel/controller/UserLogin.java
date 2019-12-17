package com.capgemini.parallel.controller;

import java.util.Scanner;

import com.capgemini.parallel.beans.UserBean;
import com.capgemini.parallel.driver.Driver;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;

public class UserLogin {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;

	public void userLogin(UserBean userbean) {
		try {
		System.out.println("Welcome User");
		System.out.println("Press 1 to View Product");
		System.out.println("Press 2 in order to change password");
		System.out.println("Press 3 in order to Buy product");
		System.out.println("Press 4 in order to logout");
		System.out.println("Press 5 in order to send message");
		System.out.println("Press 6 in order to view message");
//		int choice = Integer.parseInt(sc.nextLine());
//		switch(choice) {
		valid = true;
		while (valid) {
			String choice = sc.nextLine();
			try {
				choiceNum = ExceptionHandling.choiceValidation(choice);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		switch (choiceNum) {

		case 1:{
			new AdminModuleMethod().viewAllProductMethod();
			//new ViewAllProductClass().viewAllProductMethod();
			System.out.println("Please do buy our product");
			new UserLogin().userLogin(userbean);
			break;
		}//End of case 1
		case 2:{
			new AdminModuleMethod().changePassword();
			//new ChangePassword().changePassword();
			new UserLogin().userLogin(userbean);
			break;
		}//End of case 2
		case 3:{
			System.out.println("Let have a view to all product");
			new AdminModuleMethod().viewAllProductMethod();
			//new ViewAllProductClass().viewAllProductMethod();
			System.out.println("Press 1 in order to add product ");
			int select = Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1:{
				new CartModule().addProductCart();
				//new AddProductCart().addProductCart();
				new UserLoginCart().userLoginCart();
				break;
			}//End of case 1
			default:{
				System.out.println("Something went wrong");
				new UserLogin().userLogin(userbean);
				break;
			}//End of default()
			}//End of select switch
			new UserLogin().userLogin(userbean);
			break;
		}//End of case 3
		case 4:{
			System.out.println("You have logout successfully");
			new Driver().main(null);
			break;
		}//End of case 4
		case 5:{
			new Message().messageUser(userbean);
			new UserLogin().userLogin(userbean);
			break;
		}//End of case 5
		case 6:{
			new Message().messageGet(userbean);
			new UserLogin().userLogin(userbean);
			break;
		}//End of case 6
		default:{
			System.out.println("Something went wrong");
			new UserLogin().userLogin(userbean);
			break;
		}//End of default
		}//End of choice
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			userLogin(userbean);
		}
	}//End of userLogin()
}//End of UserLogin()
