package com.coding.web.notice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.web.notice.service.noticeService;

@Service(value="noticeService")
public class noticeServiceImpl implements noticeService {
	@Autowired 
	private noticeDAO noticedao;
	
	@Override
	public int noticeListCount(Map<String, Object> searchMap){
		return noticedao.noticeListCount(searchMap);
	}
	@Override
	public List<HashMap<String, Object>> noticeMainList(int page) {
		// TODO Auto-generated method stub
		return noticedao.noticeMainList(page);
	}
	
	@Override
	public List<HashMap<String, Object>> noticeList(Map<String, Object> searchMap) {
		return noticedao.noticeList(searchMap);
	}

	@Override
	public void noticeListReadUpdate(Map<String, Object> searchMap) {
		noticedao.noticeListReadUpdate(searchMap);
	}
	
	@Override
	public List<HashMap<String, Object>> noticeListOne(Map<String, Object> searchMap) {
		return noticedao.noticeListOne(searchMap);
	}

	@Override
	public List<HashMap<String, Object>> noticeListOneNext(Map<String, Object> searchMap) {
		return noticedao.noticeListOneNext(searchMap);
	}
	
	@Override
	public List<HashMap<String, Object>> noticeListOnePrev(Map<String, Object> searchMap) {
		return noticedao.noticeListOnePrev(searchMap);
	}
	
	@Override
	public List<HashMap<String, Object>> noticeFileList(Map<String, Object> searchMap) {
		return noticedao.noticeFileList(searchMap);
	}
	
	@Override
	public int noticeReturnOne() {
		return noticedao.noticeReturnOne();
	}
	
	@Override
	public void noticeUpdate(Map<String, Object> searchMap) {
		noticedao.noticeUpdate(searchMap);
	}
	
	@Override
	public void noticeInsert(Map<String, Object> searchMap) {
		noticedao.noticeInsert(searchMap);
	}
	
	@Override
	public void noticeFileInsert(Map<String, Object> searchMap) {
		noticedao.noticeFileInsert(searchMap);
	}
	
	@Override
	public void noticeDelete(Map<String, Object> params){
		noticedao.noticeDelete(params);
	}
	
	@Override
	public void noticeFileDelete(Map<String, Object> params){
		noticedao.noticeFileDelete(params);
	}
	
	@Override
	public void noticeFileOneDelete(Map<String, Object> params){
		noticedao.noticeFileOneDelete(params);
	}

	
	
}
