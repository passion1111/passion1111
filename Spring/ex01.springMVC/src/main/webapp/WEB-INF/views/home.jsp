<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<hr> 
 이미지 파일을 보여 줄게여 <br/>
 <img src="./resources/aaaaa.jpg">
 <br>
 <%-- <c:url value="경로/파일명.확장자"/>--%>
 <img src="<c:url value="./image/Koala.jpg"  />"   width="200px" height="100px""/> 
 
 
 
 
  <img src="./image/Koala.jpg">요기요 



<c:set var="path" value="${pageContext.servletContext.contextPath}"/>
<img src="${path }/Tulips.jpg" />
<img src="${ pageContext.servletContext.contextPath}/Tulips.jpg" />


<hr>
<P>  The time on the server is ${serverTime}. </P>

<br><br><br><br><br>

<%=request.getContextPath() %><br> <!--  /bit -->
<%=request.getRequestURI() %><br>   <!-- /bit/WEB-INF/views/home.jsp-->
<%=request.getServletPath() %><br> <!-- /WEB-INF/views/home.jsp -->
<%=application.getContextPath() %><br>  <!-- /bit -->
<%=pageContext.getServletContext().getContextPath() %> <br>  <!-- /bit -->

<!-- 위에 -->
<!-- <!-- /bit
/bit/WEB-INF/views/home.jsp
/WEB-INF/views/home.jsp
/bit
/bit  --> -->
<!-- 끝 -->
<hr>
${pageContext.request.contextPath }<br>  <!-- /bit -->
${pageContext.request.requestURI }<br> 	 <!-- /bit/WEB-INF/views/home.jsp -->
${pageContext.request.contextPath }<br>    <!-- /bit -->
${pageContext.servletContext.contextPath }<br>   <!-- /bit -->
<%=pageContext.getServletContext().getRealPath(request.getRequestURI()) %>
<!-- 시작 -->
<!-- 
/bit
/bit/WEB-INF/views/home.jsp
/bit
/bit 
-->


<!-- 끝 -->
</body>
</html>
