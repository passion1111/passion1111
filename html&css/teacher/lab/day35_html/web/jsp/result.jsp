<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송 결과 확인 페이지</title>
</head>
<body>
  <%
  	request.setCharacterEncoding("utf-8");
  	String name = request.getParameter("name");	
  	String passwd = request.getParameter("pwd");
  	
  	out.print(name +"님 비번은 : " + passwd);
  %>
</body>
</html>