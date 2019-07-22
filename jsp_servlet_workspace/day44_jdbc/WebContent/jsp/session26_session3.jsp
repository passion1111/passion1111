<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user="java";String passwd="1004";
	
	String id=request.getParameter("uid");
	String pwd=request.getParameter("pwd");
	
	boolean loginState=false;
	//db연결 확인..
	//id,pw==uid,pwd같으면 회원이라고 가정하면
	if(id.equals(id)&&passwd.equals(pwd)){
		session.setAttribute("MemberID", id);
		loginState=true;
	}
	
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
<% String userID=(String)session.getAttribute("MemberID"); //MemberID를 가져오면 id를 가져오게됨 왜냐하면 해쉬맵이니까%>
<%=userID %><br><br>
<%
	if(loginState==true){
		out.print(id+"님 로그인 성공하셨습니다.");
	}else{
		out.print("회원이 아니시군여.회원가입하세여.");
	}
%>

</body>
</html>