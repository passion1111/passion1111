<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="./view/color.jsp" %>

<!-- ------------------------------------------------------------------ -->
 
 <!-- ------------------------------------------------------------------ -->

<html>
<head><title>�������� ������ ���ε��ϴ� ����</title></head>
<link href="/view/style.css" rel="stylesheet" type="text/css" >

<script type="text/javascript">
	function inputValue(form1, param, form2, idx){
		var paramValue = form1.elements[idx].value;
		form2.elements[idx].value = paramValue;
		return;
	}
	
	function addFile(formName){
		if(formName.addcnt.value == ""){
			alert("�Է��� ���� ������ �ְ� Ȯ�� Ŭ���ض�~");
			formName.addcnt.focus();
			return;
		}
		
		formName.submit();
	}
	
	function elementCheck(formName){
		paramIndex = 1;
		for(idx=0; idx<formName.elements.length; idx++){
			if(formName.elements[idx].type == "file"){
				if(formName.elements[idx].value==""){
					var msg = paramIndex + "��° ���� ������ �����ϴ�.\n"+
										"���ε��� ������ �����ض�!!";
					alert(msg);
					formName.elements[idx].focus();
					return ;
				}
				
				paramIndex++;
			}
		}
		formName.action = "fileSelectPro2.jsp";
		formName.submit();
	}
</script>
<body bgcolor="<%= bodyback_c %>">
	<div align="center">
		<h2>�������� ������ ���ε��ϴ� ���� �Դϴ�.</h2>
		<font color="#0000ff" size="2">���� ������ �Է��� �� Ȯ�� �������<br>
		�Է��� �Ϸ�Ǹ� ���� ���ε带 ���� ���ε� ���߸� ������~ 
		</font>	</div> <br>
	<form name="frmName" method="post">
	<table width="50%" border="1" align="center" cellpadding="1" cellspacing="1">
	<tr>
		<td width="15%" bgcolor="<%=value_c %>" align="center">�ۼ���</td>
		<td><input type="text" name="user" onkeyup="inputValue(this.form, user,frmName2, 0)" 
			value=" <%=getParam(request, "user") %>" ></td>
	<tr>
		<td width="15%" bgcolor="<%=value_c %>" align="center">����</td>
		<td><input type="text" name="title" onkeyup="inputValue(this.form, title,frmName2, 1)" 
			value="<%=getParam(request, "title") %>" ></td>
	</tr>
	
	<tr>
		<td width="15%" bgcolor="<%=value_c %>" align="center">����</td>
		<td width="50%" colspan="3">
		<textarea name="abstract" cols="40" 
		onkeyup="inputValue(this.form, abstract, frmName2, 2)">
		<%= getParam(request, "abstract") %>
		</textarea>
		</td>
	</tr>
	
	<tr>
		<td colspan="4" bgcolor="<%=value_c %>" align="center" >
		���ε��� ���� �� �Է�
		<input type="text" name="addcnt" >
		<input type="button" value="Ȯ��" onclick="addFile(this.form)">
		</td>
	</tr>
	</table>
</form>

<form name="frmName2" method="post" enctype="multipart/form-data"  >
	<table width="50%" border="1" align="center" cellpadding="1" cellspacing="1" >
    <tr>
    	<td width="40%" bgcolor="<%=value_c %>" align="center">
    	<input type="hidden" name="txtUser" value="<%= getParam(request, "user") %>" >   	
    	<input type="hidden" name="txtTitle" value="<%= getParam(request, "title") %>" >
    	<input type="hidden" name="txtAbstract" value="<%= getParam(request, "abstract") %>" >
    	<!-- ------------------------------------------------------------------ -->
    	
			
 		<!-- ------------------------------------------------------------------ -->
    	<input type="button" value="���ε�" onclick="elementCheck(this.form)" > 
    	</td>
    </tr>
    </table>
</form>
</body>
</html>









