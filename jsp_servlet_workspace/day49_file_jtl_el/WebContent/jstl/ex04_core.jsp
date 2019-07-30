<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core-set,out,remove</title>
</head>
<body>
<h3>jstl core-set,out,remove</h3>
<p>browser 변수 값 설정 </p>
<c:set var="browser" value="${ header}" />
<c:out value="${browser }"/></p>

<p> browser  변수값 제거 후 
<c:remove var="browser"/>
<c:out value="${browser }">없어? 응 없어</c:out>
</body>
</html>