package com.capgemin.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person 
{
	@Id
	@Column
	private int id;
	@Column
	private int pid;
	@Column
	private String name;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "voter_id")
	private Votercard votercard;
	
	public Votercard getVotercard() {
		return votercard;
	}
	public void setVotercard(Votercard votercard) {
		this.votercard = votercard;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
