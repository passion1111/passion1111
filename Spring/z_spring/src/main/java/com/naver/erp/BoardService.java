package com.naver.erp;

import java.util.List;
import java.util.Map;
import com.naver.erp.*;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// [BoardService 인터페이스] 선언
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
public interface BoardService {
	//***************************************************** 
	// [검색한 게시판 목록 개수] 리턴하는 메소드 선언
	//***************************************************** 
	int  getBoardListCnt( BoardSearchFormDTO boardSearchFormDTO );
	//***************************************************** 
	// [검색한 게시판 목록] 리턴하는 메소드 선언
	//***************************************************** 
	List<Map<String,String>> getBoardList( BoardSearchFormDTO boardSearchFormDTO );
	
	//***************************************************** 
	// [게시판 글 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	//***************************************************** 
	int insertBoard( BoardDTO boardDTO);
	//***************************************************** 
	// 수정화면에서 보여줄 [1개 게시판 글 정보] 리턴하는 메소드 선언
	//***************************************************** 
	BoardDTO  getBoardDTO( int board_no );
	//***************************************************** 
	// [1개 게시판 글의 아들 댓글 개수] 리턴하는 메소드 선언
	//***************************************************** 
	int  getSonBoardCnt( int board_no );
	//***************************************************** 
	// [1개 게시판 글 수정하고 수정행의 개수] 리턴하는 메소드 선언
	//***************************************************** 
	int  updateBoard( BoardDTO boardDTO);
	
	//***************************************************** 
	// [1개 게시판 글 삭제하고 삭제 행의 개수] 리턴하는 메소드 선언
	//***************************************************** 
	int  deleteBoard( BoardDTO boardDTO);
}