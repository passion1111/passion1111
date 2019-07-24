<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="edu.bit.member.*" %>
<%@ include file="../view/color.jsp" %>
<%request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="vo" class="edu.bit.member.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>


<%
	String id=(String)session.getAttribute("memID");
	vo.setId(id);

	MemberDAO.getInstance().update(vo);
	/*
	MemberDAO dao=MemberDAO.getInstance();
	dao.update(vo);
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../view/mystyle.css" rel="stylsheet" type="text/css" >
<title>gogo</title>
</head>
<body>
<table width="270" border="0" cellpadding="5" align="center">
	<tr bgcolor="<%=value_c%>">
	<td height="39" align="center">
		<fornt size="2">회원 정보가 수정됐습니다.</fornt>
	</td>
	</tr>
	
		<tr>
	<td height="39" align="center">
		<fornt size="2">입력하신내용이 수정완료됐습니다.</fornt>
	</td>
	</tr>
	
		<tr>
	<td height="39" align="center">
		<form>
			<input type="button" value=메인으로" onclick="window.location='main.jsp'">
			5초후에 메인으로 이동합니다.
			<meta http-equiv="Refresh" content="5; url=main.jsp">
		</form>
	</td>
	</tr>
	


</table>
</body>
</html>