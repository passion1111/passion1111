<!-- ex06_fmt.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="utf-8"/>
<fmt:setLocale value="en_us"/>
					<!--  .properties 를 뺀 파일명만 기재 -->
  <!-- 경로.파일명 -->
<fmt:bundle basename="bundle.testBundle"> 
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSTL fmt - bundle, message </title>
</head>
<body>
	<fmt:message key="name" /><p>
	<fmt:message key="message"  var="msg" />
	<c:out value="${ msg }" />
</body>
</html>

</fmt:bundle> <!-- /fmt:bundle이 아래에 있어야함. -->








