<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content= "text/html" charset="EUC-KR">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>

<title>게시판을 만들어 보자용</title>

<style type = "text/css">
	table, td, th{
	border:1px solid green;
	}
	th{
	background-color:green;
	color:white;
	}
	
</style>
</head>

<body>
	<h1>게시글 리스트</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th> 
			<th>조회수</th>
		</tr>
	
		<c:forEach items="${articleList}" var="article">
			<tr>
				<td>${article.idx}</td>
				<td><a href='count.do?idx=${article.idx}'>${article.title}</a></td>
				<td>${article.writer}</td>
				<td>${article.regdate}</td>
				<td>${article.count}</td>
			</tr>
		</c:forEach>


	
	</table>
	<input type="hidden" name="page" id="page" value="${page}">
	<a href="#" onclick="loadNextPage()">더보기</a>
	<script>
	function loadNextPage(){
		var page = $('#page').val();
		page = parseInt(page);
		page += 10;
		$.ajax({
			type:'post',
			url:'ajaxList.do',
			data:({page:page}),
			success:function(data){
				$('table').append(data);
				$('#page').val(page);
			}
		});
	}
	</script>

<br/><a href="write.jsp">글쓰기</a>



</body>
</html>