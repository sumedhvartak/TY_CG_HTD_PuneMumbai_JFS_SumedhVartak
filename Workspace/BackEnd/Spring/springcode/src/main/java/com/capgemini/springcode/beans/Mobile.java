package com.capgemini.springcode.beans;

public class Mobile {
	private String brandName;
	private String modelName;
	private int price;
	private MobileDisplayBean mobileDisplay;
	
	public String getBrandName() {
		return brandName;
	}
	public MobileDisplayBean getMobileDisplay() {
		return mobileDisplay;
	}
	public void setMobileDisplay(MobileDisplayBean mobileDisplay) {
		this.mobileDisplay = mobileDisplay;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}//End of main class
