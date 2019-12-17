package com.capgemini.parallelhibernate.dao;

import com.capgemini.parallelhibernate.beans.UserBean;

public interface UserDao {
	
	public boolean loginUser(String email, String password);
	public boolean register(UserBean userBean);
	public void AllUser(String type);
	public boolean DeleteUser(int userId);
	public boolean changePassword(int userId, String password, String emailId);

}//End of UserDao
