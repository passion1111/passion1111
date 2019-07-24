<!-- loginPro.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="edu.bit.member.*" %>
<%@ page import="java.sql.Timestamp" %>

<jsp:useBean id="vo" class="edu.bit.member.MemberVO" />
<jsp:setProperty property="*" name="vo"/>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = MemberDAO.getInstance();
	int check = dao.userCheck(id, pwd);
	
	if( check == 1 ) {
		session.setAttribute("memID", id); // name(key), value
		response.sendRedirect("main.jsp");
	} else if( check == 0 ) {
%>
	<script type="text/javascript">
	<!--
		alert("아이디 또는 비밀번호 틀렸습니다.");
		history.go(-1);
	//-->
	</script>

<%	} else { %>	

	<script type="text/javascript">
	<!--
		alert("아이디 또는 비밀번호 틀렸습니다.");
		history.go(-1);
	//-->
	</script>
	
		
<%	}// if end%>
	


<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>가입 메세지 출력</title>
</head>
<body>

</body>
</html>








