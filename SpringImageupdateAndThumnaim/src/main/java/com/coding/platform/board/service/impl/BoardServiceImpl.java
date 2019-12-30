package com.coding.platform.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.domain.BoardFile;
import com.coding.platform.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired 
	private BoardDAO boardDao;
	
	public List<HashMap<String, String>> getRankCode(HashMap<String, String> params) {
		return boardDao.getRankCode(params);
	}
	
	public HashMap<String, String> getBoardKind(HashMap<String, String> params) {
		return boardDao.getBoardKind(params);
	}//
	
	@Override
	public List<HashMap<String, String>> boardList(HashMap<String, String> params) {
		return boardDao.boardList(params);
	}
	
	@Override
	public int listCount(HashMap<String, String> params) {
		return boardDao.listCount(params);
	}
	
	@Override
	public List<HashMap<String, String>> boardFAQList(HashMap<String, String> params) {
		return boardDao.boardFAQList(params);
	}
	
	@Override
	public int boardFAQListCount(HashMap<String, String> params) {
		return boardDao.boardFAQListCount(params);
	}
	
	@Override
	public int getIsReply(HashMap<String, String> params) {
		return boardDao.getIsReply(params);
	}
	
	@Override
	public Object boardInsertProcess(HashMap<String, Object> params) {
//		return boardDao.boardInsertProcess(params);
		return null;
	}
	
	@Override
	public Object boardFAQInsertProcess(HashMap<String, Object> params) {
		return boardDao.boardFAQInsertProcess(params);
	}
	
	@Override
	public Object boardReplyInsertProcess(HashMap<String, Object> params) {
		return boardDao.boardReplyInsertProcess(params);
	}
	
	@Override
	public void insertBoardCatInfo(HashMap<String, Object> params) {
		boardDao.insertBoardCatInfo(params);
	}
	
	@Override
	public void deleteTboardTestClass(HashMap<String, Object> params) {
		boardDao.deleteTboardTestClass(params);
	}
	
	@Override
	public void deleteBoardData(HashMap<String, Object> params) {
		boardDao.deleteBoardData(params);
	}
	
	@Override
	public HashMap<String, Object> getBoardDetail(HashMap<String, String> params){
		return boardDao.getBoardDetail(params);
	}
	
	@Override
	public List<BoardFile> getBoardFiles(HashMap<String, Object> params) {
		return boardDao.getBoardFiles(params);
	}
	
	@Override
	public BoardFile getBoardFile(int fileNo) {
		return boardDao.getBoardFile(fileNo);
	}
	
	@Override
	public void deleteBoardFile(HashMap<String, Object> params){
		boardDao.deleteBoardFile(params);
	}
	@Override
	public void updateBoardFile(HashMap<String, Object> params){
		boardDao.updateBoardFile(params);
	}
	
	@Override
	public void updateBoardHits(HashMap<String, String> params){
		 boardDao.updateBoardHits(params);
	}
	
	@Override
	public BoardFile getfileInfo(Integer fileNo) {
		return boardDao.getfileInfo(fileNo);
	}
	
	@Override
	public List<HashMap<String, String>> getboardCodeList(HashMap<String, String> params){
		return boardDao.getboardCodeList(params);
	}
	
	@Override
	public HashMap<String, Object> getFileInfo(HashMap<String, Object> params){
		return boardDao.getFileInfo(params);
	}
	
	@Override
	public List<HashMap<String, String>> getReplyData(HashMap<String, String> params){
		return boardDao.getReplyData(params);
	}
	
	@Override
	public Object boardFAQUpdateProcess(HashMap<String, Object> params){
		return boardDao.boardFAQUpdateProcess(params);
	}
	
	@Override
	public Object boardUpdateProcess(HashMap<String, Object> params){
		return boardDao.boardUpdateProcess(params);
	}
	
	@Override
	public Object boardReplyUpdateProcess(HashMap<String, Object> params){
		return boardDao.boardReplyUpdateProcess(params);
	}
	
	@Override
	public List<HashMap<String, String>> getFaqCategoryCode(HashMap<String, String> params) {
		return boardDao.getFaqCategoryCode(params);
	}
	
	@Override
	public int deleteBoardFile(BoardFile bf) {
		return boardDao.deleteBoardFile(bf);
	}
	
}
