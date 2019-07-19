<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage="../Error/CommonError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
name값:<%=request.getParameter("name").toUpperCase() %>
</body>
</html>