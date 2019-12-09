package com.capg.jdbc.controller;

import java.util.Scanner;

import com.capg.jdbc.Factory.UserFactory;
import com.capg.jdbc.beans.UserBean;
import com.capg.jdbc.dao.UserDAO;


public class UserLogin 
{
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		UserDAO dao = UserFactory.getInstance();
		System.out.println("Enter userid");
		int userid = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Password");
		String password =sc.nextLine();
		UserBean user = dao.userlogin(userid,password);
		if(user!=null)
		{
			System.out.println(user);
		}
		else
		{
			System.out.println("Something went wrong");
		}
		sc.close();
		
	}

}
