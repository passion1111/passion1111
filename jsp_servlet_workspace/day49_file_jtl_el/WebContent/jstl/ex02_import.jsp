<!-- ex02_import.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <%@ page import="date.jsp" %> --%>
<c:import url="date.jsp" var="today"/>

<%-- <% request.setCharacterEncoding("utf-8"); %> --%>
<fmt:requestEncoding value="utf-8"/>

<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSTL core, fmt 라이브러리 - requestEncoding,..</title>
</head>
<body>
${ today } <br> <hr>
파라미터 : <c:out value="${ param.id }" /><br>
			<c:out value="${ param['id'] }" /><br><br><br>
			
			
  <form action="ex02_import.jsp" method="post">
  	<input type="text"  name="id"> 
  	<input type="submit"  value="확인"> 
  </form>
</body>
</html>







