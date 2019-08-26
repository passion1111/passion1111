package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import springbook.user.domain.UserVO;

public class UserDAO {
	
	private SimpleConnectionMaker  simpleConnectionMaker;
	
	public UserDAO() {
		this.simpleConnectionMaker = new SimpleConnectionMaker();
	}

	//insert
	public void add(UserVO vo) throws ClassNotFoundException, SQLException {
		Connection conn = simpleConnectionMaker.getConnection();
		
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		pstmt.executeUpdate();
		
		pstmt.close();		conn.close();
	}
}






