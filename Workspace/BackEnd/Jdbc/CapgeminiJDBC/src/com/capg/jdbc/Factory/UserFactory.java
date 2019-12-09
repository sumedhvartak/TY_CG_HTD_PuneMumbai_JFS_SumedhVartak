package com.capg.jdbc.Factory;

import com.capg.jdbc.dao.UserDAO;
import com.capg.jdbc.dao.UserDAOJDBCImpl;

public class UserFactory 
{
	private UserFactory()
	{
		
	}
	public static UserDAO getInstance()
	{
		UserDAO dao = new UserDAOJDBCImpl();
		return dao;
	}

}
