package kr.or.kosta.dao;

import java.sql.SQLException;

import kr.or.kosta.vo.Member;
public interface MemberDao {
	public Member getMember(String uid) throws ClassNotFoundException, SQLException;
	public int insert(Member member) throws ClassNotFoundException, SQLException;
	
}
