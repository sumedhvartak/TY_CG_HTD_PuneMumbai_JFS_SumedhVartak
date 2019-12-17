package com.capgemini.parallelrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.parallelrest.beans.UserBean;
import com.capgemini.parallelrest.dao.UserBeanDao;

@Service
public class UserBeanServicesImpl implements UserBeanServices{
	
	@Autowired
	private UserBeanDao userBeanDao;

	@Override
	public UserBean userLogin(String email, String password) {
		return userBeanDao.userLogin(email, password);
	}//End of userLogin()

	@Override
	public UserBean addUser(UserBean userBean) {
		return userBeanDao.addUser(userBean);	
	}//End of addUser()

	@Override
	public List<UserBean> showAllUser() {		
		return userBeanDao.showAllUser();
	}//End of showAllUser()

	@Override
	public UserBean getUser(int userId) {
		return userBeanDao.getUser(userId);
	}//End of getUser()

	@Override
	public boolean removeUser(int userId) {
		return userBeanDao.removeUser(userId);
	}//End of removeUser()

	@Override
	public boolean updateUser(UserBean userBean) {
		return userBeanDao.updateUser(userBean);
	}//End of updateUser()
	
}//End of UserBeanServicesImpl
