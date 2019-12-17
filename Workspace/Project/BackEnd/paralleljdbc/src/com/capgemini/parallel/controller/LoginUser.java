package com.capgemini.parallel.controller;

import java.util.Scanner;

import com.capgemini.parallel.beans.UserBean;
import com.capgemini.parallel.dao.UserDao;
import com.capgemini.parallel.driver.Driver;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;
import com.capgemini.parallel.factory.UserFactory;

public class LoginUser {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	static String email;
	static String password;


	public  void loginUser() {
		try {
		UserDao dao = UserFactory.getUserInstance();
		
//		System.out.println("Enter EmailId");
//		String email = sc.nextLine();
		
		valid = true;
		while (valid) {
			System.out.println();
			System.out.println("Enter Email Id");
			String emailR = sc.nextLine();
			try {
				email = ExceptionHandling.emailValidation(emailR);
				System.out.println();
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while()

		
//		System.out.println("Enter Password");
//		String password = sc.nextLine();
		
		valid = true;
		while (valid) {
			System.out.println("Enter Password");
			String passR = sc.nextLine();
			try {
				password = ExceptionHandling.passValidation(passR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while()

		
		UserBean user = dao.login(email, password);
		if(user!=null) {
			System.out.println("You have successfully login");
			System.out.println("Welcome " + user.getUserName());
			System.out.println("Type of user: " + user.getType());
			if(user.getType().equals("admin")) {
				new AdminLogin().adminLogin(user);
			
			}else if(user.getType().equals("user")) {
				new UserLogin().userLogin(user);
			}
			else {
				System.out.println("Something is invalid");
			}
		}else {
			System.out.println("Something Went Wrong");
			new Driver().main(null);
		}
		}catch(Exception e) {
			System.out.println("Invalid credential");
			loginUser();
		}//End of catch()
	}//End of main() method

}//End of LoginUser()
