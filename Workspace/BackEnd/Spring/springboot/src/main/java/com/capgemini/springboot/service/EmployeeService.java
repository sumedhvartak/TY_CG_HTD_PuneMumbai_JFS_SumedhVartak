package com.capgemini.springboot.service;

import java.util.List;

import com.capgemini.springboot.bean.EmployeeInfoBean;


public interface EmployeeService {
	
	public EmployeeInfoBean getEmployee(int empId);
	public EmployeeInfoBean authenticate(int empid, String pwd);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean deleteEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();
	
	

}//End of Service Interface
