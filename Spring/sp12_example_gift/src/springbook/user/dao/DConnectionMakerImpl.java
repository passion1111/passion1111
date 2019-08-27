package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		Class.forName("mysql");
		Connection conn = DriverManager.getConnection(
				"mysql", 
				"kingsmile", "mysql");
				
		return conn;
	}
	
	//함수 제공
	

}
