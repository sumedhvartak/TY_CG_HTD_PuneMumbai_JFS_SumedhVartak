package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;

public class LoginCart {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;

	public void loginCart(AdminBean admin) {
		System.out.println();
		System.out.println("Press 1 to add other product");
		System.out.println("Press 2 to view product added in list");
		System.out.println("Press 3 to delete product from cart");
		System.out.println("Press 4 to confirm payment");
		System.out.println("Press 5 to logout ");
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
			new AddProductCart().addProductCart(admin);
			new LoginCart().loginCart(admin);
			break;
		} // End of case 1

		case 2: {
			new AddProductCart().viewAllProductCart(admin);
			new LoginCart().loginCart(admin);
			break;
		} // End of case 2

		case 3: {
			new AddProductCart().deleteItemCart(admin);
			new LoginCart().loginCart(admin);
			break;
		} // End of case 3

		case 4: {
			new AddProductCart().totalBill(admin);
			new LoginCart().loginCart(admin);
			break;
		} // End of case 4

		case 5: {
			System.out.println("You have successfully logout ");
			new AddProductCart().deleteAllItem(admin);
			new LoginCart().loginCart(admin);
			break;
		} // End of case 5

		default: {
			System.out.println("You have entered innvalid credential");
			loginCart(admin);
		} // End of default

		}// End of switch

	}// End of loginCart()

}// End of LoginCart()
