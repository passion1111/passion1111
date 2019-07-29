<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.setAttribute("msg", "session test"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
	<form action="ex02_el_result.jsp" method="post">
	<table border="1">
		<tr>
		<td>검색:</td>
		<td><input type="search" name="search" placeholder="검색어를 쓰세요."></td>
		</tr>
		
		
		<tr>
		<td>이름:</td>
		<td><input type="text" name="name" placeholder="이름을 쓰세요."></td>
		</tr>
		
		<tr>
		<td colspan="2" align="center"><input type="submit" value="전송"></td>
		
		</tr>
	
	</table>
	</form>
</body>
</html>