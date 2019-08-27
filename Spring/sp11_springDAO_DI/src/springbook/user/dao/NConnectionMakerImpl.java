package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", 
				"kim", "oracle");
				
		return conn;
	}

}
