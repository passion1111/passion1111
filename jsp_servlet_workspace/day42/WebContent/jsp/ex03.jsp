<!-- ex03_loginForm.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<form action="ex03_loginOK.jsp" method="get">
		ID : <input type="text" name="userId"> <br />
		PWD : <input type="password" name="pwd"> <br />
		Hobby : 
			<input type="checkbox" name="hobby" value="baseball"> baseball
			<input type="checkbox" name="hobby" value="soccer"> soccer
			<input type="checkbox" name="hobby" value="basketball"> basketball
			<br />
			
		<input type="submit" value="로그인" >
	</form>
</body>
</html>