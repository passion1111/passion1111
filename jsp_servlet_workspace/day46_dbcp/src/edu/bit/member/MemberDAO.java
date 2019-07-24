package edu.bit.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dbclose.util.CloseUtil;

public class MemberDAO {
	public static MemberDAO instance=new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	public static Connection getConnection() throws Exception{
		//JNDI기재하기.
//		Context initCtx=new InitialContext();
//		Context envCtx=(Context)initCtx.lookup("java:comp/env");
//		DataSource ds=(DataSource)envCtx.lookup("jdbc:MemberDB");
		
		Context initCtx=new InitialContext();
//		Context envCtx=(Context)initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc:MemberDB");
	
		Connection conn=ds.getConnection();
		
		return conn;
	}
	
	//insert처리- 회원 가입 처리 메소드(삽입)
	public  void insert(MemberVO vo) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		StringBuffer sb=new StringBuffer();
		sb.append("insert into Members(id, passwd, name, jumin1, jumin2, email, blog, reg_date)");
		sb.append(" values (?, ?, ?, ?, ?, ?, ?,  ?)");
		conn=getConnection();
		pstmt=conn.prepareStatement(sb.toString());
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPasswd());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getJumin1());
		pstmt.setString(5, vo.getJumin2());
		pstmt.setString(6, vo.getEmail());
		pstmt.setString(7, vo.getBlog());
		pstmt.setTimestamp(8, vo.getReg_date());
		
		int result=pstmt.executeUpdate();
		CloseUtil.close(conn); //안써도 됨
		CloseUtil.close(pstmt); //안써도 됨.
	}
	public ArrayList<MemberVO> selectAll() throws Exception{
		String sql="select id,name,jumin1,jumin2,email,blog,"+
				"reg_date from Members order by name desc";
		Connection conn=getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		MemberVO vo=null;
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		while(rs.next()) {
			vo=new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
			vo.setJumin1(rs.getString("jumin1"));
			vo.setJumin2(rs.getString("jumin2"));
			vo.setEmail(rs.getString("email"));
			vo.setBlog(rs.getString("blog"));
			vo.setReg_date(rs.getTimestamp("reg_date"));
			list.add(vo);
		}
		
		return list;
	}//selectAll() end
	
	
	public int confirmID(String id) throws Exception {
		String sql = "select id from Members where id = ?";
		int result = -1;
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if( rs.next() ) result = 1;  //해당 아이디가 있다.
		else result = -1;  
		
		CloseUtil.close(rs);  CloseUtil.close(pstmt); CloseUtil.close(conn);
				
		return result;
	} // confirmID(id) end
	
	
	public int userCheck(String id, String pwd) throws Exception {
		String sql = "select passwd from Members where id = ?";
		String dbpwd = "";
		int result = -1;
		
		//System.out.println(sql);
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if( rs.next() ) {  //id check
			dbpwd = rs.getString("passwd");
			if( dbpwd.equals(pwd)) result = 1;  //인증 성공
			else result = 0;  // 비번 틀림
			
		}else {
			result = -1;  //해당 아이디가 없음
		}//end if
		
		CloseUtil.close(rs);  CloseUtil.close(pstmt); CloseUtil.close(conn);
		
		return result;
	} // userCheck() end
	
	public MemberVO getMember(String id) throws Exception {
		
		String sql="select *from members where id=?";
		MemberVO vo=null;
		Connection conn=getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		
		
		if(rs.next()) {
			vo=new MemberVO(); //vo에 여러가지 클래스값들을 넣어줌.
			vo.setId(rs.getString("id"));
			vo.setPasswd(rs.getString("passwd"));
			vo.setName(rs.getString("name"));
			vo.setJumin1(rs.getString("jumin1"));
			vo.setJumin2(rs.getString("jumin2"));
			vo.setEmail(rs.getString("email"));
			vo.setBlog(rs.getString("blog"));
			vo.setReg_date(rs.getTimestamp("reg_date"));
			
		}
		return vo;
	}
//	public int userCheck(String id,String pwd) throws Exception{
//		String sql="select passwd from members where id=?";
//		String dbpwd="";
//		int result=-1;
//		Connection conn=getConnection();
//		PreparedStatement pstmt=conn.prepareStatement(sql);
//		pstmt.setString(1, id);
//		ResultSet rs=pstmt.executeQuery();
//		if(rs.next()) {
//			dbpwd=rs.getString("passwd");
//			if(dbpwd.equals("passwd")) result=1;
//			else result=0;
//		
//		}
//		return result;
//	}
	public void update(MemberVO vo)throws Exception{
		String sql="update Members set passwd=?,name=?,email=?,blog=? where id=?";
		Connection conn=getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPasswd());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getEmail());
		pstmt.setString(4, vo.getBlog());
		pstmt.setString(5, vo.getId());
		pstmt.executeUpdate();
		
		
	}

}
