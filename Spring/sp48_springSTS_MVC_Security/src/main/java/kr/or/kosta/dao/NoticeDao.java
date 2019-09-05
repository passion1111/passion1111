package kr.or.kosta.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.kosta.vo.Notice;

//CRUD
public interface NoticeDao {
	//게시물 개수
	public int getCount(String field, String query) 
			throws ClassNotFoundException, SQLException;
	//전체 게시물
	public List<Notice> getNotices(int page, String field, String query) 
			throws ClassNotFoundException, SQLException;
	//게시물 삭제
	public int delete(String seq) 
			throws ClassNotFoundException, SQLException;
	//게시물 수정
	public int update(Notice notice) 
			throws ClassNotFoundException, SQLException;
	//게시물 상세
	public Notice getNotice(String seq) 
			throws ClassNotFoundException, SQLException;
	//게시물 입력
	public int insert(Notice n) 
			throws ClassNotFoundException, SQLException; 
	
	//게시물 입력시 회원 point 증가하는 트랜재션 처리용 함수
	public void InsertAndPointOfMember(Notice n , String id)
			throws ClassNotFoundException, SQLException; 
}
