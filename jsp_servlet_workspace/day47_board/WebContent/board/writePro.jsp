<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,edu.bit.board.*" %>
<% request.setCharacterEncoding("UTF-8"); %>


<jsp:useBean id="vo" class="edu.bit.board.BoardVO"></jsp:useBean>
<<jsp:setProperty property="*" name="vo"/>




<%
	vo.setReg_date(new Timestamp(System.currentTimeMillis()));
	vo.setIp(request.getRemoteAddr());// ip주소 얻게해주는 아이
	
	BoardDAO dao=BoardDAO.getInstance();
	dao.insert(vo);
	
	response.sendRedirect("list.jsp");

%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>

</body>
</html> -->