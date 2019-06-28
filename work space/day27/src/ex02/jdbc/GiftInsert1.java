package ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

 class GiftInsert1 {
	GiftInsert1(String[] args)	throws ClassNotFoundException, SQLException {
//		// 1.Driver load,... exception
//		Class.forName("oracle.jdbc.OracleDriver");
//		// 2. Connection & Open
//		// driver:@IP:portNumber:SID(or 전역데이터베이스명)
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//		String uid = "kimkim";
//		String pwd = "oracle";
//		Connection conn = DriverManager.getConnection(url, uid, pwd);
		MainEntry a=new MainEntry();
		Connection conn;
		conn=a.Connection();
		
		// 3. 사용 ( DML - Insert )
		Statement stmt = conn.createStatement();
		//insert into gift values(13, '스팸2', 3000, 5000);
		//String sql = "insert into gift values(13, '스팸2', 3000, 5000)";
		String sql = 
		 "insert into gift values("+ args[0]+",'"+ args[1] +"',"
				 			+ args[2]+","+args[3]+")";
		
		int result = stmt.executeUpdate(sql);
		System.out.println(result + " 데이터 추가 성공함");
		
		//4. 자원반환(닫기)
		stmt.close();		conn.close();
		
	}
}










