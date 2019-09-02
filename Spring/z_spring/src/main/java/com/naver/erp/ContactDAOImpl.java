package com.naver.erp;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.erp.*;


//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
//[DAO 클래스]인 [ContactDAOImpl 클래스] 선언.
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// @Repository 를 붙임으로서 [DAO 클래스] 임를 지정하게되고, bean 태그로 자동 등록된다.
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
@Repository
public class ContactDAOImpl  implements ContactDAO {

	//*****************************************************
	// 속성변수 contactService를 선언하고 SqlSessionTemplate 객체를 생성해 저장
	//*****************************************************
	@Autowired
	private SqlSessionTemplate sqlSession;

	//********************************************************************
	// JSP 페이지의 select, checkbox, radio 에 삽입될 
	// [연락처 사업분야 목록]을 리턴하는  메소드 선언
	//********************************************************************
	public List<Map<String, String>>  getSaup_fieldList( ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 [selectList(~) 메소드] 호출로 [사업 영역 목록]를 리턴.
		//-------------------------------------------------------------------------------------
		// sqlSession.selectList( "com.naver.erp.ContactDAO.getSaup_fieldList" ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDAO">태그 내부의
			// <select id="getSaup_fieldList" ~> 태그 내부의 
			// [n행 리턴 select 쿼리문]을 실행하여 얻은 데이터를  List<Map<String, String>> 객체 담아 리턴한다.
			// 2번째 인자는 [n행 리턴 select 쿼리문]에 삽입될 데이터이다.
			// 리턴 자료형은 <select id="getSaup_fieldList" ~> 태그의 resultType 속성값에 설정한다
		//-------------------------------------------------------------------------------------
		List<Map<String, String>>  contactList 
			= sqlSession.selectList(  "com.naver.erp.ContactDAO.getSaup_fieldList" );
		return contactList;
	}
	
	//********************************************************************
	// [검색한 연락처 목록 총 개수]를 리턴하는 메소드 선언
	//********************************************************************
	public int  getContactListAllCnt(ContactSearchDTO contactSearchDTO ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 selectOne 메소드 호출로 [검색 연락처 총 행의 개수]를 리턴.
		//-------------------------------------------------------------------------------------
		// selectOne( "com.naver.erp.ContactDAO.getContactListTotCnt", contactSearchDTO ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDAO">태그 내부의
			// <select id="getContactListTotCnt" ~> 태그 내부의 
			// [1행 리턴 select 쿼리문]을 실행하고 얻은 데이터를 int 로 리턴한다.
			// 2번째 인자는 [n행 리턴 select 쿼리문]에 삽입될 데이터이다.
			// 리턴 자료형은 <select id="getContactList" ~> 태그의 resultType 속성값에 설정한다
		//-------------------------------------------------------------------------------------
		int  contactListTotCnt 
			= sqlSession.selectOne(  "com.naver.erp.ContactDAO.getContactListAllCnt", contactSearchDTO );
		return contactListTotCnt;
	}
	//********************************************************************
	// [검색한 연락처 목록]을 리턴하는 메소드 선언
	//********************************************************************
	public List<Map<String, String>>  getContactList( ContactSearchDTO contactSearchDTO ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 selectList 메소드 호출로 검색 연락처 결과물인 List<Map<String, String>> 객체를 리턴.
		//-------------------------------------------------------------------------------------
		// selectList( "com.naver.erp.ContactDAO.getContactList", contactSearchDTO ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDAO">태그 내부의
			// <select id="getContactSearchList" ~> 태그 내부의 
			// [n행 리턴 select 쿼리문]을 실행하여 얻은 데이터를  List<Map<String, String>> 객체 담아 리턴한다.
			// 2번째 인자는 [n행 리턴 select 쿼리문]에 삽입될 데이터이다.
			// 리턴 자료형은 <select id="getContactSearchList" ~> 태그의 resultType 속성값에 설정한다
		//-------------------------------------------------------------------------------------
		List<Map<String, String>>  contactList 
			= sqlSession.selectList(  "com.naver.erp.ContactDAO.getContactList", contactSearchDTO  );
		return contactList;
	}	

