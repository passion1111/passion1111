package com.naver.erp;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.erp.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// 가상 URL 주소로 접속하면 호출되는 메소드를 소유한 [LoginController 컨트롤러 클래스] 선언. 
//		@Controller 를 붙임으로서 [컨트롤러 클래스]임을 지정한다.
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
@Controller
public class LoginController {
	
	//*****************************************************
	// 속성변수 loginService 선언하고,LoginService 라는 인터페이스를 구현한 클래스를 객체화하여 저장	
	//*****************************************************
		// @Autowired 이 붙은 속성변수에는 인터페이스 자료형을 쓰고 
		// 이 인터페이스를 구현한 클래스를 객체화하여 저장한다.
		// LoginService 라는 인터페이스를 구현한 클래스의 이름을 몰라도 관계없다. 1개 존재하기만 하면된다.
	//*****************************************************
	@Autowired
	private LoginService loginService;
		
	
	//*****************************************************
	// 가상주소 /erp/loginForm.do 로 접속하면 호출되는 메소드 선언.
	//*****************************************************
		// [컨트롤러 클래스]의 메소드에 @ResponseBody 가 없고, @RequestMapping이 붙고
		// 메소드의 리턴형이 String 일 경우 리턴하는 문자열은 호출할 JSP 페이지명 이다. 
	//*****************************************************
	@RequestMapping(value="/loginForm.do" )
	public String loginForm( 
			// [HttpSession 객체]가 들어올 매개변수 선언
			// 매개변수에 자료형이 HttpSession이면 웹서버가 생성한 HttpSession 객체가 들어온다.
			HttpSession session 
	){
		//-------------------------------------------------
		// HttpSession 객체에 저장된 기존 [로그인 아이디], [수정 연락처 번호] 제거하기.
		//-------------------------------------------------
			// <참고> session.invalidate(); 를 사용하면 HttpSession 객체의 getId() 이외의 메소드 호출을
			// 불가능하게 만들어 기존 [로그인 아이디], [수정 연락처 번호]를 없애주는 듯한 효과를 볼수 있다.
//		session.removeAttribute("admin_id");		
//		session.removeAttribute("contact_noList");
		

		//-------------------------------------------------
		// HttpSession 객체에 저장된 모든 객체를 제거한다
		//-------------------------------------------------
		session.invalidate();
		//session.setMaxInactiveInterval(0);
		
		
		//-------------------------------------------------
		// [호출할 JSP 페이지명]을 리턴하기
		//-------------------------------------------------
		return "loginForm";
	}	
	
	
	
	
	//*****************************************************
	// 가상주소 /erp/loginProc.do 로 접속하면 호출되는 메소드 선언.
	//*****************************************************
		// [컨트롤러 클래스]의 메소드에 @ResponseBody 가 있고, @RequestMapping이 붙으면
		// 메소드의 리턴 데이터가 바로 클라이언트에게 전송된다.
		// 클라이언트는 JSON 형태로 받게된다.
		//*****************************************************
	@RequestMapping(	value="/loginProc.do", method=RequestMethod.POST  )
	public ModelAndView loginProc( 
		//-----------------------------------------------------
		// admin_id 라는 파라미터명의 파라미터값이 들어올 String 형 매개변수 선언
		// <주의>admin_id 라는 파라미터명의 파라미터값이 없으면 메소드 내용 실행안되고 에러 발생
		//-----------------------------------------------------
			//-----------------------------------------------------------------------------------------------------------------------
			// @RequestParam( value="파라미터명", required=true|false, defaultValue="디폴트값" )   자료형  파라미터값저장할매개변수명
			//-----------------------------------------------------------------------------------------------------------------------
				// [파라미터명]의 [파리미터값]을 [파라미터값저장할매개변수명]에 저장한다.
				// required=true           => 파라미터명이 없을 경우 에러발생. 메소드안의 코딩은 한줄도 실행 안된다. 생략 가능.
				// required=false          => 파라미터명이 없을 경우 null 값을 매개변수에 저장. 만약 매개변수 자료형이 기본형이면 에러 발생.
				// defaultValue="디폴트값" => 파라미터값이 없을 경우 디폴트값을 매개변수에 저장. required=false 가 있어야함. 
				//					  		 생략 시 매개변수에는 null 저장됨.
				//-----------------------------------------------------	
		@RequestParam( value="admin_id" )  String admin_id
		//-----------------------------------------------------
		// pwd 라는 파라미터명의 파라미터값이 들어올 String 형 매개변수 선언
		// <주의>pwd 라는 파라미터명의 파라미터값이 없으면 메소드 내용 실행안되고 에러 발생
		//-----------------------------------------------------
		,@RequestParam( value="pwd" )       String pwd
		//-----------------------------------------------------
		// is_login 라는 파라미터명의 파라미터값이 들어올 String 형 매개변수 선언
		// is_login 라는 파라미터명의 파라미터값이 없으면 null 저장
		//-----------------------------------------------------
		,@RequestParam( value="is_login", required=false )   String is_login		
		//-----------------------------------------------------
		// [HttpRequest 객체]가 들어올 매개변수 선언
		//-----------------------------------------------------
		,HttpServletResponse response
		//-----------------------------------------------------
		// [HttpSession 객체]가 들어올 매개변수 선언
		//-----------------------------------------------------
		,HttpSession session

	){
		System.out.println("is_login => " + is_login );
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("loginProc");
		int adminCnt = 0;
		try{
			System.out.println("111");
			//-------------------------------------------------
			// HashMap 객체에 [로그인 아이디, 암호] 저장하기
			//-------------------------------------------------
			Map<String, String> admin_id_pwd = new HashMap<String, String>();
			admin_id_pwd.put("admin_id", admin_id);
			admin_id_pwd.put("pwd", pwd);
			//-------------------------------------------------
			// loginServiceImpl 객체의 getAdminCnt( admin_id_pwd ) 메소드 호출로 [로그인 아이디의 존재 개수]를 얻기
			//-------------------------------------------------
			adminCnt = this.loginService.getAdminCnt( admin_id_pwd );
			//-------------------------------------------------
			// ModelAndView 객체에 아이디 존재 개수 저장하기
			//-------------------------------------------------
			mav.addObject( "adminCnt", adminCnt );
			//-------------------------------------------------
			// [로그인 아이디의 존재 개수]가 1이면 Session 객체에 로그인 아이디 저장하기
			// [아이디]가 DB에 존재하면(즉 로그인이 성공할 경우) HttpSession 객체에 [아이디] 저장하기
			// [아이디,암호 저장 의사]가 있을 경우 아이디와 암호를 Cookie 객체에 저장하고 
			// 이 Cookie 객체를 HttpServletResponse 객체에 저장하기.
			//-------------------------------------------------
					// HttpSession 객체는 웹브라우저와 웹서버간의 연결 상태가 끊긴 상태에서 처음 접근하여 연결이 성공하면 1개 생성되고
					//		웹브라우저와 웹서버간의 연결 상태가 끊기기 전까지 모든 JSP 에서 존재하여 사용 가능한 객체이다.
					//		JSP 페이지에서 HttpSession 객체는 session 이라는 제공 객체 참조 변수에 저장되어 제공된다.
					// HttpServletResponse 객체 안의 Cookie 객체 안의 쿠키는 [응답 메시지]에 저장되어 클라이언에게 전송된후 클라이언에 저장된다.
				//-------------------------------------------------
			if( adminCnt==1 ){
				//HttpSession 객체에 [아이디] 저장하기
				session.setAttribute("admin_id", admin_id);
				//-----
				// [아이디,암호 저장 의사]가 없을 경우 [아이디,암호 관련 쿠키]를 null 로 덮어 씌우고 수명 없애기. 
				// 그리고 이 쿠키를  HttpServletRequest 객체에 저장하기
				//-----
				if(is_login==null){
//					Cookie cookie1 = new Cookie( "admin_id", null );
//					cookie1.setMaxAge( 0 );         
//					response.addCookie( cookie1 );
//					Cookie cookie2 = new Cookie( "pwd", null );
//					cookie2.setMaxAge( 0 );         
//					response.addCookie( cookie2 );					
					Util.addCookie(  response , "admin_id", null , 0 );
					Util.addCookie(  response , "pwd", null , 0 );
				}
				//-----
				// [아이디,암호 저장 의사]가 있을 경우 [아이디,암호 관련 쿠키] 만들고 수명 정하기
				// 그리고 이 쿠키를  HttpServletRequest 객체에 저장하기
				//-----
				else{
					/*Cookie cookie1 = new Cookie( "admin_id", admin_id );
					cookie1.setMaxAge( 60*60*24 );         
					response.addCookie( cookie1 );
					Cookie cookie2 = new Cookie( "pwd", pwd );
					cookie2.setMaxAge( 60*60*24 );         
					response.addCookie( cookie2 );*/					
					Util.addCookie(  response , "admin_id", admin_id , 60*60*24 );
					Util.addCookie(  response , "pwd", pwd , 60*60*24 );
				}
			}
		}catch(Exception ex){
			System.out.println( "LoginController.loginProc(~) 에서 에러발생" );
			mav.addObject( "adminCnt", -1 );
		}
		return mav;
	}
	
	
	
	
	
	
/*
	//*****************************************************
	// 가상주소 /erp/loginProc2.do 로 접속하면 호출되는 메소드 선언.
	//*****************************************************
		// [컨트롤러 클래스]의 메소드에 @ResponseBody 가 있고, @RequestMapping이 붙으면
		// 메소드의 리턴 데이터가 바로 클라이언트에게 전송된다.
		// 클라이언트는 JSON 형태로 받게된다.
		//*****************************************************
	@RequestMapping(
			value="/loginProc2.do"
			, method=RequestMethod.POST
			, produces="application/json;charset=UTF-8"
	)
	@ResponseBody
	public int loginProc2( 
		//-----------------------------------------------------
		// admin_id 라는 파라미터명의 파라미터값이 들어올 String 형 매개변수 선언
		//-----------------------------------------------------
			//-----------------------------------------------------------------------------------------------------------------------
			// @RequestParam( value="파라미터명", required=true|false, defaultValue="디폴트값" )   자료형  파라미터값저장할매개변수명
			//-----------------------------------------------------------------------------------------------------------------------
				// [파라미터명]의 [파리미터값]을 [파라미터값저장할매개변수명]에 저장한다.
				// required=true           => 파라미터명이 없을 경우 에러발생. 메소드안의 코딩은 한줄도 실행 안된다. 생략 가능.
				// required=false          => 파라미터명이 없을 경우 null 값을 매개변수에 저장. 만약 매개변수 자료형이 기본형이면 에러 발생.
				// defaultValue="디폴트값" => 파라미터값이 없을 경우 디폴트값을 매개변수에 저장. required=false 가 있어야함. 
				//					  		 생략 시 매개변수에는 null 저장됨.
				//-----------------------------------------------------	
		@RequestParam( value="admin_id" )  String admin_id
		//-----------------------------------------------------
		// pwd 라는 파라미터명의 파라미터값이 들어올 String 형 매개변수 선언
		//-----------------------------------------------------
		,@RequestParam( value="pwd" )       String pwd
		//-----------------------------------------------------
		// is_login 라는 파라미터명의 파라미터값이 들어올 String 형 매개변수 선언
		//-----------------------------------------------------
		,@RequestParam( value="is_login" )       String is_login
		
		//-----------------------------------------------------
		// [HttpRequest 객체]가 들어올 매개변수 선언
		//-----------------------------------------------------
		,HttpServletResponse response
		//-----------------------------------------------------
		// [HttpSession 객체]가 들어올 매개변수 선언
		//-----------------------------------------------------
		,HttpSession session

	){
		int adminCnt = 0;
		try{
			//-------------------------------------------------
			// HashMap 객체에 [로그인 아이디, 암호] 저장하기
			//-------------------------------------------------
			Map<String, String> admin_id_pwd = new HashMap<String, String>();
			admin_id_pwd.put("admin_id", admin_id);
			admin_id_pwd.put("pwd", pwd);
			//-------------------------------------------------
			// loginServiceImpl 객체의 getAdminCnt( admin_id_pwd ) 메소드 호출로 [로그인 아이디의 존재 개수]를 얻기
			//-------------------------------------------------
			adminCnt = this.loginService.getAdminCnt( admin_id_pwd );
			
			//-------------------------------------------------
			// [로그인 아이디의 존재 개수]가 1이면 Session 객체에 로그인 아이디 저장하기
			// [아이디]가 DB에 존재하면(즉 로그인이 성공할 경우) HttpSession 객체에 [아이디] 저장하기
			// [아이디,암호 저장 의사]가 있을 경우 아이디와 암호를 Cookie 객체에 저장하고 
			// 이 Cookie 객체를 HttpServletResponse 객체에 저장하기.
			//-------------------------------------------------
					// HttpSession 객체는 웹브라우저와 웹서버간의 연결 상태가 끊긴 상태에서 처음 접근하여 연결이 성공하면 1개 생성되고
					//		웹브라우저와 웹서버간의 연결 상태가 끊기기 전까지 모든 JSP 에서 존재하여 사용 가능한 객체이다.
					//		JSP 페이지에서 HttpSession 객체는 session 이라는 제공 객체 참조 변수에 저장되어 제공된다.
					// HttpServletResponse 객체 안의 Cookie 객체 안의 쿠키는 [응답 메시지]에 저장되어 클라이언에게 전송된후 클라이언에 저장된다.
				//-------------------------------------------------
			if( adminCnt==1 ){
				//HttpSession 객체에 [아이디] 저장하기
				session.setAttribute("admin_id", admin_id);
				//-----
				// [아이디,암호 저장 의사]가 없을 경우 [아이디,암호 관련 쿠키]를 null 로 덮어 씌우고 수명 없애기. 
				// 그리고 이 쿠키를  HttpServletRequest 객체에 저장하기
				//-----
				if(is_login==null){
					Cookie cookie1 = new Cookie( "admin_id", null );
					cookie1.setMaxAge( 0 );         
					response.addCookie( cookie1 );
					Cookie cookie2 = new Cookie( "pwd", null );
					cookie2.setMaxAge( 0 );         
					response.addCookie( cookie2 );
				}
				//-----
				// [아이디,암호 저장 의사]가 있을 경우 [아이디,암호 관련 쿠키] 만들고 수명 정하기
				// 그리고 이 쿠키를  HttpServletRequest 객체에 저장하기
				//-----
				else{
					Cookie cookie1 = new Cookie( "admin_id", admin_id );
					cookie1.setMaxAge( 60*60*24 );         
					response.addCookie( cookie1 );
					Cookie cookie2 = new Cookie( "pwd", pwd );
					cookie2.setMaxAge( 60*60*24 );         
					response.addCookie( cookie2 );
				}
			}
		}catch(Exception ex){
			System.out.println( "LoginController.loginProc2(~) 에서 에러발생" );
			adminCnt = -1;
		}
		return adminCnt;
	}*/
}


	/*
	//****************************************************************** 
	// 위 loginProc(~) 메소드는 아래 처럼도 가능하다.
	// 클라이언트가 전송한 모든 파라미터값을 저장한  HttpServletRequest 객체를 매개변수로 받는 방법이다.
	//******************************************************************
		@RequestMapping(value="/loginProc.do",method=RequestMethod.POST )
		public ModelAndView loginProc( 
			HttpSession session
			, HttpServletRequest request 
		){
			ModelAndView mav = new ModelAndView();	
			mav.setViewName("loginProc");
			try{
				String admin_id = request.getAttribute("admin_id");
				String pwd = request.getAttribute("pwd");
				Map<String, String> map = new HashMap<String, String>();
				map.put( "admin_id", admin_id );
				map.put( "pwd", pwd );
				int adminCnt = this.loginService.getAdminCnt( map );
				if(adminCnt==1 ){
					session.setAttribute( "admin_id", paramsMap.get("admin_id") );
				}
				mav.addObject( "adminCnt", adminCnt );
			}catch(Exception ex){
				mav.addObject( "adminCnt", -1 );
				System.out.println( "LoginController.loginProc(~) 에서 에러발생" );
			}
			return mav;
		}
	//****************************************************************** 
	// 위 loginProc(~) 메소드는 아래 처럼도 가능하다.
	// 클라인트가 전송한 파라미터값을 저장한 HashMap 으로 받는 방법이다..
	//******************************************************************
		@RequestMapping(value="/loginProc.do",method=RequestMethod.POST )
		public ModelAndView loginProc( 
				HttpSession session
				,@RequestParam Map<String,String> paramsMap
		){
			ModelAndView mav = new ModelAndView();	
			mav.setViewName("loginProc");
			try{
				int adminCnt = this.loginService.getAdminCnt( paramsMap );
				if(adminCnt==1 ){
					session.setAttribute( "admin_id", paramsMap.get("admin_id") );
				}
				mav.addObject( "adminCnt", adminCnt );
			}catch(Exception ex){
				mav.addObject( "adminCnt", -1 );
				System.out.println( "LoginController.loginProc(~) 에서 에러발생" );
			}
			return mav;
		}
	//****************************************************************** 
	// 위 loginProc(~) 메소드는 아래 처럼 @ResponseBody 를 사용하면 JSP 페이지 호출 없이
	// 리턴하는 로그인 정보 존재개수를 직접 클라이언트에게 전송할 수도 있다.
	// 단 서버가 보내는 데이터를 클라이언트가 받을 수 있도록 클라이언트가 코딩되어 있어야한다.
	//******************************************************************
		@RequestMapping(
			value="/loginProc.do"
			,method=RequestMethod.POST 
			,produces="application/json;charset=UTF-8"
		)
		@ResponseBody
		public int loginProc( 
				HttpSession session
				,@RequestParam Map<String,String> paramsMap
		){
			int adminCnt = 0;
			try{
				int adminCnt = this.loginService.getAdminCnt( paramsMap );
				if(adminCnt==1){
					session.setAttribute( "admin_id", paramsMap.get("admin_id") );
				}
			}catch(Exception ex){
				System.out.println( "LoginController.loginProc(~) 에서 에러발생" );
				adminCnt = -1;
			}
			return adminCnt;
		}	
	*/




















