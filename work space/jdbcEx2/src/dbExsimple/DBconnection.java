package dbExsimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection dbConn;
	
		public static Connection getconnConnection() //클래스를 그렇게 저장했기떄문에
		{
			Connection conn=null;
			try {
				String user="kimkim";
				String pw="oracle";
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				
				Class.forName("oracle.jdbc.OracleDriver");//대소문자 구분함
				//oracle.jdbc.OracleDriver
				conn=DriverManager.getConnection(url, user, pw);
				
				System.out.println("Database에 연결되었습니다.");
			}catch (ClassNotFoundException cnfe) {
				System.out.println("DB드라이버 로딩 실패"+cnfe.toString());
			}catch (SQLException sqle) {
				System.out.println("DB 접속실패:"+sqle.toString());
				
			}catch (Exception e) {
				System.out.println("Unkown error");
			}
			
			
			
			
			return conn;
		}
}