package dbConn.util;
import java.sql.*;
import java.util.*;

//db연결 정보 반복적으로 코딩 해결
//다른클래스에서 아래 코드 구현을 하지 않도록 설계

/*
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kim", "oracle");
//이런식으로 사용할것임
ConnectionHelper.getConnection("mysql") or ("oracle") //갑입력하면 알아서 던지는것.
dsn=<data source name  
*/

public class ConnectionHelper {
//	함수(접근자:public,static)
	public static Connection getConnection(String dsn) {
			Connection conn=null;
			
			try {
				if(dsn.equals("oracle")) {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kim","oracle");
					
					
					
				}else if(dsn.equals("mysql")) {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:DB명","kim","mysql");
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				return conn;
			}
	}
	
	public static Connection getConnection(String dsn,String uid,String pw) {
		Connection conn=null;
		
		try {
			if(dsn.equals("oracle")) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",uid,pw);
				
				
				
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:DB명",uid,pw);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
}
	
	
	
	
	
}
