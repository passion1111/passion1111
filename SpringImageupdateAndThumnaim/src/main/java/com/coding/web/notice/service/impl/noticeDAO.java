package com.coding.web.notice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class noticeDAO extends SqlSessionDaoSupport {
	
	public int noticeListCount(Map<String, Object> searchMap) {
		return getSqlSession().selectOne("notice.noticeListCount", searchMap);
	}
	
	public List<HashMap<String, Object>> noticeMainList(int page){
		return getSqlSession().selectList("noticeMainList",page);
	}
	
	public List<HashMap<String, Object>> noticeList(Map<String, Object> searchMap){
		return getSqlSession().selectList("notice.noticeList",searchMap);
	}

	public void noticeListReadUpdate(Map<String, Object> searchMap){
		getSqlSession().update("notice.noticeListReadUpdate",searchMap);
	}
	
	public List<HashMap<String, Object>> noticeListOne(Map<String, Object> searchMap){
		return getSqlSession().selectList("notice.noticeListOne",searchMap);
	}
	
	public List<HashMap<String, Object>> noticeListOneNext(Map<String, Object> searchMap){
		return getSqlSession().selectList("notice.noticeListOneNext",searchMap);
	}
	
	public List<HashMap<String, Object>> noticeListOnePrev(Map<String, Object> searchMap){
		return getSqlSession().selectList("notice.noticeListOnePrev",searchMap);
	}
	
	public List<HashMap<String, Object>> noticeFileList(Map<String, Object> searchMap){
		return getSqlSession().selectList("notice.noticeFileList",searchMap);
	}
	
	public int noticeReturnOne(){
		return getSqlSession().selectOne("notice.noticeReturnOne");
	}

	public void noticeUpdate(Map<String, Object> searchMap){
		getSqlSession().update("notice.noticeUpdate",searchMap);
	}
	
	public void noticeInsert(Map<String, Object> searchMap){
		getSqlSession().insert("notice.noticeInsert",searchMap);
	}
	
	public void noticeFileInsert(Map<String, Object> searchMap){
		getSqlSession().insert("notice.noticeFileInsert",searchMap);
	}
	
	public void noticeDelete(Map<String, Object> params) {
		getSqlSession().delete("notice.noticeDelete", params);
	}

	public void noticeFileDelete(Map<String, Object> params) {
		getSqlSession().delete("notice.noticeFileDelete", params);
	}
	
	public void noticeFileOneDelete(Map<String, Object> params) {
		getSqlSession().delete("notice.noticeFileOneDelete", params);
	}
	
}
