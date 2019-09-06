<!-- 2017. 4. 27. ���� 4:14:37 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this is writeform2</title>

</head>
<body>

	<fieldset>
		<legend>
			<h3>dept2 추가 입니다</h3>
		</legend>
		<form action="write_dept2.do">
			<table style="text-align: center;">
				<tr>
					<td>DCODE</td>
					<td>:</td>
					<td><input type="text" name="dcode" required="required"
						value=${dcode}></td>
				</tr>
				<tr>
					<td>DNAME</td>
					<td>:</td>
					<td><input type="text" name="dname" required="required"></td>
				</tr>
				<tr>
					<td>PDEPT</td>
					<td>:</td>
					<td><input type="text" name="pdept"></td>
				</tr>
				<tr>
					<td>AREA</td>
					<td>:</td>
					<td><input type="text" name="area"></td>
				</tr>
				<tr>
					<td colspan="3"><hr>	</td>
				</tr>
				<tr>
					<td><input style="width: 100%;" type="button" value="취소"
						onclick="window.location.href='dept2_list.do'"></td>
					<td><input style="width: 100%;" type="reset" value="초기화"></td>
					<td><input style="width: 100%;" type="submit" value="추가"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>