package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.domain.EmpDTO;

import dbclose.util.CloseUtil;

public class EmpDAO {
	
	int empno;
	DataSource dataFactory;
	
	public EmpDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc:Emp2DB");
			//System.out.println("connection success!!");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}// end 생성자함수 
	
	//데이터 검색(select)
	public ArrayList<EmpDTO> select() {
		
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=dataFactory.getConnection();
			String sql="select empno ,name, pay ,deptno from emp2";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				int pay=rs.getInt("pay");
				String name=rs.getString("name");
				String deptno=rs.getString("deptno");
				list.add(new EmpDTO(empno, name,deptno, pay));
			}//end while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn);
		}//try end
		
		return list;
	}//end select()
	

}












