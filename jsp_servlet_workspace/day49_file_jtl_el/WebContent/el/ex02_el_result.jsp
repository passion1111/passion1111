<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<h3>${sessionScope.msg }</h3> 
<h3>${param.search}</h3> 
<h3>${param.name }</h3> 
<h3>${param['name'] }</h3> 
<h3>${param['search'] }</h3> 
<h3>${param["search"] }</h3> 


   
   <br><Br><br>
<% //request.setCharacterEncoding("UTF-8");
	String search=request.getParameter("search");
	String name=request.getParameter("name");

	out.print(session.getAttribute("msg")+"<br>");
	out.print(search+"<br>");
	out.print(name+"<br>");
%>