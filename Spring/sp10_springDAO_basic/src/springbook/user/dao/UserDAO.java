package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import springbook.user.domain.UserVO;

public class UserDAO {
	private ConnectionMaker connectionMaker;
	
	public UserDAO(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	//insert
	
	//selectAll
	public void selectAll() throws Exception {
		Connection conn = connectionMaker.makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet  rs = stmt.executeQuery("SELECT * FROM USERS");
		
		System.out.println("ID \t  Name \t  PWD");
		
		while( rs.next() ) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String pwd = rs.getString("password");
			
			System.out.println(id + "\t" + name + "\t" + pwd );
		} // while end
	}
	public void add(UserVO vo) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		pstmt.executeUpdate();
		
		pstmt.close();		conn.close();
	}
	
}










