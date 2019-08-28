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

<h3>간단</h3>
<a href="./Writeform.do">글쓰기</a>
<input type="button" value="글쓰기" onclick="location.href='view/Writeform.jsp'"/>
<br><br>

<c:forEach var="list" items="${list }">
${list.name } ${list.email } ${list.home } ${list.contents }  
<input type="button" onclick="location.href='modifyform.do?num=${list.num}'" value="수정"/>
<input type="button" onclick="location.href='Delete.do?num=${list.num}'" value="삭제"/>
<hr>




</c:forEach>
</body>
</html>