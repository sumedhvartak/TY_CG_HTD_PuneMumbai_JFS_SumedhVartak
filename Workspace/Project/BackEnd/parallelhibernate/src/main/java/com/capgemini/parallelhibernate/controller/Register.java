package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.dao.UserDao;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.factory.UserFactory;

public class Register {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	// User
	static Integer userId;
	static String userName;
	static String email;
	static String password;

	public void register() {
		UserDao dao = UserFactory.getInstance();
		UserBean userBean = new UserBean();
//		System.out.println("Entered UserId");
//		userBean.setUserId(Integer.parseInt(sc.nextLine()));
//		System.out.println("Entered UserName");
//		userBean.setUserName(sc.nextLine());
//		System.out.println("Entered Email");
//		userBean.setEmailId(sc.nextLine());
//		System.out.println("Entere password");
//		userBean.setPassword(sc.nextLine());
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
		userBean.setUserId(userId);
		valid = true;
		while (valid) {
			System.out.println("Enter User Name");
			String userNameR = sc.nextLine();
			try {
				userName = ExceptionHandling.nameValidation(userNameR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while
		userBean.setUserName(userName);
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
		userBean.setEmailId(email);
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
		userBean.setPassword(password);
		userBean.setType("user");
		
		boolean register = dao.register(userBean);
		if(register) {
			System.out.println("Registered Successfully");
			System.out.println();
		}else {
			System.out.println("Failed to register");
			System.out.println();
		}//End of Else
		
	}//End of main()

}//End of Register()
