package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	Connection conn;
	String uid;
	String pw;
	String Driver;
	
	DBconnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kim", "oracle");
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBconnection db=new DBconnection();
		
	}

}
