package edu.bit.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleUserDAOImpl extends UserDAO {

	@Override
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", 
				"kingsmile", "oracle");
				
		return conn;
	}

}
