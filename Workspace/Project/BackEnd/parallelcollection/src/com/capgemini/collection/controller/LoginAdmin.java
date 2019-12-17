package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.driver.Driver;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;

public class LoginAdmin {
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;

	public void loginAdmin(AdminBean adminBean) {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Here you can do all necessary operation");
		System.out.println("Press 1 to add product");
		System.out.println("Press 2 to delete product");
		System.out.println("Press 3 to update product");
		System.out.println("Press 4 to view all product");
		System.out.println("Press 5 to view all user");
		System.out.println("Press 6 to delete a user");
		System.out.println("Press 7 to add a user");
		System.out.println("Press 8 to send message to User");
		System.out.println("Press 9 to view All User Message");
		System.out.println("Press 10 to logout");

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
			new AdminModuleMethod().addProduct(adminBean);
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 1
		case 2: {
			new AdminModuleMethod().deleteProduct();
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 2
		case 3: {
			new AdminModuleMethod().updateProduct();
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 3
		case 4: {
			new AdminModuleMethod().viewAllProduct();
			new LoginAdmin().loginAdmin(adminBean);
			break;

		} // End of case 4
		case 5: {
			new AdminModuleMethod().viewAllUser();
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 5
		case 6: {
			new AdminModuleMethod().deleteUser();
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 6
		case 7: {
			new AdminModuleMethod().register();
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 7
		case 8: {
			new MessageSent().messageSentAdmin(adminBean);
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 8

		case 9: {
			new MessageSent().viewAllMessage(adminBean);
			new LoginAdmin().loginAdmin(adminBean);
			break;
		} // End of case 9

		case 10: {
			System.out.println("Successfully Logout");
			new Driver().main(null);
			break;
		} // End of case 10

		default: {
			System.out.println("You have entered something wrong");
			new LoginAdmin().loginAdmin(adminBean);
		} // End of default

		}// End of switch choice
		sc.close();
	}// End of loginAdmin()

}// End of LoginAdmin
