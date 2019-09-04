<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Spring Mvc </title>
</head>
<body>
<h2>Contact Manager</h2>
<form:form method="post" acceptCharset="addContact.htm" modelAttribute ="DD">
	<table>
		<tr>
			<td><form:label path="firstname"> First Name</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		
		<tr>
			<td><form:label path="lastname"> last Name</form:label></td>
			<td><form:input path="lastname"/></td>
		</tr>
		
		<tr>
			<td><form:label path="email"> email</form:label></td>
			<td><form:input path="email"/></td>
		</tr>
		
		<tr>
			<td><form:label path="telephone"> telephone</form:label></td>
			<td><form:input path="telephone"/></td>
		</tr>
		
	
	
	
	<tr >
	<td colspan="2"> <input type="submit" value="Add Contact">
	</tr>
	</table>

</form:form>

</body>
</html>