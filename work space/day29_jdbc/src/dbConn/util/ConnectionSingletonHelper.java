package dbConn.util;
import java.sql.*;
import java.util.*;

//db연결 정보 반복적으로 코딩 해결
//다른클래스에서 아래 코드 구현을 하지 않도록 설계

/*
	ConnectionHelper 클래스의 문제
	매번 드라이버 로드
	Connection 생성
	
	어차피 하나으 ㅣ프로세스에서 하나만 만들어서
	재사용하면 될텐데..
	
	해결방법 > 공유자원으로 사용(싱글톤)
*/

public class ConnectionSingletonHelper {
	private static Connection conn;
	private ConnectionSingletonHelper(String dsn) {};
//	함수(접근자:public,static)
	public static Connection getConnection(String dsn) {
//			Connection conn=null;
			
		if(conn!=null) {
			return conn;
		}
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
	
	public static void close() throws SQLException{
		if(conn!=null) {
			if(!conn.isClosed()) {
				conn.close();
			}
		}
	}
	
	
	
}
