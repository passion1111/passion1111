package com.naver.erp;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.erp.*;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
//가상 URL 주소로 접속하면 호출되는 메소드를 소유한 [컨트롤러 클래스] 선언. 
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	//		@Controller 를 붙임으로서 [컨트롤러 클래스]임을 지정된다.
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
@Controller
public class ContactController {
	//**************************************************************************
	// 속성변수 contactService 선언하고, ContactService 인터페이스를 구현한 클래스를 객체 생성해 저장.
	// ContactService 인터페이스를 구현한 클래스명은 알 필요가 없다.
	//**************************************************************************
		// @Autowired 역할 => 속성변수에 붙은 자료형인 [인터페이스]를 구현한 [클래스]를 객체화하여 저장한다.
		//                    [인터페이스]를 구현한 [클래스]가 1개가 아니면 에러가 발생한다.
		//                    단 @Autowired( required=false )로 선언하면 0개 이어도 에러없이 null 이 저장된다.
		//                    Spring에서만 지원하는 어노테이션이다. 
		//                    자바에서 지원하는 @Inject 를 사용할수도 있으나 required=false는 사용불가능 하다.
		//                    @Inject 사용하려면 pom.xml 에 아래를 API 수입 설정을 해야한다.
		//                    <dependency><groupld>javax.inject
		//**************************************************************************
	@Autowired
	private ContactService contactService;

	//**************************************************************************
	// [ContactController 클래스] 내부의  @RequestMapping(~) 이 붙은 
	// 모든 메소드가 호출되기 전에 자동으로 호출되는 메소드 선언.
	// 		반드시 @ModelAttribute("키값명") 이 붙어야함.
	//**************************************************************************
		// @ModelAttribute("키값명") 이 붙는 메소드가 리턴하는 데이터는 
		// @RequestMapping(~) 이 붙은 메소드 호출 후에 이동하는 JSP 페이지로 "키값명" 을 달고 자동 이동한다.
		//***************************************************
	@ModelAttribute("saup_fieldList")
	public List<Map<String,String>> getSaup_fieldList(){
		//-------------------------------------------------
		// DB에 있는 [사업분야] 목록을 검색해 List<Map<String,String>> 객체에 저장하기
		//-------------------------------------------------
		List<Map<String,String>> saup_fieldList = this.contactService.getSaup_fieldList();
		return saup_fieldList;
	}

	
	//**************************************************************************
	// [ContactController 클래스] 내부의  @RequestMapping(~) 이 붙은 모든 메소드가 호출되기 전에 자동으로 호출되는 메소드 선언.
	// 		반드시 @ModelAttribute("키값명") 이 붙어야함.
	//**************************************************************************
		// @ModelAttribute("키값명") 이 붙으며 이 메소드에서 리턴되는 데이터는 
		// @RequestMapping(~) 이 붙은 메소드 호출 후에 이동하는 JSP 페이지로 "키값명" 을 달고 자동 이동한다.
	//***************************************************
	@ModelAttribute("saup_fieldMap")
	public Map<String,String> getSaup_fieldMap(){
		//-------------------------------------------------
		// 동료 메소드인 getSaup_fieldList() 를 호출하여 
		// DB에 있는 [사업분야] 목록을 검색해 List<Map<String,String>> 객체에 저장하기
		//-------------------------------------------------
		List<Map<String,String>> saup_fieldList = getSaup_fieldList();
		//-------------------------------------------------
		// List<Map<String,String>> 객체에 저장된 [사업 목록] 데이터를  Map<String,String> 객체로 저장하기
		//-------------------------------------------------
		Map<String,String> saup_fieldMap = new HashMap<String,String>();
		for( Map<String,String> tmp : saup_fieldList){
			saup_fieldMap.put( tmp.get("saup_field_code"), tmp.get("saup_field_name") );
		}
		return saup_fieldMap;
	}
	
	
	
	
	

	@ModelAttribute("param_info")
	public String getInfo( HttpServletRequest request ){
		return Util.getRequsetInfo( request );
	}
	
	

	//**************************************************************************
	// 가상주소 /erp/contactSearchForm.do 로 접속하면 호출되는 메소드 선언.
	//**************************************************************************
		// [컨트롤러 클래스]의 메소드에 @ResponseBody 가 없고, @RequestMapping이 붙고
		// 메소드의 리턴형이 String 일 경우 리턴하는 문자열은 호출할 JSP 페이지명 이다. 
		//*****************************************************
	@RequestMapping(value="/contactSearchForm.do")
	public String contactSearchForm( ){
		return "contactSearchForm";
	}

	//**************************************************************************
	// 가상주소 /erp/contactSearchProc.do 로 접속하면 호출되는 메소드 선언.
	//**************************************************************************
	@RequestMapping(value="/contactSearchProc.do")
	public  ModelAndView contactSearchProc(
			//-----------------------------------------------------
			// 모든 파라미터값이 저장된 [ContactSearchDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// [파라미터명]과 [ContactSearchDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
				//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
				//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
				//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
				// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
				//-----------------------------------------------------
			@ModelAttribute("contactSearchDTO") ContactSearchDTO contactSearchDTO 
	){	
		contactSearchDTO.print_info() ;
		//-------------------------------------------------
		// ModelAndView 객체 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();	
		//-------------------------------------------------
		// ModelAndView 객체에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("contactSearchProc");
		try{
			//System.out.println(111);
			//-------------------------------------------------
			// [ContactServiceImpl 객체]의 메소드 호출로 [검색한 연락처 총 개수]를 얻기
			//-------------------------------------------------
			int  contactListAllCnt = this.contactService.getContactListAllCnt( contactSearchDTO );	
			//-------------------------------------------------
			// [검색한 연락처 총 개수]에 따라 달라지는 이전 [선택한 페이지 번호]를 보정하기.
			// [선택한 페이지 번호]에 따른 시작행 번호 구하기.
			//-------------------------------------------------
			//contactSearchDTO.updateDTO( contactListAllCnt );
			
			

			//-------------------------------------------------
			// [선택 페이지 번호]에 대응하는 오라클 검색 결과물 행의 [오름차순 시작번호] 얻기 
			//-------------------------------------------------
			int oracleAscStartRowNo = contactSearchDTO.getSelectPageNo() * contactSearchDTO.getRowCntPerPage() 
										- contactSearchDTO.getRowCntPerPage()  + 1;

			//-------------------------------------------------
			// [선택된 페이지 번호]와 [총검색 개수]와의 관계가 비합리적이면 
			// [선택된 페이지 번호]를 1로 하고 검색 행의 [시작행 번호]를 1로 하기
			//-------------------------------------------------
			if( contactListAllCnt<oracleAscStartRowNo ) { 
				contactSearchDTO.setSelectPageNo(  1 );
				oracleAscStartRowNo = 1; 
			}

			//-------------------------------------------------
			// [선택 페이지 번호]에 대응하는 오라클 검색 결과물 행의 [내림차순 시작번호] 얻기 
			//-------------------------------------------------
			int oracleDescStartRowNo = contactListAllCnt - oracleAscStartRowNo + 1;
			
			//-------------------------------------------------
			// [ContactServiceImpl 객체]의 메소드 호출로 [검색한 연락처 목록] 얻기
			//-------------------------------------------------
			List<Map<String, String>>  contactList = this.contactService.getContactList( contactSearchDTO );
			//-------------------------------------------------
			// ModelAndView 객체에 [검색한 연락처 총 개수], [검색한 연락처 목록]을 저장하기.
			// ModelAndView 객체에 저장된 데이터는 호출할 JSP 에서 꺼내어 HTML 코딩과 어울리게 된다.
			//-------------------------------------------------
			mav.addObject("contactListAllCnt",contactListAllCnt);
			mav.addObject("contactList",contactList);	
			mav.addObject("oracleAscStartRowNo",oracleAscStartRowNo);	
			mav.addObject("oracleDescStartRowNo",oracleDescStartRowNo);	
			//-------------------------------------------------
			// [ContactSearchDTO 객체]의 print_info( ) 메소드 호출하여
			// ContactSearchDTO 객체의 속성변수에 저장된 데이터를 도스창에 출력하기.
			// <주의>선택 페이지를 번호를 보정 한 후 출력해야 하므로 
			//       contactSearchDTO.updateDTO( contactListAllCnt ); 메소드 호출 후 코딩한다.
			//       개발자를 위한 코딩이므로 프로젝트 완료 후 성 후 주석 처리한다.
			//-------------------------------------------------
			//contactSearchDTO.print_info( );			
		}catch(Exception ex){
			//-------------------------------------------------
			// 예외 발생 시 실행할 코딩 설정.
			//-------------------------------------------------
			System.out.println("ContactController.contactSearchProc 메소드 호출 시 에러발생");	
		}
		return mav;
	}
	

