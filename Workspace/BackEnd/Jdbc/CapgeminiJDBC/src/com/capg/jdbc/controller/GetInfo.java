package com.capg.jdbc.controller;

import java.util.Scanner;

import com.capg.jdbc.Factory.UserFactory;
import com.capg.jdbc.beans.UserBean;
import com.capg.jdbc.dao.UserDAO;
public class GetInfo 
{
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		UserDAO dao = UserFactory.getInstance();
		System.out.println("Enter userid");
		UserBean user1 = dao.getInfo(sc.nextInt(1));
		if(user1!=null)
		{
			System.out.println(user1);
		}
		else
		{
			System.out.println("Something went wrong");
		}
		sc.close();
	}
}
