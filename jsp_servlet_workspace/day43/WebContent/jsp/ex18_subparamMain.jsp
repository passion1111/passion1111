<!-- ex18_subparamMain.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>Sub Param Main</title>
</head>
<body>
<%
	String t=request.getParameter("Type");
	String userID=request.getParameter("userid");
	String pwd=request.getParameter("pwd");
	
	out.print(t+"/"+userID+"/"+pwd);
	out.print("Main page");
%>
<hr>
<h3> Include page infomation</h3>
	<jsp:include page="ex18_subparam.jsp">
		<jsp:param value="<%=t %>" name="Type"/>
		<jsp:param value="1004" name="userid"/>
		<jsp:param value="oracle" name="pwd"/>
	</jsp:include>
	


</jsp:include>
</body>
</html>








<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" 아래 에러뜨는거 이유 찾아보기. 찾음 "<%=t>"에 쌍 따움표없었음.
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
<%
	String t=request.getParameter("Type");
	String userID=request.getParameter("userid");
	String pwd=request.getParameter("pwd");
	
	out.print(t+"/"+userID+"/"+pwd);
	out.print("Main page");
%>
<hr>
<h3>Include page information</h3>
<jsp:include page="ex18_subparam.jsp">
	<jsp:param value="<%=t %>" name="Type"/>
	<jsp:param value="1004" name="userid"/>
	<jsp:param value="orcle2" name="pwd"/>

</jsp:include>
</body>
</html> --%>