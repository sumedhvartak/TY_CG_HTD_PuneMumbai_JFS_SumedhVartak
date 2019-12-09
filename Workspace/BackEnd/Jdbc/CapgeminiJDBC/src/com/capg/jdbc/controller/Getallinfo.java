package com.capg.jdbc.controller;

import java.util.List;

import com.capg.jdbc.Factory.UserFactory;
import com.capg.jdbc.beans.UserBean;
import com.capg.jdbc.dao.UserDAO;

public class Getallinfo {

	public static void main(String[] args) 
	{
		UserDAO dao = UserFactory.getInstance();
		List<UserBean> userlist = dao.getAllinfo();
		if(userlist!=null)
		{
			for(UserBean user: userlist)
			{
				System.out.println(user);
			}
		}
	}
}
