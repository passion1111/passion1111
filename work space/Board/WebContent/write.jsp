<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۾���</title>
</head>

<body>

	<h1> Write This </h1>
	<form action="insert.do" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
	
	���� : <input type="text" name="title" /> <br/>
	�ۼ��� : <input type="text" name="writer" /> <br/>
	���� : <textarea rows="10" cols="20" name="content"/></textarea> <br/>
	file : <input type="file" name="filename"> <br/>
	
	<input type="submit"/>
	</form>
	

<script>
function formCheck(){
	
	var title = document.forms[0].title.value;
	var writer = document.forms[0].writer.value;
	var content = document.forms[0].content.value;
	// var regdate = document.forms[0].regdate.value;
	
	if (title == null || title == ""){
		alert('������ �Է��Ͻÿ�');
		document.forms[0].title.focus();
		return false;
	}
	if (writer == null || writer == ""){
		alert('�ۼ����Է��Ͻÿ�');
		document.forms[0].writer.focus();
		return false;
	}else if(writer.match(/^(\w+)@(\w+)[.](\w+)$/ig) == null){
			alert('�̸��� �������� �Է��ض�');
			document.forms[0].writer.focus();
			return false;
		}
	if (content == null || content == ""){
		alert('�����Է��Ͻÿ�');
		document.forms[0].content.focus();
		return false;
	}
	//if (regdate == null || regdate == ""){
	//	alert('��¥�Է��Ͻÿ�');
	//	document.forms[0].regdate.focus();
	//	return false;
	// }else if(regdate.match(/^\d\d\d\d\d\d+$/ig) == null ){
	//	alert('���� ����(6�ڸ�)�� �Է���')
	//	document.forms[0].regdate.focus();
	//	return false;
	//}
}
</script>
</body>
</html>