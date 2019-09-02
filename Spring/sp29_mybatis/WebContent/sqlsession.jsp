<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.bit.dao.*,java.util.List,kr.bit.service.SqlMapClient" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sqlsession설정파일 부르기.</title>
</head>
<body>
	<%
		SqlSession sqlSession=SqlMapClient.getSqlSession();
		Emp2 emp2=sqlSession.selectOne("EMP2.emp22","나한라");
		out.print(emp2.getEmpno());
		out.print("<br>여러줄처리하기</br>");
		List<Emp2>listmap=sqlSession.selectList("EMP2.selectall");
		for(Emp2 e :listmap){
			out.print(e.getEmpno()+"<br>");
		}
	%>
</body>
</html>