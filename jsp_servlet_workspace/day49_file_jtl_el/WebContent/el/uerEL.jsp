<%@page import="com.bit.camp.el.Calcurator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="hap" uri="/WEB-INF/tlds/el_function.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자가 만든 태그 라이브러리 이용 함수 호출하기</title>
</head>
<body>

<h3>표현 언어에서 함수 사용하기 -두수의 합을 구하는 함수 호출</h3>
<p>
	<form action="uerEL.jsp" method="post">
		x:<input type="text" name="x" value="${param['x'] }">
		y:<input type="text" name="y" value="${param['y'] }">
		<input type="submit" value="더하기 눌러봐"/>
	</form>
</p>
<br><br><br>

<p>
	<h3>합은 : ${hap:add( param['x'],param['y']) }입니다.</h3>
	<h3><%=Calcurator.add("3", "5") %></h3>
</p>
</body>
</html>