package com.naver.erp;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.naver.erp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
//가상 URL 주소로 접속하면 호출되는 메소드를 소유한 [컨트롤러 클래스] 선언. 
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	//@Controller 를 붙임으로서 [컨트롤러 클래스]임을 지정한다.
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
@Controller
public class BoardController {

	//*****************************************************
	// 속성변수 boardService 선언하고,[BoardService 인터페이스]를 구현받은 [BoardServiceImpl 객체를 생성해 저장
	//*****************************************************
		// @Autowired 역할 => 속성변수에 붙은 자료형인 [인터페이스]를 구현한 [클래스]를 객체화하여 저장한다.
		//                    [인터페이스]를 구현한 [클래스]가 1개가 아니면 에러가 발생한다.
		//                    단 @Autowired( required=false )로 선언하면 0개 이어도 에러없이 null 이 저장된다.
		//                    Spring에서만 지원하는 어노테이션이다. 
		//                    자바에서 지원하는 @Inject 를 사용할수도 있으나 required=false는 사용불가능 하다.
		//                    @Inject 사용하려면 pom.xml 에 아래를 API 수입 설정을 해야한다.
		//                    <dependency><groupld >javax.inject</groupld ><artifactId >javax.inject</artifactId><version>1</version></dependency>
	//*****************************************************
	@Autowired
	private BoardService boardService;

	
	@ModelAttribute("param_info")
	public String getInfo( HttpServletRequest request ){
		return Util.getRequsetInfo( request );
	}
	

	//*****************************************************
	// 가상주소 /boardListForm.do 로 접근하면 호출되는 메소드 선언
	//*****************************************************
	@RequestMapping( value="/boardListForm.do")
	public ModelAndView getBoardList(	
		//-----------------------------------------------------
		// 파라미터값을 저장할 [BoardListDTO 객체]를 매개변수로 선언
		//-----------------------------------------------------
			// [파라미터명]과 [BoardListDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
			// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
			// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
			//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
			//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
			//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
			// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
			// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
			// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
			//-----------------------------------------------------
		@ModelAttribute("boardListDTO") BoardSearchFormDTO  boardSearchFormDTO 
	){
		//-------------------------------------------------
		// [ModelAndView 객체] 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();	
		//-------------------------------------------------
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("boardListForm");	
		try{	
			//-------------------------------------------------
			// [BoardServiceImpl 객체]의 getBoardListCnt( boardListDTO ) 메소드 호출로 [검색한 게시판 총 개수]를 얻기
			//-------------------------------------------------
			int  boardListAllCnt = this.boardService.getBoardListCnt( boardSearchFormDTO );	
			

			//-------------------------------------------------
			// [선택 페이지 번호]에 대응하는 오라클 검색 결과물 행의 [오름차순 시작번호] 얻기 
			//-------------------------------------------------
			int oracleAscStartRowNo = boardSearchFormDTO.getSelectPageNo() * boardSearchFormDTO.getRowCntPerPage() 
										- boardSearchFormDTO.getRowCntPerPage()  + 1;

			//-------------------------------------------------
			// [선택된 페이지 번호]와 [총검색 개수]와의 관계가 비합리적이면 
			// [선택된 페이지 번호]를 1로 하고 검색 행의 [시작행 번호]를 1로 하기
			//-------------------------------------------------
			if( boardListAllCnt<oracleAscStartRowNo ) { 
				boardSearchFormDTO.setSelectPageNo(  1 );
				oracleAscStartRowNo = 1; 
			}

			//-------------------------------------------------
			// [선택 페이지 번호]에 대응하는 오라클 검색 결과물 행의 [내림차순 시작번호] 얻기 
			//-------------------------------------------------
			int oracleDescStartRowNo = boardListAllCnt - oracleAscStartRowNo + 1;
			
			//-------------------------------------------------
			// [BoardListDTO 객체]의 updateDTO 메소드를 호출하여
			// [DTO 객체]에서 [게시판 검색 총 개수]에 따라 달라지는 [선택한 페이지 번호]를 보정하기.  
			//-------------------------------------------------
			//boardListDTO.updateDTO( boardListAllCnt );		
			
			//-------------------------------------------------
			// [BoardServiceImp 객체]의 getBoardList( boardListDTO ) 메소드 호출로 [검색한 게시판 목록]를 얻기
			//-------------------------------------------------
			List<Map<String,String>>  boardList = this.boardService.getBoardList( boardSearchFormDTO );
			
			//-------------------------------------------------
			// ModelAndView 객체에 [검색한 게시판 총 개수], [검색한 게시판 목록]을 저장하기.
			// ModelAndView 객체에 저장된 데이터는 호출할 JSP 에서 꺼내어 HTML 코딩과 어울리게 된다.
			//-------------------------------------------------
			mav.addObject("boardListAllCnt",boardListAllCnt);
			mav.addObject("boardList",boardList);	
			mav.addObject("oracleAscStartRowNo",oracleAscStartRowNo);	
			mav.addObject("oracleDescStartRowNo",oracleDescStartRowNo);	
		}catch(Exception ex){
			System.out.println("ContactController.getBoardList(~) 메소드 호출 시 에러발생");			
		}
		//-------------------------------------------------
		// [ModelAndView 객체] 리턴하기
		//-------------------------------------------------
		return mav;
	}
	
