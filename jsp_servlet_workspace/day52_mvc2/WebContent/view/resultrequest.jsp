<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
1.el
<%
request.getAttribute("useraddress");
%>
<br>
2..jstl el
${useraddress }
${ username}
<br>
</body>
</html>