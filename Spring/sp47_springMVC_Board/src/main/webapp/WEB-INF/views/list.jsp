<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Page</title>
</head>
<body>
	<h3> LIST Page </h3>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성일</td>
			<td>조회수</td>
			<td></td>
		</tr>
		
		<c:forEach items="${ list }" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td>
					<c:forEach begin="1" end="${dto.bIndent}">
						-
					</c:forEach>
					<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a>
				</td>
				<td>${dto.bContent }</td>
				<td>${dto.bDate }</td>
				<td>${dto.bHit }</td>
				<td><a href="delete?bId=${dto.bId}">글삭제</a></td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="7">
				<a href="write_view">글쓰기</a>
			</td>
		</tr>
	</table>
	
	
</body>
</html>