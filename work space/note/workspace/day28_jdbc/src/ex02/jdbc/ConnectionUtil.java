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
	
	// ����
	public void connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// �ݱ�
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
		System.out.println("\t 1.���ڵ� ���� ");
		System.out.println("\t 2.���ڵ� ���� ");
		System.out.println("\t 3.��ü���� ");
		System.out.println("\t 4.���ڵ� ���� ");
		System.out.println("\t 0.���α׷� ���� ");
		System.out.println("���ϴ� �޴� ���� �Է� : ");
	}
	
	// select()
	public void selectAll() {
		try {
			pstmt = conn.prepareStatement("SELECT * FROM DEPT2");
			rs = pstmt.executeQuery(); //��ȯ�� �ִ� ���
			System.out.println("\n DCODE \t DNAME \t PDEPT \t AREA");
			
			while(rs.next()) {
				System.out.print(rs.getString(1) +"\t\t");
				System.out.print(rs.getString(2) +"\t\t");
				System.out.print(rs.getString(3) +"\t\t");
				System.out.print(rs.getString(4) +"\n");
				
			} // while end
			
			pstmt = null;  ///<--- pstmt �ʱ�ȭ�ϱ�
			
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
			pstmt = conn.prepareStatement(sql);     // pstmt.setXXX( ����, �� );
			pstmt.setString(1, dcode);
			pstmt.setString(2, new String(dname.getBytes("utf-8"), "utf-8"));
			pstmt.setString(3, pdept);
			pstmt.setString(4, area);
			int result = pstmt.executeUpdate();
			System.out.println(result + "�����Ͱ� �߰��Ǿ����ϴ�.");
			// ȭ�� ��� Ȯ���ϰ��� �Ҷ� - select
			selectAll();
			//�ڹٴ� auto Commit �ȴ�.
			//conn.commit();
			pstmt = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// update() 
	public void update() {
		selectAll();
		System.out.print("������ Dcode? : ");		
		String dcode = sc.next();
		System.out.print("Dcode �Է� : ");			
		String dcode2 = sc.next();
		System.out.print("Dname �Է� : ");			
		String dname = sc.next();
		System.out.print("Pdept �Է� : ");			
		String pdept = sc.next();
		System.out.print("Area �Է� : ");				
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
			System.out.println(result + " ������ ���� ����~!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//���ϴ� �ʵ常 ��� �����ϱ� 
	public void update2() {
		selectAll();
		System.out.print("������ Dcode? : ");		
		String dcode = sc.next();
		System.out.print("Dcode �Է� : ");			
		String dcode2 = sc.next();
		System.out.print("Dname �Է� : ");			
		String dname = sc.next();
		System.out.print("Pdept �Է� : ");			
		String pdept = sc.next();
		System.out.print("Area �Է� : ");				
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
			System.out.println(result + " ������ ���� ����~!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// delete()
	public void delete() {
		System.out.print("���� �Ϸ��� Dcode? : ");		String dcode = sc.next();			
		try {
			sql = "DELETE FROM DEPT2 WHERE DCODE = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dcode);
			int result = pstmt.executeUpdate(); //
			System.out.println(result + " ������ ���� ����~!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// selectByDcode(int code) - ���ϴ� ���ڵ� ����ϱ�
	public void selectByDcode(int code) {
		
	}
}






