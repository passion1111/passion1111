<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
	<%
		String subID=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String type=request.getParameter("Type");
		%><br/>
		Sub param page<br/>
		subID request value:<%=subID %><br/>
		pwd request value:<%=pwd %><br/>
		type request value:<%=type%><br/>
		<hr/>
		name 파라메터 list<br>
		<ul>
		<%
			String[] names=request.getParameterValues("userid");
		for(String n:names){
		%>
		   <li><%=n %> </li>
		<%} %>
		
		</ul>
</body>
<br/>
<hr>

<%
	if(type.equals("A")){
		out.print("당신이 요청한 데이터는 제품:"+type);
		
	}else if(type.equals("B")){
		out.println("당신이 요청한 데이터는 제품"+type);
	}
%>
</html>