<!-- ex07_fmt.jsp -->
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
<c:set value="${date }" var="today"/>
<c:out value="${ today }"></c:out>
<c:out value="${date }"></c:out><br>

<%
	java.util.Date date2 = new Date();
	out.print(date2);
%>

<fmt:setLocale value="en_US"/>  <!-- en_us, ko_kr -->

<fmt:bundle basename="bundle.testBundle">
	<fmt:message key="name" /><br>
	<fmt:message key="say" /><br>
	<fmt:message key="say2" >
		<fmt:param>abcd</fmt:param>	
	</fmt:message>
</fmt:bundle>

<%-- <fmt:param value="kbs" /> --%>
<hr>
<fmt:formatNumber value="500000" type="currency"/><br>
<fmt:formatNumber value="0.15" type="percent"/><br>
<fmt:formatNumber value="500000789" pattern="###,###,###" /><br>
<hr>
<fmt:formatDate value="${ date }" type="date"/><br>
<fmt:formatDate value="${ date }" type="time"/><br>
<fmt:formatDate value="${ date }" type="both"/><br>
<hr>

<fmt:formatDate value="${ date }" type="both" timeStyle="short" dateStyle="short" /><br>
<fmt:formatDate value="${ date }" type="both" timeStyle="long" dateStyle="long" /><br>
<hr>
<p> number : <fmt:formatNumber value="12345.789" type="number" />
<p> currency : <fmt:formatNumber value="12345.789" type="currency" currencySymbol="$"/>












<%-- <%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
<c:set value="${date }" var="today"/>
<c:out value="${ today }"></c:out>
<c:out value="${date }"></c:out><br>
<%
	//스크립트릿으로 해결할려면
	java.util.Date date2=new Date();
	out.print(date2);
%>
<fmt:setLocale value="en_US"/><!-- en_us , ko_kr -->
<<fmt:bundle basename="bundle.testBundle">
	<fmt:message key="name"/>
	<fmt:message key="say"/>
	<fmt:message key="say2">
	<fmt:param>abcd</fmt:param>
	</fmt:message>
</fmt:bundle>
 
<!-- <fmt:param value="kbs"/> -->
<fmt:formatNumber value="50000" type="currency" />
<fmt:formatNumber value="0.15" type="percent" />
<fmt:formatNumber value="50000789" pattern="###,###,###" />
<hr>
<fmt:formatDate value="${date }" type="date"/><br>
<fmt:formatDate value="${date }" type="time"/><br>
<fmt:formatDate value="${date }" type="both"/><br>
<hr> 

<fmt:formatDate value="${date }" type="both" timeStyle="short" dateStyle="short"/>
<fmt:formatDate value="${date }" type="both" timeStyle="long" dateStyle="long"/>

<fmt:formatNumber value="12345.789" type="number"/>
<fmt:formatNumber value="12345.789" type="currency" currencySymbol="$"/>
 --%>