package com.capgemini.parallel.dao;

import java.util.List;

import com.capgemini.parallel.beans.UserBean;

public interface UserDao {

	public boolean registerUser(int userid, String username, String email, String password);

	public UserBean login(String email, String password);

	public boolean changePassword(String password, int userid);

	public boolean deleteUser(int userid);

	public List<UserBean> viewUser();
}// End of userDao interface
