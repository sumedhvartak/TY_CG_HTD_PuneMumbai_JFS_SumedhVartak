package com.capgemini.springmvc.bean;

import java.util.Date;

public class UserBean {
	
	private int empId;
	private String password;
	private Date dob;
	
	//Getters and Setters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

}//End of UserBean