	//**************************************************************************
	// 가상주소 /erp/contactSearchProc.do 로 접속하면 호출되는 메소드 선언.
	//**************************************************************************
	@RequestMapping(value="/contactSearchForm2.do")
	public  ModelAndView contactSearchForm2(
			//-----------------------------------------------------
			// 모든 파라미터값이 저장된 [ContactSearchDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// [파라미터명]과 [ContactSearchDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
				//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
				//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
				//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
				// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
				//-----------------------------------------------------
			@ModelAttribute("contactSearchDTO") ContactSearchDTO contactSearchDTO 
	){	
		System.out.println("~~~~~~~~~~~~~~");
		//-------------------------------------------------
		// ModelAndView 객체 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();	
		//-------------------------------------------------
		// ModelAndView 객체에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("contactSearchForm2");
		try{
			//-------------------------------------------------
			// [ContactServiceImpl 객체]의 메소드 호출로 [검색한 연락처 총 개수]를 얻기
			//-------------------------------------------------
			int  contactListAllCnt = this.contactService.getContactListAllCnt( contactSearchDTO );	
			//-------------------------------------------------
			// [선택 페이지 번호]에 대응하는 오라클 검색 결과물 행의 [오름차순 시작번호] 얻기 
			//-------------------------------------------------
			int oracleAscStartRowNo = contactSearchDTO.getSelectPageNo() * contactSearchDTO.getRowCntPerPage() 
										- contactSearchDTO.getRowCntPerPage()  + 1;

			//-------------------------------------------------
			// [선택된 페이지 번호]와 [총검색 개수]와의 관계가 비합리적이면 
			// [선택된 페이지 번호]를 1로 하고 검색 행의 [시작행 번호]를 1로 하기
			//-------------------------------------------------
			if( contactListAllCnt<oracleAscStartRowNo ) { 
				contactSearchDTO.setSelectPageNo(  1 );
				oracleAscStartRowNo = 1; 
			}

			//-------------------------------------------------
			// [선택 페이지 번호]에 대응하는 오라클 검색 결과물 행의 [내림차순 시작번호] 얻기 
			//-------------------------------------------------
			int oracleDescStartRowNo = contactListAllCnt - oracleAscStartRowNo + 1;
			
			//-------------------------------------------------
			// [ContactServiceImpl 객체]의 메소드 호출로 [검색한 연락처 목록] 얻기
			//-------------------------------------------------
			List<Map<String, String>>  contactList = this.contactService.getContactList( contactSearchDTO );
			//-------------------------------------------------
			// ModelAndView 객체에 [검색한 연락처 총 개수], [검색한 연락처 목록]을 저장하기.
			// ModelAndView 객체에 저장된 데이터는 호출할 JSP 에서 꺼내어 HTML 코딩과 어울리게 된다.
			//-------------------------------------------------
			mav.addObject("contactListAllCnt",contactListAllCnt);
			mav.addObject("contactList",contactList);	
			mav.addObject("oracleAscStartRowNo",oracleAscStartRowNo);	
			mav.addObject("oracleDescStartRowNo",oracleDescStartRowNo);			
		}catch(Exception ex){
			//-------------------------------------------------
			// 예외 발생 시 실행할 코딩 설정.
			//-------------------------------------------------
			System.out.println("ContactController.contactSearchForm2 메소드 호출 시 에러발생");	
		}
		return mav;
	}
	
	
	
	
	

