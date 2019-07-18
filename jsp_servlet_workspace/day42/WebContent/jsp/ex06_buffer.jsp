<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page buffer="1000kb" autoFlush="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
<%
	//default:buffer size:8kb
	//default:auto flush:true
	
	for(int i=0;i<1000;i++){
%>
	Hello~~~~~~~~~~~
<%}//for end
//브라우저에서도 임시저장소가있다 그것의 이름은 버퍼 그것의 default는 8키로 그게 다차면 다시 flush	
	%>
</body>
</html>