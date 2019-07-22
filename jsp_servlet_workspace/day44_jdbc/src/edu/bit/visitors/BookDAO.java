package edu.bit.visitors;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