	//**************************************************************************
	// 가상주소 /erp/contactSearchForm.do 로 접속하면 호출되는 메소드 선언.
	//**************************************************************************
		// [컨트롤러 클래스]의 메소드에 @ResponseBody 가 없고, @RequestMapping이 붙고
		// 메소드의 리턴형이 String 일 경우 리턴하는 문자열은 호출할 JSP 페이지명 이다. 
		//*****************************************************
	@RequestMapping(value="/contactRegForm.do")
	public String contactRegForm( ){
		return "contactRegForm";
	}	

	
	//**************************************************************************
	// /erp/contactRegProc.do 로 접근시 호출되는 메소드 선언
		// @ResponseBody 를 붙음으로 이 메소드가 리턴하는 데이터가 JSON으로 변경되어 클에게 전송된다.
	//**************************************************************************
	@RequestMapping(                       
			value = "/contactRegProc.do"                  //=>클의 접속 URL 설정
			, method=RequestMethod.POST                   //=>클이 파라미터를 보내는 방법은 post로 설정. 즉 post 방식으로 보낸 데이터만 받겠다는 의미
			, produces="application/json;charset=UTF-8"   //=>클이 응답받을 수 있는 데이터 형식과 문자셋 지정. 
	)
	@ResponseBody                                         //=>메소드의 리턴값을 JSON 으로 변경하여 클에게 전송하는 어노테이션 설정
	public ModelAndView insertContact(
			//-----------------------------------------------------
			// 모든 파라미터값이 저장된 [ContactDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// 파라미터명과 [DTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 파라미터값이 속성변수에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 DTO 객체의 키값이다.
				//-----------------------------------------------------
				// <주의>xxx 라는 파라미터명은 있고, 파라미터값이 없으면 속성변수에는 무조건 null 값이 저장된다. 
				// <주의>[파라미터명]은 있는데 [파라미터값]이 없을 경우 [DTO 객체]의 [속성변수]에는 무조건 null 값이 저장된다. 
				//       그러므로 속성변수의 자료형은 기본형이 아니어야한다. 즉 int 같은 기본형이면 null 값을 저장할 수 없어 에러가 발생한다.
				//		 에러를 피하려면 String 같은 객체형을 쓰던가 아니면 반드시 기본령 데이터가 파라미터값이어야한다.
				//-----------------------------------------------------
			@ModelAttribute("contactDTO") ContactDTO contactDTO 
			//-----------------------------------------------------
			// 웹 서버가 생성한 HttpServletRequest 객체를 저장한 매개변수 선언
			//-----------------------------------------------------
			, HttpServletRequest request 
	) {		
		//-------------------------------------------------
		// ModelAndView 객체 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();	
		//-------------------------------------------------
		// ModelAndView 객체에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("contactRegProc");	
		//-------------------------------------------------
		// 연락처 입력 적용 행의 개수 저장 변수 선언
		//-------------------------------------------------		
		int contactRegCnt = 0;
		try{	
			//-------------------------------------------------
			// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 입력]하고 [입력 행의 개수] 얻기
			//-------------------------------------------------
			contactRegCnt = this.contactService.insertContact(contactDTO);
			mav.addObject("contactRegCnt",contactRegCnt);	
		}catch(Exception ex){
			System.out.println( "ContactController.insertContact(~) 메소드 예외 발생!");
			mav.addObject("contactRegCnt",-1);	
		}
		return mav;
	}		
	

