package dbConnectionEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection dbConn;
	
		public static Connection getconnConnection()
		{
			Connection conn=null;
			try {
				String user="kim";
				String pw="oracle";
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				
				Class.forName("oracle.jdbc.OracleDriver");//��ҹ��� ������
				//oracle.jdbc.OracleDriver
				conn=DriverManager.getConnection(url, user, pw);
				
				System.out.println("Database�� ����Ǿ����ϴ�.");
			}catch (ClassNotFoundException cnfe) {
				System.out.println("DB����̹� �ε� ����"+cnfe.toString());
			}catch (SQLException sqle) {
				System.out.println("DB ���ӽ���:"+sqle.toString());
				
			}catch (Exception e) {
				System.out.println("Unkown error");
			}
			
			
			
			
			return conn;
		}
}
