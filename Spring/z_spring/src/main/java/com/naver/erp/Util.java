package com.naver.erp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// [BoardDAO 인터페이스] 선언
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm Util.getRequsetInfo( request )
public class Util {
	//***************************************************** 
	// 클라이언트에게 보낼 쿠키 생성하여 저장하기
	//***************************************************** 
	public static void  addCookie( 
			HttpServletResponse response
			, String  cookieName 
			, String  cookieVal
			, int  cookieLifetime
	) {
		Cookie cookie1 = new Cookie( cookieName, cookieVal );
		cookie1.setMaxAge( cookieLifetime ); 
		response.addCookie( cookie1 );
	}
		
	//***************************************************** 
	// [HttpServletRequest객체에 저장된 모든 파라미터명과 파라미터값을 html 태그 문자열]로 리턴하는 메소드 선언
	//***************************************************** 
	public static String  getRequsetInfo( HttpServletRequest  request ) {
		//----------------------------------------
		// 모든 파라미터명과 파라미터값을 저장할 List<Map<String,String[]>> 객체 생성
		//----------------------------------------
		List<Map<String,String[]>> list = new ArrayList();
		//----------------------------------------
		// 클라이언트에서 전송되어 온 모든 파라미터명을 관리하는 Enumeration 객체 생성
		//----------------------------------------
		Enumeration xxx = request.getParameterNames() ;
		//----------------------------------------
		StringBuffer sb = new StringBuffer();
		sb.append( "<table border=1 cellpadding=5>" );
		sb.append( "<tr bgcolor=gray><th>번호<th>파라미터명<th>파라미터값" );
		int cnt = 0;
		while( xxx.hasMoreElements() ) {
			String paramN = (String)xxx.nextElement();
			String[] values = request.getParameterValues(paramN);
			Map<String,String[]> map = new HashMap<String,String[]>( );
			map.put( paramN, values );
			list.add( map );
			//----------------------------
			String tmp1 = "\\&nbsp;";
			for( String tmp2 : values ){
				tmp1 = tmp1 + " " + tmp2;
			}
			if( values==null) tmp1 = tmp1 + "없음";
			//if( values==null || values.length==0 || (values.length==1 && values[0].length()==0) ) tmp1 = tmp1 + "없음";
			sb.append( "<tr><th>" +  ++cnt );
			sb.append( "<td>"+ paramN );
			sb.append( "<td>"+ tmp1.substring(1) );
			//sb.append( "<td>"+ values.length );
		}
		sb.append( "</table>" );
		return sb.toString();
	}
}