	//**************************************************************************
	// /erp/contactRegProc.do 로 접근시 호출되는 메소드 선언
		// @ResponseBody 를 붙음으로 이 메소드가 리턴하는 데이터가 JSON으로 변경되어 클에게 전송된다.
	//**************************************************************************
	@RequestMapping(                       
			value = "/contactRegProc2.do"                  //=>클의 접속 URL 설정
			, method=RequestMethod.POST                   //=>클이 파라미터를 보내는 방법은 post로 설정. 즉 post 방식으로 보낸 데이터만 받겠다는 의미
			, produces="application/json;charset=UTF-8"   //=>클이 응답받을 수 있는 데이터 형식과 문자셋 지정. 
	)
	@ResponseBody                                         //=>메소드의 리턴값을 JSON 으로 변경하여 클에게 전송하는 어노테이션 설정
	public int insertContact2(
			//-----------------------------------------------------
			// 모든 파라미터값이 저장된 [ContactDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// 파라미터명과 [DTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 파라미터값이 속성변수에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 DTO 객체의 키값이다.
				//-----------------------------------------------------
				// <주의>xxx 라는 파라미터명은 있고, 파라미터값이 없으면 속성변수에는 무조건 null 값이 저장된다. 
				// <주의>[파라미터명]은 있는데 [파라미터값]이 없을 경우 [DTO 객체]의 [속성변수]에는 무조건 null 값이 저장된다. 
				//       그러므로 속성변수의 자료형은 기본형이 아니어야한다. 즉 int 같은 기본형이면 null 값을 저장할 수 없어 에러가 발생한다.
				//		 에러를 피하려면 String 같은 객체형을 쓰던가 아니면 반드시 기본령 데이터가 파라미터값이어야한다.
				//-----------------------------------------------------
			@ModelAttribute("contactDTO") ContactDTO contactDTO 
			//-----------------------------------------------------
			// 웹 서버가 생성한 HttpServletRequest 객체를 저장한 매개변수 선언
			//-----------------------------------------------------
			, HttpServletRequest request 
	) {		
		//-------------------------------------------------
		// [contactDTO 객체]의 print_info( ) 메소드 호출하여
		// contactDTO 객체의 속성변수에 저장된 데이터를 도스창에 출력하기.
		// <주의>개발자를 위한 코딩이므로 프로젝트 완료 후 성 후 주석 처리한다.
		//-------------------------------------------------
		contactDTO.print_info( ); 
		//-------------------------------------------------
		// 연락처 입력 적용 행의 개수 저장 변수 선언
		//-------------------------------------------------		
		int contactRegCnt = 0;
		try{	
			//-------------------------------------------------
			// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 입력]하고 [입력 행의 개수] 얻기
			//-------------------------------------------------
			contactRegCnt = this.contactService.insertContact(contactDTO);
		}catch(Exception ex){
			System.out.println( "ContactController.insertContact(~) 메소드 예외 발생!");
			contactRegCnt = -1;
		}
		return contactRegCnt;
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	//**************************************************************************
	// 가상주소 /contactUpDelForm.do 로 접근시 호출되는 메소드 선언
	//**************************************************************************
	@RequestMapping(value="/contactUpDelForm.do", method=RequestMethod.POST )
	public ModelAndView contactUpDelForm(
		//-----------------------------------------------------
		// contact_no 라는 [파라미터명]의 [파라미터값]을 저장할 int 형 매개변수 선언
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
		@RequestParam( "contact_no" ) int contact_no
	){
		//-------------------------------------------------
		// ModelAndView 객체 생성하기
		//-------------------------------------------------
		ModelAndView mav = new ModelAndView();
		//-------------------------------------------------
		// ModelAndView 객체에 [호출 JSP 페이지명]을 저장하기
		//-------------------------------------------------
		mav.setViewName("contactUpDelForm");  
		try{
			//-----------------------------------
			// [ContactServiceImpl 객체]의 getContact 메소드 호출로 [수정/삭제할 연락처] 데이터 얻기
			//-----------------------------------
			ContactDTO contact = this.contactService.getContact( contact_no );
			//-----------------------------------
			// ModelAndView 객체에 호출 JSP 페이지에서 반영할 [수정/삭제할 연락처] 저장	
			//-----------------------------------
			mav.addObject("contact",contact);
			//-------------------------------------------------
			// [contactDTO 객체]의 print_info( ) 메소드 호출하여
			// contactDTO 객체의 속성변수에 저장된 데이터를 도스창에 출력하기.
			// <주의>개발자를 위한 코딩이므로 프로젝트 완료 후 성 후 주석 처리한다.
			//-------------------------------------------------
			if( contact!=null ){ contact.print_info(); }
		}catch(Exception ex){
			System.out.println( "ContactController.contactUpDelForm(~) 메소드 예외 발생!");
		}
		//-----------------------------------
		// ModelAndView 객체 리턴
		//----------------------------------- 
		return mav;
	}

	//**************************************************************************
	// /erp/contactUpDelProc.do 로 접근시 호출되는 메소드 선언
	//**************************************************************************
	@RequestMapping(                       
			value = "/contactUpDelProc.do"                  //=>클의 접속 URL 설정
			, method=RequestMethod.POST                   //=>클이 파라미터를 보내는 방법은 post로 설정. 즉 post 방식으로 보낸 데이터만 받겠다는 의미
	)
	public ModelAndView contactUpDelProc(
			//-----------------------------------------------------
			// 모든 파라미터값이 저장된 [ContactDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// 파라미터명과 [DTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 파라미터값이 속성변수에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 DTO 객체의 키값이다.
				//-----------------------------------------------------
				// <주의>xxx 라는 파라미터명은 있고, 파라미터값이 없으면 속성변수에는 무조건 null 값이 저장된다. 
				// <주의>[파라미터명]은 있는데 [파라미터값]이 없을 경우 [DTO 객체]의 [속성변수]에는 무조건 null 값이 저장된다. 
				//       그러므로 속성변수의 자료형은 기본형이 아니어야한다. 즉 int 같은 기본형이면 null 값을 저장할 수 없어 에러가 발생한다.
				//		 에러를 피하려면 String 같은 객체형을 쓰던가 아니면 반드시 기본령 데이터가 파라미터값이어야한다.
				//-----------------------------------------------------
			@ModelAttribute("contactDTO") ContactDTO contactDTO
			
			//-----------------------------------------------------
			// upDel 라는 파라미터명의 파라미터값을 저장할 String 형 매개변수 선언
			//-----------------------------------------------------
				//-----------------------------------------------------------------------------------------------------------------------
				// @RequestParam( value="파라미터명", required=true|false, ="디폴트값" )   자료형  파라미터값저장할매개변수명
				//-----------------------------------------------------------------------------------------------------------------------
					// [파라미터명]의 [파리미터값]을 [파라미터값저장할매개변수명]에 저장한다.
					// required=true           => 파라미터명이 없을 경우 에러발생. 메소드안의 코딩은 한줄도 실행 안된다. 생략 가능.
					// required=false          => 파라미터명이 없을 경우 null 값을 매개변수에 저장. 만약 매개변수 자료형이 기본형이면 에러 발생.
					// defaultValue="디폴트값" => 파라미터값이 없을 경우 디폴트값을 매개변수에 저장. required=false 가 있어야함. 
					//					  		 생략 시 매개변수에는 null 저장됨.
					//-----------------------------------------------------	
			,@RequestParam( value="upDel", required=false )   String upDel
	){	
		//------------------------------
		// ModelAndView 객체 생성하기
		//------------------------------
		ModelAndView mav = new ModelAndView();
		//------------------------------
		// ModelAndView 객체에 [호출 JSP 페이지명]을 저장하기
		//------------------------------
		mav.setViewName("contactUpDelProc");  
		
		//------------------------------
		// 수정 또는 삭제 실행 후 수정 또는 삭제 적용 행의 개수 저장 변수 선언
		//------------------------------
		int contactUpDelCnt = 0;
		try{
			/*//------------------------------
			// [ContactServiceImpl 객체]의 메소드 호출로 [수정/삭제할 연락처] 가져오기.
			// 이유는 다른 접속자가 삭제해 버릴 수 있기 때문에 [수정/삭제] 전에 가져와 본다.
			//------------------------------
			ContactDTO contactDTO2 = this.contactService.getContact( contactDTO.getContact_no( )   );
			//------------------------------
			// 만약 수정 또는 삭제할 [연락처 정보]가 있으면 연락처 수정 또는 삭제하고 적용 행의 개수 저장
			//------------------------------
			if( contactDTO2!=null ){
				if( upDel.equals("up") ){		
					//------------------------------
					// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 수정]한 후 적용행의 개수 얻기
					//------------------------------	
					contactUpDelCnt = this.contactService.updateContact( contactDTO  );
				}
				else{
					//------------------------------
					// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 삭제]한 후 적용행의 개수 얻기
					//------------------------------
					contactUpDelCnt = this.contactService.deleteContact( contactDTO.getContact_no( )  );
				}
			}*/

			//------------------------------
			// 연락처 수정 또는 삭제하고 적용 행의 개수 저장하기
			// 개수가 1 이상이면 수정/삭제 완료, 0개면 다른 사람이 이미 삭제했음을 의미함.
			//------------------------------
			if( upDel.equals("up") ){		
				//------------------------------
				// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 수정]한 후 적용행의 개수 얻기
				//------------------------------	
				contactUpDelCnt = this.contactService.updateContact( contactDTO  );
			}
			else{
				//------------------------------
				// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 삭제]한 후 적용행의 개수 얻기
				//------------------------------
				contactUpDelCnt = this.contactService.deleteContact( contactDTO.getContact_no( )  );
			}
			//------------------------------
			// ModelAndView 객체에 수정/삭제 적용행의 개수 생성하기
			//------------------------------
			mav.addObject("contactUpDelCnt",contactUpDelCnt);
		}catch(Exception ex){
			contactUpDelCnt = -1;
			System.out.println( "ContactController.contactUpDelProc(~) 메소드 예외 발생!");
		}  
		//------------------------------
		// ModelAndView 객체 리턴
		//------------------------------ 
		return mav;
	}
	
	//**************************************************************************
	// /erp/contactUpDelProc2.do 로 접근시 호출되는 메소드 선언
	//**************************************************************************
	@RequestMapping(                       
			value = "/contactUpDelProc2.do"                  //=>클의 접속 URL 설정
			, method=RequestMethod.POST                   //=>클이 파라미터를 보내는 방법은 post로 설정. 즉 post 방식으로 보낸 데이터만 받겠다는 의미
			, produces="application/json;charset=UTF-8"   //=>클이 응답받을 수 있는 데이터 형식과 문자셋 지정. 
	)
	@ResponseBody                                         //=>메소드의 리턴값을 JSON 으로 변경하여 클에게 전송하는 어노테이션 설정
	public int contactUpDelProc2(
			//-----------------------------------------------------
			// 모든 파라미터값이 저장된 [ContactDTO 객체]를 매개변수로 선언
			//-----------------------------------------------------
				// 파라미터명과 [DTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 파라미터값이 속성변수에 저장된다. 
				// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
				// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
				// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 DTO 객체의 키값이다.
				//-----------------------------------------------------
				// <주의>xxx 라는 파라미터명은 있고, 파라미터값이 없으면 속성변수에는 무조건 null 값이 저장된다. 
				// <주의>[파라미터명]은 있는데 [파라미터값]이 없을 경우 [DTO 객체]의 [속성변수]에는 무조건 null 값이 저장된다. 
				//       그러므로 속성변수의 자료형은 기본형이 아니어야한다. 즉 int 같은 기본형이면 null 값을 저장할 수 없어 에러가 발생한다.
				//		 에러를 피하려면 String 같은 객체형을 쓰던가 아니면 반드시 기본령 데이터가 파라미터값이어야한다.
				//-----------------------------------------------------
			@ModelAttribute("contactDTO") ContactDTO contactDTO
			
			//-----------------------------------------------------
			// upDel 라는 파라미터명의 파라미터값을 저장할 String 형 매개변수 선언
			//-----------------------------------------------------
				//-----------------------------------------------------------------------------------------------------------------------
				// @RequestParam( value="파라미터명", required=true|false, ="디폴트값" )   자료형  파라미터값저장할매개변수명
				//-----------------------------------------------------------------------------------------------------------------------
					// [파라미터명]의 [파리미터값]을 [파라미터값저장할매개변수명]에 저장한다.
					// required=true           => 파라미터명이 없을 경우 에러발생. 메소드안의 코딩은 한줄도 실행 안된다. 생략 가능.
					// required=false          => 파라미터명이 없을 경우 null 값을 매개변수에 저장. 만약 매개변수 자료형이 기본형이면 에러 발생.
					// defaultValue="디폴트값" => 파라미터값이 없을 경우 디폴트값을 매개변수에 저장. required=false 가 있어야함. 
					//					  		 생략 시 매개변수에는 null 저장됨.
					//-----------------------------------------------------	
			,@RequestParam( value="upDel", required=false )   String upDel
	){
		//------------------------------
		// 수정 또는 삭제 실행 후 수정 또는 삭제 적용 행의 개수 저장 변수 선언
		//------------------------------
		int contactUpDelCnt = 0;
		try{
			//------------------------------
			// 연락처 수정 또는 삭제하고 적용 행의 개수 저장하기
			// 개수가 1 이상이면 수정/삭제 완료, 0개면 다른 사람이 이미 삭제했음을 의미함.
			//------------------------------			
			if( upDel.equals("up") ){		
				//------------------------------
				// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 수정]한 후 적용행의 개수 얻기
				//------------------------------	
				contactUpDelCnt = this.contactService.updateContact( contactDTO  );
			}
			else{
				//------------------------------
				// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 삭제]한 후 적용행의 개수 얻기
				//------------------------------
				contactUpDelCnt = this.contactService.deleteContact( contactDTO.getContact_no( )  );
			}
		}catch(Exception ex){
			contactUpDelCnt = -1;
			System.out.println( "ContactController.contactUpDelProc2(~) 메소드 예외 발생!");
		}  
		//------------------------------
		// 수정 또는 삭제 적용 행의 개수 리턴
		//------------------------------ 
		return contactUpDelCnt;
	}
		


	//**************************************************************************
	// /erp/contactNoBank.do 로 접근시 호출되는 메소드 선언
	//**************************************************************************
	@RequestMapping(                       
		value = "/contactNoBank.do"             //=>클의 접속 URL 설정
		, method=RequestMethod.POST                   //=>클이 파라미터를 보내는 방법은 post로 설정. 즉 post 방식으로 보낸 데이터만 받겠다는 의미
		, produces="application/json;charset=UTF-8"   //=>클이 응답받을 수 있는 데이터 형식과 문자셋 지정. 
	)
	@ResponseBody                                     //=>메소드의 리턴값을 JSON 으로 변경하여 클에게 전송하는 어노테이션 설정
	public List<String> contactNoBank( 
			//-----------------------------------------
			// contact_no 라는 파라미터명의 파라미터값이 들어올 String 형 매개변수 선언
			//-----------------------------------------
			@RequestParam(value="contact_no", required=false,defaultValue="0" ) String contact_no
			,@RequestParam(value="flag") String flag
			//-----------------------------------------
			// [HttpSession 객체]가 들어올 매개변수 선언
			//-----------------------------------------
			, HttpSession session
	){
		//------------------------------
		// HttpSession 객체에서 contact_noList 란 키깂으로 저장된 List<String> 객체 꺼내기
		//------------------------------
		List<String> contact_noList = (List<String>)session.getAttribute("contact_noList");	
		try{					
			//------------------------------
			// 만약 flag 가 del 이면 List<String> 객체에 저장된 연락처 번호 삭제하기
			//------------------------------
			if( flag.equals("del")) {
				if( contact_noList!=null && contact_noList.size()>0  && contact_noList.indexOf(contact_no)>=0) {
					contact_noList.remove(contact_no);
				}
			}
			//------------------------------
			// 만약 flag 가 reg 이면 List<String> 객체에 연락처 번호 저장하기
			//------------------------------
			else if( flag.equals("reg")) {
				if( contact_noList==null ) {
					contact_noList = new ArrayList<String>();
					contact_noList.add(contact_no);
				}else {
					//---------------
					// List<String> 객체에 저장된 모든 연락처 번호 삭제하기
					//---------------
					// contact_noList.clear();
					//---------------
					// 만약  List<String> 객체에 연락처 번호가 없으면 저장하기
					//---------------
					if( contact_noList.indexOf(contact_no)<0 ) { 
						contact_noList.add(contact_no);
					}
				}
			}
			session.setAttribute( "contact_noList", contact_noList );
		}catch(Exception e){
			System.out.println( "contactNoBank 클래스에서 에러발생!" );
		}
		//****************************************************
		// 호출할  JSP 페이지명을 [ControllerAction 객체]에 문자열로 리턴하기 
		// [ControllerAction 객체]는 이 문자열에 해당하는 JSP 페이지를 호출한다.
		// 호출하는 JSP 페이지로 HttpServletRequest, HttpServletResponse, HttpSession 객체도 이동한다.
		//****************************************************
		//System.out.println("contact_noList=>"+contact_noList);
        return contact_noList;
	}
	

	//**************************************************************************
	// 현재 이 [컨트롤러 클래스] 내의 @RequestMapping 이 붙은 메소드 호출 시 예외발생하면 호출되는 메소드 선언
	//**************************************************************************
		// @ExceptionHandler(Exception.class) 를 붙여야하며
		// 리턴되는 문자열은 호출 JSP 페이지명이다.
	
	@ExceptionHandler(Exception.class)
	public String handleException( 
			HttpServletRequest request
	) {
		//--------------------------
		// HttpServletRequest 객체에 클라이언트의 URL 주소를 담기
		//--------------------------
		request.setAttribute( "msg", request.getRequestURL() );
		request.setAttribute( "info", Util.getRequsetInfo( request ) );
		//--------------------------
		// 호출할 error.jsp 페이지를 문자열오 리턴
		//--------------------------
		return "error";
	}	
	
	
}  // ContactController.java
//-------------------------------------------------------------------------------------------------------------
		
