<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 JSP 페이지의 처리 방식 설정-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 페이지에 common.jsp 파일 내의 소스 삽입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="/WEB-INF/views/common2.jsp"%>

<html>
<head>
	<title>게시판</title>
	<script>
		//************************************************
		// body 태그를 모두 실행한 후에 실행할 자스 코드 설정
		//************************************************
		$(document).ready(function(){
			$('form').hide();
			$('.boardContentForm').show();
			//---------------------------
			$('.content').keyup(function() {
				checkContent( );
				/* var maxContentLen = 900;
				if( ($(this).val()).length > maxContentLen) {
					alert("더 이상 입력 불가능")
				    $(this).val(  ($(this).val()).substring(0, maxContentLen)   );
				}
				$('.zzz').text(   $('.content').val().length  ); */
			});
		});
		//************************************************
		// 게시판 글의 유효성 체크 함수 선언
		//************************************************
		function checkContent( ){
			var maxContentLen = 900;
			if( ($('.content').val()).length > maxContentLen) {
				alert("더 이상 입력 불가능")
			    $(this).val(  ($(this).val()).substring(0, maxContentLen)   );
			}
			$('.zzz').text(   $('.content').val().length  );
		} 
		//************************************************
		// 게시판 수정 화면으로 이동하는 함수 선언
		//************************************************
		function goBoardUpDelForm( ){
			//=======================================================
			// 현재 화면에서 페이지 이동 없이(=비동기 방식으로) 
			// 서버쪽 "~/checkSonBoardCnt.do"  을 호출하여 
			// [아들 댓글의 개수]에 따른 자스 코드를 포함한 HTML 을 응답 받아 실행하기
			//=======================================================
			$.ajax({
				//------------------
				// 호출할 서버쪽 자원 URL 주소
				//------------------
				url : "${path1}/checkSonBoardCnt.do" 
				//------------------
				// form 태그 안의 데이터를 보내는 방법 지정
				//------------------
				, type : "post"
				//------------------
				// 서버에 보낼 파라미터명과 파라미터값을 설정
				//------------------
				, data : {"board_no":$("[name=board_no]").val()}
				//------------------
				// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
				// 익명함수의 매개변수 html 에는 [아들 댓글의 개수]에 따른 자스 코드가 들어온다.
				//------------------
				,success : function(html) {
					//------------
					// 서버가 응답한 html 소스 문자열을 현재페이지의 body 태그 마지막에 html로 삽입하고 실행하기
					//------------
					$("body").append(html); 
				}
				//------------------
				// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정.
				//------------------
				,error : function() {
					alert("서버 접속 실패!"); 
				}
			});
		}
		//************************************************
		// 게시판 입력 화면으로 이동하는 함수 선언
		//************************************************
		function goBoardRegForm( ){
			document.boardContentForm.action = "${path1}/boardRegForm.do";
			document.boardContentForm.submit();
		}
	</script>
</head>

  
<body><center><br>


<!--*********************************************************************-->
<!--[1개의 게시판 내용] 출력하고 게시판 등록 화면으로 이동하는 form 태그 선언->
<!--*********************************************************************-->
<form class="boardContentForm" name="boardContentForm" method="post" action="${path1}/boardRegForm.do">
	<b>[글 상세 보기]</b>	
	<table class="tbcss1" width="500" border="1" bordercolor="#DDDDDD"  cellpadding="5" align="center">  
	  <tr align="center">
	    <th  bgcolor=#C6C6C6 width=60>글번호
	    <td  width=150>${board.board_no}
	    <th  bgcolor=#C6C6C6 width=60>조회수
	    <td width=150>${board.readcount}
	  <tr align="center">
	    <th bgcolor=#C6C6C6>작성자
	    <td>${board.writer}
	    <th bgcolor=#C6C6C6>작성일
	    <td>${board.reg_date}
	  
	  <tr>
	    <th bgcolor=#C6C6C6>글제목
	    <td colspan="3">${board.subject}
	  
	  <tr>
	    <th  bgcolor=#C6C6C6>글내용
	    <td colspan="3"><pre>${board.content}</pre>
	</table>    
	
	<table><tr height=3><td></table>
	
	<input type="hidden" name="board_no" value="${board.board_no}">
	<input type="hidden" name="selectPageNo" 
			value="${empty param.selectPageNo?1:param.selectPageNo}">
	<input type="hidden" name="rowCntPerPage" 
			value="${empty param.rowCntPerPage?1:param.rowCntPerPage}">
	
	<input type="button" value="글 수정/삭제" onclick="goBoardUpDelForm()">&nbsp;
	<input type="button" value="댓 글쓰기" onclick="goBoardRegForm()">&nbsp;
	<input type="button" value="글목록 보기" onclick="document.boardListForm.submit();">   
</form>   
<!--*********************************************************************-->
		
<!--*********************************************************************-->
<!--이전 페이지에서 온 게시판 선택 페이지 번호를 저장한 hidden 태그 출력하고 [게시판 목록] 화면으로 이동하는 form 태그 선언->
<!--*********************************************************************-->
<form name="boardListForm" method="post" action="${path1}/boardListForm.do">
	<input type="hidden" name="selectPageNo" 
			value="${empty param.selectPageNo?1:param.selectPageNo}">
	<input type="hidden" name="rowCntPerPage" 
			value="${empty param.rowCntPerPage?1:param.rowCntPerPage}">
</form>      
<!--*********************************************************************-->

</body>
</html>    


























