package qwfwqfqwd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class qwdqwdwq {

	public static void main(String[] args) {
		

	Connection conn=null;
	try {
        String user="minjee";
        String pw="oracle";
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        
        Class.forName("oracle.jdbc.OracleDriver");//대소문자 구분함
        conn=DriverManager.getConnection(url, user, pw);
        
        System.out.println("연결완료?");
     }catch (ClassNotFoundException cbfe) {
        System.out.println("DB드라이버 로딩 실패");
     }catch (SQLException sqle) {
        System.out.println("DB접속실패"+sqle);
     }catch (Exception e) {
    	 
        System.out.println("Unkwon error");
     }
	
}
	
	


		
	}

