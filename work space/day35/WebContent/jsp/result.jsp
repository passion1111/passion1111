<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("id") ;
String pw=request.getParameter("passowrd");
String name=request.getParameter("name");
out.print(id+"아이디 비밀번호"+pw+"이름"+name);
%>
</body>
</html>