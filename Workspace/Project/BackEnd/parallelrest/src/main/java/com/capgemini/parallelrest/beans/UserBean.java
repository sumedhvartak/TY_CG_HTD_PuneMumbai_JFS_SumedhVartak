package com.capgemini.parallelrest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("userbean")
@XmlRootElement(name = "user-bean")
@Entity
@Table(name="user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBean {
	
	@Id
	@Column
	private int userId;
	
	@Column
	private String userName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String type;
	
	//Getter and Setter
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
