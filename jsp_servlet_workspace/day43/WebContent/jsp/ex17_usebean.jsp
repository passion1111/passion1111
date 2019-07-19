<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="edu.bit.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usebean Article Tag</title>
</head>
<!--  new로 객체 생성하던것을 tag로 객체생성하기위해나온 액션태그-->
<jsp:useBean id="e2" class="edu.bit.Emp"></jsp:useBean> <!--e2라는 객체가 생성된다고 생각하면 됨. -->
<%-- <jsp:setProperty property="empno" name="e2" value="7777"/> <!-- 내가 지정한 유즈빈의 id명이 네임으로 와야한다. -->
<jsp:setProperty property="name" name="e2" value="타이틀"/>
<jsp:setProperty property="pay" name="e2" value="79797979"/> --%>
<jsp:setProperty property="*" name="e2"/> <!-- set은 *로 대체 *하면 여러 필드를 다 지칭 get은 다 적어줘야함. -->
	이름:<jsp:getProperty property="name" name="e2"/> <br/>
	사번:<jsp:getProperty property="empno" name="e2"/> <br/>
	급여:<jsp:getProperty property="pay" name="e2"/> <br/>

<body>
<hr>
<%
	//오늘 날짜를 출력하기
	Date today=new Date();
	out.println(today);
 		//기존에 객체를 생성했던 방법
 		Emp e=new Emp();
		e.setEmpno(32332);
		e.setName("호호호호");
		e.setPay(50000);
		
		out.println(e.getEmpno());
		out.println(e.getName());
		out.println(e.getPay());

	e2.setEmpno(23213);
	e2.setName("ddd");
	e2.setPay(500000);
%>
<br>
	<%=e2.getEmpno() %>
	<%=e2.getName() %>
	<%=e2.getPay() %> <br/>
<hr>
			userbean을 이용해서 객체 생성하기 <br/>
			<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
			<%=now %>
		
			
</body>
</html>