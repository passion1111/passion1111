<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등록된 게시글 보기</title>
</head>
<body>
	<%--<h3>게시판에 등록된 글 목록보기</h3>
	 제목 : ${newArticleCommand.title}
	내용 : ${newArticleCommand.content}
	순번 : ${newArticleCommand.parentId} --%>
	<h3>View 전달되는 객체이름 변경</h3>
	제목 : ${ArticleData.title}
	내용 : ${ArticleData.content}
	순번 : ${ArticleData.parentId}
</body>
</html>