package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.dao.AdminDao;
import com.capgemini.collection.driver.Driver;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;
import com.capgemini.collection.factory.AdminFactory;

public class Login {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	static String email;
	static String password;

	public void login(AdminBean adminBean) {
		AdminDao dao = AdminFactory.getInstance();
		Scanner sc = new Scanner(System.in);

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

		AdminBean ad = dao.login(email, password);
		if (ad != null) {
			System.out.println("You have login successfully");
			System.out.println("Welcome " + ad.getAdminName());
			System.out.println("Type of user: " + ad.getType());
			if (ad.getType().equals("Admin")) {
				System.out.println("Begining of Admin Module");
				new LoginAdmin().loginAdmin(ad);
			} else if (ad.getType().equals("User")) {
				System.out.println("Begining of User Module");
				new LoginUser().loginUser(ad);
			} else {
				System.out.println("Something is wrong");
				new Driver().main(null);
			}
		} else {
			System.out.println("Please Enter valid Email Id and Password");
			new Driver().main(null);
		}
		sc.close();// Closing of scanner
	}// End of main method

}// End of Login
