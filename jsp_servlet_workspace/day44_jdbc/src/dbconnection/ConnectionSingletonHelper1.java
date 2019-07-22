package dbconnection;
import java.sql.*;
import java.util.*;

//db���� ���� �ݺ������� �ڵ� �ذ�
//�ٸ�Ŭ�������� �Ʒ� �ڵ� ������ ���� �ʵ��� ����

/*
	ConnectionHelper Ŭ������ ����
	�Ź� ����̹� �ε�
	Connection ����
	
	������ �ϳ��� �����μ������� �ϳ��� ����
	�����ϸ� ���ٵ�..
	
	�ذ��� > �����ڿ����� ���(�̱���)
*/

public class ConnectionSingletonHelper1 {
	private static Connection conn=null;
	private ConnectionSingletonHelper1(String dsn) {};
//	�Լ�(������:public,static)
	public static Connection getConnection(String dsn) {
		
			
		if(conn!=null) {
			return conn;
		}
			try {
				if(dsn.equals("oracle")) {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kim","oracle");
					
					
					
				}else if(dsn.equals("mysql")) {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:DB��","kim","mysql");
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
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306:DB��",uid,pw);
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
				conn=null;
			}
		}
	}
	
	
	
}
