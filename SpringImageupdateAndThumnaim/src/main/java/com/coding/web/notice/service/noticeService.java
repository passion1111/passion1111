package com.coding.web.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface noticeService {

	int noticeListCount(Map<String, Object> searchMap);//공지사항 목록 count
	
	List<HashMap<String, Object>> noticeMainList(int page);   //메인페이지 공지사항 목록  
	
	List<HashMap<String, Object>> noticeList(Map<String, Object> searchMap);//공지사항 목록

	void noticeListReadUpdate(Map<String, Object> searchMap);//수정
	
	List<HashMap<String, Object>> noticeListOne(Map<String, Object> searchMap);//공지사항 뷰
	
	List<HashMap<String, Object>> noticeListOneNext(Map<String, Object> searchMap);//공지사항 다음글
	
	List<HashMap<String, Object>> noticeListOnePrev(Map<String, Object> searchMap);//공지사항 이전글
	
	List<HashMap<String, Object>> noticeFileList(Map<String, Object> searchMap);//파일 리스트

	int noticeReturnOne();//최상위글

	void noticeUpdate(Map<String, Object> searchMap);//수정

	void noticeInsert(Map<String, Object> searchMap);//신규등록

	void noticeFileInsert(Map<String, Object> searchMap);//파일신규등록

	void noticeDelete(Map<String, Object> searchMap);//선택리스트

	void noticeFileDelete(Map<String, Object> searchMap);//선택리스트

	void noticeFileOneDelete(Map<String, Object> searchMap);//선택리스트

}
