<!-- 2017. 4. 24. ���� 12:13:54 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dept2 update</title>
</head>
<body>
	<fieldset>
		<legend>
			<h3>dept2 수정입니다</h3>
		</legend>
		<form action="update_dept2.do">
			DCODE : <input readonly="readonly" type="text" name="dcode" value="${dto.dcode}"><br>
			DNAME : <input type="text" name="dname" value="${dto.dname}"><br>
			PDEPT : <input type="text" name="pdept" value="${dto.pdept}"><br>
			AREA : <input type="text" name="area" value="${dto.area}"><br>
			<input type="submit" value="수정하기">
		</form>
	</fieldset>


</body>
</html>