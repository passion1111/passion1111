package dbConnectionEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstm=null;//sql을 나타내는 객체
		ResultSet rs=null;
		
		try {
		//sql문장을 만들고 문장이 select문이라면 결과를 담을
//		객체를 미리 준비후 생성
		
			String quary="select*from emp";
			conn=DBconnection.getconnConnection();
			pstm=conn.prepareStatement(quary);
			rs=pstm.executeQuery();
			
			System.out.println("empno ename job mgr hiredate sal comm deptno");
			System.out.println("******************");
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString(2);
				String job=rs.getString(3);
				int mgr=rs.getInt(4);
				java.sql.Date hiredate=rs.getDate(5);
				int sal=rs.getInt(6);
				int comm=rs.getInt(7);
				int deptno=rs.getInt(8);
				
				String result=empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno;
				System.out.println(result);
				
				
			}
		}catch (SQLException sqle) {
		System.out.println("select문에서 예외발생");
		}finally {
			//db연결을 종료한다
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
}
