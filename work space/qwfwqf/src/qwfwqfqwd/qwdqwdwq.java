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
        
        Class.forName("oracle.jdbc.OracleDriver");//��ҹ��� ������
        conn=DriverManager.getConnection(url, user, pw);
        
        System.out.println("����Ϸ�?");
     }catch (ClassNotFoundException cbfe) {
        System.out.println("DB����̹� �ε� ����");
     }catch (SQLException sqle) {
        System.out.println("DB���ӽ���"+sqle);
     }catch (Exception e) {
    	 
        System.out.println("Unkwon error");
     }
	
}
	
	


		
	}

