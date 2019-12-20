
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SmartEditor</title>

<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->
<script type="text/javascript">var testSmartEditorUrl="/file_uploader"</script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="/resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<!-- jQuery를 사용하기위해 jQuery라이브러리 추가 -->


 
</head>
<body>
<a href="${pageContext.request.contextPath }/test1">테스트1</a>
<a href="${pageContext.request.contextPath }/test2">테스트2</a>
<form id="frm" action="${pageContext.request.contextPath}/test2" method="POST" >
<input type="hidden" name="idx" value="${list.IDX}">
${list.CONTENT }
<input type="submit" value="수정">
</form>
    
 
</body>
</html>