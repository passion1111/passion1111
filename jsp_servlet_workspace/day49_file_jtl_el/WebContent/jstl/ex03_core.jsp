<!-- ex03_core.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%-- <c:import url="java.util.*" /> --%>

<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리 사용 예제</title>
</head>
<body>
<!-- 스크립트릿과 JSTL 비교 -->
<p>1번 JSTL</p>
<c:forEach var="i" begin="1" end="10" step="2">
	<b>${ i }</b> &nbsp; &nbsp; &nbsp; &nbsp;
</c:forEach><p>

<p>1번 스크립트릿</p>
<%
	for(int j=0; j< 10; j++) {
		if( j % 2 == 1 ) { %>
			<b><%= j %></b> &nbsp; &nbsp; &nbsp; &nbsp;
	<%	}//if end
	}//for end
%><hr>
<h2>1 ~ 100까지의 합은?</h2>
<c:set value="0" var="sum" />

<c:forEach var="i" begin="1" end="100">
	<c:set var="sum"  value="${ sum + i }"/>
</c:forEach>

<font color="red">합은 : ${ sum }</font> <hr>

<h1>구구단</h1>
<c:forEach var="i" begin="1" end="9">
	<c:forEach var="j" begin="1" end="9">
			${i }* ${j } = ${ i*j } <br>	
	</c:forEach>
</c:forEach> <hr>

<%
String[] sports={"축구","야구","농구","럭비"};
HashMap map=new HashMap();
map.put("name","king");
map.put("age",13);
map.put("tel","010-4444-4444");
map.put("date",new Date());
%>
<h1>스포츠 배열 2번째 값부터 3개만 출력</h1>
<c:set var="sportArray" value="<%= sports %>" />

<c:forEach var="i" items="${ sportArray }" begin="1" 
								end="3" step="1" varStatus="status">
								
	i값 : ${ i }<br>
	루프 실행 현재 인덱스 값 : ${ status.index } <br>
	루프 실행 횟수 : ${ status.count } <br>
	begin 값 : ${ status.begin } <br>
	end 값 : ${ status.end } <br>
	step 값 : ${ status.step } <br>
</c:forEach><hr>

<c:set var="membermap" value="<%=map %>"/>
<c:forEach var="i" items="${membermap }">
	${i.key } : ${i.value }<br>

</c:forEach>

<p>2번 스크립트릿</p>
<%
	String a="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u";
	String[] alphabet=a.split(",");
	for(int i=0;i<alphabet.length;i++){
%>
	<%=alphabet[i] %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%} //for end%>
<p>3번 jstl</p>
<c:set var="data" value="을지문덕,김유신,강감찬,조규민,김세종"/>
<c:forTokens items="${ data}" delims="," var="vardata"> ${vardata } &nbsp;&nbsp;&nbsp;</c:forTokens>
<hr>
	<% String data="을지문덕,김유신,강감찬,조규민,김세종";
		String vardata[]=data.split(",");
		for(int i=0;i<vardata.length;i++){%>
			<b><%=vardata[i] %></b>
		<% }%>

</body>
</html>







<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<c:import url="java.util.*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
<p>1번 jstl</p>
<c:forEach var="i" begin="1" end="10" step="2">
	<b>${i }</b>&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>
<hr>
<%
	for(int j=0;j<10;j++){
		if(j%2==1) {%>
			<b><%=j%></b>&nbsp;&nbsp;&nbsp;&nbsp;
<%	}}
%>

<h2>1~100까지의 합은</h2>
<c:set value="0" var="sum"/>
	<c:forEach var="i" begin="1" end="100" >
	<c:set var="sum" value="${sum+i }"/>	
	</c:forEach>
	
	<font color="red">합은:${sum }</font><br>
	<h1>구구단</h1>
<c:forEach var="i" begin="1" end="9">
	<c:forEach var="j" begin="1" end="9">
		${i }*${j }  =${i*j}<br>
	</c:forEach>

</c:forEach>
<hr>

<%
	String[] sports={"축구","야구","농구","럭비"};
	HashMap map=new HashMap();
	map.put("name","king");
	map.put("age",13);
	map.put("tel","010-4444-4444");
	map.put("date",new Date());
%>
<h1>스포츠 배열 2번쨰 값부터 3개만 출력</h1>
<c:set var="sportArray"value="<%=sports %>"/>
<c:forEach var="i" items="${sportArray }" begin="1" end="3" step="1" varStatus="status">

	i값:${i }<br>
	루프 실행 현재 인덱스 값: ${status.index } <br>
	루프 실행 횟수:${status.count} <br>
	begin 값:${status.begin }<br>
	end값 : ${status.end }<br>
	step값: ${status.step }<br>
</c:forEach>
</body>
</html> --%>