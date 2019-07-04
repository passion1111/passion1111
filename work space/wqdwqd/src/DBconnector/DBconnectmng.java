package DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectmng {

	String url = null;
	String uid = null;
	String pwd = null;
	Connection conn = null;

	public DBconnectmng() {
		getConnection();
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	static { //클래스선언.
		try { 
			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("라이브러리 추가되었는지 클래스 이름이 정확한지 확인해주세요");

		}
	}

	public Connection getConnection() {//DB 공통 메소드.
		try {
			url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			uid = "hak92";
			pwd = "oracle";
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		System.out.println("DB와 연결되었습니다!");
		return conn;
	}
}
