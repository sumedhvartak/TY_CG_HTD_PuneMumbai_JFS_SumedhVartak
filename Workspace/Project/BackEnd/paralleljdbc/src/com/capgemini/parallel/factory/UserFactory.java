package com.capgemini.parallel.factory;

import com.capgemini.parallel.dao.UserDao;
import com.capgemini.parallel.dao.UserDaoJdbcImpl;

public class UserFactory {
	private UserFactory() {

	}// End of constructor

	public static UserDao getUserInstance() {
		UserDao dao = new UserDaoJdbcImpl();
		return dao;
	}// End of getUserInstance()
}// End of UserFactory
