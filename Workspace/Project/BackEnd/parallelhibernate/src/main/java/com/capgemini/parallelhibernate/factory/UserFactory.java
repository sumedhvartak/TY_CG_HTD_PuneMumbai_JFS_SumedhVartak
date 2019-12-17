package com.capgemini.parallelhibernate.factory;

import com.capgemini.parallelhibernate.dao.UserDao;
import com.capgemini.parallelhibernate.dao.UserDaoImpl;

public class UserFactory {
	
	private UserFactory() {
		
	}//End of UserFactory()
	
	public static UserDao getInstance() {
		UserDao dao = new UserDaoImpl();
		return dao;
	}//End of getInstance()

}//End of UserFactory()
