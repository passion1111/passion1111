<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- request가 하는 역할 웹브라우저가 웹서버에 전송한 요청 관련 정보 제공 
   >>주요 기능.
   -클라이언트(웹브라우저)와 관련된 정보 읽기 기능
   - 서버와 관련된 정보 읽기 기능
   -클라이언트가 전송한 요청 파라미터 읽기 기능
   -클라이언트가 전송한 요청 헤더 읽기 기능
   -클라이언트가 전송한 쿠키 읽기 기능
   -속성 처리 기능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	out.println(id);
%>
	<h3>request 객체가 가지고 있는 함수</h3>
	클라이언트 ip정보 가져오기:<%=request.getRemoteAddr() %><br/>
	요청 방식(인코딩)	<%=request.getCharacterEncoding() %><br/>
	전송방식 				<%=request.getProtocol() %><br/>
	서버이름			<%=request.getServerName() %><br/>
	서버포트			<%=request.getServerPort() %><br/>
	컨텍스트 정보		<%=request.getContextPath() %><br/>
	전송된 데이터.		<%=request.getParameter("id") %><br/>
</body>
</html>