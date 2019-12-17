package com.capgemini.parallelhibernate.factory;

import com.capgemini.parallelhibernate.dao.MessageDao;
import com.capgemini.parallelhibernate.dao.MessageDaoImpl;

public class MessageFactory {
	
	private MessageFactory() {
		
	}
	public static MessageDao getInstance() {
		MessageDao dao = new MessageDaoImpl();
		return dao;
	}//End of getInstance()
}//End of MessageFactory()
