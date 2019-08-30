<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set  var="path" value="${ pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
</head>
<body>
 <%-- 
     <%= request.getContextPath() %> <br>
     <%=request.getRequestURL() %> <br>
     <%= application.getContextPath() %> <br>    
     <%= request.getServletPath() %><p>
  
     <%= pageContext.getServletContext().getContextPath() %><p>
     <hr>
       ${pageContext.request.contextPath}<br>
     	${pageContext.request.requestURL} <br>
		${pageContext.request.requestURI} <br>
		${pageContext.servletContext.contextPath }
		<hr>

 --%>
	Session value : <c:out value="${sessionScope.USERID}" /> 
					<%-- 
						<%= session.getAttribute("USERID") %> 
						<%= request.getContextPath() %>
					--%>
	<%-- <form action="${pageContext.servletContext.contextPath}/login.do" method="POST"> --%>
	 <form action="${path}/login.do" method="POST">
		<table border="1">
			<tr>
				<td>아이디:</td>
				<td>
					<input type="text" name="id" size="20">
				</td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td>
					<input type="password" name="pwd" size="20">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset"  value="취소">
				</td>
			</tr>
		</table>
	</form>
	회원가입 : <a href="MemberInsertview.do">회원가입</a>
</body>
</html>