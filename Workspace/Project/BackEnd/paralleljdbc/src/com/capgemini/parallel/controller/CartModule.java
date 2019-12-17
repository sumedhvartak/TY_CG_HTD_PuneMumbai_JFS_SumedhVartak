package com.capgemini.parallel.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.parallel.beans.ProductBean;
import com.capgemini.parallel.beans.UserBean;
import com.capgemini.parallel.dao.CartDao;
import com.capgemini.parallel.exceptionhandling.ExceptionHandling;
import com.capgemini.parallel.exceptionhandling.ExceptionMedical;
import com.capgemini.parallel.factory.CartFactory;

public class CartModule {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean

	// Product
	static Integer productId;
	static Integer productPrice;
	static String productName;
	static String productType;
	
	//Bill
	static Integer cvv;
	static String credit;

	public void addProductCart() {
		try {
		CartDao dao = CartFactory.getCart();
		
//		System.out.println("Enter ProductId");
//		int productId = Integer.parseInt(sc.nextLine());
		valid = true;
		while (valid) {
			System.out.println("Enter ProductId");
			String productIdR = sc.nextLine();
			try {
				productId = ExceptionHandling.numValidation(productIdR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		ProductBean product = new ProductBean();
		UserBean userbean = new UserBean();
		product.setProductId(productId);
		boolean added = dao.addProductCart(product);
		if(added) {
			System.out.println("Product Added Successfully");
		}else {
			System.out.println("Something Went Wrong");
			new UserLogin().userLogin(userbean);
		}
		}catch(Exception e) {
			System.out.println("Invalid Credential");
			addProductCart();
		}//End of catch()
	}//End of method
	
	public void bill() {
		try {
		CartDao dao = CartFactory.getCart();
		UserBean userBean = new UserBean();
		boolean pay = dao.sum();
		if(pay) {
			
			System.out.println("You can proceed for payment section");
			valid = true;
			while(valid) {
				System.out.println("FOR PAYMENT PLEASE ENTER YOUR CARD NUMBER ");
				String creditR = sc.nextLine();
				try {
					credit = ExceptionHandling.creditValidation(creditR);
					valid = false;
					
				}catch(ExceptionMedical e) {
					e.getMessage();
				}//End of catch()	
			}//End of while
			valid = true;
			while(valid) {
				System.out.println("PLEASE ENTER YOUR CVV NUMBER ");
				String cvvR = sc.nextLine();
				try {
					cvv = ExceptionHandling.cvvValidation(cvvR);
					valid = false;
				}catch(ExceptionMedical e) {
					e.getMessage();
				}//End of catch()
			}//End of while()
			
			
			System.out.println("TRANSCATION IS SUCCESSFULL");
			deleteAllCart();
			new UserLogin().userLogin(userBean);
		}else {
			System.out.println("Something went wrong");
		}//End of else
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			//bill();
		}//End of catch()
	}//End of method
	
	public void deleteAllCart() {
		try {
		CartDao dao = CartFactory.getCart();
		boolean delete =dao.deleteAllCart();
		if(delete) {
			System.out.println();
		}else {
			System.out.println("Something went wrong");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credential");
			deleteAllCart();
		}//End of catch()
	}//End of main method
	
	public void deleteProductCart() {
		try {
		CartDao dao = CartFactory.getCart();
//		System.out.println("Enter productId to delete product from cart");
//		int delete = Integer.parseInt(sc.nextLine());
		valid = true;
		while (valid) {
			System.out.println("Enter ProductId");
			String productIdR = sc.nextLine();
			try {
				productId = ExceptionHandling.numValidation(productIdR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		boolean isDeleted = dao.deleteProductCart(productId);
		if(isDeleted) {
			System.out.println("Product deleted successfully");
		}else {
			System.out.println("Failed to remove the product from Cart");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			deleteProductCart();
		}
	}//End of method()
	
	public void viewAllCart() {
		try {
		CartDao dao = CartFactory.getCart();
		List<ProductBean> list = dao.viewAllCart();
		if(list!=null) {
			System.out.println("The List of all product selected in cart");
		}else {
			System.out.println("Something went wrong");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			viewAllCart();
		}
	}//End of main method


}//End of CartModule
