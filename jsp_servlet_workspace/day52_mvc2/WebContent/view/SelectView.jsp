<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select임</title>
</head>
<body>
<c:forEach var="i" items="${list }">



${i.name }

</c:forEach>
</body>
</html>