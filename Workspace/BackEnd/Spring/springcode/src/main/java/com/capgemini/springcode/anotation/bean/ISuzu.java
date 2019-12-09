package com.capgemini.springcode.anotation.bean;

import com.capgemini.springcode.interfaces.Engine;

public class ISuzu implements Engine {

	@Override
	public int getCC() {
		return 1700;
	}

	@Override
	public String getType() {
		return "4-Stroke Petrol";
	}

}//End of ISuzu()
