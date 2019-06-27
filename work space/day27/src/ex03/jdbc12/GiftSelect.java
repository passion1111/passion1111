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
					//driver:@IP:portNumber:SID(or 전역데이터베이스명)
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String uid = "kimkim";
		String pwd = "oracle";
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		//3. 사용 ( DML - Select )
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM GIFT");
		
		System.out.println("상품번호\t상품명\t최저가\t최고가");
		while( rs.next() ) {
			int gno = rs.getInt(1);  // int gno = rs.getInt("gno");
			String gname = rs.getString("gname");
			int g_s = rs.getInt("g_start");
			int g_e = rs.getInt("g_end");
			
			System.out.println(gno+"\t"+gname+"\t"+g_s + "\t"+g_e);
		} // end while
		
		//4. 자원반환(닫기)
		rs.close();		stmt.close();		conn.close();
	}
}






