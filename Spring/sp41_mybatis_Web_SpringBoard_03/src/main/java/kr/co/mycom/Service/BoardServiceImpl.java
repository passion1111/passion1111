package kr.co.mycom.Service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.mycom.model.BoardDAO;
import kr.co.mycom.model.BoardDTO;


@Component
public class BoardServiceImpl implements BoardService {
	
	/*private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}*/
	
	@Autowired
	private SqlSession sqlsession; //SqlSessionTemplate
	
	
	
	@Override
	public void insertBoard(BoardDTO dto) {
		    //기존 : Spring 에서는 sqlsession 사용(x)
			//sqlsession.insert("BOARD.insertall");
		
		    //Spring 에서는 SqlSessionTemplate (
		
			//BoardDAO 인터페이스 메서드 이름(리턴타입, 파라메터 정의)
		    //단 Mapper 파일의 : namespace="kr.co.mycom.model.BoardDAO"
			//단 ****** : Mapper 가지는 id값 인터페이스가 가지는 함수명과 같다면
			BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
			boardDAO.insertBoard(dto); 
			//sqlsession.insert("BOARD.insertall"); 동일
			
			//인터페이를 구현부를  Mapper xml이 가지고 있다
			//getMapper 연결시켜주는 역활 
			//단 : namespace 동일
			//단 : 함수명 == id 동일
	}

	@Override
	public List<BoardDTO> getBoardList(HashMap map) {
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		return boardDAO.getBoardList(map);
	}

	@Override
	public BoardDTO getBoard(int num) {
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		return boardDAO.getBoard(num);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		return boardDAO.updateBoard(dto);
	}

	@Override
	public int deleteBoard(BoardDTO dto) {
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		return boardDAO.deleteBoard(dto);
	}

	@Override
	public void updateHit(int num) {
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		boardDAO.updateHit(num);

	}

	@Override
	public int getBoardCount() {
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		return boardDAO.getBoardCount();
	}

	
	@Override
	public void insertReply(BoardDTO dto) {
		BoardDAO boardDAO = sqlsession.getMapper(BoardDAO.class);
		boardDAO.updateSort(dto);
		boardDAO.insertReply(dto);

	}

}
