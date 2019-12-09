package com.capg.Factory;

import com.capg.DAO.UserDAO;
import com.capg.DAO.UserDAOImp;

public class UserFactory {
	private UserFactory()
	{
		
	}
	
	public static UserDAO getInstance()
	{
		UserDAO dao = new UserDAOImp();
		return dao;
	}

}
