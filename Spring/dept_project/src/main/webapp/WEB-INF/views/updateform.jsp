<!-- 2017. 4. 24. ���� 12:13:54 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>
			<h3>글수정입니다</h3>
		</legend>
		<form action="update_dept.do">
			DEPTNO : <input readonly="readonly" type="text" name="deptno" value="${dto.deptno }"><br>
			DNAME : <input type="text" name="dname" value="${dto.dname}"  maxlength="16"><br>
			LOC : <input type="text" name="loc" value="${dto.loc }"><br>
			<input type="submit" value="수정하기">
		</form>
	</fieldset>


</body>
</html>