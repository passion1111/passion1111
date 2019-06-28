package ex02.jdbc;
import java.sql.*;
import java.util.*;

public class ConnectionUtil {
	private static final String driver ="oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String uid = "kingsmile",  pwd = "oracle";
	
	Scanner sc = new Scanner(System.in);
	PreparedStatement pstmt = null;
	public Connection conn = null;
	ResultSet rs = null;
	String sql = null;
	
	// 연결
	public void connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 닫기
	public void close() {
		try {
			if( rs != null ) rs.close();
			if( pstmt != null) pstmt.close();
			if( conn != null ) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	// menu()
	public static void menu() {
		System.out.println("\n-=-=-=-= JDBC Query =-=-=-=-");
		System.out.println("\t 1.레코드 삽입 ");
		System.out.println("\t 2.레코드 수정 ");
		System.out.println("\t 3.전체보기 ");
		System.out.println("\t 4.레코드 삭제 ");
		System.out.println("\t 0.프로그램 종료 ");
		System.out.println("원하는 메뉴 숫자 입력 : ");
	}
	
	// select()
	public void selectAll() {
		try {
			pstmt = conn.prepareStatement("SELECT * FROM DEPT2");
			rs = pstmt.executeQuery(); //반환값 있는 경우
			System.out.println("\n DCODE \t DNAME \t PDEPT \t AREA");
			
			while(rs.next()) {
				System.out.print(rs.getString(1) +"\t\t");
				System.out.print(rs.getString(2) +"\t\t");
				System.out.print(rs.getString(3) +"\t\t");
				System.out.print(rs.getString(4) +"\n");
				
			} // while end
			
			pstmt = null;  ///<--- pstmt 초기화하기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// insert()
	public void insert() {
		 System.out.print("Dcode : ");		 String dcode = sc.next();
		 System.out.print("Dname : ");		 String dname = sc.next();
		 System.out.print("Pdept : ");		 String pdept = sc.next();
		 System.out.print("Area : ");		 String area = sc.next();
		 try {
			sql = "INSERT INTO DEPT2 VALUES( ?, ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);     // pstmt.setXXX( 순번, 값 );
			pstmt.setString(1, dcode);
			pstmt.setString(2, new String(dname.getBytes("utf-8"), "utf-8"));
			pstmt.setString(3, pdept);
			pstmt.setString(4, area);
			int result = pstmt.executeUpdate();
			System.out.println(result + "데이터가 추가되었습니다.");
			// 화면 결과 확인하고자 할때 - select
			selectAll();
			//자바는 auto Commit 된다.
			//conn.commit();
			pstmt = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// update() 
	public void update() {
		selectAll();
		System.out.print("수정할 Dcode? : ");		
		String dcode = sc.next();
		System.out.print("Dcode 입력 : ");			
		String dcode2 = sc.next();
		System.out.print("Dname 입력 : ");			
		String dname = sc.next();
		System.out.print("Pdept 입력 : ");			
		String pdept = sc.next();
		System.out.print("Area 입력 : ");				
		String area = sc.next();
		
		try {
			sql = "UPDATE DEPT2 SET DCODE = ? , DNAME =?,  PDEPT = ?, AREA = ? WHERE DCODE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dcode2);
			pstmt.setString(2, new String(dname.getBytes("utf-8"), "utf-8") );
			pstmt.setString(3, pdept);
			pstmt.setString(4, area);
			pstmt.setString(5, dcode);
			int result = pstmt.executeUpdate(); //
			System.out.println(result + " 데이터 수정 성공~!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//원하는 필드만 골라서 수정하기 
	public void update2() {
		selectAll();
		System.out.print("수정할 Dcode? : ");		
		String dcode = sc.next();
		System.out.print("Dcode 입력 : ");			
		String dcode2 = sc.next();
		System.out.print("Dname 입력 : ");			
		String dname = sc.next();
		System.out.print("Pdept 입력 : ");			
		String pdept = sc.next();
		System.out.print("Area 입력 : ");				
		String area = sc.next();
		
		try {
			sql = "UPDATE DEPT2 SET DCODE = ? , DNAME =?,  PDEPT = ?, AREA = ? WHERE DCODE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dcode2);
			pstmt.setString(2, new String(dname.getBytes("utf-8"), "utf-8") );
			pstmt.setString(3, pdept);
			pstmt.setString(4, area);
			pstmt.setString(5, dcode);
			int result = pstmt.executeUpdate(); //
			System.out.println(result + " 데이터 수정 성공~!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// delete()
	public void delete() {
		System.out.print("삭제 하려는 Dcode? : ");		String dcode = sc.next();			
		try {
			sql = "DELETE FROM DEPT2 WHERE DCODE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dcode);
			int result = pstmt.executeUpdate(); //
			System.out.println(result + " 데이터 삭제 성공~!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// selectByDcode(int code) - 원하는 레코드 출력하기
	public void selectByDcode(int code) {
		
	}
}