		////*****************************************************
		//// /erp/contactRegProc.do 로 접근시 호출되는 메소드 선언
		//	// @ResponseBody 를 붙음으로 이 메소드가 리턴하는 데이터가 JSON으로 변경되어 클에게 전송된다.
		////*****************************************************
		//@RequestMapping(                       
		//		value = "/contactRegProc.do"                  //=>클의 접속 URL 설정
		//		, method=RequestMethod.POST                   //=>클이 파라미터를 보내는 방법은 post로 설정. 즉 post 방식으로 보낸 데이터만 받겠다는 의미
		//		, produces="application/json;charset=UTF-8"   //=>클이 응답받을 수 있는 데이터 형식과 문자셋 지정. 
		//)
		//@ResponseBody                                         //=>메소드의 리턴값을 JSON 으로 변경하여 클에게 전송하는 어노테이션 설정
		//public int insertContact2(
		//		//-----------------------------------------------------
		//		// 모든 파라미터값이 저장된 [ContactDTO 객체]를 매개변수로 선언
		//		//-----------------------------------------------------
		//			// 파라미터명과 [DTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 파라미터값이 속성변수에 저장된다. 
		//			// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
		//			// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
		//			// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 DTO 객체의 키값이다.
		//			//-----------------------------------------------------
		//			// <주의>xxx 라는 파라미터명은 있고, 파라미터값이 없으면 속성변수에는 무조건 null 값이 저장된다. 
		//			// <주의>[파라미터명]은 있는데 [파라미터값]이 없을 경우 [DTO 객체]의 [속성변수]에는 무조건 null 값이 저장된다. 
		//			//       그러므로 속성변수의 자료형은 기본형이 아니어야한다. 즉 int 같은 기본형이면 null 값을 저장할 수 없어 에러가 발생한다.
		//			//		 에러를 피하려면 String 같은 객체형을 쓰던가 아니면 반드시 기본령 데이터가 파라미터값이어야한다.
		//			//-----------------------------------------------------
		//		@ModelAttribute("contactDTO") ContactDTO contactDTO 
		//		, HttpServletRequest request 
		//		//, MultipartHttpServletRequest request 
		//		//, @RequestParam("contact_img") MultipartFile mpf
		//) {		
		//	//-------------------------------------------------
		//	// 개발자를 위해 [contactDTO 객체]의 속성변수에 저장된 데이터를 도스창에 출력하기
		//	//-------------------------------------------------
		//	contactDTO.print_info( ); 
		//	//-------------------------------------------------
		//	// 연락처 이미지가 저장되는 경로 얻기
		//	//-------------------------------------------------
		//	String save_path  = request.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\");
		//	//-------------------------------------------------
		//	// 연락처 이미지 파일명 저장 변수선언하기.
		//	//-------------------------------------------------
		//	//String new_conact_img_name = null; MultipartFile mpf = contactDTO.getContact_img();
		//	//String xxx =  RandomStringUtils.randomAlphaNumeric(32);	
		//	//-------------------------------------------------
		//	// 연락처 입력 적용 행의 개수 저장 변수 선언
		//	//-------------------------------------------------		
		//	int contactRegCnt = 0;
		//	try{	
		//
		//		//-------------------------------------------------
		//		// MultipartFile 객체가 있으면, 즉 업로드된 파일이 있으면
		//		//-------------------------------------------------
		//		if( mpf!=null ){	
		//			//-------------------------------------------------
		//			// 연락처의 예정 PK값 얻기 
		//			//-------------------------------------------------
		//			int new_contact_no = this.contactService.getNewContact_no( );
		//			//-------------------------------------------------
		//			// 연락처 이미지의 새로운 파일명 만들기
		//			//-------------------------------------------------
		//			// 업로드된 파일의 원래 이름 얻기
		//			String upFileName = mpf.getOriginalFilename();
		//			// 업로드된 파일의 확장자 얻기
		//			String extension_name = FilenameUtils.getExtension(upFileName).toLowerCase(); 
		//				//String extension_name = upFileName.substring( upFileName.lastIndexOf(".")+1 );
		//			// 업로드된 파일의 새 파일명 만들기
		//			new_conact_img_name = new_contact_no+"."+extension_name;
		//			//-------------------------------------------------
		//			// 연락처 이미지의 새로운 파일명을 ContactDTO 객체에 저장하기
		//			//-------------------------------------------------
		//			contactDTO.setContact_img_name( new_conact_img_name );				
		//			//-------------------------------------------------
		//			// MultipartFile 객체가 소유한 [연락처 이미지]를 새로운 이름으로 서버의 폴더에 저장하기
		//			//-------------------------------------------------			
		//			mpf.transferTo(  new java.io.File(save_path+"\\"+new_conact_img_name)  );
		//		}
		//		//-------------------------------------------------
		//		// [ContactServiceImpl 객체]의 메소드 호출로 [연락처 입력]하고 [입력 행의 개수] 얻기
		//		//-------------------------------------------------
		//		contactRegCnt = this.contactService.insertContact(contactDTO);
		//	}catch(Exception ex){
		//		System.out.println( "ContactController.insertContact(~) 메소드 예외 발생!");
		//		//-------------------------------------------------
		//		// 예외 발생 시 업로드된 파일이 있으면 지우기
		//		//-------------------------------------------------
		//		if( mpf!=null ){	
		//			java.io.File file = new java.io.File( save_path+"\\"+new_conact_img_name );
		//			if( file.exists() ){ file.delete(); }
		//		}
		//		contactRegCnt = -1;
		//	}
		//	return contactRegCnt;
		//}	
		
		
		
		
		/*
		//*****************************************************
		// /erp/contactRegProc.do 로 접근시 호출되는 메소드 선언
		//*****************************************************
		@RequestMapping(value = "/contactRegProc.do",  method=RequestMethod.POST)
		public ModelAndView insertContact(
				//-----------------------------------------------------
				// 파라미터값을 저장할 [ContactDTO 객체]를 매개변수로 선언
				//-----------------------------------------------------
					// 파라미터명과 [DTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 파라미터값이 속성변수에 저장된다. 
					// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
					// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
					// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 DTO 객체의 키값이다.
					//-----------------------------------------------------
					// <주의>xxx 라는 파라미터명은 있고, 파라미터값이 없으면 속성변수에는 무조건 null 값이 저장된다. 
					// <주의>[파라미터명]은 있는데 [파라미터값]이 없을 경우 [DTO 객체]의 [속성변수]에는 무조건 null 값이 저장된다. 
					//       그러므로 속성변수의 자료형은 기본형이 아니어야한다. 즉 int 같은 기본형이면 null 값을 저장할 수 없어 에러가 발생한다.
					//		 에러를 피하려면 String 같은 객체형을 쓰던가 아니면 반드시 기본령 데이터가 파라미터값이어야한다.
					//-----------------------------------------------------
				@ModelAttribute("contactDTO") ContactDTO contactDTO 
				, HttpServletRequest request 
				//, MultipartHttpServletRequest request 
				//, @RequestParam("contact_img") MultipartFile mpf
		) {		
			System.out.println("<C1>");
			//-------------------------------------------------
			// 개발자를 위해 [contactDTO 객체]의 속성변수에 저장된 데이터를 도스창에 출력하기
			//-------------------------------------------------
			contactDTO.print_info( );
			//-------------------------------------------------
			// ModelAndView 객체 생성하기
			//-------------------------------------------------
			ModelAndView mav = new ModelAndView();	
			//-------------------------------------------------
			// ModelAndView 객체에 [호출 JSP 페이지명]을 저장하기
			//-------------------------------------------------
			mav.setViewName("contactRegProc");  
			//-------------------------------------------------
			// 연락처 이미지가 저장되는 경로 얻기
			//-------------------------------------------------
			String save_path 
				= request.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\");
			//-------------------------------------------------
			// 연락처 이미지 파일명 저장 변수선언하기.
			//-------------------------------------------------
			String new_conact_img_name = null;
			MultipartFile mpf = contactDTO.getContact_img();
			//String xxx =  RandomStringUtils.randomAlphaNumeric(32);
			try{	
		
				//-------------------------------------------------
				// MultipartFile 객체가 있으면, 즉 업로드된 파일이 있으면
				//-------------------------------------------------
				if( mpf!=null ){	
					//-------------------------------------------------
					// 연락처의 예정 PK값 얻기 
					//-------------------------------------------------
					int new_contact_no = this.contactService.getNewContact_no( );
					//-------------------------------------------------
					// 연락처 이미지의 새로운 파일명 만들기
					//-------------------------------------------------
					// 업로드된 파일의 원래 이름 얻기
					String upFileName = mpf.getOriginalFilename();
					// 업로드된 파일의 확장자 얻기
					String extension_name = FilenameUtils.getExtension(upFileName).toLowerCase(); 
		
					String extension_name = upFileName.substring(
							upFileName.lastIndexOf(".")+1
					);
					
					// 업로드된 파일의 새 파일명 만들기
					new_conact_img_name = new_contact_no+"."+extension_name;
					//-------------------------------------------------
					// 연락처 이미지의 새로운 파일명을 ContactDTO 객체에 저장하기
					//-------------------------------------------------
					contactDTO.setContact_img_name( new_conact_img_name );
					//System.out.println("new_conact_img=>"+new_conact_img);
					System.out.println("<C2>");
					
					//-------------------------------------------------
					// MultipartFile 객체가 소유한 연락처 이미지를 새로운 이름으로 서버의 폴더에 저장하기
					//-------------------------------------------------			
					mpf.transferTo(  new java.io.File(save_path+"\\"+new_conact_img_name)  );
					System.out.println("<C3>");
				}
				//-------------------------------------------------
				// [ContactServiceImpl 객체]의 메소드 호출로 연락처 입력하고 [입력 행의 개수] 얻기
				//-------------------------------------------------
				int contactRegCnt = this.contactService.insertContact(contactDTO);
				//-------------------------------------------------
				// ModelAndView 객체에 호출 JSP 페이지에서 반영할 [입력 행의 개수] 저장	
				//-------------------------------------------------
				mav.addObject("contactRegCnt",contactRegCnt);
			}catch(Exception ex){
				System.out.println("<C4>");
				if( mpf!=null ){	
					java.io.File file = new java.io.File( save_path+"\\"+new_conact_img_name );
					if( file.exists() ){
						file.delete();
					}
				}
				mav.addObject("contactRegCnt",-1);
				System.out.println( "ContactController.insertContact(~) 메소드 예외 발생!");
			}
			//-----------------------------------
			// ModelAndView 객체 리턴
			//----------------------------------- 
			return mav;
		}		
		*/
		
