<%@page import="com.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConnTest</title>
</head>
<body>
<%--
	EmpDAO dao=new EmpDAO();

--%>
<jsp:useBean id="dao" class="com.dao.EmpDAO"></jsp:useBean>
</body>
</html>