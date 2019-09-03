<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="join.do" method="post"> <br>
이름<input type="text" name="name">	<br>
아이디 <input type="text" name="id" id='checkid'> <input type="button" value="중복확인" onclick='ajax(this)'> <div id='idcheckidcheck'></div><br>
			
비밀번호  <input type="password" name="password">	<br>
주민번호  <input type="text" name="jumin1" maxlength="7">-<input type="text" name="jumin2" maxlength="6"> <br>
<input type="submit" value="보내기"/>
</form>


</body>
</html>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
function ajax(){
	document.getElementById('idcheckidcheck').style.display = "none"

obj=new Object();
obj.id=document.getElementById('checkid').value;
	
	
	$.ajax({
         type:"get",
        url:"./idcheck.do",
        data:{data : JSON.stringify(obj)},
        success:function(data){
        	 var json=	JSON.parse(data);
            if(json.id!='null'){
            	console.log(json);
            	document.getElementById('idcheckidcheck').style.display = ""
            	document.getElementById('idcheckidcheck').innerText="중복된 아이디입니다."
           }else{
        	   document.getElementById('idcheckidcheck').style.display = ""
               	document.getElementById('idcheckidcheck').innerText="사용가능합니다.."
           } 
          
} 
});
}

</script>
