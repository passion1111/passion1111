<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>"WebContent/MainForm.jsp"
<head>
<meta charset="EUC-KR">
<title>메인 화면</title>
<style>

	#wrap {
			width: 950px;
			margin: 0 auto 0 auto;
		}
		
		
		#header {
			text-align: center;
			width: 950px;
			height: 150px;
			background-color: #F5F5F5;
			padding: 60px 0px;
		}

		#main {
			float: left;
			width: 950px;
			height: 600px;
			/*background-color: #FFCA6C;*/
			text-align:center;
			vertical-align: middle;
			overflow:auto;	/* 자동 스크롤 */
		}
		#footer {
			clear: left;
			width: 950px;
			height: 100px;
			background-color: #F5F5F5;
		}

</style>

</head>
<body>
<div id="wrap">
	<div id="header">
		<jsp:include page="Header.jsp"/>
	</div>
	<div id="main">
	
	<c:set var="contenPage" value="${param.contentPage }"/>
	<c:if test="${contentPage==null}" >
	 <jsp:include page="FirstView.jsp"/>
	 
	</c:if>
	<jsp include page="${contentPage }"/>
	
	
	</div>
	<div id="footer">
		<jsp:include page="${Footer.jsp }"/>
		
	
	</div>

	



</div>

</body>
</html>