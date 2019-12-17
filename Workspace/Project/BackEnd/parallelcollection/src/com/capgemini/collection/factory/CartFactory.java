package com.capgemini.collection.factory;

import com.capgemini.collection.dao.CartDao;
import com.capgemini.collection.dao.CartDaoImpl;
import com.capgemini.collection.dao.MessageDao;
import com.capgemini.collection.dao.MessageDaoImpl;

public class CartFactory {

	private CartFactory() {

	}// End of CartDao

	public static CartDao getInstance() {
		CartDao dao = new CartDaoImpl();
		return dao;

	}// End of CartFactory()

	public static MessageDao getMessage() {
		MessageDao dao = new MessageDaoImpl();
		return dao;
	}// End of getMessage()
}// End of CartFactory
