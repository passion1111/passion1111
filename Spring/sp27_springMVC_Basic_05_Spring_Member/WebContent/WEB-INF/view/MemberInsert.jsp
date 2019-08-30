<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set  var="path" value="${ pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입 입력 폼</h3>
	<%-- <form action="${pageContext.servletContext.contextPath}/MemberInsert.do" method="POST"> --%>
	<form action="${path}/MemberInsert.do" method="POST">
		ID:<input type="text" name="id"><br>
		PWD:<input type="password" name="pwd"><br>
		NAME:<input type="text" name="name"><br>
		EMAIL:<input type="email" name="email"><br>
		AGE:<input type="number" name="age"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>