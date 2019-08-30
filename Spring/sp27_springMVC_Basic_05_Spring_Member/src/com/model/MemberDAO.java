package com.model;

import java.sql.SQLException;

public interface MemberDAO {
	
	//회원상세 조회
	MemberVO selectMemberById(String id) throws SQLException;
	
	//회원 유무를 판단하는 조회 메서드
	boolean memberCheck(String id, String pwd) throws SQLException;

	int memberInsert(MemberVO membervo) throws SQLException;
	
}
