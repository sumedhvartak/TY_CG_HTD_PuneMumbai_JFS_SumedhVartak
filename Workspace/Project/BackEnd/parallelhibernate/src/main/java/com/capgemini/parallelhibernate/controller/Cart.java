package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.CartBean;
import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.dao.CartDao;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.factory.CartFactory;

public class Cart {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid;// boolean
	static Integer choiceNum;

	// Product
	static Integer productId;
	static Integer productPrice;
	static String productName;
	static String productType;
	static Integer productQuantity;
	
	//Bill
	static Integer cvv;
	static String credit;

	CartBean cartBean = new CartBean();
	
	public void addProductCart(UserBean userBean) {
		try {
		CartDao dao = CartFactory.getInstance();
		
//		System.out.println("Entered ProductId you want to add to Cart");
//		int productId = Integer.parseInt(sc.nextLine());
		valid = true;
		while (valid) {
			System.out.println("Enter ProductId you want to add to Cart");
			String productIdR = sc.nextLine();
			try {
				productId = ExceptionHandling.numValidation(productIdR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		
//		System.out.println("Entered ProductQuantity you want to have");
//		int productQuantity = Integer.parseInt(sc.nextLine());
		
		valid = true;
		while (valid) {
			System.out.println("Enter ProductQuantity you want to have");
			String productQR = sc.nextLine();
			try {
				productQuantity = ExceptionHandling.numValidation(productQR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		
		boolean addCart = dao.addProductCart(productId,productQuantity);
		if(addCart) {
			System.out.println("Product Added to Cart");
			new CartModule().cartModule(userBean);
		}else {
			System.out.println("Something went wrong");
		}
		}catch(Exception e) {
			System.out.println("Invalid Credntials");
			addProductCart(userBean);
		}//End of catch()
	}//End of addProductCart()
	
	
	public void addBill(UserBean userBean) {
		try {
		//UserBean userBean = new UserBean();
		Scanner sc = new Scanner(System.in);
		CartDao dao = CartFactory.getInstance();
		long cartBill = dao.addBill();
		if (cartBill > 0) {
			System.out.println("The Bill for your day is " + cartBill);
			System.out.println("In order to make payment. You can choose any of two ways");
			System.out.println("Press 1 for Cash on Delivery");
			System.out.println("Press 2 for Online Payment");
			valid = true;
			while (valid) {
				String choice = sc.nextLine();
				try {
					choiceNum = ExceptionHandling.choiceValidation(choice);
					valid = false;
				} catch (ExceptionMedical e) {
					e.getMessage();
				} // End of catch()
			} // End of while

			switch (choiceNum) {

			case 1: {
				System.out.println("Thank You for choosing us .We will reach to you as early as possible");
				new MessageHistoryController().insertMessageHistory(userBean);
				new Cart().deleteAllCart(cartBean);
				new UserModule().userModule(userBean);
				break;
			} // End of case 1
			case 2: {
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
				deleteAllCart(cartBean);
				new UserModule().userModule(userBean);
			} // End of case 2
			default:{
				System.out.println("You have entered Invalid Credentials");
				new Cart().addBill(userBean);
				//new AddBill().addBill(userBean);
			}//End of default
			}// End of choice
		} else {
			System.out.println("You havent selected any product");
			new UserModule().userModule(userBean);
		}//End of else
		}catch(Exception e) {
			System.out.println("Invalid Credntials");
			addBill(userBean);
		}//End of catch()
	}// End of addBill()
	
	public void updateCartProduct(UserBean userBean) {
		try {
		CartDao dao = CartFactory.getInstance();
//		System.out.println("Enter ProductId");
//		int productId = Integer.parseInt(sc.nextLine());
//		System.out.println("Enter ProductQuantity");
//		int productQuantity = Integer.parseInt(sc.nextLine());
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

		
//		System.out.println("Entered ProductQuantity you want to have");
//		int productQuantity = Integer.parseInt(sc.nextLine());
		
		valid = true;
		while (valid) {
			System.out.println("Enter ProductQuantity");
			String productQR = sc.nextLine();
			try {
				productQuantity = ExceptionHandling.numValidation(productQR);
				valid = false;
			} catch (ExceptionMedical e) {
				e.getMessage();
			} // End of catch()
		} // End of while

		boolean isUpdated = dao.updateProductCart(productQuantity, productId);
		if(isUpdated) {
			//System.out.println("Product Updated Succes");
		}else {
			System.out.println("Something went wrong");
		}//End of else
		}catch(Exception e) {
			System.out.println("Invalid Credentials");
			updateCartProduct(userBean);
		}//End of updateCartProduct()
	}//End of updateCartProduct
	
	public void deleteAllCart(CartBean cart) {
		try {
		CartDao dao = CartFactory.getInstance();
		boolean allDeleted = dao.deleteAllCart();
		if(allDeleted) {
			//System.out.println("Entire cart Deleted");
		}else {
			//System.out.println("Something went wrong");
		}
		}catch(Exception e) {
		
		}//End of catch()
	}//End of deleteAllCart()


}//End of Cart()
