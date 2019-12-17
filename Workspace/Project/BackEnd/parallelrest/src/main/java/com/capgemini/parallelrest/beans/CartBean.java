package com.capgemini.parallelrest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartBean {
	
	@Id
	@Column
	private int cartId;
	
	@Column
	private int productId;
	
	@Column
	private String productName;
	
	@Column
	private int productPrice;
	
	
	//Getter and setter
	
	public int getProductId() {
		return productId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}//End of CartBean
