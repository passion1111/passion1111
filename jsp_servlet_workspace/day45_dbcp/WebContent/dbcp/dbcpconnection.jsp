<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP connection poll 예제</title>
</head>
<body>
<%
	try{
		Context initCtx=new InitialContext();
		Context envCtx=(Context)initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource)envCtx.lookup("jdbc:dbcpTestDB");
	
		Connection conn=ds.getConnection();
		
		out.println("DBCP Connection<br><br>");
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>