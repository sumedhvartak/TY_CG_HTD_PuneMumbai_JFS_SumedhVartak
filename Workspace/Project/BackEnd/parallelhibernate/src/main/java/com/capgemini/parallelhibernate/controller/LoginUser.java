package com.capgemini.parallelhibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.dao.UserDao;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.factory.UserFactory;
import com.capgemini.parallelhibernate.main.Driver;

public class LoginUser {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	// User
	static Integer userId;
	static String userName;
	static String email;
	static String password;


	public void loginUser() {	
		try {
		UserDao dao = UserFactory.getInstance();
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter EmailId");
//		String email = sc.nextLine();
//		System.out.println("Enter password");
//		String password = sc.nextLine();
		valid = true;
		while (valid) {
			System.out.println("Enter Email Id");
			String emailR = sc.nextLine();
			try {
				email = ExceptionHandling.emailValidation(emailR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while()
		
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
		boolean userBean = dao.loginUser(email, password);
		if(userBean) {
		}else {
			new Driver().main(null);
		}//End of else()
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			loginUser();
		}//End of loginUser()

	}//End of method()

}//End of LoginUser()
