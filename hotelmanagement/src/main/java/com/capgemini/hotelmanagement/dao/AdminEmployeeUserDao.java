package com.capgemini.hotelmanagement.dao;

import com.capgemini.hotelmanagement.beans.AdminEmployeeUserBean;

public interface AdminEmployeeUserDao {

	public AdminEmployeeUserBean getLogin( String email , String password);
	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean userBean);
	
}//End of AdminEmployeeUserDao
