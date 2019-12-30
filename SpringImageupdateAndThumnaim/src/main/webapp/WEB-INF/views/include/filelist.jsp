<%-- 
<%@page import="com.nptech.domain.BoardFile"%>
--%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<style type="text/css">
.fileDown{color:#777}
.fileDown:hover{text-decoration:underline;color:#444}

</style>
<ul>
	<c:forEach var="item" items="${file }" varStatus="status">
		<a href="#" onClick="javascript:newFileDownload('${item.FILE_PATH}', '${item.NUM }');" class="fileDown">${item.INXNAME}</a><br />
	</c:forEach>
</ul>
<script>
	curl = "<c:url value='/' />";
</script>