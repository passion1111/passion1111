<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 기술의 한 종류인 [Page Directive] 를 이용하여 현 JSP 페이지 처리 방식 선언하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
	<!--현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, 이문서는 UTF-8 방식으로 인코딩 한다 라고 설정함.-->
	<!--현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다-->
	<!--UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할수 있는 방법이다.-->
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 기술의 한 종류인 [Include Directive]를 이용하여 common.jsp 파일 내의 소스를 삽입하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="common1.jsp"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--로그인 화면 구성하는 HTML 태그 코딩하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<html>
<head><title>로그인</title>
	<script>
		//************************************************
		// body 태그 안의 소스를 모두 실행한 후에 실행할 자스 코드 설정
		//************************************************
		$(document).ready(function(){
			//--------------------------------------------
			// name=loginForm 가진 태그 안의 class=.login 가진 태그에 
			// click 이벤트 발생 시 실행할 코드 설정하기
			//--------------------------------------------
			$("[name=loginForm] .login").click(function(){
				checkLoginForm( );
			})
			/* $('[name=admin_id]').val( '${admin_id_cookie}' );
			$('[name=pwd]').val( '${pwd_cookie}' );
			
			<c:if test="${!empty admin_id_cookie}">
				$('[name=is_login]').prop( "checked", true );
			</c:if> */
			//--------------------------------------------
			// 클라이언트가 웹서버보낸 쿠키중 admin_id 라는 쿠키명의 쿠키값을 name=admin_id 가진 태그의 value 값에 삽입하기
			//--------------------------------------------
			$('[name=admin_id]').val( '${cookie.admin_id.value}' );
			//--------------------------------------------
			// 클라이언트가 보낸 쿠키중 pwd 라는 쿠키명의 쿠키값을 name=pwd 가진 태그의 value 값에 삽입하기
			//--------------------------------------------
			$('[name=pwd]').val( '${cookie.pwd.value}' );
			//--------------------------------------------
			// 클라이언트가 보낸 쿠키중 admin_id 라는 쿠키명의 쿠키값이 존재하면 name=is_login 가진 태그를 체크하기
			//--------------------------------------------
			$('[name=is_login]').prop( "checked", ${!empty cookie.admin_id.value?true:false} );

		});

		//************************************************
		// 로그인 정보 유효성 체크하고 비동기 방식으로 서버와 통신하여 
		// 로그인 아이디와 암호의 존재 여부에 따른 자스 코드 실행하기
		//************************************************
		function checkLoginForm(){
			//-----------------------------------------
			// 웹브라우저에서 입력한 [아이디]를 가져와 변수에 저장
			//-----------------------------------------
			var admin_id = $("[name=admin_id]").val( );
			//-----------------------------------------
			// 웹브라우저에서 입력한 [암호]를 가져와 변수에 저장
			//-----------------------------------------
			var pwd = $("[name=pwd]").val( );
			//-----------------------------------------
			// 관리자 아이디를 입력 안했으면  경고하고 함수 중단
			//-----------------------------------------
			if( admin_id.split(" ").join()=="" ){
				alert("관리자 아이디 입력 요망");
				$("[name=admin_id]").val("");
				return;
			}
			//-----------------------------------------
			// 암호를 입력 안했으면  경고하고 함수 중단
			//-----------------------------------------
			if( pwd.split(" ").join()=="" ){
				$("[name=pwd]").val("");
				alert("암호 입력 요망");
				return;
			}
			//-----------------------------------------
			// 현재 화면에서 페이지 이동 없이(=비동기 방식으로) 서버쪽 "${path1}/loginProc.jsp"  을 호출하여 
			// HTML 소스을 응답 받아 실행하기.
			//-----------------------------------------
			//alert( "${path1}/loginProc.do"  )
			alert( $("form").filter("[name=loginForm]").serialize()  )
			$.ajax({
				//------------------
				// 서버쪽 호출 URL 주소 지정
				//------------------
				url : "${path1}/loginProc.do" 
				//------------------
				// form 태그 안의 데이터를 보내는 방법 지정
				//------------------
				, type : "post"
				//------------------
				// 서버에 보낼 파라미터명과 파라미터값을 설정
				//------------------
				, data : $("form").filter("[name=loginForm]").serialize()
				//, data :  {'admin_id':admin_id,'pwd':pwd}  
				// 오른쪽도 가능.  , data : "admin_id="+admin_id+"&pwd="+pwd 
					// 오른쪽도 가능.  , data : $("form").filter("[name=loginForm]").serialize()
				//------------------
				// 서버가 응답할 페이지 종류. html 일경우 생략 가능
				//------------------
				, datatype : "html"
				//------------------
				// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
				// 익명함수의 매개변수 html 에는 서버가 응답한 [html 소스 문자열]이 들어온다.
				//------------------
				,success : function(html) {
					//alert(html); return;
					//---------
					// 서버가 응답한 html 소스 문자열을 현재페이지의 
					// body 태그 마지막에 html로 삽입하고 실행하기
					//---------
					//$("body").append("<textarea cols=200 rows=700>"+html+"</textarea>"); 
					$("body").append( html); 
				}
				//-----------------------------------------
				// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정.
				//-----------------------------------------
				,error : function() {
					alert("서버 접속 실패!"); 
				}
			});
		}		
	</script>
</head>

<body><center><br><br><br>
	<!--++++++++++++++++++++++++++++++++++++++++++++++++++++#E1E1E1++++++++-->
	<!--[로그인 정보 입력 양식] 내포한 form 태그 선언-->
	<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
	<form name="loginForm" method="post" action="${path1}/loginProc.jsp">
		<%-- <table style="border-collapse:collapse;" border=1 cellpadding=20 cellspacing=20 bordercolor="${borderColor}"><tr><th> --%>
		<table class="tbcss0"><tr><th>
			<b>[로그인]</b>
			<!--------------------------->
			<div style="height:6"></div>
			<!--------------------------->
			<table class="tbcss11" border=1 cellpadding=5 cellspacing=0 bordercolor="gray">
				<tr>
					<th bgcolor="${color1}" align=center>아이디
					<td><input type="text" name="admin_id" class="admin_id" size="20">
				<tr>
					<th bgcolor="${color1}" align=center>암 호
					<td><input type="password" class="pwd" name="pwd" size="20">
			</table>
			<!--------------------------->
			<div style="height:6"></div>
			<!--------------------------->
			<!-- <button class="login" >로그인</button> -->
			<input type="button" value="로그인" class="login">
			<input type="checkbox"  name="is_login" value="y" >아이디.암호 기억
			
		</table>
	<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
	</form>
	<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
</body>

<html>





















