<!-- ex04_emp.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="edu.bit.ex04.*" %>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%
	Emp e = new Emp();
	e.setEmpno(7788);
	e.setName("길동아");
	e.setPay(10000);
	
	int num = 999;

%>

 외부 package에 있는 클래스 객체 사용<br />
 <%= e.toString() %> <br />
 <%= e.getName() %> <br />
 <%= 1 + 2+ 3 %> <br />
 <%= num %>
</body>
</html>















