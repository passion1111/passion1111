package com.naver.erp;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.erp.*;


//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// [DAO 클래스]인 [BoardDAOImpl 클래스] 선언.
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// @Repository 를 붙임으로서 [DAO 클래스] 임를 지정하게되고, bean 태그로 자동 등록된다.
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
@Repository
public class BoardDAOImpl  implements BoardDAO {

	//*****************************************************
	// 속성변수 sqlSession 선언하고, [SqlSessionTemplate 객체]를 생성해 저장
	//*****************************************************
		// @Autowired 역할 => 속성변수에 붙은 자료형이 [인터페이스]면 이를 구현한 [클래스]를 객체화하여 저장한다.
		// @Autowired 역할 => 속성변수에 붙은 자료형이 [클래스]면 이를  객체화하여 저장한다.
	@Autowired
	private SqlSessionTemplate sqlSession;

	//***************************************************** 
	// [검색한 게시판 목록 개수] 리턴하는 메소드 선언
	//***************************************************** 
	public int  getBoardListCnt(BoardSearchFormDTO boardSearchFormDTO){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 메소드를 호출하여 [검색한 게시판 결과물 개수]를 int 로 얻기.
		//--------------------------------------------------------------------------------------
		//  DTO|Map|int|double  selectOne(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.select태그 id 속성값"
		//        ,  select 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 select 태그 id 속성값을 가진 태그 내부의 select 쿼리문에 
			// [select 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 1행의 데이터를 
			// [기본형] 또는 [String] 또는 [HashMap] 또는 [DTO] 등으로 리턴하라는 의미이다
			//---------------------------------------------------------
			// 리턴 자료형은 select 태그의 resultType 속성값에 정의한다.
			//---------------------------------------------------------
			// [select 쿼리에 삽입되는 외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		int  boardListCnt = sqlSession.selectOne(  
			"com.naver.erp.BoardDAO.getBoardListCnt"   // 실행할 SQL 구문의 위치 지정
			, boardSearchFormDTO                             // 실행할 SQL 구문에서 사용할 데이터 설정
		);
		return boardListCnt;
	}

	//***************************************************** 
	// [검색한 게시판 목록] 리턴하는 메소드 선언
	//***************************************************** 
	public List<Map<String, String>> getBoardList( BoardSearchFormDTO boardSearchFormDTO){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 메소드를 호출하여 [n행 검색 결과물]을 List<Map<String, String>> 객체로 리턴하기
		//--------------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------------
		//  List<Map<String, String>>|List<DTO>|List<String>|List<Integer>  selectList(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.select태그 id 속성값"
		//        ,  select 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 select태그 id 속성값을 가진 태그 내부의 select 쿼리문에 
			// [select 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는  n행의 데이터를 
			// List<Map<String, String>>|List<DTO>|List<String>|List<Integer>  등으로 리턴하라는 의미이다
			//---------------------------------------------------------
			// 리턴 자료형은 select 태그의 resultType 속성값에 정의한다.
			//---------------------------------------------------------
			// [외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		List<Map<String, String>>  boardList = sqlSession.selectList(  
			"com.naver.erp.BoardDAO.getBoardList"   //실행할 SQL 구문의 위치 지정
			, boardSearchFormDTO                          // 실행할 SQL 구문에서 사용할 데이터 설정
		);
		return boardList;
	}

	//***************************************************** 
	// [게시판 글 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	//***************************************************** 
	public int insertBoard( BoardDTO boardDTO ){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 insert(~,~) 메소드를 호출하여 [입력 실행 후 입력 행의 개수] 얻기.
		//--------------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------------
		// int insert(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.insert태그 id 속성값"
		//        ,  insert 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 insert태그 id 속성값을 가진 태그 내부의 insert 쿼리문에 
			// [insert 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 정수 데이터를 int로 리턴한다.
			//---------------------------------------------------------
			// 리턴 자료형은 무조건 int 형이고, insert 태그 내에 resultType 속성은 없다.
			//---------------------------------------------------------
			// [외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		int  boardRegCnt = sqlSession.insert(    
			"com.naver.erp.BoardDAO.insertBoard"  // 실행할 SQL 구문의 위치 지정
			, boardDTO                            // 실행할 SQL 구문에서 사용할 데이터 설정
		);
		return boardRegCnt;
	}

	//***************************************************** 
	// 수정 화면에서 보여줄 [1개 게시판 글 정보] 리턴하는 메소드 선언
	//*****************************************************  
	public BoardDTO getBoardDTO( int board_no ){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 메소드를 호출하여 1개 행의 [검색한 게시판 정보]를 저장한 BoardDTO 로 얻기.
		//--------------------------------------------------------------------------------------
		//  DTO|Map|int|double  selectOne(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.select태그 id 속성값"
		//        ,  select 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 select 태그 id 속성값을 가진 태그 내부의 select 쿼리문에 
			// [select 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 1행의 데이터를 
			// [기본형] 또는 [String] 또는 [HashMap] 또는 [DTO] 등으로 리턴하라는 의미이다
			//---------------------------------------------------------
			// 리턴 자료형은 select 태그의 resultType 속성값에 정의한다.
			//---------------------------------------------------------
			// [select 쿼리에 삽입되는 외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		BoardDTO boardDTO = sqlSession.selectOne(
				"com.naver.erp.BoardDAO.getBoardDTO"   // 실행할 SQL 구문의 위치 지정
				,board_no                              // 실행할 SQL 구문에서 사용할 데이터 설정                
		);
		return boardDTO;
	}
	//***************************************************** 
	// [게시판 글 조회수 수정하고 수정행의 개수] 리턴하는 메소드 선언
	//***************************************************** 	
	public int updateReadcount( int board_no ){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 update(~,~) 메소드를 호출하여 [수정 실행 후 수정 행의 개수] 얻기.
		//--------------------------------------------------------------------------------------
		//  int update(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.update태그 id 속성값"
		//        ,  update 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 update태그 id 속성값을 가진 태그 내부의 update 쿼리문에 
			// [update 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 정수 데이터를 int로 리턴한다.
			//---------------------------------------------------------
			// 리턴 자료형은 무조건 int 형이고, resultType 속성은 없다.
			//---------------------------------------------------------
			// [외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		int  readcount = sqlSession.update(    
			"com.naver.erp.BoardDAO.updateReadcount"   // 실행할 SQL 구문의 위치 지정
			, board_no                                 // 실행할 SQL 구문에서 사용할 데이터 설정			
		);		
		return readcount;
	}
	
	//***************************************************** 
	// [1개 게시판 글 출력번호 수정하고 수정 행의 개수] 리턴하는 메소드 선언
	//***************************************************** 	
	public int updatePrint_no(BoardDTO boardDTO){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 update(~,~) 메소드를 호출하여 
		// [게시판 글 출력번호 수정하고 수정 행의 개수] 얻기.
		//--------------------------------------------------------------------------------------
		//  int update(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.update태그 id 속성값"
		//        ,  update 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 update태그 id 속성값을 가진 태그 내부의 update 쿼리문에 
			// [update 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 정수 데이터를 int로 리턴한다.
			//---------------------------------------------------------
			// 리턴 자료형은 무조건 int 형이고, resultType 속성은 없다.
			//---------------------------------------------------------
			// [외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		int updatePrint_noCnt = sqlSession.update(    
			"com.naver.erp.BoardDAO.updatePrint_no"   // 실행할 SQL 구문의 위치 지정
			, boardDTO                                // 실행할 SQL 구문에서 사용할 데이터 설정
		);		
		return updatePrint_noCnt;
	}

	//***************************************************** 
	// [1개 게시판 글의 아들 댓글 개수] 리턴하는 메소드 선언
	//***************************************************** 
	public int getSonBoardCnt( int board_no  ){		
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 메소드를 호출하여 [게시판 아들 댓글 개수]을 int로 리턴.
		//--------------------------------------------------------------------------------------
		//  DTO|Map|int|double  selectOne(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.select태그 id 속성값"
		//        ,  select 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 select 태그 id 속성값을 가진 태그 내부의 select 쿼리문에 
			// [select 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 1행의 데이터를 
			// [기본형] 또는 [String] 또는 [HashMap] 또는 [DTO] 등으로 리턴하라는 의미이다
			//---------------------------------------------------------
			// 리턴 자료형은 select 태그의 resultType 속성값에 정의한다.
			//---------------------------------------------------------
			// [select 쿼리에 삽입되는 외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		int  sonBoardCnt = sqlSession.selectOne(    
			"com.naver.erp.BoardDAO.getSonBoardCnt"   // 실행할 SQL 구문의 위치 지정
			, board_no                                // 실행할 SQL 구문에서 사용할 데이터 설정 
		);		
		return sonBoardCnt;
	}
	
	
	//***************************************************** 
	// [1개 게시판 글 수정하고 수정 행의 개수] 리턴하는 메소드 선언
	//***************************************************** 	
	public int updateBoard( BoardDTO boardDTO ){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 update(~,~) 메소드를 호출하여 
		// [게시판 글 수정하고 수정 행의 개수] 얻기.
		//--------------------------------------------------------------------------------------
		//  int update(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.update태그 id 속성값"
		//        ,  update 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 update태그 id 속성값을 가진 태그 내부의 update 쿼리문에 
			// [update 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 정수 데이터를 int로 리턴한다.
			//---------------------------------------------------------
			// 리턴 자료형은 무조건 int 형이고, resultType 속성은 없다.
			//---------------------------------------------------------
			// [외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		int  updateBoardCnt = sqlSession.update(    
			"com.naver.erp.BoardDAO.updateBoard"   // 실행할 SQL 구문의 위치 지정
			, boardDTO                             // 실행할 SQL 구문에서 사용할 데이터 설정 
		);		
		return updateBoardCnt;
	}

	//***************************************************** 
	// [1개 게시판 글 삭제하고 삭제 행의 개수] 리턴하는 메소드 선언
	//***************************************************** 
	public int deleteBoard( BoardDTO boardDTO ){
		//--------------------------------------------------------------------------------------
		// [SqlSessionTemplate 객체]의 delete(~,~) 메소드를 호출하여 
		// [게시판 글 삭제하고 삭제 행의 개수] 얻기.
		//--------------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------------
		//  int delete(  
		//        "쿼리문설정 XML 파일안에 mapper 태그의 namespace 속성값.delete태그 id 속성값"
		//        ,  delete 쿼리에 삽입되는 외부 데이터 자료형  
		//  )
		//--------------------------------------------------------------------------------------
			// [쿼리문설정 XML파일 안에 namespace 속성값을 가진 mapper 태그 안에 delete태그 id 속성값을 가진 태그 내부의 delete 쿼리문에 
			// [delete 쿼리에 삽입되는 외부 데이터 자료형]을 삽입하여 쿼리를 실행한 후 리턴되는 정수 데이터를 int로 리턴한다.
			//---------------------------------------------------------
			// 리턴 자료형은 무조건 int 형이고, resultType 속성은 없다.
			//---------------------------------------------------------
			// [외부 데이터 자료형]이 DTO일 경우 DTO 내부의 속성변수는 #{속성변수명} 또는 ${속성변수명}로 삽입된다.
			// #{속성변수명} 일 경우 속성변수의 자료형이 String 형이면 '(싱글퀄트) 가 붙어 삽입된다.
			// ${속성변수명} 일 경우 속성변수의 자료형이 무었이든 '(싱글퀄트) 없이 삽입된다.
			//---------------------------------------------------------
			// [쿼리문설정 XML 파일]은 아래   root-context.xml 파일에 서 아래 처럼 등록해 놓은 파일이다.
			//---------------------------------------------------------
				//  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				//	  <property name="dataSource" ref="log4jdbcProxyDataSource"/>
				//	  <property name="mapperLocations" value="classpath:com/naver/erp/*.xml"/>		
				//  </bean> 
		//--------------------------------------------------------------------------------------
		int  deleteBoardCnt = sqlSession.delete(    
			"com.naver.erp.BoardDAO.deleteBoard"   // 실행할 SQL 구문의 위치 지정
			, boardDTO                             // 실행할 SQL 구문에서 사용할 데이터 설정 
		);		
		return deleteBoardCnt;
	}
		
}
































































