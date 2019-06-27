package ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class GiftCRUD {
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int num, gno, g_start, g_end, modiNum;
		num = gno = g_start = g_end = modiNum = 0;
		String gname = null;
		
		System.out.print("���ϴ� ����� ������ �ּ���  \n");
		System.out.println(
				"1. Gift select,  2. Gift insert,  3. Gift update,  4. Gift delete, 5. Gift rollback, 6. exit  ");
		num = sc.nextInt();

		switch (num) {
		// select
		case 1: select(); break;
		case 2: insert(); break;
		case 3: update(); break;
		case 4: delete(); break;		
		case 5:
			getConnection().rollback();
			System.out.println("�ѹ� �߽��ϴ�.");
			break;

		case 6:
			rs.close();
			// pstmt.close();
			stmt.close();
			getConnection().close();
			System.exit(0);
			break;

		default:
			System.out.println("�ٽ� �Է��� �ּ���");
			break;

		} // switch end

	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kingsmile";
		String pwd = "oracle";
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 1.
			Class.forName(driver);
		// 2.
		Connection conn = DriverManager.getConnection(url, user, pwd);
		conn.setAutoCommit(false); // �ڵ� Ŀ�� ����
		return conn ;
	}
	
	public static void insert() throws ClassNotFoundException, SQLException {
		int num, gno, g_start, g_end, modiNum;
		num = gno = g_start = g_end = modiNum = 0;
		String gname = null;
				
		System.out.print("gno = ");			gno = sc.nextInt();
		System.out.print("gname = ");		gname = sc.next();
		System.out.print("g_start = ");		g_start = sc.nextInt();
		System.out.print("g_end = ");		g_end = sc.nextInt();
		
		try {
			stmt.executeQuery("INSERT INTO GIFT VALUES(" + gno + ", '"
					+ new String(gname.getBytes("euc-kr"), "euc-kr") + "' ," + g_start + ", " + g_end + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
		getConnection().commit(); // �߰� �Ϸ�....
		System.out.println(gname + " �߰� �Ǿ����ϴ�.");
	}
	
	public static void update() throws SQLException, ClassNotFoundException {
		int  modiNum=0, num=0, gno = 0;

		rs = stmt.executeQuery("SELECT * FROM GIFT");
		printdata(rs);
		System.out.print("������ �������� gno�� �����ϼ��� :  ");
		modiNum = sc.nextInt();
		System.out.println("������ �����ʹ� ���� ? ");
		System.out.println("1. gno,  2. gname,  3. ��ǰ����");
		num = sc.nextInt();

			System.out.println("���� gno : ");
			rs = stmt.executeQuery("select gno from gift where gno = " + modiNum);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " �Դϴ�.");
			} // in while end
			System.out.println("�� ������ �ٲٽðڽ��ϱ�? ");
			gno = sc.nextInt();

			pstmt = getConnection().prepareStatement("update gift set gno = ?  where  gno = " + modiNum);
			pstmt.setInt(1, gno);
			pstmt.executeUpdate(); // !!!!!
			System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
	}
		
	public static void delete() throws ClassNotFoundException, SQLException {
		rs = stmt.executeQuery("SELECT * FROM GIFT");
		printdata(rs);
		System.out.print("������ ������ �̸��� �Է� �ϼ��� ");
		String gname = sc.next();

		// stmt.executeUpdate("delete from gift where gname = '" + gname
		// + " ' " );
		pstmt = getConnection().prepareStatement("DELETE FROM GIFT WHERE GNAME = ? ");
		pstmt.setString(1, gname);
		pstmt.executeUpdate();
		System.out.println(gname + " �� �ش��ϴ� ��ǰ�� ���� �Ǿ����ϴ�.");
	}
	
	public static void select() throws ClassNotFoundException, SQLException {
		stmt = getConnection().createStatement();
		rs = stmt.executeQuery("SELECT * FROM GIFT");
		printdata(rs); // ��¸޼ҵ� - �ݺ��ڵ�...
	}
	
	public static void printdata(ResultSet rs) { // ��� �Լ�
		int num = 1;
		try {
			ResultSetMetaData rsmd = null; // ���̺��� ������ ��� �� �� �ִ� �������̽�
			// resultset�� �����͸� MetaData�� ������ �ľ��Ѵ�.
			// MetaData = �Ӽ� ���� ��� �� �� �ִ�.
			rsmd = rs.getMetaData();

			int colCount = rsmd.getColumnCount(); // �÷� ���� ���Ѵ�.

			while (rs.next()) {
				System.out.print(num + " ��  --> ");
				num++;

				for (int i = 1; i <= colCount; i++) {

					switch (rsmd.getColumnType(i)) { // �� Ÿ�Ժ��� ��� �Ѵ�.
					case Types.NUMERIC:
					case Types.INTEGER:
						System.out.print("\t" + rsmd.getColumnName(i) + " : " + rs.getInt(i) + "\t");
						// System.out.printf( " %d ", rs.getInt(i) );
						// //(Object[])rs.getObject(i) );
						break;

					case Types.FLOAT:
						System.out.print("\t" + rsmd.getColumnName(i) + " : " + rs.getFloat(i) + "\t");
						break;

					case Types.DOUBLE:
						System.out.print("\t" + rsmd.getColumnName(i) + " : " + rs.getDouble(i) + "\t");
						break;

					case Types.CHAR:
						System.out.print("\t" + rsmd.getColumnName(i) + " : " + rs.getString(i) + "\t");
						break;

					case Types.DATE:
						System.out.print("\t" + rsmd.getColumnName(i) + " : " + rs.getDate(i) + "\t");
						break;

					default:
						// System.out.println("defult ");
						System.out.print("\t" + rsmd.getColumnName(i) + " : " + rs.getString(i) + "\t");
					} // switch end
						// System.out.println();
				} // for end
				System.out.println();
			} // while end

		} catch (Exception e) {
			System.err.println("SQLException : " + e.getMessage());
		} // try end
	} // printdata method end
}
