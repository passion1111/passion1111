<%@page import="edu.bit.visitors.BookDAO"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초간단 방명록 </title>
</head>
<jsp:useBean id="vo" class="edu.bit.visitors.BookVO"/>
<jsp:setProperty property="*" name="vo"/>
<body>
<%
	Connection conn=BookDAO.loadOracleDriver();
	BookDAO.insert(conn, vo);
%>

<p>감사합니다 성공적으로 등록 됐습니다.</p>
<p>방명록 읽기 위해서는 <a href="greadForm.jsp">목록보기 </a>를 클릭하세요 <br>
</p><p>글 쓰고 싶어요<a href="gwriteForm.jsp">글쓰기</a>를 클릭하세요.
</body>
</html>