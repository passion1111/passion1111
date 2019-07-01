package ex01.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbConn.util.ConnectionCloseHelper;
import dbConn.util.ConnectionSingletonHelper;

public class Ex06_Oracle_PrepareStatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			 //conn = ConnectionHelper.getConnection("oracle");
			 //�̱��� ������ ����� ����
			 conn = ConnectionSingletonHelper.getConnection("oracle");
			
			// pstmt = conn.prepareStatement("select empno,ename from emp where empno=?");
			// pstmt.setInt(1, 7788);
			 
			//rs = pstmt.executeQuery();
			// while(rs.next()){
			//	System.out.println("empno : " + rs.getInt(1) + " ename : " + rs.getString(2));
			// }
			 
			 //Insert  ó��
			 String sql = "insert into emp(empno,ename,sal) values(?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, 8888);
			 pstmt.setString(2, "nothing");
			 pstmt.setInt(3, 5555);
			 
			 int row =  pstmt.executeUpdate(); // statement ���  pstmt.executeUpdate(������);
			 System.out.println("�ݿ��� ���� �� : " + row);
		
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			ConnectionCloseHelper.close(pstmt);
			ConnectionCloseHelper.close(conn);
		}

	}

}