		/*
		//*****************************************************
		// 가상주소 /contactUpDelForm3.do 로 접근시 호출되는 메소드 선언
		//*****************************************************
		@RequestMapping(value="/contactUpDelForm3.do", method=RequestMethod.POST )	
		@ResponseBody 
		public ContactDTO contactUpDelForm3(
			//-----------------------------------------------------
			// contact_no 라는 [파라미터명]의 [파라미터값]을 저장할 int 형 매개변수 선언
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
			@RequestParam( "contact_no" ) int contact_no
		){
			//-----------------------------------
			// [수정/삭제할 연락처] 를 저장할 변수 선언
			//-----------------------------------
			ContactDTO contactDTO = null;
			try{
				//-----------------------------------
				// [ContactServiceImpl 객체]의 getContact 메소드 호출로 [수정/삭제할 연락처] 데이터 얻기
				//-----------------------------------
				contactDTO = this.contactService.getContact( contact_no );
				//-----------------------------------
				// ContactDTO 객체의 속성변수 데이터 도스창에 출력하기
				//-----------------------------------
				if( contactDTO!=null ){ contactDTO.print_info(); }
			}catch(Exception ex){
				System.out.println( "ContactController.contactUpDelForm(~) 메소드 예외 발생!");
				contactDTO = null;
			}
			return contactDTO;
		}
		*/
		
