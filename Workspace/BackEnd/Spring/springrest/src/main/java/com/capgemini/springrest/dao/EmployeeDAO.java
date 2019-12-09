package com.capgemini.springrest.dao;

import java.util.List;

import com.capgemini.springrest.beans.EmployeeInfoBean;

public interface EmployeeDAO {
	
	public EmployeeInfoBean getEmployee(int empId);
	public EmployeeInfoBean authenticate(int empid, String pwd);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean deleteEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();

}//End of DAO Method
