package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.driver.Driver;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;

public class LoginUser {
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;

	public void loginUser(AdminBean adminBean) {
		System.out.println("Welcome " + adminBean.getAdminName());
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Here you can make necessary changes");
		System.out.println("Press 1 to view all product ");
		System.out.println("Press 2 to change password");
		System.out.println("Press 3 to buy any product");
		System.out.println("Press 4 to send message to Admin");
		System.out.println("Press 5 to view All Message");
		System.out.println("Press 6 to logout successfully");
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
			System.out.println("The list of all product");
			new AdminModuleMethod().viewAllProduct();
			new LoginUser().loginUser(adminBean);
			break;
		} // End of case 1
		case 2: {
			new AdminModuleMethod().changePassword(adminBean);
			new LoginUser().loginUser(adminBean);
			break;
		} // End of case 2
		case 3: {
			new AddProductCart().addProductCart(adminBean);
			new LoginUser().loginUser(adminBean);
			break;
		} // End of case
		case 4: {
			new MessageSent().messageSent(adminBean);
			new LoginUser().loginUser(adminBean);
			break;
		} // End of case 4
		case 5: {
			new MessageSent().viewAllMessage(adminBean);
			new LoginUser().loginUser(adminBean);
			break;
		} // End of case 5
		case 6: {
			System.out.println("You have successfully logout");
			new Driver().main(null);
		} // End of case 6
		default: {
			System.out.println("Something went wrong");
			new LoginUser().loginUser(adminBean);
		} // End of default

		}// End of choice

		sc.close();
	}// End of loginUser()

}// End of LoginUser
