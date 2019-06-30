<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글쓰기</title>
</head>
<%
	String idx = request.getParameter("idx");
%>
<body>

	
	<h1> modify This </h1>
	<form action="modify.jsp?idx=<%=idx%>" method="post" onsubmit="return formCheck();">
	
	제목 : <input type="text" name="title" /> <br/>
	작성자 : <input type="text" name="writer" /> <br/>
	내용 : <textarea rows="10" cols="20" name="content"/></textarea> <br/>

	<input type="submit"/>
	</form>
	

<script>
function formCheck(){
	
	var title = document.forms[0].title.value;
	var writer = document.forms[0].writer.value;
	var content = document.forms[0].content.value;
	// var regdate = document.forms[0].regdate.value;
	
	if (title == null || title == ""){
		alert('제목을 입력하시오');
		document.forms[0].title.focus();
		return false;
	}
	if (writer == null || writer == ""){
		alert('작성자입력하시오');
		document.forms[0].writer.focus();
		return false;
	}else if(writer.match(/^(\w+)@(\w+)[.](\w+)$/ig) == null){
			alert('이메일 형식으로 입력해라');
			document.forms[0].writer.focus();
			return false;
		}
	if (content == null || content == ""){
		alert('내용입력하시오');
		document.forms[0].content.focus();
		return false;
	}
	//if (regdate == null || regdate == ""){
	//	alert('날짜입력하시오');
	//	document.forms[0].regdate.focus();
	//	return false;
	// }else if(regdate.match(/^\d\d\d\d\d\d+$/ig) == null ){
	//	alert('숫자 형식(6자리)로 입력해')
	//	document.forms[0].regdate.focus();
	//	return false;
	//}
}
</script>
</body>
</html>