		/*
		@RequestMapping("/redirect")
		public String redirect(@RequestParam("url") String url) {
		    return "redirect:" + url;
		} 
		*/
		
		




/*
//**************************************************************************
// 가상주소 /erp/contactSearchForm2.do 로 접속하면 호출되는 메소드 선언.
//**************************************************************************
	// [컨트롤러 클래스]의 메소드에 @ResponseBody 가 없고, @RequestMapping이 붙고
	// 메소드의 리턴형이 String 일 경우 리턴하는 문자열은 호출할 JSP 페이지명 이다. 
	//*****************************************************
@RequestMapping(value="/contactSearchForm2.do")
public String contactSearchForm2(  ){
	return "contactSearchForm2";
}

//**************************************************************************
// 가상주소 /erp/contactSearchProc2.do 로 접속하면 호출되는 메소드 선언.
//**************************************************************************
	// [컨트롤러 클래스]의 메소드에 @ResponseBody 가 있고, @RequestMapping이 있으면
	// 메소드의 리턴 데이터가 바로 클라이언트에게 전송된다.
	// 클라이언트는 JSON 형태로 받게된다.
	//*****************************************************
@RequestMapping(value="/contactSearchProc2.do")
@ResponseBody
public  Map<String,Object> contactSearchProc2(
		//-----------------------------------------------------
		// 모든 파라미터값이 저장된 [ContactSearchDTO 객체]를 매개변수로 선언
		//-----------------------------------------------------
			// [파라미터명]과 [ContactSearchDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
			// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
			// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
			//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
			//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
			//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
			// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
			// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
			// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
			//-----------------------------------------------------
		@ModelAttribute("contactSearchDTO") ContactSearchDTO contactSearchDTO 
){	
	Map<String,Object> map = new HashMap<String,Object>();
	try{
		//-------------------------------------------------
		// [ContactServiceImpl 객체]의 getContactListAllCnt(~) 메소드 호출로 [검색한 연락처 총 개수]를 얻기
		//-------------------------------------------------
		int  contactListAllCnt = this.contactService.getContactListAllCnt( contactSearchDTO );	
		//-------------------------------------------------
		// [검색한 연락처 총 개수]에 따라 달라지는 기존 [선택한 페이지 번호]를 보정하기.
		// [선택한 페이지 번호]에 따른 시작행 번호 구하기.
		//-------------------------------------------------
		//contactSearchDTO.updateDTO( contactListAllCnt );
		//-------------------------------------------------
		// [ContactServiceImpl 객체]의 메소드 호출로 [검색한 연락처 목록] 얻기
		//-------------------------------------------------
		List<Map<String, String>>  contactList = this.contactService.getContactList( contactSearchDTO );
		//-------------------------------------------------
		// ModelAndView 객체에 [검색한 연락처 총 개수], [검색한 연락처 목록]을 저장하기.
		// ModelAndView 객체에 저장된 데이터는 호출할 JSP 에서 꺼내어 HTML 코딩과 어울리게 된다.
		//-------------------------------------------------
		map.put("contactListAllCnt",contactListAllCnt);
		map.put("contactList",contactList);	
		//-------------------------------------------------
		// [ContactSearchDTO 객체]의 print_info( ) 메소드 호출하여
		// ContactSearchDTO 객체의 속성변수에 저장된 데이터를 도스창에 출력하기.
		// <주의>선택 페이지를 번호를 보정 한 후 출력해야 하므로 
		//       contactSearchDTO.updateDTO( contactListAllCnt ); 메소드 호출 후 코딩한다.
		//       개발자를 위한 코딩이므로 프로젝트 완료 후 성 후 주석 처리한다.
		//-------------------------------------------------
		contactSearchDTO.print_info( );			
	}catch(Exception ex){
		System.out.println("ContactController.contactSearchForm 메소드 호출 시 에러발생");		
		map = null;	
	}
	//-------------------------------------------------
	// [검색한 연락처 총 개수], [검색한 연락처 목록]가 저장된 Map<String,Object> 객체 리턴
	// @ResponseBody 가 있으므로 리턴한 데이터가  클라이언트에게 JSON 형태로 전송된다.
	//-------------------------------------------------
	return map;
}

//**************************************************************************
// 가상주소 /erp/contactSearchForm.do 로 접속하면 호출되는 메소드 선언.
//**************************************************************************
@RequestMapping(value="/contactSearchForm3.do")
public ModelAndView contactSearchForm3(
		//-----------------------------------------------------
		// 모든 파라미터값이 저장된 [ContactSearchDTO 객체]를 매개변수로 선언
		//-----------------------------------------------------
			// [파라미터명]과 [ContactSearchDTO 객체]의 [속성변수명]이 같으면 setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다. 
			// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다. 
			// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면 [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다. 
			//		이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
			//		이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
			//		이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
			// 매개변수로 들어온 [DTO 객체]는 호출되는 JSP 페이지로 그대로 이동한다.
			// 매개변수 앞의 @ModelAttribute("xxx") 는 호출되는 JSP 페이지로  이동하는 [DTO 객체]의 키값이다.
			// 매개변수 앞의 @ModelAttribute("xxx") 가 없으면 [DTO 객체]의 시작문자를 소문자로 고친 단어가 키값이다.
			//-----------------------------------------------------
		@ModelAttribute("contactSearchDTO") ContactSearchDTO contactSearchDTO 
){
	//-------------------------------------------------
	// ModelAndView 객체 생성하기
	//-------------------------------------------------
	ModelAndView mav = new ModelAndView();	
	//-------------------------------------------------
	// ModelAndView 객체에 [호출 JSP 페이지명]을 저장하기
	//-------------------------------------------------
	mav.setViewName("contactSearchForm3");	
	try{
		//-------------------------------------------------
		// [ContactServiceImpl 객체]의 메소드 호출로 [검색한 연락처 총 개수]를 얻기
		//-------------------------------------------------
		int  contactListAllCnt = this.contactService.getContactListAllCnt( contactSearchDTO );	
		//-------------------------------------------------
		// [검색한 연락처 총 개수]에 따라 달라지는 기존 [선택한 페이지 번호]를 보정하기.
		// [선택한 페이지 번호]에 따른 시작행 번호 구하기.
		//-------------------------------------------------
		//contactSearchDTO.updateDTO( contactListAllCnt );
		//-------------------------------------------------
		// [ContactServiceImpl 객체]의 메소드 호출로 [검색한 연락처 목록] 얻기
		//-------------------------------------------------
		List<Map<String, String>>  contactList = this.contactService.getContactList( contactSearchDTO );
		//-------------------------------------------------
		// ModelAndView 객체에 [검색한 연락처 총 개수], [검색한 연락처 목록]을 저장하기.
		// ModelAndView 객체에 저장된 데이터는 호출할 JSP 에서 꺼내어 HTML 코딩과 어울리게 된다.
		//-------------------------------------------------
		mav.addObject("contactListAllCnt",contactListAllCnt);
		mav.addObject("contactList",contactList);	
		//-------------------------------------------------
		// [ContactSearchDTO 객체]의 print_info( ) 메소드 호출하여
		// ContactSearchDTO 객체의 속성변수에 저장된 데이터를 도스창에 출력하기.
		// <주의>선택 페이지를 번호를 보정 한 후 출력해야 하므로 
		//       contactSearchDTO.updateDTO( contactListAllCnt ); 메소드 호출 후 코딩한다.
		//       개발자를 위한 코딩이므로 프로젝트 완료 후 성 후 주석 처리한다.
		//-------------------------------------------------
		contactSearchDTO.print_info( );			
	}catch(Exception ex){
		System.out.println("ContactController.contactSearchForm3 메소드 호출 시 에러발생");			
	}
	//-----------------------------------
	// ModelAndView 객체 리턴
	//----------------------------------- 
	return mav;
}

*/



































































