package com.capgemini.parallelhibernate.controller;

import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.dao.MessageHistoryDao;
import com.capgemini.parallelhibernate.factory.MessageHistoryFactory;

public class MessageHistoryController {
		public void insertMessageHistory(UserBean userBean) {
		try {
		MessageHistoryDao dao = MessageHistoryFactory.getInstance();
		int userId = userBean.getUserId();
		String userName = userBean.getUserName();
		boolean inserted = dao.insertCart(userId, userName);
		if (inserted) {
			
		} else {
			System.out.println("Eighter Database is Empty or ");
			System.out.println("something went wrong");
		} // End of else case
		}catch(Exception e) {
			System.out.println("Invalid Credntials");
			insertMessageHistory(userBean);
		}//End of catch()
	}// End of insertMessageHistory()

	public void getUserHistory(UserBean userBean) {
		
		try {
		MessageHistoryDao dao = MessageHistoryFactory.getInstance();
		int userId = userBean.getUserId();

		boolean getAll = dao.getCartInfo(userId);
		if (getAll) {
			System.out.println("Above order history is displayed");
		} else {
			System.out.println("Either Database is Empty");
			System.out.println("Something went wrong");
		} // End of else
		}catch(Exception e) {
			
		}//End of catch()
	}// End of getUserHistory

	public void getAllUserOrderHistory(UserBean userBean) {
		try {
		MessageHistoryDao dao = MessageHistoryFactory.getInstance();
		boolean getAllOrder = dao.getAllCartInfo();
		if (getAllOrder) {
			System.out.println("Above user order history is displayed ");
		} else {
			System.out.println("Either Database is Empty");
			System.out.println("Something went wrong");
		} // End of else
		}catch(Exception e) {
			
		}//End of catch()
	}// End of getAllUserOrderHistory()

}// End of MessageHistory()
