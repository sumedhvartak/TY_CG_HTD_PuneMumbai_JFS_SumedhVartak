package com.capg.homejdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class Jdbcretrieval1 
{

	public static void main(String[] args)
	{
		FileReader reader;
		Properties prop = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		
		try 
		{
		 reader = new FileReader("db1.properties");
		 prop = new Properties();
		 prop.load(reader);
		 System.out.println("File loaded");
		 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		try
		{
		String dbUrl = prop.getProperty("dbUrl");
		conn = DriverManager.getConnection(dbUrl,prop.getProperty("user"),prop.getProperty("password"));
		System.out.println("Connection Established");
		System.out.println("**************************");
		
		String query = prop.getProperty("query2");
		pstmt = conn.prepareStatement(query);
		System.out.println("Enter userid");
		pstmt.setInt(1,sc.nextInt());
		rs = pstmt.executeQuery();
		sc.close();
		
		if(rs.next())
		{
			System.out.println("Userid : " + rs.getInt(1));
			System.out.println("username :" + rs.getString(2));
			System.out.println("Email id" + rs.getString(3));
			System.out.println("password" + rs.getString(4));
			
		}
		}catch(Exception e)
		{
			
		}
		
	}

}
