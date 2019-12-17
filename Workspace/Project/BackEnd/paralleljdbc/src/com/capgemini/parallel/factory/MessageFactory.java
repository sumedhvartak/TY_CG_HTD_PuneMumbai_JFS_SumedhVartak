package com.capgemini.parallel.factory;

import com.capgemini.parallel.dao.MessageDao;
import com.capgemini.parallel.dao.MessageDaoImpl;

public class MessageFactory {

	private MessageFactory() {

	}// End of MessageFactory()

	public static MessageDao getMessage() {
		MessageDao dao = new MessageDaoImpl();
		return dao;

	}// End of getMesssage()

}// End of class
