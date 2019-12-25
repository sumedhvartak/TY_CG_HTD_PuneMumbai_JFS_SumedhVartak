package com.capgemini.hotelmanagement.service;

import com.capgemini.hotelmanagement.beans.AdminEmployeeUserBean;

public interface AdminEmployeeUserService {

	public AdminEmployeeUserBean getLogin( String email , String password);
	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean userBean);
}
