package com.capg.homejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertJdbc 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			System.out.println("*****************");
			
			
			String dbUrl = "jdbc:mysql://localhost:3306/capg_db";  //jdbc:mysql://localhost:3306/capg_db?user=root&password=root
			System.out.println("Enter Username");
			String user = sc.nextLine();
			System.out.println("Enter password");
			String password = sc.nextLine();
			conn = DriverManager.getConnection(dbUrl,user,password);
			System.out.println("Connection Establish");
			System.out.println("*************************");
			
			String query = "Insert into users_info values('2019008','Sumedh Vartak','sam@gmail.com','sam@gmail.com')";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(query);
			
			if(count > 0)
			{
				System.out.println("Data Inserted");
			}
			else
			{
				System.out.println("Data failed to insert");
			}
			
			sc.close();
			
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