	//********************************************************************
	// [연락처명,전화번호 중복 개수]를 리턴하는 메소드 선언
	//********************************************************************	
	public int getContactPhoneCnt(  ContactDTO contactDTO ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 selectOne 메소드 호출로 [연락처명, 전화번호 중복 개수]를 int 로 리턴.
		//-------------------------------------------------------------------------------------
		// selectOne( "com.naver.erp.ContactDAO.getContactPhoneCnt", contactDTO  ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDAO">태그 내부의
			// <select id="getContactPhoneCnt" ~> 태그 내부의 
			// [1행 리턴 select 쿼리문]을 실행하여 얻은  int 데이터를  담아 리턴한다.
			// 2번째 인자는 [n행 리턴 select 쿼리문]에 삽입될 데이터이다.
			// 리턴 자료형은 <select id="getContactPhoneCnt" ~> 태그의 resultType 속성값에 설정한다
		//-------------------------------------------------------------------------------------
		int  contactPhoneCnt = sqlSession.selectOne(    
			"com.naver.erp.ContactDAO.getContactPhoneCnt"
			, contactDTO 
		);
		return contactPhoneCnt;
	}

	//********************************************************************
	// [연락처] 입력하고 입력 행의 개수]를 리턴하는 메소드 선언
	//********************************************************************	
	public int insertContact( ContactDTO contactDTO ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 insert 메소드 호출로 [연락처 입력] 후 입력 행의 개수를 int 로 리턴.
		//-------------------------------------------------------------------------------------
		// insert( "com.naver.erp.ContactDAO.insertContact", contactDTO  ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDAO">태그 내부의
			// <insert id="insertContact" ~> 태그 내부의 
			// [insert 쿼리문]을 실행하고 입력 성공 행의 개수를 int 로 리턴한다.
			// 2번째 인자는 [n행 리턴 select 쿼리문]에 삽입될 데이터이다.
		//-------------------------------------------------------------------------------------
		int  contactRegCnt = sqlSession.insert(    
			"com.naver.erp.ContactDAO.insertContact"
			, contactDTO 
		);		
		return contactRegCnt;
	}

	//*****************************************************
	// 새로 입력 예정인 [연락처]의 연락처 번호(=PK값)]를 리턴하는 메소드 선언
	//*****************************************************
	public int getNewContact_no( ){
		int  newContact_no = sqlSession.selectOne(    
				"com.naver.erp.ContactDAO.getNewContact_no"
			);
			return newContact_no;
	}

	//********************************************************************
	// [연락처 사업 분야 입력] 메소드 선언
	//********************************************************************
	public int insertContactSaup_field( ContactDTO contactDTO ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 insert 메소드 호출로 [연락처 사업 분야 입력] 후 입력 행의 개수를 int 로 리턴.
		//-------------------------------------------------------------------------------------
		// insert( "com.naver.erp.ContactDAO.insertContactSaup_field", contactDTO  ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDAO">태그 내부의
			// <insert id="insertContactSaup_field" ~> 태그 내부의 
			// insert 쿼리문을 실행하고 입력 행의 개수를 int 로 리턴한다.
		//-------------------------------------------------------------------------------------
		int saup_fieldRegCnt = sqlSession.insert(    
			"com.naver.erp.ContactDAO.insertContactSaup_field"
			, contactDTO
		);
		return saup_fieldRegCnt;
	}
		
