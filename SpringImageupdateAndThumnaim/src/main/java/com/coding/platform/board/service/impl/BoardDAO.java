package com.coding.platform.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.coding.domain.BoardFile;

@Repository
public class BoardDAO extends SqlSessionDaoSupport {

	public List<HashMap<String, String>> getRankCode(HashMap<String, String> params) {
		return getSqlSession().selectList("board.getRankCode", params);

	}

	public HashMap<String, String> getBoardKind(HashMap<String, String> params) {
		return getSqlSession().selectOne("board.getBoardKind" , params);
	}

	public List<HashMap<String, String>> boardList(HashMap<String, String> params) {
		return getSqlSession().selectList("board.boardList", params);
	}
	
	public int listCount(HashMap<String, String> params) {
		return getSqlSession().selectOne("board.boardListCount", params);
	}
	
	public List<HashMap<String, String>> boardFAQList(HashMap<String, String> params) {
		return getSqlSession().selectList("board.boardFAQList", params);
	}
	
	public int boardFAQListCount(HashMap<String, String> params) {
		return getSqlSession().selectOne("board.boardFAQListCount", params);
	}

	/*public Object boardInsertProcess(HashMap<String, Object> params) {
		params.put("BOARD_SEQ", 0);
		Object o = getSqlSession().insert("board.boardInsertProcess", params);
		@SuppressWarnings("unchecked")
		List<BoardFile> bFiles = (List<BoardFile>)(params.get("boardFiles"));
		for(BoardFile bFile : bFiles) {
			bFile.setBOARD_SEQ((Integer)(params.get("BOARD_SEQ")));
		}
		if (bFiles != null && bFiles.size() > 0) {
			getSqlSession().insert("board.boardInsertFiles", bFiles);
		}
		return o;
	}*/
	public Object boardFAQInsertProcess(HashMap<String, Object> params) {
		return getSqlSession().insert("board.boardFAQInsertProcess", params);
	}

	public void insertBoardCatInfo(HashMap<String, Object> params) {
		getSqlSession().insert("board.insertBoardCatInfo", params);
		
	}

	public HashMap<String, Object> getBoardDetail(HashMap<String, String> params) {
		
		return getSqlSession().selectOne("board.getBoardDetail", params);
	}
	public List<BoardFile> getBoardFiles(HashMap<String, Object> params) {
		return getSqlSession().selectList("board.getBoardFiles", params);
	}
	public BoardFile getBoardFile(int fileNo) {
		return getSqlSession().selectOne("board.getBoardFile", fileNo);
	}
	public void updateBoardHits(HashMap<String, String> params) {
		getSqlSession().update("board.updateBoardHits", params);		
	}

	public List<HashMap<String, String>> getboardCodeList(HashMap<String, String> params) {
		return getSqlSession().selectList("board.getboardCodeList", params);
	}

	public HashMap<String, Object> getFileInfo(HashMap<String, Object> params) {
		return getSqlSession().selectOne("board.getFileInfo", params);
	}

	public void deleteTboardTestClass(HashMap<String, Object> params) {
		getSqlSession().delete("board.deleteTboardTestClass", params);
	}

	public Object boardUpdateProcess(HashMap<String, Object> params) {
		Object o = getSqlSession().update("board.boardUpdateProcess", params);
		@SuppressWarnings("unchecked")
		List<BoardFile> bFiles = (List<BoardFile>)(params.get("boardFiles"));
		if (bFiles != null && bFiles.size() > 0) {
			getSqlSession().update("board.boardInsertFiles", bFiles);
		}
		return o;
		
	}
	public Object boardFAQUpdateProcess(HashMap<String, Object> params) {
		return getSqlSession().update("board.boardFAQUpdateProcess", params);	
	}

	public void updateBoardFile(HashMap<String, Object> params) {
		getSqlSession().update("board.updateBoardFile", params);		
	}

	public void deleteBoardFile(HashMap<String, Object> params) {
		getSqlSession().delete("board.deleteBoardFile", params);				
	}

	public Object boardReplyInsertProcess(HashMap<String, Object> params) {
		return getSqlSession().insert("board.boardReplyInsertProcess", params);
	}

	public int getIsReply(HashMap<String, String> params) {
		return getSqlSession().selectOne("board.getIsReply", params);
	}

	public List<HashMap<String, String>> getReplyData(HashMap<String, String> params) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("board.getReplyData", params);
	}

	public BoardFile getfileInfo(int fileNo) {
		return getSqlSession().selectOne("board.getfileInfo", fileNo);
	}
	
	public Object boardReplyUpdateProcess(HashMap<String, Object> params) {
		return getSqlSession().update("board.boardReplyUpdateProcess", params);	
	}

	public void deleteBoardData(HashMap<String, Object> params) {
		getSqlSession().delete("board.deleteBoardData", params);	
	}

	public List<HashMap<String, String>> getFaqCategoryCode(
			HashMap<String, String> params) {
		return getSqlSession().selectList("board.getFaqCategoryCode", params);
	}
	public int deleteBoardFile(BoardFile bf) {
		return getSqlSession().update("board.deleteBoardFileNew", bf);
	}

}
