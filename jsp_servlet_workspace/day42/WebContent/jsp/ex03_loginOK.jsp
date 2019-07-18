<!-- ex03_loginOK.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%
	/* 1.한글처리
	method = "post"
	request.setCharacterEncoding("euc-kr");

	2.한글처리
	method = "get"
	URL
	http://localhost:8080/day42_jsp/jsp/ex03_loginOK.jsp?userId=han4ram&pwd=dddd&hobby=baseball&hobby=soccer
	
    <Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" reloadable="true"/>
	 */
	 
	 String id = request.getParameter("userId");
	 String pwd = request.getParameter("pwd");
	 
/* 	 String[] hobby = request.getParameterValues("hobby"); */ //여러개 가져올떄
	Map map=request.getParameterMap();         //이것도 여러개 가져올떄.
	String[]hobby=(String[])map.get("hobby");
%>

당신의 id : <%= id %> <br>
당신의 pasword : <%= pwd %> <br>

<%
	if( hobby != null ) {
		for(int i=0; i < hobby.length; i++) {
%>			
	
		<%= hobby[i] %>
			
<%			
		} // end for
	} //end if
%>
</body>
</html>














