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
		try { // ����̹��� ��� ����ҰŴϱ� static���� �����ؼ� �޸𸮿� �̸� �÷���
			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("���̺귯�� �߰��Ǿ����� Ŭ���� �̸��� ��Ȯ���� Ȯ�����ּ���");

		}
	}// static end

	public Connection getConnection() {// ������ ������ �޼ҵ�
		try {
			url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			uid = "kim";// �ڱ� �������� ���ļ� �� ��
			pwd = "oracle";
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (SQLException e) {
			System.out.println("Ŀ�ؼ� ���� ����");
			e.printStackTrace();
		}
		System.out.println("DB�� ����Ǿ����ϴ�!");
		return conn;
	}
}
