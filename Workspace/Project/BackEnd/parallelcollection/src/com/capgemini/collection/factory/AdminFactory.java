package com.capgemini.collection.factory;

import com.capgemini.collection.dao.AdminDao;
import com.capgemini.collection.dao.AdminDaoImpl;

public class AdminFactory {

	private AdminFactory() {

	}// End of constructor

	public static AdminDao getInstance() {

		AdminDao dao = new AdminDaoImpl();
		return dao;

	}// End of getInstance()

}// End of AdminFactory()
