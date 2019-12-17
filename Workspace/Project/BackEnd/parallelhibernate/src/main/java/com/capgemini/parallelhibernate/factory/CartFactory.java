package com.capgemini.parallelhibernate.factory;

import com.capgemini.parallelhibernate.dao.CartDao;
import com.capgemini.parallelhibernate.dao.CartDaoImpl;

public class CartFactory {
	
	private CartFactory() {
		
	}//End of CartFactory()
	
	public static CartDao getInstance() {
		CartDao dao = new CartDaoImpl();
		return dao;
	}//End of CartDao()
	
//	public static MessageDao getMethod() {
//		MessageDao dao = new MessageDaoImpl();
//		return dao;
//	}//End of MessageDao()
//	

}//End of CartFactory()
