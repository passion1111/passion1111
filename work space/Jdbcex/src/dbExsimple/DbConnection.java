package dbExsimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

	public static Connection conn;
	public static Connection getConnection() {
		Connection conn=null;
		try {
			String user="kimkim";
			String pw="oracle";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			Class.forName("oracle.jdbc.OracleDriver");//��ҹ��� ������
			conn=DriverManager.getConnection(url);
		}catch (ClassNotFoundException cbfe) {
			System.out.println("DB����̹� �ε� ����");
		}catch (SQLException sqle) {
			System.out.println("DB���ӽ���"+sqle);
		}catch (Exception e) {
			System.out.println("Unkwon error");
		}
		return conn;
		
	}

      private void closeConnection() {
	 try {
		if(conn!=null) {conn.close(); }
			
		
	} catch (Exception e) {
		// TODO: handle exception
	}
      }
      
	 public int menuadd(Menu menu) {
		int result =-1;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="inserto int menu(name,temp,price) values(?,?,?)";

		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, menu.getName());
			pstmt.setInt(2, menu.getPrice());
		
			result=pstmt.executeUpdate();
			conn.setAutoCommit(false);
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}try {
			conn.rollback();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				closeConnection();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
		 
}
      }