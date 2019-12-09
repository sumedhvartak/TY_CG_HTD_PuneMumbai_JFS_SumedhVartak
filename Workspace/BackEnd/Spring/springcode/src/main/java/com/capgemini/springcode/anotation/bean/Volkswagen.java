package com.capgemini.springcode.anotation.bean;

import com.capgemini.springcode.interfaces.Engine;

public class Volkswagen implements Engine{

	@Override
	public int getCC() {
		return 2300;
	}

	@Override
	public String getType() {
		return "3-Stroke Engine";
	}

}//End of Volkswagen
