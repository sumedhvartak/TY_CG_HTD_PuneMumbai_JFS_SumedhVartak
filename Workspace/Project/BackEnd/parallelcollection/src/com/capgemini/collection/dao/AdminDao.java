package com.capgemini.collection.dao;

import com.capgemini.collection.bean.AdminBean;

public interface AdminDao {

	public AdminBean login(String emailId, String password);

	public AdminBean viewAllUser(String type);

	public AdminBean registerUser(int id, String name, String emailId, int mobileNo, String password, String type);

	public boolean deleteUser(int id);

	public boolean changePassword(int id, String password);

}// End of AdmiNdAO
