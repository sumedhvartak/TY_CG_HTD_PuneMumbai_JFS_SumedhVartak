package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.bean.MessageBean;

public class MessageDaoImpl implements MessageDao {

	public static List<MessageBean> messageList;
	public static List<AdminBean> adminList;

	AdminBean adminBean = null;
	MessageBean messageBean = null;

	static {
		messageList = new ArrayList<MessageBean>();
	}

	static {
		adminList = new ArrayList<AdminBean>();
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminId(2019001);
		adminBean.setAdminName("sam");
		adminBean.setEmailId("sam@gmail.com");
		adminBean.setPassword("samurai");
		adminBean.setType("Admin");

		AdminBean adminBean1 = new AdminBean();
		adminBean1.setAdminId(2019002);
		adminBean1.setAdminName("india");
		adminBean1.setEmailId("india@gmail.com");
		adminBean1.setMobileNo(12345678);
		adminBean1.setPassword("myindia");
		adminBean1.setType("User");

		AdminBean adminBean2 = new AdminBean();
		adminBean2.setAdminId(2019003);
		adminBean2.setAdminName("cristiano");
		adminBean2.setEmailId("cristiano@gmail.com");
		adminBean2.setMobileNo(123456);
		adminBean2.setPassword("ronaldo");
		adminBean2.setType("User");

		adminList.add(adminBean);
		adminList.add(adminBean1);
		adminList.add(adminBean2);

	}// End of static

	@Override
	public boolean addMessage(int messageId, int userId, String message, String userType) {
		boolean addedMessage = false;
		try {
			for (AdminBean adminBean : adminList) {

				if (userId == adminBean.getAdminId()) {
					MessageBean messageB = new MessageBean();
					messageB.setMessageId(messageId);
					messageB.setUserId(userId);
					messageB.setMessage(message);
					messageB.setUserType(userType);
					messageList.add(messageB);
					System.out.println("******************************************");
					System.out.println("The Message Id: " + messageB.getMessageId());
					System.out.println("The User Id: " + messageB.getUserId());
					System.out.println("Message: " + messageB.getMessage());
					System.out.println("The Handler Type " + messageB.getUserType());
					System.out.println();
					addedMessage = true;
					return addedMessage;
				} else {
					addedMessage = false;
				} // End of else
			} // End of AdminBean
		} catch (Exception e) {
			System.out.println("Something is wrong");
			addedMessage = false;
		} // End of catch()
		return addedMessage;
	}// End of addMessage

	@Override
	public boolean viewAllMessage() {
		boolean displayAll = false;
		try {
			for (MessageBean messageBean : messageList) {
				System.out.println("******************************");
				System.out.println("The MessageId: " + messageBean.getMessageId());
				System.out.println("The UserId: " + messageBean.getUserId());
				System.out.println("The Message: " + messageBean.getMessage());
				System.out.println("The Type: " + messageBean.getUserType());
				System.out.println();
				displayAll = true;

			} // End of for
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Your Database is Empty");
			displayAll = false;
		} // End of catch()
		return displayAll;
	}// End of viewAllMessage()

}// End of MessageDaoImpl
