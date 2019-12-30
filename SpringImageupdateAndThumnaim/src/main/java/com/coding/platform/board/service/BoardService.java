package com.coding.platform.board.service;

import java.util.HashMap;
import java.util.List;

import com.coding.domain.BoardFile;

public interface BoardService {

	List<HashMap<String, String>> getRankCode(HashMap<String, String> params);

	HashMap<String, String> getBoardKind(HashMap<String, String> params);

	List<HashMap<String, String>> boardList(HashMap<String, String> params);

	int listCount(HashMap<String, String> params);

	List<HashMap<String, String>> boardFAQList(HashMap<String, String> params);
	
	int boardFAQListCount(HashMap<String, String> params);
	
	Object boardInsertProcess(HashMap<String, Object> params);
	
	Object boardFAQInsertProcess(HashMap<String, Object> params);
	
	void insertBoardCatInfo(HashMap<String, Object> boardTestClassMap);
	
	HashMap<String, Object> getBoardDetail(HashMap<String, String> params);
	List<BoardFile> getBoardFiles(HashMap<String, Object> params);
	BoardFile getBoardFile(int fileNo);

	void updateBoardHits(HashMap<String, String> params);

	List<HashMap<String, String>> getboardCodeList(HashMap<String, String> params);

	HashMap<String, Object> getFileInfo(HashMap<String, Object> params);

	void deleteTboardTestClass(HashMap<String, Object> params);

	Object boardUpdateProcess(HashMap<String, Object> params);
	
	Object boardFAQUpdateProcess(HashMap<String, Object> params);

	void updateBoardFile(HashMap<String, Object> params);

	void deleteBoardFile(HashMap<String, Object> params);

	Object boardReplyInsertProcess(HashMap<String, Object> params);

	int getIsReply(HashMap<String, String> params);

	List<HashMap<String, String>> getReplyData(HashMap<String, String> params);

	Object boardReplyUpdateProcess(HashMap<String, Object> params);

	void deleteBoardData(HashMap<String, Object> params);

	List<HashMap<String, String>> getFaqCategoryCode(HashMap<String, String> params);
	int deleteBoardFile(BoardFile bf);

	BoardFile getfileInfo(Integer fileNo);
	

}
