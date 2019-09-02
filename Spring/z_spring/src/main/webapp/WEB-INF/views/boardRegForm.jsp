<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 JSP 페이지의 처리 방식 설정-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 페이지에 common.jsp 파일 내의 소스 삽입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="/WEB-INF/views/common2.jsp"%>

<head>
	<title>게시판</title>
	<script>
	//************************************************
	// [게시판 등록 화면]에 입력된 데이터의 유효성 체크 함수 선언
	//************************************************
	function checkBoardRegForm( ){
		var writer = $("[name=writer]").val();
		if( writer.split(" ").join("")=="" ){
			alert("이름을 입력해 주십시요"); 
			$("[name=writer]").focus();
			return;
		}
		var subject = $("[name=subject]").val();
		if( subject.split(" ").join("")=="" ){
			alert("제목을 입력해 주십시요"); 
			$("[name=subject]").focus();
			return;
		}
		var email = $("[name=email]").val();
		if( email.split(" ").join("")=="" ){
			alert("이메일을 입력해 주십시요"); 
			$("[name=email]").focus();
			return;
		}
		/*
		var email  = $("[name=email]").val( );
		var regExp = new RegExp( /^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/ );
		var flag = regExp.test(email); 
		if( flag==false ) { 
			alert("이메일 형식으로 구성되 있지 않으습니다. 재 입력 바람니다!");
			$("[name=email]").val( "" ); 
			$("[name=email]").focus( ); 
			return;   
		}
		*/
		var content = $("[name=content]").val();
		if( content.split(" ").join("")=="" ){
			alert("내용을 입력해 주십시요"); 
			$("[name=content]").focus();
			return;
		}
		var pwd = $("[name=pwd]").val();
		if( pwd.split(" ").join("")=="" ){
			alert("암호를 입력해 주십시요"); 
			$("[name=pwd]").focus();
			return;
		}
		if( confirm("정말 저장하시겠습니까?")==false ){ return; }
		//=========================================================
		// 현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/boardRegProc.do"  을 호출하여 
		// [게시판 입력 행 적용 개수]가 있는 html 소스를 받기
		//=========================================================
		$.ajax({
			// ----------------------------
			// 호출할 서버쪽 URL 주소 설정
			// ----------------------------  
			url : "${path1}/boardRegProc.do"    
			// ---------------------------- 
			// 전송 방법 설정
			// ----------------------------
			,type : "post"
			//---------------------------------
			// 서버에 보낼 파라미터명과 파라미터값을 설정
			//---------------------------------
			,data : $("[name=boardRegForm]").serialize( )
			//---------------------------------
			// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
			// 익명함수의 매개변수 data 에는 boardRegProc.jsp 의 실행 결과물인 html 소스가 문자열로 들어옴.
			//---------------------------------
			,success : function( html ){
				$("body").append(html);
			}
			//---------------------------------
			// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정.
			//---------------------------------
			,error : function(  ){	 
				alert("서버와 비동기 방식 통신 실패!");
			}
		});
	}
	</script>
</head>
  
<body><br><center>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--[게시판 등록] 화면을 출력하는 form 태그 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<form method="post" name="boardRegForm" action="${path1}/boardRegProc.do" >
	<c:if test="${empty param.group_no}">
		<b>[새 글쓰기]</b>
	</c:if>
	<c:if test="${!empty param.group_no}">
		<b>[댓 글쓰기]</b>
	</c:if>
	<!------------------------------------------------------------>
	<table class="tbcss1" border="1" bordercolor=gray cellspacing="0" cellpadding="5"  align="center">
		<tr>
			<th bgcolor=#C6C6C6>이 름
			<td><input type="text" size="10" maxlength="10" name="writer">
		</tr>
		<tr>
			<th bgcolor=#C6C6C6>제 목
			<td>
				<input type="text" size="40" maxlength="50" name="subject"></td>
		</tr>
		<tr>
			<th bgcolor=#C6C6C6>이메일
			<td><input type="text" size="40" maxlength="30" name="email" >
		</tr>
		<tr>
			<th bgcolor=#C6C6C6>내 용
			<td>
				<textarea name="content" rows="13" cols="40"></textarea>
		</tr>
		<tr>
			<th bgcolor=#C6C6C6>비밀번호
			<td><input type="password" size="8" maxlength="12" name="pwd">
		</tr>
	</table>    
	
	<table><tr height=4><td></table>
	
	<input type="hidden" name="board_no" value="${empty param.board_no?0:param.board_no}">
	
	<input type="button" value="저장"  onClick="checkBoardRegForm()">  
	<input type="reset" value="다시작성">
	<input type="button" value="목록보기" onclick="document.boardListForm.submit();">  
</form>      
		
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--[선택한 페이지번호] 저장한 hidden 태그 선언하고 [게시판 목록] 화면으로 이동하는 form  태그 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<form name="boardListForm" method="post" action="${path1}/boardListForm.do">
	<input type=""hidden"" name="selectPageNo" 
			value="${empty param.selectPageNo?1:param.selectPageNo}">
	<input type=""hidden"" name="rowCntPerPage" 
			value="${empty param.rowCntPerPage?1:param.rowCntPerPage}">
</form>      

</body>
</html>      





































































