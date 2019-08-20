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
<%-- <img src="${ pageContext.servletContext.contextPath}/Tulips.jpg" />
${ pageContext.servletContext.contextPath} --%>

<%=request.getContextPath() %><br> <!--  /bit -->
<%=request.getRequestURI() %><br>   <!-- /bit/holla.jsp -->
<%=request.getServletPath() %><br> <!-- /holla.jsp -->
<%=application.getContextPath() %><br>  <!-- /bit -->
<%=pageContext.getServletContext().getContextPath() %> <br>  <!-- /bit -->


<hr>
${pageContext.request.contextPath }<br>
${pageContext.request.requestURI }<br>
${pageContext.request.contextPath }<br>
${pageContext.servletContext.contextPath }<br>

</body>
</html>