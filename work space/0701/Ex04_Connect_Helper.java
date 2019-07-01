package ex01.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConn.util.ConnectionHelper;

public class Ex04_Connect_Helper {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
				conn = ConnectionHelper.getConnection("oracle");
			
			   //3.명령생성 (CRUD)
			   stmt = conn.createStatement();
			   String sql = "select *  from gift";
			   
			   //4.명령실행(mysql 에게 명령 구문 실행)
			    rs = stmt.executeQuery(sql);
			   
			   //5.명령처리
			   while(rs.next()){
				   System.out.printf("[%d][%s][%d][%d]\n", 
						                 rs.getInt("gno") , rs.getString("gname") , rs.getInt("g_start"),rs.getInt("g_end") );
			   }
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			//6.자원해제
			//DB연결 종료
			if(rs != null){try{rs.close();}catch(Exception e){}}
			if(stmt != null){try{stmt.close();}catch(Exception e){}}
			if(conn != null){try{conn.close();}catch(Exception e){}}
		}
		
	}
}
