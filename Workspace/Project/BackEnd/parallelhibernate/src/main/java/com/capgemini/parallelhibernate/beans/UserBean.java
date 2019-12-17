package com.capgemini.parallelhibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserBean {
	
	@Id
	@Column(name="userid")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="emailid")
	private String emailId;
	
	@Column
	private String password;
	
	@Column
	private String type;
	
	//Getter and Setter
	
	public String getUserName() {
		return userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		
}//End of UserBean
