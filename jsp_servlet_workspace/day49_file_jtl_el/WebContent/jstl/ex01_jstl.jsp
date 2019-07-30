<!-- ex01_jstl.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리 사용 예제</title>
</head>
<body>
<c:set value="Hello JSTL!!!" var="str" />
<h3>&lt;c:set&gt; 사용 후 : <c:out value="${ str }" /></h3>
<c:set value="happydoyeon" var="name" />
<h3>이름은 <c:out value="${name }" /> </h3><hr>

<c:set var="num">1000</c:set>
<h3>&lt;c:set&gt; 사용 후 num : <c:out value="${ num }" /></h3><hr>

<c:catch var="error">
	<%= 10/0 %>
</c:catch>
<h3>&lt;c:catch&gt;로 잡아낸 오류 : <c:out value="${ error }" /></h3><hr>  
<%
	String msg = "hello jstl~~~";
	out.print(msg + "<br>");
%>
표현식을 이용한 출력 : <%= msg %><br>
JSTL 이용하면 
	<c:set var="msg2">hello jstl~~~</c:set>
	message = <c:out value="${ msg2 }" /> <hr>

<%
	String name2 = "happy";
	pageContext.setAttribute("id", "kingsmile");
	session.setAttribute("pwd", "oracle");
	application.setAttribute("team", "우리팀");
	request.setAttribute("age", 3);
%>
<%= name2 %> <br>
<c:set var="irum">doyeon</c:set>  <%-- <c:set var="irum" value="doyeon" /> --%>

name2 = ${ name2 }<br>
name2 = <c:out value="${ name2 }" default="무명씨야~" /> <br>
name = ${ irum }<br> <hr>

id = ${ id }<br>
pwd = ${ pwd }<br>
team = ${ team }<br>
age = ${ age }<br> <hr>
<c:out value="ID = ${ id }" /><br>
<c:out value="pwd = ${ pwd }" /><br>
<c:out value="team = ${ team }" /><br>
<c:out value="age = ${ age }" /><br> <hr>

<c:if test="${ 5 < 10 }">  <!-- if 조건에서 else 부분은 없다 -->
	<h3>5는 10보다 작다</h3>
</c:if>

<c:if test="${ 5 > 10 }">
	<h3>5는 10보다 크지 않다</h3>
</c:if>

<c:if test="${ 6 + 3 == 9 }"> <h3> 6 + 3 == 9</h3> </c:if>
<c:if test="${ 6 + 3 != 9 }"> <h3> 6 + 3 != 9</h3> </c:if><hr>

<!-- java : switch ~ case -->
<c:choose>
	<c:when test="${ 5 + 10 == 50 }"><h3>5 + 10 == 50</h3></c:when>
	<c:when test="${ 50 + 10 == 50 }"><h3>50 + 10 == 50</h3></c:when>
	<c:when test="${ 10 + 10 != 50 }"><h3>10 + 10 != 50</h3></c:when>
	<c:otherwise><h3>아무것도 아니네요.</h3></c:otherwise>
</c:choose>


</body>

</html>










