package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.main.Driver;

public class AdminModule {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;
	
	public void adminModule(UserBean userBean) {
		try {
		
		System.out.println("Welcome Admin");
		System.out.println("Here you can perform particular range of Operation");
		System.out.println("Press 1 to add Product");
		System.out.println("Press 2 to delete Product");
		System.out.println("Press 3 to update Product");
		System.out.println("Press 4 to view all Product");
		System.out.println("Press 5 to view all User");
		System.out.println("Press 6 to add User");
		System.out.println("Press 7 to delete User");
		System.out.println("Press 8 to Logout");
		System.out.println("Press 9 to send Message");
		System.out.println("Press 10 to view Message");
		System.out.println("Press 11 to view All Order List");
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
			//new AddProduct().addProduct();
			new Admin().addProduct();
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 1
		case 2:{
			//new DeleteProduct().deleteProduct();
			new Admin().deleteProduct();
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 2
		case 3:{
			//new UpdateProduct().updateProduct();
			new Admin().updateProduct();
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 3
		case 4:{
			//new AllProduct().allProduct();
			new Admin().allProduct();
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 4
		case 5:{
			//new AllUser().allUser();
			new Admin().allUser();
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 5
		case 6:{
			new Register().register();
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 6
		case 7:{
			//new DeleteUser().deleteUser();
			new Admin().deleteUser();
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 7
		case 8:{
			System.out.println("You have Successfully Logout");
			new Driver().main(null);
			break;
		}//End of case 8
		
		case 9:{
			new Message().addMessageAdmin(userBean);
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 9
		case 10:{
			new Message().getAllMessage(userBean);
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 10
		case 11:{
			new MessageHistoryController().getAllUserOrderHistory(userBean);
			new AdminModule().adminModule(userBean);
			break;
		}//End of case 11
		default:{
			System.out.println("You have entered Invalid Credentials");
			new AdminModule().adminModule(userBean);
			break;
		}//End of default
		
		}//End of switch
		}catch(Exception e) {
			System.out.println("Please enter correct credential");
			new AdminModule().adminModule(userBean);
		}//End of catch()
	}//End of adminModule()

}//End of AdminModule
