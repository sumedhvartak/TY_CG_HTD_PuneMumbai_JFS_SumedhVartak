package com.capgemini.springcode.beans;

public class EmployeeBean {

	private int empid;
	private String empName;
	private DepartmentBean deptBean;

	
	  public EmployeeBean(int empid, String empName, DepartmentBean deptBean) {
	  this.empid = empid; this.empName = empName; this.deptBean = deptBean; }//Comment in case of autowire by name,type
	 

	// Getter and Setter
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public DepartmentBean getDeptBean() {
		return deptBean;
	}

	public void setDeptBean(DepartmentBean deptBean) {
		this.deptBean = deptBean;
	}

}// End of EmployeeBean
