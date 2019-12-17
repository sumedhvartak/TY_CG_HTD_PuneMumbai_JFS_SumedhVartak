package com.capgemini.parallel.controller;

import java.util.Scanner;

import com.capgemini.parallel.beans.UserBean;
import com.capgemini.parallel.driver.Driver;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;

public class AdminLogin {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;


	
	public void adminLogin(UserBean userbean) {
		try {
		System.out.println();
		System.out.println("Welcome Admin");
		System.out.println("Enter Your Choice ");
		System.out.println("Press 1 for Add Medicine");
		System.out.println("Press 2 for View  Medicine");
		System.out.println("Press 3 for Remove  Medicine");
		System.out.println("Press 4 for  Update Price of Medicine");
		System.out.println("Press 5 for  View User");
		System.out.println("Press 6 for Remove User");
		System.out.println("Press 7 for  Add User");
		System.out.println("Press 8 to send Response");
		System.out.println("Press 9 to view Response from user");
		System.out.println("Press 10 for Logout");
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
			new AdminModuleMethod().addProduct();
			//new AddProduct().addProduct();
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 1
		case 2:{
			new AdminModuleMethod().viewAllProductMethod();
			//new ViewAllProductClass().viewAllProductMethod();
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 2
		case 3:{
			new AdminModuleMethod().deleteProduct();
			//new DeleteProduct().deleteProduct();
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 3
		case 7:{
			new AdminModuleMethod().userRegister();
			//new Register().userRegister();
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 7
		case 5:{
			new AdminModuleMethod().viewUser();
			//new ViewUser().viewUser();
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 5
		case 6:{
			new AdminModuleMethod().deleteProduct();
			//new DeleteUser().deleteUser();
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 6
		case 4:{
			//System.out.println("Inorder to update product price first view product you want to update ");
			//new ViewAllProductClass().viewAllProductMethod();
			new AdminModuleMethod().updateProduct();
			//new UpdateProduct().updateProduct();
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 4
		case 8:{
			new Message().messageAdmin(userbean);
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 8
		case 9:{
			new Message().messageGet(userbean);
			new AdminLogin().adminLogin(userbean);
			break;
		}//End of case 9
		case 10:{
			new Driver().main(null);
			break;
		}//End of case 10
		default:{
			System.out.println("You have Entered something wrong");
			new AdminLogin().adminLogin(userbean);
			break;
		}//Default
		}//End of choice
		}catch(Exception e) {
			System.out.println("Invalid credentials");
			adminLogin(userbean);
		}//End of catch()
		
	}//End of adminLogin()

}//End of AdminLogin()
