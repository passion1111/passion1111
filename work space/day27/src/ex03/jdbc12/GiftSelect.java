package ex03.jdbc12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GiftSelect {
	GiftSelect() throws ClassNotFoundException, SQLException  {
		//1.Driver load,... exception
		Class.forName("oracle.jdbc.OracleDriver");
		//2. Connection & Open
					//driver:@IP:portNumber:SID(or ���������ͺ��̽���)
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String uid = "kimkim";
		String pwd = "oracle";
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		//3. ��� ( DML - Select )
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM GIFT");
		
		System.out.println("��ǰ��ȣ\t��ǰ��\t������\t�ְ�");
		while( rs.next() ) {
			int gno = rs.getInt(1);  // int gno = rs.getInt("gno");
			String gname = rs.getString("gname");
			int g_s = rs.getInt("g_start");
			int g_e = rs.getInt("g_end");
			
			System.out.println(gno+"\t"+gname+"\t"+g_s + "\t"+g_e);
		} // end while
		
		//4. �ڿ���ȯ(�ݱ�)
		rs.close();		stmt.close();		conn.close();
	}
}






