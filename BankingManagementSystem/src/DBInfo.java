import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBInfo
{
Connection con;
static
{
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
	} 
	catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	}
}
public Connection getConn()
{
	String url="jdbc:mysql://localhost:3306/banking_management_system";String username="root";String password="rat";
	try 
	{
		con=DriverManager.getConnection(url,username,password);
	} catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return con;
}
}