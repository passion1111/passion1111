<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tile:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
	<table>
		<tr>
			<td colspan="2"><tile:insertAttribute name="header"/>
		</tr>
		<tr>
			<td><tile:insertAttribute name="menu"/>
			<td><tile:insertAttribute name="body"/>
		</tr>
		
		<tr>
			<td colspan="2"><tile:insertAttribute name="footer"/>
		</tr>
	
	</table>


</body>
</html>