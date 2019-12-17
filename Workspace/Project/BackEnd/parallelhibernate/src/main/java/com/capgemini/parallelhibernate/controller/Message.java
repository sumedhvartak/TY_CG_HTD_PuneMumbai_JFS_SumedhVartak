package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.dao.MessageDao;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.factory.MessageFactory;

public class Message {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	//
	static Integer messageId;
	static String message;
	static Integer userId;


	public void addMessage(UserBean userBean) {
		try {
		MessageDao dao = MessageFactory.getInstance();
		// UserBean userBean = new UserBean();
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter MessageId");
		// int messageId = Integer.parseInt(sc.nextLine());
		
		int userId = userBean.getUserId();
		
//		System.out.println("Enter Message");
//		String message = sc.nextLine();
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

		String type = userBean.getType();
		String ask = "Query";

		boolean isMessage = dao.addMessage(userId, message, type, ask);
		if (isMessage) {
			System.out.println("Message Added Successfully");
		} else {
			System.out.println("Something went wrong");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credential");
			addMessage(userBean);
		}//End of catch()
	}// End of Message()

	public void addMessageAdmin(UserBean userBean) {
		try {
		MessageDao dao = MessageFactory.getInstance();
		// UserBean userBean = new UserBean();
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter UserId of a particular user for whom you need to send response");
//		int userId = Integer.parseInt(sc.nextLine());
		valid = true;
		while (valid) {
			System.out.println("Enter UserId");
			String userIdR = sc.nextLine();
			try {
				userId = ExceptionHandling.numValidation(userIdR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		
//		System.out.println("Enter Message");
//		String message = sc.nextLine();
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

		
		String type = userBean.getType();
		String ask = "Response";

		boolean isMessage = dao.addMessage(userId, message, type, ask);
		if (isMessage) {
			System.out.println("Message Added Successfully");
		} else {
			System.out.println("Failed to add message ");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			addMessageAdmin(userBean);
		}//End of catch()
	}// End of addMessageAdmin()

	public void getMessage(UserBean userBean) {
		try {
	//	MessageBean messageBean = new MessageBean();
		MessageDao dao = MessageFactory.getInstance();
		int userId = userBean.getUserId();
		boolean isMessage = dao.getMessage(userId);
		if (isMessage) {
			System.out.println("Above the user message history is generated");
		} else {
			System.out.println("Failed to display message history");
		}
		}catch(Exception e) {
			System.out.println("Unable to load Message");
			//getMessage(userBean);
		}//End of getMessage()
	}//End of getMessage()
	
	public void getAllMessage(UserBean userBean) {
		try {
		//MessageBean messageBean = new MessageBean();
		MessageDao dao = MessageFactory.getInstance();
		boolean isMessage = dao.getAllMessage();
		if (isMessage) {
			System.out.println("Above the whole message history is generated");
		} else {
			System.out.println("Failed to load message history");
		}
		}catch(Exception e) {
			System.out.println("Unable to load Message");
		}//End of getAllMessage()
	}//End of getAllMessage()
	
	
}// End of Message()
