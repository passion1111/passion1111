package dbconnection;
import java.sql.*;
import java.util.*;

//db���� ���� �ݺ������� �ڵ� �ذ�
//�ٸ�Ŭ�������� �Ʒ� �ڵ� ������ ���� �ʵ��� ����

/*
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kim", "oracle");
//�̷������� ����Ұ���
ConnectionHelper.getConnection("mysql") or ("oracle") //���Է��ϸ� �˾Ƽ� �����°�.
dsn=<data source name  
*/

public class ConnectionHelper1 {
//	�Լ�(������:public,static)
	public static Connection getConnection(String dsn) {
			Connection conn=null;
			
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
	
	
	
	
	
}
