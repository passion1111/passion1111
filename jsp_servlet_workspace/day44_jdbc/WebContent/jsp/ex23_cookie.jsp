<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
 
<!-- 클라이언트영역-쿠키    <--처음부터있는거아님 응답할떄 감.
	서버영역-세션
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie를 이용한 한글처리 </title>
</head>
<body>
<!-- win7-C:\Users\5CLASS-184\AppData\Roaming\Microsoft\Windows\Cookies    --><br/>
<%
Cookie cookie=new Cookie("newName",URLEncoder.encode("강감찬","UTF-8"));
//cookie.setMaxAge(0);//사용기간을 0으로 만들면 <--서버 나오자마자 소멸
cookie.setMaxAge(60);//60초동안 살아있어라.   30일이면(30*24*60*60) 일 시 분 초

//Client 브라우저에게 Cookie전달 심어놓는다.
response.addCookie(cookie);
%><hr>
한글 쿠키값 읽기
<hr>
서버도메인 이름:<%cookie.getDomain(); %><br/>
서버에서 설정 이름:<%cookie.getName(); %><br/>
서버에서 설정 값:<%cookie.getValue(); %><br/>
<%
	//client쿠키정보 얻어오기.
	Cookie[] cs=request.getCookies();
	if(cs!=null||cs.length>0){
	for(int i=0;i<cs.length;i++){
		if(cs[i].getName().equals("newName")){
			//재설정
			Cookie x=new Cookie("newName","3333");
			response.addCookie(x);
		}
		
	}
	}else{
		out.print("client 저장된 쿠키 정보가 없습니다.");
		
	}
%>

</body>
</html>