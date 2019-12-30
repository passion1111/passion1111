<%-- 
<%@page import="com.nptech.domain.BoardFile"%>
--%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<ul id="${param.BOXID eq null ? '' : param.BOXID}" class="file-box ${(param.AUTOADD eq null ? 'N' : param.AUTOADD) eq 'Y' ? 'autoadd' : ''}" data-filenamemaster="${param.FILENAMEMASTER }">
	<c:forEach var="file" items="${FILES }">
	<li style="padding: 8px 5px 0px;" class="fileli">
		<a href="#" onclick="javascript:newFileDownload('${file.getFILE_NAME()}', '${file.getFILE_NO() }');">${file.getFILE_ORG()}</a>&nbsp;
		<input type="button" value="삭제" onclick="javascript:newDeleteFile('${file.getFILE_NAME()}','${file.getFILE_NO() }', this);" />
	</li>
	</c:forEach>
	<li style="padding: 8px 5px 0px;">
		<input class="file-item default" type="file" name="${param.FILENAMEMASTER}" title="${param.FILETITLE ne null ? '첨부파일' : param.FILETITLE}" />&nbsp;<input type="button" class="file-item-remove" value="삭제" style="display: none;" onclick="javascript:removeFileElement(this);" />
	</li>
</div>
<script>
	curl = "<c:url value='/' />";
	deleteUrl = "<c:url value='nfd.do' />";
</script>