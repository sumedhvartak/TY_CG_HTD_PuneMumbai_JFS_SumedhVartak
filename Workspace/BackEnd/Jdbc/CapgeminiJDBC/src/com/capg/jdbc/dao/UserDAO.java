package com.capg.jdbc.dao;

import java.util.List;

import com.capg.jdbc.beans.UserBean;

public interface UserDAO 
{
	public List<UserBean> getAllinfo();
	public UserBean getInfo(int userid);
	public UserBean userlogin(int userid , String password);

}
