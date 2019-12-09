package com.capgemini.onrtomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table

public class Pencil 
{
	@Id
	@Column
	private int pid;
	
	@Column
	private String color;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "boxid", nullable = false)
	private Pencilbox pencilBox;
	
	public Pencilbox getPencilBox() {
		return pencilBox;
	}
	public void setPencilBox(Pencilbox pencilBox) {
		this.pencilBox = pencilBox;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

}
