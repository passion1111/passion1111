package ex01.jdbc;

import java.sql.*;

public class MainEntry {
	public static void main(String[] args) 
		throws ClassNotFoundException, SQLException {
		//1.Driver load,... exception
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("driver load sucess");		
		//2. Connection & Open
					//driver:@IP:portNumber:SID(or ���������ͺ��̽���)
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String uid = "kingsmile";
		String pwd = "oracle";
		
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		System.out.println("connection sucess");
		//3. ��� (DML ��ɾ�)
		//4. �ڿ���ȯ(�ݱ�)
	}
	
	//SQL, Tag�� �ڹٿ��� ���ڿ� ����Ѵ�.
}






