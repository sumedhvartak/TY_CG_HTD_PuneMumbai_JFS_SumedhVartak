package com.capgemini.parallelhibernate.controller;

import java.util.Scanner;

import com.capgemini.parallelhibernate.beans.CartBean;
import com.capgemini.parallelhibernate.beans.UserBean;
import com.capgemini.parallelhibernate.dao.CartDao;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionHandling;
import com.capgemini.parallelhibernate.exceptionhandling.ExceptionMedical;
import com.capgemini.parallelhibernate.factory.CartFactory;

public class CartModule {
	static Scanner sc = new Scanner(System.in);
	static ExceptionHandling except = new ExceptionHandling();
	static boolean valid = false;
	static Integer choiceNum;

	public void cartModule(UserBean userBean) {
		try {
		Scanner sc = new Scanner(System.in);
	//	UserBean userBean = new UserBean();
		CartDao dao = CartFactory.getInstance();
		CartBean cartBean = new CartBean();
		System.out.println("Press 1 in order to Add more Product");
		System.out.println("Press 2 in order to Delete Product");
		System.out.println("Press 3 to Update Quantity");
		System.out.println("Press 4 to place order");
		System.out.println("Press 5 to view All Product present in cart");
		System.out.println("Press 6 to logout from this Module");
		
		
//		int choose = Integer.parseInt(sc.nextLine());
//		switch(choose) {
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

		case 1:{
			//new AddProductCart().addProductCart(userBean);
			new Cart().addProductCart(userBean);
			new CartModule().cartModule(userBean);
			break;
		}//End of case 1
		case 2:{
			System.out.println("Enter ProductId you want to delete from cart");
			dao.deleteProductCart(Integer.parseInt(sc.nextLine()));
			new CartModule().cartModule(userBean);
			break;
		}//End of case 2
		case 3:{
//			System.out.println("Enter ProductId");
//			int productId = Integer.parseInt(sc.nextLine());
//			System.out.println("Enter ProductQuantity");
//			int productQuantity = Integer.parseInt(sc.nextLine());
//			dao.updateProductCart(productQuantity, productId);
			new Cart().updateCartProduct(userBean);
			new CartModule().cartModule(userBean);
			break;
		}//End of case 3
		case 4:{
			new Cart().addBill(userBean);
			new CartModule().cartModule(userBean);
			break;
		}//End of case 4
		case 5:{
			dao.AllProductCart();
			new CartModule().cartModule(userBean);
			break;
		}//End of case 5
		case 6:{
			System.out.println("You have logout from Cart Module");
			new UserModule().userModule(userBean);
			break;
		}//End of case 6
		default:{
			System.out.println("You have entered Invalid Credential");
			new CartModule().cartModule(userBean);
		}//End of default
		}//End of switch
		}catch(Exception e) {
			System.out.println("Invalid Crednetials");
			cartModule(userBean);
		}//End of catch()
	}//End of cartModule()

}//End of CartModule()
