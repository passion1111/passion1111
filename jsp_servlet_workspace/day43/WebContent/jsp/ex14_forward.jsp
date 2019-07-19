<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward Main</title>
</head>
<body>
	사용목적:조건에 맞는 페이지를 사용자에게 전달<br>
	단,장점은 사용자(client)는 주소가 바뀌었는지 모른다.<br/>
	(사용자가 바라보는 주소는 동일하다.)
	
	<hr>
	<font color="blue">site top content...</font>
	<jsp:forward page="../module/SubForward.jsp"></jsp:forward>
	<!-- 포워드를 하면 주소는 안바뀌지만 내용은 포워드로 보임. -->
	<font color="red">site bottoooo</font>
</body>
</html>