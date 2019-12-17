package com.capgemini.parallelhibernate.factory;

import com.capgemini.parallelhibernate.dao.MessageHistoryDao;
import com.capgemini.parallelhibernate.dao.MessageHistoryDaoImpl;

public class MessageHistoryFactory {
	
	private MessageHistoryFactory() {
		
	}//End of constructor
	
	public static MessageHistoryDao getInstance() {
		MessageHistoryDao dao = new MessageHistoryDaoImpl();
		return dao;
	}//End of getInstance()

}//End of MessageHistoryFactory()
