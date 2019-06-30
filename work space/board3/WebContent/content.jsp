<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content= "text/html" charset="EUC-KR">
<title>게시판 내용을 보자용 </title>

<script>
function onDownload(idx){
	var o = document.getElementById("ifrm_filedown");
	o.src = "download.do?idx="+idx;
}
</script>

</head>

<body>
	<iframe id="ifrm_filedown" style ="position:absolute;z-index:1;visibility:hidden;"></iframe>
	
	<h1>게시글 조회</h1>
	<table border ="1">
		<tr>
			<th>번호</th>
			<td>${article.idx}</td>
			<th>작성자</th>
			<td>${aritcle.writer}</td>
			<th>IP</th>
			<td>${article.regip}</td>
			<th>날짜</th>
			<td>${article.regdate}</td>
			<th>조회수</th>
			<td>${article.count}</td>
		</tr>
		<tr>
			<th colspan="2">제목</th>
			<td colspan="6">${article.title}</td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
			<td colspan="6">${article.content}</td>
		</tr>
		<tr>
			<th colspan="2"> 첨부파일 </th>
			<td colspan="8">
				<a href="#" onclick="onDownload('${article.idx}')">${article.filename}</a>
			</td>
		</tr>
	<tr>
	</table>

	
	<a href = "delete.do?idx=${article.idx}">게시글 삭제</a>
	<a href = "modify_write.jsp?idx=${article.idx}">게시글 수정</a>
	
	<a href = "list.do">목록으로 </a>
</body>



</html>