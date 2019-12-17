package com.capgemini.collection.controller;

import java.util.Scanner;

import com.capgemini.collection.bean.AdminBean;
import com.capgemini.collection.dao.CartDao;
import com.capgemini.collection.exceptionhandling.ExceptionHandling;
import com.capgemini.collection.exceptionhandling.ExceptionMedical;
import com.capgemini.collection.factory.CartFactory;

public class AddProductCart {
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

	public void addProductCart(AdminBean adminBean) {
		try {
			CartDao dao = CartFactory.getInstance();

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

			boolean productb = dao.addProductCart(productId);
			if (productb) {
				System.out.println("Product Added to Cart");
				new LoginCart().loginCart(adminBean);
			} else {
				System.out.println("Please enter proper ProductId");
			} // End of else
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please Enter Valid Credential");
			addProductCart(adminBean);

		} // End of catch()

	}// End of addProductCart()

	public void viewAllProductCart(AdminBean adminBean) {
		try {
			CartDao dao = CartFactory.getInstance();
			boolean displayed = dao.viewAllProductCart();
			if (displayed) {
				System.out.println("Above the entire list is displayed");
			} else {
				System.out.println("Failed to display list");
				System.out.println();
			} // End of else
		} catch (Exception e) {
			System.out.println("Something is going is wrong");
			System.out.println();
			viewAllProductCart(adminBean);

		} // End of catch()

	}// End of viewAllProductCart()

	public void totalBill(AdminBean adminBean) {
		try {
			CartDao dao = CartFactory.getInstance();
			boolean bill = dao.totalBill();
			if (bill) {
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
				deleteAllItem(adminBean);
				new LoginUser().loginUser(adminBean);
				
			} else {
				System.out.println("Failed to load the bill");
			} // End of else
		} catch (Exception e) {
			System.out.println("Something is going wrong");
			totalBill(adminBean);
		} // End of catch()

	}// End of TotalBill

	public void deleteItemCart(AdminBean adminBean) {
		try {
			CartDao dao = CartFactory.getInstance();

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

			boolean deleteItem = dao.deleteItemCart(productId);
			if (deleteItem) {
				System.out.println("Item deleted successfully from Cart");
			} else {
				System.out.println("Failed to delete item");
			} // End of else

		} catch (Exception e) {
			System.out.println("Something went wrong");
			deleteItemCart(adminBean);

		} // End of catch()

	}// End of deleteItemCart

	public void deleteAllItem(AdminBean adminBean) {
		try {
			CartDao dao = CartFactory.getInstance();
			dao.deleteAllItem();
		} catch (Exception e) {
			deleteAllItem(adminBean);
		} // End of catch()
	}// End of deleteAllItem()
}// End of AddProduct Cart()
