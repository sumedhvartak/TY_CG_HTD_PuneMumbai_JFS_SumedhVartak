package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.dao.UserDao;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.factory.UserFactory;

public class ChangePassword {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	// User
	static Integer userId;
	static String userName;
	static String email;
	static String password;

	public void changePassword() {
		try {
		UserDao dao = UserFactory.getInstance();
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter UserId");
//		int userId = Integer.parseInt(sc.nextLine());
		valid = true;
		while (valid) {
			System.out.println("Enter User Id");
			String userIdR = sc.nextLine();
			try {
				userId = ExceptionHandling.numValidation(userIdR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while
		
//		System.out.println("Enter EmailId ");
//		String emailId = sc.nextLine();
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
//		System.out.println("Enter Password you want to update");
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
		boolean changePass = dao.changePassword(userId, password, email);
		if(changePass) {
			
		}else {
			System.out.println("Something went wrong");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			changePassword();
		}//End of catch()
	}//End of changePassword()

}//End of changePassword
