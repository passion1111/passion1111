<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지 처리 방식 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 페이지에 common.jsp 파일 내의 소스 삽입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="/WEB-INF/views/common2.jsp"%>


<html>   
<head><title>게시판</title>
	<script>
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// [게시판 수정/삭제 화면]에 입력된 데이터의 유효성 체크 함수 선언
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	function checkBoarUpDelForm( upDel ){
		if(upDel=="del"){
			var pwd = $("[name=pwd]").val();
			if( pwd.split(" ").join("")=="" ){
				alert("암호를 입력해 주십시요"); 
				$("[name=pwd]").focus();
				return;
			}
			document.boardUpdDelForm.upDel.value="del";
			if( confirm("정말 삭제 하시겠습니까?")==false ){ return; }
		}
		else if(upDel=="up"){
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
			if( confirm("정말 수정하시겠습니까?")==false ){ return; }
		}
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		// 현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/boardRegProc.do"  을 호출하여 
		// [게시판 입력 행 적용 개수]가 있는 html 소스를 받는다.
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		$.ajax({
			// ----------------------------
			// 호출할 서버쪽 URL 주소 설정
			// ----------------------------
			url : "${path1}/boardUpDelProc.do"    
			// ---------------------------- 
			// 전송 방법 설정
			// ----------------------------
			,type : "post"
			//---------------------------------
			// 서버에 보낼 파라미터명과 파라미터값을 설정
			//---------------------------------
			,data : $("[name=boardUpdDelForm]").serialize( )
			//---------------------------------
			// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
			// 익명함수의 매개변수 data 에는 boardUpDelProc.do 의 실행 결과물인 html 소스가 문자열로 들어옴.
			//---------------------------------
			,success : function( html ){
				// body 태그 마지막에 매개변수로 들어온 html 소스를 삽입한 후 실행하기
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
	<!--[게시판 수정/삭제] 화면을 출력하는 form 태그 선언-->
	<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
	<form method="post" name="boardUpdDelForm" action="${path1}/boardUpdDelProc.do" >
		<b>[글 수정/삭제]</b>
		<table class="tbcss1" border="1" bordercolor=gray cellspacing="0" cellpadding="5"  align="center">
			<tr>
				<th bgcolor=#C6C6C6>작성자
				<td><input type="txt" size="10" maxlength="10" name="writer" value="${boardDTO.writer}">
			</tr>
			<tr>
				<th bgcolor=#C6C6C6>제 목
				<td>
					<input type="text" size="40" maxlength="50" name="subject"value="${boardDTO.subject}"></td>
			</tr>
			<tr>
				<th bgcolor=#C6C6C6>이메일
				<td><input type="text" size="40" maxlength="30" name="email" value="${boardDTO.email}">
			</tr>
			<tr>
				<th bgcolor=#C6C6C6>내 용
				<td>
					<textarea name="content" rows="13" cols="40">${boardDTO.content}</textarea>
			</tr>
			<tr>
				<th bgcolor=#C6C6C6>비밀번호
				<td><input type="password" size="8" maxlength="12" name="pwd">
			</tr>
		</table>    
		
		<table><tr height=4><td></table>
		
		<input type="hidden" name="board_no" value="${boardDTO.board_no}">
		<input type="hidden" name="upDel" value="up"> 
			
		<input type="button" value="수정"  onClick="checkBoarUpDelForm('up')">  
		<input type="button" value="삭제"  onClick="checkBoarUpDelForm('del')">  
		<!-- <input type="button" value="목록보기" onClick="location.href='${path1}/boardListForm.do'"> -->
		<input type="button" value="목록보기" onclick="document.boardListForm.submit();"> 
	</form>      
	
	<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
	<!--[선택한 페이지번호 저장한 hidden 태그 선언하고 [게시판 목록 화면으로 이동하는 form 태그 선언-->
	<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
	<form name="boardListForm" method="post" action="${path1}/boardListForm.do"> 
		<input type="hidden" name="selectPageNo" 
				value="${empty param.selectPageNo?1:param.selectPageNo}">
		<input type="hidden" name="rowCntPerPage" 
				value="${empty param.rowCntPerPage?1:param.rowCntPerPage}">
	</form>      
</body>

</html>      





































































