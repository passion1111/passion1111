<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="edu.bit.member.*" %>
<%@ page import="java.sql.Timestamp" %>

<% request.setCharacterEncoding("utf-8"); %>


<jsp:useBean id="vo" class="edu.bit.member.MemberVO" />
<jsp:setProperty name="vo" property="*" />   <!-- getpropert는 필드당받아와야함. -->

<%
	vo.setReg_date(new Timestamp(System.currentTimeMillis()));
	MemberDAO dao = MemberDAO.getInstance(); //연결
	dao.insert(vo);
%>

<jsp:getProperty property="name" name="vo"/> 님의 회원 가입을 축하합니다.
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입 메세지 출력</title>
</head>
<body>
 <form action="memberList.jsp">
 	<input type="submit" value="회원 목록 보기" >
 </form>
</body>
</html>



