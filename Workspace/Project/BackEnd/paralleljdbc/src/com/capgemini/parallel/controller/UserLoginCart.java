package com.capgemini.parallel.controller;

import java.util.Scanner;

import com.capgemini.parallel.beans.UserBean;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;

public class UserLoginCart {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;


	public void userLoginCart() {
		try {
		UserBean userBean = new UserBean();
		System.out.println("Press 1 in order to view all product in your cart");
		System.out.println("Press 2 in order to add more product");
		System.out.println("Press 3 in order to delete product from cart ");
		System.out.println("Press 4 in order to confirm payment");
		System.out.println("Press 5 in order to logout");
//		int pay = Integer.parseInt(sc.nextLine());
//		switch(pay) {
		
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
			System.out.println("The List of product in your cart");
			new CartModule().viewAllCart();
			//new ViewAllCart().viewAllCart();
			new UserLoginCart().userLoginCart();
			break;
			
		}//End of case 1
		case 2:{
			new CartModule().addProductCart();
			//new AddProductCart().addProductCart();
			new UserLoginCart().userLoginCart();
			break;
		}//End of case 2
		case 3:{
			System.out.println("Delete the product you want to delete");
			new CartModule().deleteProductCart();
			//new DeleteProductCart().deleteProductCart();
			System.out.println("Before going for payment just view your cart");
			new UserLoginCart().userLoginCart();
			break;
		}//End of case 3
		case 4:{
			System.out.println("In order to confirm payment");
			new CartModule().bill();
			//new Bill().bill();
			new UserLogin().userLogin(userBean);
			break;
		}//End of case 4
		case 5:{
			System.out.println("You have logged out successfully");
			new CartModule().deleteAllCart();
			//new DeleteAllCart().deleteAllCart();
			new CartModule().deleteAllCart();
			new UserLogin().userLogin(userBean);
			break;
		}//End of case 5
		default:{
			System.out.println("Something went wrong");
			new UserLoginCart().userLoginCart();
		}//End of default
		}//End of pay
		}catch(Exception e) {
			System.out.println("Invalid Credntials");
			userLoginCart();
		}//End of catch()
	}//End of main method

}//End of UserLoginCart()
