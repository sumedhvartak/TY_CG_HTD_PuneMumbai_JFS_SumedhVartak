package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.dao.MessageDao;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;
import com.capgemini.collection.factory.CartFactory;

public class MessageSent {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	//
	static Integer messageId;
	static String message;
	static Integer userId;

	public void messageSent(AdminBean adminBean) {
		try {
			MessageDao dao = CartFactory.getMessage();
			valid = true;
			while (valid) {
				System.out.println("Enter MessageId");
				String messageIdR = sc.nextLine();
				try {
					messageId = ExceptionHandling.numValidation(messageIdR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while

			int userId = adminBean.getAdminId();
			valid = true;
			while (valid) {
				System.out.println("Enter Message");
				String messageR = sc.nextLine();
				try {
					message = ExceptionHandling.productNameTypeVal(messageR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while

			String userType = "User";
			boolean messageAdded = dao.addMessage(messageId, userId, message, userType);
			if (messageAdded) {
				System.out.println("Message Added");
			} else {
				System.out.println("Something went wrong");
			} // End of messageAdded
		} catch (Exception e) {
			System.out.println("Please Enter proper credential");
			messageSent(adminBean);
		} // End of catch()

	}// End of messageSent()

	public void viewAllMessage(AdminBean adminBean) {
		try {
			MessageDao dao = CartFactory.getMessage();
			boolean messageBean = dao.viewAllMessage();
			if (messageBean) {
				System.out.println("Above whole database is loaded");
			} else {
				System.out.println("Failed to load database");
			} // End of else
		} catch (Exception e) {
			System.out.println("Something is wrong");
			viewAllMessage(adminBean);
		}
	}// End of viewAllMessage

	public void messageSentAdmin(AdminBean adminBean) {
		try {
			MessageDao dao = CartFactory.getMessage();
			valid = true;
			while (valid) {
				System.out.println("Enter MessageId");
				String messageIdR = sc.nextLine();
				try {
					messageId = ExceptionHandling.numValidation(messageIdR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while

			valid = true;
			while (valid) {
				System.out.println("Enter UserId of a particular user you want to communicate");
				String userIdR = sc.nextLine();
				try {
					userId = ExceptionHandling.numValidation(userIdR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while
				// System.out.println(userId);

			valid = true;
			while (valid) {
				System.out.println("Enter Message");
				String messageR = sc.nextLine();
				try {
					message = ExceptionHandling.productNameTypeVal(messageR);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while

			String userType = "Admin";
			boolean messageAdded = dao.addMessage(messageId, userId, message, userType);
			if (messageAdded) {
				System.out.println("Message Added");
			} else {
				System.out.println("Something went wrong");
			} // End of messageAdded

		} catch (Exception e) {
			System.out.println("Something Invalid is Entered ");
			messageSentAdmin(adminBean);
		} // End of catch()

	}// End of messageSent()

}// End of MessageSent
