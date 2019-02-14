package DBCon;
import java.sql.*;

public class DBConnection
{
	

	public Connection getConnection()throws ClassNotFoundException,SQLException
	{
		
		
			   Connection con;
		        Class.forName("com.mysql.jdbc.Driver");
		        con=DriverManager.getConnection("jdbc:mysql://localhost/dashboard", "root", "admin");
		        
		       return(con);
	}

	
	
}
