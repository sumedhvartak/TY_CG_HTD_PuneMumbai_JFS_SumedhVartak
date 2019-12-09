package com.capgemini.springcode.anotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.springcode.anotation.bean.DepartmentBean;

@Configuration
public class DepartmentConfig {

	@Bean(name="dev")
	public DepartmentBean getDevDept() {
		DepartmentBean bean = new DepartmentBean();
		bean.setDepId(901);
		bean.setDeptName("Dev");
		return bean;
	}
	
	@Bean(name="test")
	public DepartmentBean getTestingDept() {
		DepartmentBean bean = new DepartmentBean();
		bean.setDepId(902);
		bean.setDeptName("Testing");
		return bean;
	}
	
	@Bean(name="hr")
	//@Primary
	public DepartmentBean getHrDept() {
		DepartmentBean bean = new DepartmentBean();
		bean.setDepId(903);
		bean.setDeptName("Hr");
		return bean;
	}

}//End of Class
