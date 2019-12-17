package com.capgemini.parallel.factory;

import com.capgemini.parallel.dao.CartDao;
import com.capgemini.parallel.dao.CartDaoJdbcImpl;

public class CartFactory {

	private CartFactory() {

	}// End of CartFactory()

	public static CartDao getCart() {
		CartDao dao = new CartDaoJdbcImpl();
		return dao;
	}// End of getCart()

}// End of CartFactory
