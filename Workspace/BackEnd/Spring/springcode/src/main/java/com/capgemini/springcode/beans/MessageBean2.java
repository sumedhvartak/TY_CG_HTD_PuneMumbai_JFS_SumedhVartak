package com.capgemini.springcode.beans;

public class MessageBean2 {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("It is init phase.......");
	}
	
	public void destroy() {
		System.out.println("Its Destroy Phase");
	}//End of destroy()

}// End of class