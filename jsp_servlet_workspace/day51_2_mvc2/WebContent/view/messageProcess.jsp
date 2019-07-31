<!-- messageProcess.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>요청 파라미터로 명령어를 전달하는 방법</title>
</head>
<body>
 	전달 결과 :
 		${ message }
 		
 		<hr>
 		<c:set value="${ message }" var="msg" />
 		<c:out value="${ msg }" />
</body>
</html>