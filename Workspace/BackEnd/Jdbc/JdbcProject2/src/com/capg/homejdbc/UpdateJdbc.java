package com.capg.homejdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class UpdateJdbc 
{

	public static void main(String[] args)
	{
		FileReader reader;
		Properties prop = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		try 
		{
			reader = new FileReader("db1.properties");
			prop = new Properties();
			prop.load(reader);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		try 
		{
			String dbUrl = prop.getProperty("dbUrl");
			conn = DriverManager.getConnection(dbUrl, prop.getProperty("user"), prop.getProperty("password"));
			System.out.println("Connection Established");
			System.out.println("**********************");

			String query = prop.getProperty("query5");
			pstmt = conn.prepareStatement(query);
			System.out.println("Enter email");
			pstmt.setString(1, sc.nextLine());
			System.out.println("Enter userid");
			pstmt.setInt(2, sc.nextInt());
			int count = pstmt.executeUpdate();

			sc.close();
			if(count >0)
			{
				System.out.println("Data Updated");
			}
			else
			{
				System.out.println("Data failed to update");
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(conn!=null)
			{
				try 
				{
					conn.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}


	}

}
