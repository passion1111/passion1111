<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상단 영역</title>


	<link rel="stylesheet" href="css/bootstrap.min.css">
	
	<style type="text/css">
	
	#wrap{
		text-align: center;
		width: 800px;
		height: 150px;
	}
	</style>

	<script type="text/javascript">
	
		function changeView(value){
			if(value=="0")
			{
				location.href="MainForm.do";	
			}
			else if(value=="1")
			{
				location.href="LoginForm.do";
			}
			else if(value=="2")
				{
				location.href="JoinForm.do";
				
				}
			else if(value=="3")
				{
				location.href="MemberLogoutAction.do";				
				}
			else if(value=="4")
				{
				location.href="MemberInfoAction.do";
				}
			else if(value=="5")
				{
				location.href="MemberListAction.do";
				}
			else if(value=="6")
				{
				location.href="BoardListAction.bo";
				}
			else if(value=="7")
				{
				location.href="GuestbookListAction.ge";
				}
		}
	
	</script>



</head>
<body>
	<div id="wrap">
		<p>
			<button class="btn btn-success" onclick="changeView(0)">Home</button>
			
			
			<c:if test="${sessionScope.sessionID==null }">
			<button id="LoginBtn" class="btn btn-primary" onclick="changeView(1)">로그인</button>
			<button id="joinBtn" class="btn btn-primary" onclick="changeView(2)">회원가입</button>
			</c:if>
			
			<c:if test="${sessionScope.sessionID!=null}">
				<button id="LogoutBtn
	
	</div>



</body>
</html>