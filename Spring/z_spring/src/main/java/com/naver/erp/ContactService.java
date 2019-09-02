package com.naver.erp;

import java.util.List;
import java.util.Map;
import com.naver.erp.*;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// [ContactService 인터페이스] 선언
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
public interface ContactService {
	//*****************************************************
	// JSP 페이지의 checkbox에 삽입될 
	// [연락처 사업분야 목록]을 리턴하는  메소드 선언
	//*****************************************************
	List<Map<String, String>>  getSaup_fieldList( );
	
	//*****************************************************
	// [검색한 연락처 목록 총 개수]를 리턴하는 메소드 선언
	//*****************************************************
	int  getContactListAllCnt( ContactSearchDTO contactSearchDTO );
	//*****************************************************
	// [검색한 연락처 목록]을 리턴하는 메소드 선언
	//*****************************************************
	List<Map<String,String>> getContactList( ContactSearchDTO contactSearchDTO );
	
	//*****************************************************
	// [연락처명,전화번호 중복 개수]를 리턴하는 메소드 선언
	//*****************************************************
	int getContactPhoneCnt( ContactDTO contactDTO );
	//*****************************************************
	// [연락처] 입력하고 입력 행의 개수]를 리턴하는 메소드 선언
	//*****************************************************
	int insertContact(ContactDTO contactDTO);
	//*****************************************************
	// 새로 입력 예정인 [연락처]의 연락처 번호(=PK값)]를 리턴하는 메소드 선언
	//*****************************************************
	int getNewContact_no( );
	
	//*****************************************************
	// [연락처 번호에 해당하는 연락처]를 리턴하는 메소드 선언
	//*****************************************************
	ContactDTO getContact( int contact_no );
	//*****************************************************
	// [1개 연락처 수정하고 수정 행의 개수]를 리턴하는 메소드 선언
	//*****************************************************
	int updateContact( ContactDTO contactDTO );
	//*****************************************************
	// [1개 연락처 삭제하고 삭제 행의 개수]를 리턴하는 메소드 선언
	//*****************************************************
	int deleteContact( int contact_no );
}