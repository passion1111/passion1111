<!-- fileUploadForm.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>파일 업로드 예제</title>
</head>
<body>
      <!-- method="post" enctype="multipart/form-data" 파일 업로드 하려면 반드시 -->
	<form action="fileUploadPro.jsp" method="post" enctype="multipart/form-data">
		작성자 : <input type="text" name="user"><br> 
		제  목 : <input type="text" name="title"><br> 
		파일명 : <input type="file" name="uploadFile"><br> <br>
		<input type="submit" value="파일올리기">
	</form>
</body>
</html>


























<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
<form action="fileIploadPro.jsp" method="post" entype="multipart/form-data"> <!-- 파일보내는것은 포스트방식만 됨. entype는 multipart-form이여야함. -->
	작성자: <input type="text" name="user"><br>
	제목:  <input type="text" name="title"><br>
	파일명: <input type="file" name="uploadFile"><br><br>
	<input type="submit" value="파일전송">
</form>

</body>
</html> --%>