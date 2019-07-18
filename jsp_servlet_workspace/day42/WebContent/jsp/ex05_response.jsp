<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response object</title>
</head>
<body>
	일반 request:<%= 100_200+300 %><br/>
	Redirect:<%
	   //클라이언트 브라우저에게 ex01.jsp를 재요청하도록 명령한다.
	   out.print("d");
	response.sendRedirect("ex01.jsp"); //원래주소를 잃어버림.
	
	%>
</body>
</html>