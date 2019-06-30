<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>



</head>
<body>
	<form action="NewFile.jsp" method ="post">
	제목: <input type="text"name="title"/><br/>
	작성자: <input type="text" name="writer"/><br/>
	내용: <textarea rows="10" cols="20"name="content"></textarea><br/>
	날짜: <input type="text" name ="regdate"/><br/>
	<input type="submit"/>
	
	</form>

	
	

</body>
</html>