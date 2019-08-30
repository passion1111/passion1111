<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set  var="path" value="${ pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 처리 화면</title>
</head>
<body>
	
	로그인ID : <c:out value="${sessionScope.USERID}" /> 님 로그인 성공
	<hr>
	로그아웃  : <a href="${path}/logout.do">로그아웃</a>
	<hr>
	회원조회  : 
	<form action="${path}/MemberSearch.do" method="post">
			<input type="text" name="id">
			<input type="submit" value="조회">
	</form>
	

</body>
</html>