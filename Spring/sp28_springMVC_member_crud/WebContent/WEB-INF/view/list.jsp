<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="list" items="${list }">
${list.id }   여기 하나///

</c:forEach>


<form action="insert.do">
이름<input type="text" name="id">
비밀번호<input type="password" name="id">
<input type="submit" value="가자">
</form>
오나요~
</body>
</html>