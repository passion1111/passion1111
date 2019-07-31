<!-- messageView.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>간단한 컨트롤러 뷰 페이지</title>
</head>
<body>
 갖고 온 데이터 :
 	${ result }
 	<form action="${pageContext.request.contextPath}/bitCamp">
 	테스트: <input type="text" name="message"> <input type="submit" value="d"> 
 	</form>
 	<c:set value="${ result}" var="x" />
 	<c:out value="${ x }" />
</body>
</html>