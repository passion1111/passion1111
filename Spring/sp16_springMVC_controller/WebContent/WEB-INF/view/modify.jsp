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
<form action="modifyAction.do">
번호<input type="hidden" name="num" value="${list.num }"/>
이름<input type="text" name="name" value="${list.name }"/>
이메일<input type="text" name="email" value="${list.email }"/>
집<input type="text" name="home" value="${list.home }"/>
내용<input type="text" name="contents" value="${list.contents}"/>

<input type="submit" value="보내자">

</form>
</c:forEach>

</body>
</html>