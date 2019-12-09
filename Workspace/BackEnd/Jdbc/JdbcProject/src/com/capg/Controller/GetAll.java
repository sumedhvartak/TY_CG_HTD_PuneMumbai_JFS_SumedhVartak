package com.capg.Controller;

import java.util.Scanner;

import com.capg.BeanClass.Bean;
import com.capg.DAO.UserDAO;
import com.capg.Factory.UserFactory;


public class GetAll {

	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		UserDAO dao = UserFactory.getInstance();
		System.out.println("Enter any value ");
		int c = sc.nextInt();
		switch(c)
		{
		case 1:
		{
			Bean user1 = dao.getall();
		}
		case 2:
		{
			int a =sc.nextInt();
			switch(a)
			{
			case 101:
			{
				int item_code = Integer.parseInt(sc.nextLine());
				Bean user1 = dao.getorder(item_code);
				int ab = sc.nextInt();
				switch(ab)
				{
				case 102:
				{
					item_code = Integer.parseInt(sc.nextLine());
					Bean user2 = dao.getorder(item_code);


					item_code = Integer.parseInt(sc.nextLine());
					switch(item_code)
					{
					case 103:
					{
						item_code = Integer.parseInt(sc.nextLine());
						Bean user3 = dao.getorder(item_code);
						break;
					}//end of 103
					default:
					{
						System.out.println("Something went wrong");
					}//end of default of 102
					}//end of switch abc
					break;
				}//end of case 102
				case 0:
				{
					System.out.println("Thank you for Ordering");
				}//end of case 0 of 102
				default:
				{
					System.out.println("Something went wrong");
				}//end of default of 102


				}//end of switch ab
				break;
			}//end of case 101
			case 0:
			{
				System.out.println("You haven't order anything");
			}//end of case 0 of 101
			default:
			{
				System.out.println("Something went wrong");
			}//end of default of 101
			}//end of switch a
		}//end of case 2

		}//end of switch c


	}//end of main method

}//end of main class