	//*****************************************************
	// 가상주소 /boardRegForm.do 로 접근하면 호출되는 메소드 선언.
	//*****************************************************
	@RequestMapping( value="/boardRegForm.do")
	public ModelAndView goBoardRegForm(
			//-----------------------------------------------------
			// 파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// [파라미터명]과 [BoardDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
				//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
				//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
				//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
				// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
				//-----------------------------------------------------
			@ModelAttribute("boardDTO")  BoardDTO   boardDTO
	){
		//-------------------------------------------------
		// [ModelAndView 객체] 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();
		//-------------------------------------------------
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("boardRegForm");
		//-------------------------------------------------
		// [ModelAndView 객체] 리턴하기
		//-------------------------------------------------
		return mav;
	}
	
	//*****************************************************
	// /erp/boardRegProc.do 로 접근하면 호출되는 메소드 선언
	//*****************************************************  ,
	@RequestMapping(value = "/boardRegProc.do",method=RequestMethod.POST )
	public ModelAndView insertBoard( 
			//-----------------------------------------------------
			// 파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// [파라미터명]과 [BoardDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
				//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
				//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
				//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
				// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
				//-----------------------------------------------------
			@ModelAttribute("boardDTO") BoardDTO boardDTO  
	) {		
		//-------------------------------------------------
		// [ModelAndView 객체] 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();	
		//-------------------------------------------------
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("boardRegProc");  
		try{	
			//-------------------------------------------------
			// [BoardServiceImpl 객체]의 insertBoard 메소드 호출로 게시판 입력하고 [입력 연락처 행의 개수] 얻기	
			//-------------------------------------------------
			int boardRegCnt = this.boardService.insertBoard(boardDTO);
			//-------------------------------------------------
			// [ModelAndView 객체]에 [호출 JSP 페이지]에 반영할 [입력 연락처 행의 개수] 저장	
			//-------------------------------------------------
			mav.addObject("boardRegCnt",boardRegCnt);
		}catch(Exception ex){		
			//-------------------------------------------------
			// 예외 발생 시 실행할 코드 설정
			//-------------------------------------------------
			mav.addObject("boardRegCnt",-1);
			System.out.println( "BoardController.insertBoard(~) 메소드 예외 발생!");
		}
		//-------------------------------------------------
		// [ModelAndView 객체] 리턴하기
		//-------------------------------------------------
		return mav;
	}		

