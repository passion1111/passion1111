<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>



</head>
<body>

	<form action="insert.jsp"  method="post"  onsubmit ="return formCheck()">
	제목: <input type="text" name ="title"/> <br/>
	작성자: <input type="text" name="writer"/> <br/>
	내용: <textarea rows="10" cols="20" name="content"></textarea><br/>
	날짜: <input type="text" name="regdate" /> <br/>
	<input type="submit"/>
	
	<script>

	function formCheck(){
		var title=document.forms[0].title.value;
		//사용하기 쉽도록 변수를 선언하여 담아주고,
		var write=document.forms[0].write.value;
		
		var regdate=document.forms[0].regdate.value;
		
		var content=document.forms[0].content.value;
		
		if(title==null||title==""){ //null인지 비교한뒤
		
		alert('제목을 입력하세요');
	
		document.forms[0].title.focus();//해당 태그에 포커스를 준뒤
		
		return false;
		}
		if(write==null||write==""){
			alert('작성자를 입력하세요');
			document.forms[0].write.focus();
			
			return false;
			
		}
		
		//글 작성폼에 내용을 추가하였습니다. 게시판에 글내용이 있어야하니
		
		if(content==null||content==""){
			alert('내용을 입력하세요');
			
			document.forms[0].content.focus();
			
			return false;
		}
		
		if(regdate==null||regdate==""){
			alert('날짜를 입력하세요');
			
			document.forms[0].regdate.focus();
			
			return false;
			
			
		}
		
		
		}


</script>
	
	</form>
	
	

</body>
</html>