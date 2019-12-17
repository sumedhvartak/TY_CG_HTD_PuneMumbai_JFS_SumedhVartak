package com.capgemini.parallelrest.service;

import java.util.List;

import com.capgemini.parallelrest.beans.UserBean;

public interface UserBeanServices {
	
	public UserBean userLogin(String email, String password);
	public UserBean addUser(UserBean userBean);
	public List<UserBean> showAllUser();
	public UserBean getUser(int userId);
	public boolean removeUser(int userId);
	public boolean updateUser(UserBean userBean);

}//End of UserBeanServices
