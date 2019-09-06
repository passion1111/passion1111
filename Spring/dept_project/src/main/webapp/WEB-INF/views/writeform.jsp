<!-- 2017. 4. 27. ���� 4:13:58 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this is writeform</title>
</head>
<body>
	<fieldset>
		<legend>
			<h3>DEPT 추가 하기 </h3>
		</legend>
		<form action="write_dept.do">
			<table style="text-align: center;">
				<tr>
					<td>DEPTNO</td>
					<td>:</td>
					<td><input type="text" name="deptno"></td>
				</tr>
				<tr>
					<td>DNAME</td>
					<td>:</td>
					<td><input type="text" name="dname"></td>
				</tr>
				<tr>
					<td>LOC</td>
					<td>:</td>
					<td><input type="text" name="loc"></td>
				</tr>
				<tr>
					<td>잉여</td>
					<td>:</td>
					<td><input type="text" name="over"></td>
				</tr>
				<tr>
					<td colspan="3"><hr>	</td>
				</tr>
				<tr>
					<td colspan="3"><input style="width: 100%;" type="submit" value="추가"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>