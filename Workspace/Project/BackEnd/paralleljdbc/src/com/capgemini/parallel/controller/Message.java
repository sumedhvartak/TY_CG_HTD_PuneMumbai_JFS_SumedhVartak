package com.capgemini.parallel.controller;

import java.util.Scanner;

import com.capgemini.parallel.beans.MessageBean;
import com.capgemini.parallel.beans.UserBean;
import com.capgemini.parallel.dao.MessageDao;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;
import com.capgemini.parallel.factory.MessageFactory;

public class Message {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	//
	static Integer messageId;
	static String message;
	static Integer userId;


	public void messageUser(UserBean userBean) {
		try {
		MessageDao dao = MessageFactory.getMessage();
//		System.out.println("Enter messageId");
//		int messageId = Integer.parseInt(sc.nextLine());
		
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

//		System.out.println("Enter the message");
//		String mess = sc.nextLine();
		
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

		String type = "user";
		String ask = "Query";
		MessageBean mb = dao.sendMessage(messageId, userBean.getUserId(), message, type, ask);
		if(mb!=null) {
			System.out.println("Above list of message is displayed");
		}else {
			System.out.println("Failed to display list of message");
		}
		}catch(Exception e) {
			System.out.println("Invalid credentials");
			messageUser(userBean);
		}//End of catch()

	}//End of messageUser
	
	public void messageGet(UserBean userBean) {
		try {
		MessageDao dao = MessageFactory.getMessage();
		MessageBean messageb = dao.getMessage();
		if(messageb!=null) {
			
		}else {
			System.out.println("Something went wrong");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			messageGet(userBean);
		}//End of messageGet()
				
	}//End of messageGet()
	
	public void messageAdmin(UserBean userBean) {
		try {
		MessageDao dao = MessageFactory.getMessage();
		
//		System.out.println("Enter messageId");
//		int messageId = Integer.parseInt(sc.nextLine());
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

		
		
//		System.out.println("Enter the message");
//		String mess = sc.nextLine();
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

		String type12 = "Admin";
		String ask12 = "Response";
		MessageBean mb = dao.sendMessage(messageId, userBean.getUserId(), message, type12, ask12);
		if(mb!=null) {
			System.out.println("Above list of message is displayed");
		}else {
			System.out.println("Failed to display list of message");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credential");
			messageAdmin(userBean);
		}//End of messageAdmin

	}//End of messageUser


}//End of message
