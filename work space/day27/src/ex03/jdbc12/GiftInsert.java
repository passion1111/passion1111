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
		// driver:@IP:portNumber:SID(or 전역데이터베이스명)
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String uid = "kimkim";
		String pwd = "oracle";
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		// 3. 사용 ( DML - Insert )
		Statement stmt = conn.createStatement();
		//insert into gift values(?, ?, ?, ?);
		//String sql = "insert into gift values(13, '스팸2', 3000, 5000)";
		
//		INSERT INTO table (gno,gname,g_start,g_end) VALUES (?,?,?,?)
//		WHERE NOT EXISTS (SELECT * FROM table WHERE gno=gno)
		String sql = 
				 "insert into gift select "+args[0]+",'"+args[1]+"',"+args[2]+","+args[3]+
				 " from dual where not exists (select * from gift where gno ="+args[0] +")"; 
		// gift에   넣기전에  가상 table을 만들고 가상 table값들과 적용할 변수명(args)0 1 2 3을 만들고 그 변수명중에 gift에
//		 										gno가  변수명1과 동일하지않은지 비교.
//		즉 넣기전에 가상테이블로 기존값과 같은건 없는지 비교 
				 		
				  

				 						
		int result = stmt.executeUpdate(sql);
		System.out.println(result + " 데이터 추가 성공함");
		
		//4. 자원반환(닫기)
		stmt.close();		conn.close();
		
	}
}










