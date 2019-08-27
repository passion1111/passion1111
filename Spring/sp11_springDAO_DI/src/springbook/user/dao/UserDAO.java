package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import springbook.user.domain.UserVO;

public class UserDAO { // Controller
	private ConnectionMaker connectionMaker;

	// public UserDAO() {}
	public UserDAO(ConnectionMaker connectionMaker) { // DI
		this.connectionMaker = connectionMaker;
	}

	// insert
	public void insert(UserVO user) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());

		int result = pstmt.executeUpdate();
		System.out.println(result + " 개 입력 성공했습니다.");
		pstmt.close();
		conn.close();
	}

	// selectAll
	public void selectAll() throws Exception {
		Connection conn = connectionMaker.makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");

		System.out.println("ID \t  Name \t  PWD");

		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String pwd = rs.getString("password");

			System.out.println(id + "\t" + name + "\t" + pwd);
		} // while end
	}

	// select - 조건에 맞는것 select 하기(id)
	public UserVO select(String id) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		UserVO u = new UserVO();
		u.setId(rs.getString("id"));
		u.setName(rs.getNString("name"));
		u.setPassword(rs.getString("password"));

		return u;
	}
	// update

	// delete

}
