package ex03.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class GiftController { // Controller

	// 연결, 삽입, 삭제, 수정, 검색...
	static final String driver = "oracle.jdbc.OracleDriver";
	static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String uid = "kim", pwd = "oracle";

	static Scanner sc = new Scanner(System.in);
	 static Statement stmt = null;
	static Connection conn = null;
	static ResultSet rs = null;

	// 연결
	public static void connect() {
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.createStatement();
			conn.setAutoCommit(false); // 자동커밋 끄기 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 닫기
	public void close() {
		try {
			rs.close();		stmt.close();	conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// menu()
	public static void menu() throws SQLException {
		
		Gift gift = new Gift();
		
		while(true) {
			
			System.out.println("\n★ 메뉴를 선택하세요....");
			System.out.println("\n1.select \t2.insert \t3.update \n4.delete \t5.rollback \t 6.exit ");
			
			switch( sc.nextInt() ) {
			case 1:
				select(gift.getClassname());
				break;
				
			case 2:
				select(gift.getClassname());
				insert();
				select(gift.getClassname());
				break;
			case 4:
				select(gift.getClassname());
				delete();
				select(gift.getClassname());
				break;	
				
			
			} //end switch
		} // end while
	}//end menu()

	public static void insert() {
		PreparedStatement pstmt = null;
		System.out.print("GNO : ");	String GNO = sc.next();
		System.out.print("GNAME : ");	String GNAME = sc.next();
		System.out.print("G_START : ");	String G_START = sc.next();
		System.out.print("G_END : ");	String G_END = sc.next();
		
		try {
			pstmt = conn.prepareStatement("insert into gift values(?, ?, ?, ?)");
			pstmt.setString(1, GNO);
			pstmt.setString(2, GNAME);
			pstmt.setString(3, G_START);
			pstmt.setString(4, G_END);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+ " 데이터가 추가되었습니다.");
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
		
	

	public static void select(String className) 
			throws SQLException {
		
		rs = stmt.executeQuery("select * from " + className);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		while( rs.next() ) {
			for (int i = 1; i <= count; i++) {  //각 타입별로 출력하기
				
				switch (rsmd.getColumnType(i)) {
				
					case Types.NUMERIC:
					case Types.INTEGER:
						System.out.print( rsmd.getColumnName(i) 
								+ " : " + rs.getInt(i) +" ");
						break;
						
					case Types.FLOAT:
						System.out.print( rsmd.getColumnName(i) 
								+ " : " + rs.getFloat(i)+" ");
						break;
						
					case Types.DOUBLE:
						System.out.print( rsmd.getColumnName(i) 
								+ " : " + rs.getDouble(i)+" ");
						break;
						
					case Types.CHAR:
						System.out.print( rsmd.getColumnName(i) 
								+ " : " + rs.getString(i)+" ");
						break;
						
					case Types.DATE:
						System.out.print( rsmd.getColumnName(i) 
								+ " : " + rs.getDate(i)+" ");
						break;
	
					default:
						System.out.print( rsmd.getColumnName(i) 
								+ " : " + rs.getString(i)+" ");
						break;
				} // end switch
				
			} //end for
			System.out.println();
		} //end while
		
	} // select() end
	
	
	public static void delete() throws SQLException {
		
		try {
		
			System.out.println("삭제하실 번호는?");
			int num=sc.nextInt();
			String sql="delete  gift where gno=" + num;
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"삭제 완료");

		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void update(String className) throws SQLException {
		
		while (true) {
			String modi = null;
			
			System.out.print("수정할 GNO: ");
			int gno = sc.nextInt();

			System.out.println("1.GNO\t2.GNAME\t3.G_START\t4.G_END\t0.exit");
			System.out.print("수정할 필드: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("바뀔 GNO: ");
				stmt.executeUpdate("update " + className + " set GNO = " + sc.nextInt() + " where gno = " + gno);
				break;
			case 2:
				System.out.print("바뀔 GNAME: ");
				stmt.executeUpdate("update " + className + " set GNAME = '" + sc.next() + "' where gno = " + gno);
				break;
			case 3:
				System.out.print("바뀔 G_START: ");
				stmt.executeUpdate("update " + className + " set G_START = " + sc.nextInt() + " where gno = " + gno);
				break;
				
			case 4:
				System.out.print("바뀔 G_END: ");
				stmt.executeUpdate("update " + className + " set G_END = " + sc.nextInt() + " where gno = " + gno);
				break;
				
			case 5:
				System.out.print("바뀔 G_END: ");
				stmt.executeUpdate("update " + className + " set G_END = " + sc.nextInt() + " where gno = " + gno);
				break;
				
				
			case 0:
				break;
			}
			if(choice==0)break;
			switch(choice) {
			case 1: modi = "GNO";
			case 2: modi = "GNAME";
			case 3: modi = "G_START";
			case 4: modi = "G_END";
			}
			
			System.out.println(modi + " 수정이 완료되었습니다.");
			
		}
	}
	
}






//rs.getmetadata로 statement의 객체들을 가져와 resultsetmetadata에 집어넣어준다.
//rs.getcoulmntype  테이블의 컬럼타입들을 for i를 돌면서 알수가있었음.
//그렇게 컬럼타입을알아낸다음 types.numeric   types.integer;
//이런형식으로 스위치 케이스 돌린것.



/*

package ex03.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class GiftController { // Controller

	// 연결, 삽입, 삭제, 수정, 검색...
	static final String driver = "oracle.jdbc.OracleDriver";
	static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String uid = "kingsmile", pwd = "oracle";

	static Scanner sc = new Scanner(System.in);
	static Statement stmt = null;
	static Connection conn = null;
	static ResultSet rs = null;

	// 연결
	public static void connect() {
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.createStatement();
			conn.setAutoCommit(false); // 자동커밋 끄기

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 닫기
	public static void close() {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// menu()
	public static void menu() throws SQLException {

		Gift gift = new Gift();

		while (true) {

			System.out.println("\n★ 메뉴를 선택하세요....");
			System.out.println("\n1.select \t2.insert \t3.update \n4.delete \t5.rollback \t 6.exit ");

			switch (sc.nextInt()) {
			case 1:
				select(gift.getClassName());
				break;

			case 2:
				select(gift.getClassName());
				insert();
				select(gift.getClassName());
				break;
				
			case 3:
				update(gift.getClassName());
				break;
				
			case 5:

				System.out.println("Commit 하시겠습니까?(Y/N)");
				System.out.print("안하시면 Rollback 됩니다.");
				if (sc.next().equalsIgnoreCase("Y")) {
					commit();
					select(gift.getClassName());
				} else {
					rollback();
					select(gift.getClassName());
				}
				break;
			case 6:
				close();
				System.out.print("프로그램 종료 !!");
				System.exit(0);
			} // end switch
		} // end while
	}// end menu()

	
	public static void update(String className) throws SQLException {
		a:
		while (true) {
			String modi = null;
			
			System.out.print("수정할 GNO: ");
			int gno = sc.nextInt();

			System.out.println("1.GNO\t2.GNAME\t3.G_START\t4.G_END\t0.exit");
			System.out.print("수정할 필드: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("바뀔 GNO: ");
				stmt.executeUpdate("update " + className + " set GNO = " + sc.nextInt() + " where gno = " + gno);
				break;
			case 2:
				System.out.print("바뀔 GNAME: ");
				stmt.executeUpdate("update " + className + " set GNAME = '" + sc.next() + "' where gno = " + gno);
				break;
			case 3:
				System.out.print("바뀔 G_START: ");
				stmt.executeUpdate("update " + className + " set G_START = " + sc.nextInt() + " where gno = " + gno);
				break;
				
			case 4:
				System.out.print("바뀔 G_END: ");
				stmt.executeUpdate("update " + className + " set G_END = " + sc.nextInt() + " where gno = " + gno);
				break;
				
			case 5:
				System.out.print("바뀔 G_END: ");
				stmt.executeUpdate("update " + className + " set G_END = " + sc.nextInt() + " where gno = " + gno);
				break;
				
				
			case 0:
				break a;
			}
			
			switch(choice) {
			case 1: modi = "GNO";
			case 2: modi = "GNAME";
			case 3: modi = "G_START";
			case 4: modi = "G_END";
			}
			
			System.out.println(modi + " 수정이 완료되었습니다.");
			
		}
	}

	public static void insert() {
		PreparedStatement pstmt = null;
		System.out.print("GNO : ");	String GNO = sc.next();
		System.out.print("GNAME : ");	String GNAME = sc.next();
		System.out.print("G_START : ");	String G_START = sc.next();
		System.out.print("G_END : ");	String G_END = sc.next();
		
		try {
			pstmt = conn.prepareStatement("insert into gift values(?, ?, ?, ?)");
			pstmt.setString(1, GNO);
			pstmt.setString(2, GNAME);
			pstmt.setString(3, G_START);
			pstmt.setString(4, G_END);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+ " 데이터가 추가되었습니다.");
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	private static void commit() throws SQLException {
		conn.commit();
		System.out.println("커밋 완료");
	}

	private static void rollback() throws SQLException {
		conn.rollback();
		System.out.println("롤백 완료");
	}
	
	public static void select(String className) throws SQLException {

		rs = stmt.executeQuery("select * from " + className);

		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= count; i++) { // 각 타입별로 출력하기

				switch (rsmd.getColumnType(i)) {

				case Types.NUMERIC:
				case Types.INTEGER:
					System.out.print(rsmd.getColumnName(i) + " : " + rs.getInt(i) + " ");
					break;

				case Types.FLOAT:
					System.out.print(rsmd.getColumnName(i) + " : " + rs.getFloat(i) + " ");
					break;

				case Types.DOUBLE:
					System.out.print(rsmd.getColumnName(i) + " : " + rs.getDouble(i) + " ");
					break;

				case Types.CHAR:
					System.out.print(rsmd.getColumnName(i) + " : " + rs.getString(i) + " ");
					break;

				case Types.DATE:
					System.out.print(rsmd.getColumnName(i) + " : " + rs.getDate(i) + " ");
					break;

				default:
					System.out.print(rsmd.getColumnName(i) + " : " + rs.getString(i) + " ");
					break;
				} // end switch

			} // end for
			System.out.println();
		} // end while

	} // select() end
	
	//delete
	public static void delete(String className) throws SQLException {
		System.out.print("삭제할 레코드의gno : ");
		String gno = sc.next();
		try {
			String sql = "delete " + className + " where gno=" + gno;
			int result = stmt.executeUpdate(sql); //쿼리 실행
			System.out.println(result + " 개의 데이터가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //delete end
	
//	public static void delete() throws SQLException {
//		
//		try {
//		
//			System.out.println("삭제하실 번호는?");
//			int num=sc.nextInt();
//			String sql="delete  gift where gno=" + num;
//			//stmt=conn.createStatement();
//			//System.out.println(sql.toString());
//			
//			//System.out.println("1111");
//			//System.out.println(stmt.executeUpdate(sql));
//			
//			int result = stmt.executeUpdate(sql);
//			System.out.println(result+"삭제 완료");
//
//		
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}

}
*/