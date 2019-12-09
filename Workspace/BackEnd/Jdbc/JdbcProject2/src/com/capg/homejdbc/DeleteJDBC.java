package com.capg.homejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteJDBC 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			System.out.println("********************");
			
			String dbUrl = "jdbc:mysql://localhost:3306/capg_db?";
			System.out.println("Enter username");
			String user = sc.nextLine();
			System.out.println("Enter password");
			String password = sc.nextLine();
			conn = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Connection Established");
			System.out.println("*************************");
			
			String query = "Delete from users_info where userid =?";
			pstmt = conn.prepareStatement(query);
			System.out.println("Enter userid");
			pstmt.setInt(1, sc.nextInt());
			int count = pstmt.executeUpdate();
			sc.close();
			if(count>0)
			{
				System.out.println("Data Deleted");
			}
			else
			{
				System.out.println("Data Failed to  delete");
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
