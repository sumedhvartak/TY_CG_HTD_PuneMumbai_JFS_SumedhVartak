package com.capgemini.springcode.anotation.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.springcode.interfaces.Engine;

public class Car {
	private int modelNum;
	private String modelName;
	@Autowired
	private Engine engine;
	
	//Getter and Setter
	public int getModelNum() {
		return modelNum;
	}
	public void setModelNum(int modelNum) {
		this.modelNum = modelNum;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
		
}//End of class
