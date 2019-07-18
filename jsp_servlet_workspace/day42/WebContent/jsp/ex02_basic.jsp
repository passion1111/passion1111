<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int add(int x,int y){
	return x+y;
}
public int mul(int x,int y){
	return x*y;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
	Hello world<br/>
	<% int i=999;%>
	변수값:<%=i %><br/>
	함수호출:
	<%
		int result=add(10,3);
		int result2=mul(30,30);
	%>
	더한결과:<%=result %><br/>
	곱한결과:<%=result2 %><br/>
	
	1~100까지의 합을 출력 합니다.
	<%
		int sum=0;
	for(int j=1;j<=100;j++){
		sum+=j;
	}
	%>
	1~100까지의 합은 <%=sum %>




</body>
</html>