	//********************************************************************
	// [연락처 번호에 해당하는 연락처]를 리턴하는 메소드 선언
	//********************************************************************
	public ContactDTO getContact( int contact_no ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 selectOne 메소드 호출로 검색 후 ContactDto 객체로 리턴.
		//-------------------------------------------------------------------------------------
		// selectOne( "com.naver.erp.ContactDao.getContact", contactDto ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDao">태그 내부의
			// <select id="getContact" ~> 태그 내부의 
			// select 쿼리문을 실행하고 얻은 데이터를 ContactDto 객체에 담아 리턴한다.
		//-------------------------------------------------------------------------------------
		ContactDTO contactDTO = sqlSession.selectOne(
				"com.naver.erp.ContactDAO.getContact"
				,contact_no
		);
		return contactDTO;
	}

	//********************************************************************
	// [1개 연락처의 사업분야] 목록 검색 메소드 선언
	//********************************************************************
	public List<Integer> getContactSaup_field( int contact_no ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 selectList 메소드 호출로 검색 후 List<String>를 리턴.
		//-------------------------------------------------------------------------------------
		// selectList( "com.naver.erp.ContactDao.getContactSaup_field",contact_no ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDao">태그 내부의
			// <select id="getContactSaup_field" ~> 태그 내부의 
			// select 쿼리문을 실행하고 얻은 데이터를 List<String>에 담아 리턴한다.
		//-------------------------------------------------------------------------------------
		List<Integer> contactSaup_fieldList = sqlSession.selectList(
			"com.naver.erp.ContactDAO.getContactSaup_field", contact_no
		);
		return  contactSaup_fieldList;
	}
		
	//********************************************************************
	// [1개 연락처 수정하고 수정 행의 개수]를 리턴하는 메소드 선언
	//********************************************************************
	public int  updateContact( ContactDTO contactDTO ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 update 메소드 호출로 수정 실행 후 적용 행의 개수를 리턴.
		//-------------------------------------------------------------------------------------
		// update( "com.naver.erp.ContactDao.updateContact", contactDto ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDao">태그 내부의
			// <update id="updateContact" ~> 태그 내부의 
			// update 쿼리문을 실행하고 얻은 수정 행의 개수를 리턴한다.
		//-------------------------------------------------------------------------------------
		return sqlSession.update(
			"com.naver.erp.ContactDAO.updateContact", contactDTO
		);
	}

	//********************************************************************
	// [1개 연락처의 사업 분야 삭제하고 삭제 행의 개수]를 리턴하는 메소드 선언
	//********************************************************************
	public int  deleteContactSaup_field( int contact_no ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 delete 메소드 호출로 [1개 연락처 사업 정보] 삭제 실행 후 적용 행의 개수를 리턴.
		//-------------------------------------------------------------------------------------
		// delete( "com.naver.erp.ContactDao.deleteContactSaup_field", contactDto ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDao">태그 내부의
			// <delete id="deleteContactSaup_field" ~> 태그 내부의 
			// delete 쿼리문을 실행하고 삭제 행의 개수를 리턴한다.
		return sqlSession.delete(
			"com.naver.erp.ContactDAO.deleteContactSaup_field", contact_no
		);
	}

	//********************************************************************
	// [1개 연락처 삭제하고 삭제 행의 개수]를 리턴하는 메소드 선언
	//********************************************************************
	public int  deleteContact( int contact_no ){
		//-------------------------------------------------------------------------------------
		// SqlSessionTemplate 객체의 delete 메소드 호출로 1개 연락처 정보 삭제 실행 후 적용 행의 개수를 리턴.
		//-------------------------------------------------------------------------------------
		// delete( "com.naver.erp.ContactDao.deleteContact", contact_no ); 의미
		//-------------------------------------------------------------------------------------
			// 마이바티스 SQL 구문 설정 XML파일(=mapper_contact.xml))에서
			// <mapper namespace="com.naver.erp.ContactDao">태그 내부의
			// <delete id="deleteContact" ~> 태그 내부의 
			// delete 쿼리문을 실행하고 삭제 행의 개수를 리턴한다.
		return (int)sqlSession.delete(
			"com.naver.erp.ContactDAO.deleteContact", contact_no
		);
	}

}