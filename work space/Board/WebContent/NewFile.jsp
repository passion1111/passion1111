<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 만들고</title>
<%
	
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String regdate=request.getParameter("regdate");
	String content=request.getParameter("content");
	int count=9999;
	
%>

</head>
<body>
	<h1>게시글</h1>
	<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>날짜</th>
		<th>날짜</th>
		<th>조회수</th>
		</tr>
	<tr>
		<td>1</td>
		<td><%=title %></td>
		<td><%=writer %></td>
		<td><%=regdate %></td>
		<td><%=count %></td>
	</tr>
	</table>
	</body>
	</html>

	
	