	//*****************************************************
	// 가상주소 /boardContentForm.do 로 접근하면 호출되는 메소드 선언
	//*****************************************************
	@RequestMapping( value="/boardContentForm.do",method=RequestMethod.POST )
	public ModelAndView goBoardContentForm(
			//-----------------------------------------------------
			// board_no 라는 [파라미터명]의 [파라미터값]을 저장할 int 형 매개변수 선언
			//-----------------------------------------------------
				//------------------------------------------------------------------------------------------------------------
				// @RequestParam( value="파라미터명",required=true|false,defaultValue="디폴트값" )   자료형  파라미터값저장할매개변수명
				//------------------------------------------------------------------------------------------------------------
					// [파라미터명]의 [파리미터값]을 [파라미터값저장할매개변수명]에 저장한다.
					// required=true           => 파라미터명이 없을 경우 에러발생. 메소드안의 코딩은 한줄도 실행 안된다. 생략 가능.
					// required=false          => 파라미터명이 없을 경우 null 값을 매개변수에 저장. 만약 매개변수 자료형이 기본형이면 에러 발생.
					// defaultValue="디폴트값" => 파라미터값이 없을 경우 디폴트값을 매개변수에 저장. required=false 가 있어야함. 
					//					  		 생략 시 매개변수에는 null 저장됨.
					//--------------------------------------------------------------------------------------------------------
			@RequestParam( value="board_no") int board_no		
	){
		//-------------------------------------------------
		// [ModelAndView 객체] 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();
		//-------------------------------------------------
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("boardContentForm");  
		try{
			//-------------------------------------------------
			// [BoardServiceImpl 객체]의 getBoard 메소드 호출로 [1개의 게시판 글] 정보 얻기
			//-------------------------------------------------
			BoardDTO boardDTO = this.boardService.getBoardDTO( board_no );
			//-------------------------------------------------
			// [ModelAndView 객체]에 [호출 JSP 페이지]에 반영할 [1개의 게시판 글] 정보 저장	
			//-------------------------------------------------
			mav.addObject("boardDTO",boardDTO);
		}catch(Exception ex){
			//-------------------------------------------------
			// 예외 발생 시 실행할 코드 설정
			//-------------------------------------------------
			System.out.println( "BoardController.goBoardContentForm(~) 메소드 예외 발생!");
		}
		return mav;
	}
	
	//*****************************************************
	// 가상주소 /boardUpDelForm.do 로 접근하면 호출되는 메소드 선언
	//*****************************************************
	@RequestMapping( value="/boardUpDelForm.do",method=RequestMethod.POST )
	public ModelAndView goBoardUpDelForm(
			//-----------------------------------------------------
			// board_no 라는 파라미터명의 파라미터값을 저장할 int 형 매개변수 선언
			//-----------------------------------------------------
				//------------------------------------------------------------------------------------------------------------
				// @RequestParam( value="파라미터명",required=true|false,defaultValue="디폴트값" )   자료형  파라미터값저장할매개변수명
				//------------------------------------------------------------------------------------------------------------
					// [파라미터명]의 [파리미터값]을 [파라미터값저장할매개변수명]에 저장한다.
					// required=true           => 파라미터명이 없을 경우 에러발생. 메소드안의 코딩은 한줄도 실행 안된다. 생략 가능.
					// required=false          => 파라미터명이 없을 경우 null 값을 매개변수에 저장. 만약 매개변수 자료형이 기본형이면 에러 발생.
					// defaultValue="디폴트값" => 파라미터값이 없을 경우 디폴트값을 매개변수에 저장. required=false 가 있어야함. 
					//					  		 생략 시 매개변수에는 null 저장됨.
					//--------------------------------------------------------------------------------------------------------
			@RequestParam( value="board_no" )   int board_no
	){
		//-------------------------------------------------
		// [ModelAndView 객체] 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();
		//-------------------------------------------------
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("boardUpDelForm");  
		try{
			//-------------------------------------------------
			// [BoardServiceImpl 객체]의 getSonBoardCnt 메소드 호출로 [아들 댓글 개수] 정보 얻기
			//-------------------------------------------------
			int sonBoardCnt = this.boardService.getSonBoardCnt( board_no );
			//-------------------------------------------------
			// [ModelAndView 객체]에 [호출 JSP 페이지]에 반영할 정보 저장	
			//-------------------------------------------------
			// 만약 아들 댓글이 1개 이상일 경우 
			if( sonBoardCnt>=1 ){
				// [ModelAndView 객체]에 [호출 JSP 페이지]에 반영할 [아들 댓글 개수] 저장	
				mav.addObject("sonBoardCnt",sonBoardCnt);
			}
			// 만약 아들 댓글이 0개일 경우 
			else{
				//-------------------------------------------------
				// [BoardServiceImpl 객체]의 getBoard 메소드 호출로 [수정/삭제할 1개의 게시판 글 정보] 얻기
				//-------------------------------------------------
				BoardDTO boardDTO = this.boardService.getBoardDTO( board_no );
				//-------------------------------------------------
				// [ModelAndView 객체]에 [호출 JSP 페이지]에 반영할 [수정/삭제할 1개의 게시판 글 정보]  저장	
				//-------------------------------------------------
				mav.addObject("boardDTO",boardDTO);
			}			
		}catch(Exception ex){
			//-------------------------------------------------
			// 예외 발생 시 실행할 코드 설정
			//-------------------------------------------------
			System.out.println( "BoardController.goBoardUpDelForm(~) 메소드 예외 발생!");
		}
		return mav;
	}
	
