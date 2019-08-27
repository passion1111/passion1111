package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import springgift.gift.domain.GiftVO;


public class GiftDAO { // Controller
	private ConnectionMaker connectionMaker;

	public GiftDAO(ConnectionMaker connectionMaker) { // DI
		this.connectionMaker = connectionMaker;
	}
	
	// insert
	public void insert(GiftVO gift) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		String sql = "INSERT INTO gift(gno, gname, g_start,g_end) VALUES(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, gift.getGno());
		pstmt.setString(2, gift.getGname());
		pstmt.setInt(3, gift.getG_start());
		pstmt.setInt(3, gift.getG_end());
		int result = pstmt.executeUpdate();
		System.out.println(result + " 개 입력 성공했습니다.");
		pstmt.close();
		conn.close();
	}

	

	// selectAll
	public void selectAll() throws Exception {
		Connection conn = connectionMaker.makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM gift");

		System.out.println("gno \t  gname \t  gstart \t gned");

		while (rs.next()) {
			String gno = rs.getString("gno");
			String gname = rs.getString("gname");
			String g_start = rs.getString("g_start");
			String g_end=rs.getString("g_end");

			System.out.println(gno + "\t" + gname + "\t" + g_start+"쥐엔드"+g_end);
		} // while end
	}

	// select - 조건에 맞는것 select 하기(id)
	public GiftVO select(String gno) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM gift WHERE gno= ?");
		ps.setString(1, gno);
		ResultSet rs = ps.executeQuery();
		rs.next();
		GiftVO vo = new GiftVO();
		
		vo.setGno(rs.getInt("gno")); 
		vo.setGname(rs.getString("gname")); 
		vo.setG_start(rs.getInt("g_start"));
		vo.setG_end(rs.getInt("g_end"));

		return vo;
	}
	// update

	// delete

}
