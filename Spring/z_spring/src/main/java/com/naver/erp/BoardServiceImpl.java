package com.naver.erp;

import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.erp.*;


//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// [서비스 클래스]인 [BoardServiceImpl 클래스] 선언
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// [서비스 클래스]에는  @Service 와 @Transactional 를 붙인다.
	//------------------------------------------------------------
	//	@Service       => [서비스 클래스] 임을 지정하고 bean 태그로 자동 등록된다.
	//	@Transactional => [서비스 클래스]의 메소드 내부에서 일어나는 모든 작업에는 [트랜잭션]이 걸린다.
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

@Transactional  //(readOnly=false,rollbackFor=Exception.class)
@Service
public class BoardServiceImpl  implements BoardService {

	//*****************************************************
	// 속성변수 boardDAO 선언하고, [BoardDAO 인터페이스]를 구현받은 [BoardDAOImpl 객체를 생성해 저장
	//*****************************************************
		// @Autowired 역할 => 속성변수에 붙은 자료형인 [인터페이스]를 구현한 [클래스]를 객체화하여 저장한다.
	@Autowired
	private BoardDAO boardDAO;

	//***************************************************** 
	// [검색한 게시판 목록 개수] 리턴하는 메소드 선언
	//*****************************************************
	public int  getBoardListCnt( BoardSearchFormDTO boardSearchFormDTO ){
		int  boardListCnt = this.boardDAO.getBoardListCnt( boardSearchFormDTO );
		return boardListCnt;
	}
	//***************************************************** 
	// [검색한 게시판 목록] 리턴하는 메소드 선언
	//***************************************************** 
	public List<Map<String,String>> getBoardList( BoardSearchFormDTO boardSearchFormDTO ){
		List<Map<String,String>> boardList = this.boardDAO.getBoardList( boardSearchFormDTO );
		return  boardList;
	}
	//***************************************************** 
	// [1개 게시판 글 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	//***************************************************** 
	public int  insertBoard( BoardDTO boardDTO ){
		int  updatePrint_noCnt = this.boardDAO.updatePrint_no(boardDTO);
		int  boardRegtCnt = this.boardDAO.insertBoard(boardDTO);
		return boardRegtCnt;
	}
	//***************************************************** 
	// 수정을 위해 [1개 게시판 글 정보] 리턴하는 메소드 선언
	//*****************************************************
	public BoardDTO getBoardDTO( int board_no ){
		int  readcount = this.boardDAO.updateReadcount(board_no);
		BoardDTO boardDTO = this.boardDAO.getBoardDTO(board_no);
		return boardDTO;
	}
	//***************************************************** 
	// [1개 게시판 글의 아들 댓글 개수] 리턴하는 메소드 선언
	//***************************************************** 
	public int  getSonBoardCnt( int board_no ){
		int  getSonBoardCnt = this.boardDAO.getSonBoardCnt( board_no );
		return getSonBoardCnt;
	}
	//***************************************************** 
	// [1개 게시판 글 수정하고 수정행의 개수] 리턴하는 메소드 선언
	//***************************************************** 
	public int  updateBoard( BoardDTO boardDTO ){
		int  updateBoardCnt = this.boardDAO.updateBoard(boardDTO);
		return updateBoardCnt;
	}
	//***************************************************** 
	// [1개 게시판 글 삭제하고 삭제 행의 개수] 리턴하는 메소드 선언
	//*****************************************************
	public int  deleteBoard( BoardDTO boardDTO ){
		int  deleteBoardCnt = this.boardDAO.deleteBoard(boardDTO);
		return deleteBoardCnt;
	}

}



