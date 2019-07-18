<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--

 스크립트릿:자바,변수선언,제어문,..함수정의안됨 호출은됨. 
<%--  <% %> --%>
 
 표현식 출력하기위해 나타냄.
<%--  <%=  %> --%>
 -->
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<!-- 선언문 : 자바, 변수선언, 함수... 되고 제어문,출력문 안됨-->
<%! 
	public String show() {
		return "안녕하세요";
	}
	int num2=9;
	/* out.print(num2);사용 안됨. */ 
	//if(10>3){사용 안됨
%>
	<%=num2 %>
<%= show() %> <br />

<!-- 스크립트릿 : 자바, 변수선언, 제어문,.... -->
<% 

	
	/* post 방식 전송시 한글 깨짐 처리 */
	request.setCharacterEncoding("utf-8");
	
	int su = 90;
	for(int i =0; i < 10; i++){
		out.print(i);
	}
	
	out.print(su);
%>
<br />
<% 
	/* post 방식 전송시 한글 깨짐 처리 */
	request.setCharacterEncoding("utf-8");
	
	int su2 = 90;
	double d = 12.34;
	for(int i =0; i < 10; i++){
%>
	<%= i %><br />
	
<%	} //for end %>

<!-- 표현식: 출력 -->
<%= d %>

</body>
</html>

