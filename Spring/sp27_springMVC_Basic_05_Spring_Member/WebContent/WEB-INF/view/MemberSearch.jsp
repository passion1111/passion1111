<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원조회</title>
</head>
<body>
	회원 ID    : ${Singlemember.id}<br>
	회원 NAME  : ${Singlemember.name}<br>
	회원 PWD   : ${Singlemember.pwd}<br>
	회원 EMAIL : ${Singlemember.email}<br>
	회원 AGE   : ${Singlemember.age}<br>
</body>
</html>