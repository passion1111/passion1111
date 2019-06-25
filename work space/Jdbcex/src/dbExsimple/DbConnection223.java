package dbExsimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection223 {

	public static Connection conn;
	public static Connection getConnection() {
		Connection conn=null;
		try {
			String user="kimkim";
			String pw="oracle";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			Class.forName("oracle.jdbc.OracleDriver");//대소문자 구분함
			conn=DriverManager.getConnection(url);
		}catch (ClassNotFoundException cbfe) {
			System.out.println("DB드라이버 로딩 실패");
		}catch (SQLException sqle) {
			System.out.println("DB접속실패"+sqle);
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
		String sql="insert into menu(name,temp,price) values('이름' ,1,3000)";

		try {
			conn=DbConnection223.getConnection();
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