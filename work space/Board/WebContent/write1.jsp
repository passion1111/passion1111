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
	����: <input type="text" name ="title"/> <br/>
	�ۼ���: <input type="text" name="writer"/> <br/>
	����: <textarea rows="10" cols="20" name="content"></textarea><br/>
	��¥: <input type="text" name="regdate" /> <br/>
	<input type="submit"/>
	
	<script>

	function formCheck(){
		var title=document.forms[0].title.value;
		//����ϱ� ������ ������ �����Ͽ� ����ְ�,
		var write=document.forms[0].write.value;
		
		var regdate=document.forms[0].regdate.value;
		
		var content=document.forms[0].content.value;
		
		if(title==null||title==""){ //null���� ���ѵ�
		
		alert('������ �Է��ϼ���');
	
		document.forms[0].title.focus();//�ش� �±׿� ��Ŀ���� �ص�
		
		return false;
		}
		if(write==null||write==""){
			alert('�ۼ��ڸ� �Է��ϼ���');
			document.forms[0].write.focus();
			
			return false;
			
		}
		
		//�� �ۼ����� ������ �߰��Ͽ����ϴ�. �Խ��ǿ� �۳����� �־���ϴ�
		
		if(content==null||content==""){
			alert('������ �Է��ϼ���');
			
			document.forms[0].content.focus();
			
			return false;
		}
		
		if(regdate==null||regdate==""){
			alert('��¥�� �Է��ϼ���');
			
			document.forms[0].regdate.focus();
			
			return false;
			
			
		}
		
		
		}


</script>
	
	</form>
	
	

</body>
</html>