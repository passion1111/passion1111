package edu.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class EmpDAO {
	public static EmpDAO instance=new EmpDAO();
	
	public EmpDAO() {
	}
	public static EmpDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception {
		// 연결은 JNDI * Pool 형태로 연결 객체 생성해서 리턴할것
		Context initCtx = new InitialContext();

		DataSource  ds = 
			(DataSource)initCtx.lookup("java:comp/env/jdbc:EmpDB");
		
		return ds.getConnection();
	}//getConnection() end

	public int getListAllCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = getConnection();
			
			//현재 board 테이블의 레코드 수 구하기
			pstmt = conn.prepareStatement("SELECT COUNT(empno) FROM emp2");
			rs = pstmt.executeQuery();
			
			if(rs.next()) count = rs.getInt("count(empno)");  
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} //end try
		
		return count;
	} //getListAllCount() end
	
	//getSelectAll(start, end) : list.jsp에서 사용
	public List<empVO> getSelectAll(int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = null;
		
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			
			
			//방법 4>
			sb.append("select * from(select EMPNO, NAME, DEPTNO, TEL, PAY,");
			sb.append("rownum r from(select  EMPNO, NAME, DEPTNO, TEL, PAY from emp2 order by empno desc, deptno asc)");
			sb.append("order by empno desc, deptno asc) where r>=? and r<=?");
			
			//System.out.println(sb.toString());
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList(end);
				
				do {
					empVO vo = new empVO();
					vo.setEMPNO(rs.getInt("EMPNO"));
					vo.setNAME(rs.getString("NAME"));
					vo.setDEPTNO(rs.getString("DEPTNO"));
					vo.setPAY(rs.getInt("pay"));
					vo.setTEL(rs.getString("tel"));
					
					//list 객체에 데이터 저장빈인 BoardVO 객체에 저장
					list.add(vo);
					
				}while(rs.next());		
			} //end if
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	} //getSelectAll() end


}
