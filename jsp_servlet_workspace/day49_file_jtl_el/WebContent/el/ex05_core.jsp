<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl core-if,choose,when,otherwise,foreach</title>
</head>
<body>
<c:set var="country" value="${'Korea' }"/>
<!-- if -->
<c:if test="${country!=null }">
	국가명 :<c:out value="${country }"/>
</c:if>

<br><br>
<!-- switchCase -->
<c:choose>
	<c:when test="${country=='Canada' }">
		<c:out value="${country }"/>의 날씨는 캐나다..<br>
	</c:when>
	<c:when test="${country=='Korea' }">
		<c:out value="${country }"/>의 날씨는 딱 한국날씨..<br>
	</c:when>
	<c:otherwise>
		<c:out value="${country }"/>해당 국가의 날씨는 모르겠습니다.<br>
	</c:otherwise>
</c:choose>
<!-- for -->
	<c:forTokens items="소나타-그랜저-현대차-삼성차-기아차" delims="-" var="car">
	구분한 글자들 출력:<c:out value="${car }"/><br>
	</c:forTokens>
	
	<c:forEach begin="1" end="100" var="i"> 
	<c:if test="${ i%2==0}"> <c:out value="${i }"/>  <br> </c:if>
	</c:forEach>
	
	단 입력<input type="text" name="dan" />  <input type="submit" value="입력"/>
	<c:forEach begin="1" end="9" var="i">
	<c:out value="${ }"
	
	</c:forEach>
	
</body>
</html>