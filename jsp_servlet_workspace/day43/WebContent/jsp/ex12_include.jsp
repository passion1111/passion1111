<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@include file="/module/SubInclude.jsp" %> --%>
<!-- 액션형태의 include는 텍스트형태로 들어오고  <  %@ 지시어의 인클루드는 실제 값을 가져옴 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include directive</title>
</head>
<body>
	<jsp:include page="/module/SubInclude.jsp"/>  <!-- 텍스트 형태로 포함됨. 액션태그는 저 페이지로 갔다가 돌아옴. 지시어 인클루드는 코드자체를 합쳐서 돌림. -->
	<% int num=200;// 지시어 include 방식을 이용하면 num이라는 변수가 subinclude에 있기때문에 에러가 뜸 %>
	<h3>include 파일 데이터</h3>
	Subinclude file data: <%=num %><br/>
	<%num=900; %>
	변경 data:<%=num %><br>

</body>
</html>