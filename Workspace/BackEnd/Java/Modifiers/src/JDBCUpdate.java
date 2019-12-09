import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;

public class JDBCUpdate {

	public static void main(String[] args) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			System.out.println("*******************");
			
			String dbUrl = "jdbc:mysql://localhost:3306/capg_db?user=root&password=root";
			conn = DriverManager.getConnection(dbUrl);
			System.out.println("Connection Established");
			System.out.println("*************************");
			
			String query = "UPDATE users_info SET email = ? WHERE userid = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,sc.nextLine());
			pstmt.setInt(2,Integer.parseInt(sc.nextLine()));
			
			int count = pstmt.executeUpdate();
			sc.close();
	
			//Process the result
			if(count >0)
			{
				System.out.println("Data Updated");
				
			}
			else
			{
				System.out.println("Something went wrong");
			}
	
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(conn!=null) 
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	
}
