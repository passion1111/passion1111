package ex03.jdbc12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GiftInsert {
	 
	GiftInsert(String[] args)	throws ClassNotFoundException, SQLException {
		// 1.Driver load,... exception
		Class.forName("oracle.jdbc.OracleDriver");
		// 2. Connection & Open
		// driver:@IP:portNumber:SID(or ���������ͺ��̽���)
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String uid = "kimkim";
		String pwd = "oracle";
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		// 3. ��� ( DML - Insert )
		Statement stmt = conn.createStatement();
		//insert into gift values(?, ?, ?, ?);
		//String sql = "insert into gift values(13, '����2', 3000, 5000)";
		
//		INSERT INTO table (gno,gname,g_start,g_end) VALUES (?,?,?,?)
//		WHERE NOT EXISTS (SELECT * FROM table WHERE gno=gno)
		String sql = 
				 "insert into gift select "+args[0]+",'"+args[1]+"',"+args[2]+","+args[3]+
				 " from dual where not exists (select * from gift where gno ="+args[0] +")"; 
		// gift��   �ֱ�����  ���� table�� ����� ���� table����� ������ ������(args)0 1 2 3�� ����� �� �������߿� gift��
//		 										gno��  ������1�� �������������� ��.
//		�� �ֱ����� �������̺�� �������� ������ ������ �� 
				 		
				  

				 						
		int result = stmt.executeUpdate(sql);
		System.out.println(result + " ������ �߰� ������");
		
		//4. �ڿ���ȯ(�ݱ�)
		stmt.close();		conn.close();
		
	}
}










