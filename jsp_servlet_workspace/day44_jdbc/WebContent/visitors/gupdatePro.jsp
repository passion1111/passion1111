<%@page import="edu.bit.visitors.BookDAO"%>
<%@page import="edu.bit.visitors.BookVO"%>
<%@page import="dbconnection.ConnectionHelper1"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
<jsp:useBean id="vo" class="edu.bit.visitors.BookVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>
</head>
<body>
<%
		Connection conn=BookDAO.loadOracleDriver();
		BookDAO.update(conn, vo);

%>
</body>
</html>