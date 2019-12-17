package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.CartBean;
import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.main.Driver;

public class UserModule {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;

	public void userModule(UserBean userBean) {
		try {		
			CartBean cartBean = new CartBean();
			System.out.println();
			System.out.println("Welcome User  " + userBean.getUserName());
			System.out.println("Here you can perform particular range of operation");
			System.out.println("Press 1 to view Product");
			System.out.println("Press 2 to change Password");
			System.out.println("Press 3 to buy any product just enter productId");
			System.out.println("Press 4 to view Order History");
			System.out.println("Press 5 to send Message");
			System.out.println("Press 6 to get Message");
			System.out.println("Press 7 to Logout");

//			int choice = Integer.parseInt(sc.nextLine());
//			switch (choice) {
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

			case 1: {
				new Admin().allProduct();
				new UserModule().userModule(userBean);
				break;
			} // End of case 1
			case 2: {
				new ChangePassword().changePassword();
				new UserModule().userModule(userBean);
				break;
			} // End of case 2
			case 3: {
				// new AddProductCart().addProductCart(userBean);
				new Cart().addProductCart(userBean);
				new UserModule().userModule(userBean);
				break;
			} // End of case 3
			case 7: {
				System.out.println("You have successfully logout");
				// new DeleteAllCart().deleteAllCart(cartBean);
				new Cart().deleteAllCart(cartBean);
				new Driver().main(null);
			} // End of case 7
			case 5: {
				new Message().addMessage(userBean);
				new UserModule().userModule(userBean);
				break;
			} // End of case 5
			case 6: {
				new Message().getMessage(userBean);
				new UserModule().userModule(userBean);
				break;
			} // End of case 6
			case 4: {
				new MessageHistoryController().getUserHistory(userBean);
				new UserModule().userModule(userBean);
				break;
			} // End of case 4
			default: {
				System.out.println("You have Entered Invalid credentials");
				new UserModule().userModule(userBean);
				break;
			} // End of default
			}// End of switch
		} catch (Exception e) {
			System.out.println("Invalid Credential");
			userModule(userBean);
		} // End of catch()
	}// End of userModule

}// End of UserModule
