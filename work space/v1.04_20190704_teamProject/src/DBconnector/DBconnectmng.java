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

	static {
		try { // 드라이버는 계속 사용할거니까 static으로 선언해서 메모리에 미리 올려둠
			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("라이브러리 추가되었는지 클래스 이름이 정확한지 확인해주세요");

		}
	}// static end

	public Connection getConnection() {// 연결을 얻어오는 메소드
		try {
			url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			uid = "kim";// 자기 계정으로 고쳐서 쓸 것
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
