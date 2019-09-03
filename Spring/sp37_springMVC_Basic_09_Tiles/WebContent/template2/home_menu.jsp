<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<ul>
<c:forEach items="${userMenus}" var="menu">
	<li>${menu.name} / ${menu.link}</li>
</c:forEach>
</ul>