package edu.bit.visitors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dbconnection.ConnectionCloseHelper1;
import dbconnection.ConnectionHelper1;

public class BookDAO {//controller
	
	public static Connection loadOracleDriver() {
		Connection conn=null;
				try {
					conn=ConnectionHelper1.getConnection("oracle");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return conn;
		
	}

	
	public static void insert(Connection conn,BookVO vo) {
		StringBuffer sb=new StringBuffer();
		PreparedStatement pstmt=null;
		try {
			conn=ConnectionHelper1.getConnection("oracle");
			sb.append("INSERT INTO GUESTBOOK(NUM,NAME,EMAIL,HOME,CONTENTS)");
			sb.append(" VALUES(BOOK_NUM.NEXTVAL,?,?,?,? )" );
			System.out.println(sb.toString());
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getHome());
			pstmt.setString(4, vo.getContents());
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void delete(Connection conn,BookVO vo) {
		conn=ConnectionHelper1.getConnection("oracle");
		StringBuffer sb=new StringBuffer();
		PreparedStatement pstmt=null;
		try {
			sb.append("DELETE from guestbook where num="+vo.getNum());
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void update(Connection conn,BookVO vo) {
		conn=ConnectionHelper1.getConnection("oracle");
		StringBuffer sb=new StringBuffer();
		PreparedStatement pstmt=null;
		try {
			sb.append("update guestbook set contents=? where num=?");
			System.out.println(sb.toString());
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getContents());
			pstmt.setLong(2, vo.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//////////전체 레코드 수 구해서 페이지 카운트하는 함수
	public static int getPageCount(Connection conn,int numPerPage) throws SQLException {
		String sql="SELECT COUNT(NUM) FROM GUESTBOOK";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		int max=0;
		while(rs.next()) {
			max=rs.getInt(1);
			break;
		}
		ConnectionCloseHelper1.close(pstmt);
		int pageCount=(int)Math.ceil((double)max/numPerPage);
		pageCount=Math.max(pageCount, 1);  //max(2,1) 둘중에 뭐가 더 크니 
		
		return pageCount;
	}
	//getData--전체 레코드 화면 추력 함수
	public static Vector<BookVO> getData(Connection conn,int mypage,int numPerPage) throws SQLException{
		StringBuffer sb =new StringBuffer();
		int start=(mypage-1)*numPerPage;//(2-1)*5=5
		int end=mypage*numPerPage;//2*5=10
		
		sb.append("select name, email, home, contents from GUESTBOOK "); 
		sb.append("  where num > ? and num <= ? order by num desc");
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		ResultSet rs=	pstmt.executeQuery();
		Vector<BookVO> data=new Vector<BookVO>();
		while(rs.next()) {
			BookVO vo=new BookVO();
			vo.setName(rs.getString("name"));
			vo.setEmail(rs.getString("email"));
			vo.setHome(rs.getString("home"));
			vo.setContents(rs.getString("contents"));
		data.add(vo);
		}
		ConnectionCloseHelper1.close(rs);
		ConnectionCloseHelper1.close(pstmt);
		return data;
	}//getData() end
}
