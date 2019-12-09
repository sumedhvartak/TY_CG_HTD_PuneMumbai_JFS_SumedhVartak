package com.capgemini.springcode.anotation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeBean {
	
	private int empId;
	private String empName;
	@Autowired(required = false)
	@Qualifier("test")
	private DepartmentBean deptBean;
	
	//Getter and Setter
	public DepartmentBean getDeptBean() {
		return deptBean;
	}
	public void setDeptBean(DepartmentBean deptBean) {
		this.deptBean = deptBean;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	//Bean life-cycle methods
	@PostConstruct
	public void init() {
		System.out.println("Its init Phase...");
	}//End of init()
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy Phase!! ");
	}//End of destroy()

}//End of main class
