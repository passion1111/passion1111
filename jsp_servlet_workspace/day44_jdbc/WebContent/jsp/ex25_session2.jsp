<!-- ex24_session.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.* , java.text.*" %>

<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>Session info</title>
</head>
<body>
<%
/*
	application.setAttribute("count", 0);
	//count(전역변수:서버에 접속한 브라우저(clinet)가 공유하는 자원)
	session.setAttribute("id", "kingsmile");
	//id는 sessionid에 고유하게 부여하는 변수
	//웹서버에 접속한 사용자의 고유한 정보:loginID,shopping cart 활용 데이터 application
*/
%>
<h3>세션 정보</h3>
서버가 고유한 고유 ID:<%=session.getId() %><hr>
<%
	session.setAttribute("id", "happy");
	session.setAttribute("login", "Fail");
%>
<h3>세션 변수값 읽어오기</h3>
<%
	String id=(String)session.getAttribute("id");
	String login=(String)session.getAttribute("login");
%><hr>
ID:<%=id %><br>
Login:<%=login %><hr>

<%
	//sessionID삭제하기
	session.invalidate();
	

%>
</body>
</html>
