	//*****************************************************
	// /erp/boardUpDelProc.do 로 접근하면 호출되는 메소드 선언
	// 게시판 정보를 DB에 저장하고 결과를 출력할 boardUpDelProc.jsp 로 이동
	//*****************************************************  
	@RequestMapping(value = "/boardUpDelProc.do",method=RequestMethod.POST )
	public ModelAndView boardUpDelProc( 
			//-----------------------------------------------------
			// 파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// [파라미터명]과 [BoardDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
				//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
				//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
				//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
				// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
				//-----------------------------------------------------	
			@ModelAttribute("boardDTO") BoardDTO boardDTO  

			//-----------------------------------------------------
			// upDel 라는 파라미터명의 파라미터값을 저장할 String 형 매개변수 선언
			//-----------------------------------------------------
				//------------------------------------------------------------------------------------------------------------
				// @RequestParam( value="파라미터명",required=true|false,defaultValue="디폴트값" )   자료형  파라미터값저장할매개변수명
				//------------------------------------------------------------------------------------------------------------
					// [파라미터명]의 [파리미터값]을 [파라미터값저장할매개변수명]에 저장한다.
					// required=true           => 파라미터명이 없을 경우 에러발생. 메소드안의 코딩은 한줄도 실행 안된다. 생략 가능.
					// required=false          => 파라미터명이 없을 경우 null 값을 매개변수에 저장. 만약 매개변수 자료형이 기본형이면 에러 발생.
					// defaultValue="디폴트값" => 파라미터값이 없을 경우 디폴트값을 매개변수에 저장. required=false 가 있어야함. 
					//					  		 생략 시 매개변수에는 null 저		
			,@RequestParam( value="upDel") String upDel
	) {		
		//-------------------------------------------------
		// 개발자를 위해 [boardDTO 객체]의 속성변수에 저장된 데이터를 도스창에 출력하기
		//-------------------------------------------------
		boardDTO.print_info( );
		//-------------------------------------------------
		// [ModelAndView 객체] 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();	
		//-------------------------------------------------
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("boardUpDelProc");  
		try{	
			//-------------------------------------------------
			// [ModelAndView 객체]에 [호출 JSP 페이지]에 반영할 정보 저장	
			//-------------------------------------------------
			// 만약 수정 모드이면 수정 실행하고 수정 적용행의 개수를 저장
			if( upDel.equals("up") ){ 		
				int boardUpCnt = this.boardService.updateBoard(boardDTO);	
				mav.addObject("boardUpCnt",boardUpCnt);	
			}
			// 만약 삭제 모드이면 삭제 실행하고 삭제 적용행의 개수를 저장
			else{
				int boardDelCnt = this.boardService.deleteBoard(boardDTO);	
				mav.addObject("boardDelCnt",boardDelCnt);
			}		
		}catch(Exception ex){
			mav.addObject("boardUpDelCnt",-1);
			System.out.println( "BoardController.boardUpDelProc(~) 메소드 예외 발생!");
		}
		return mav;
	}			
}

