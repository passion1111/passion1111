<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 기술의 한 종류인 [Page Directive] 를 이용하여 현 JSP 페이지 처리 방식 선언하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
	<!--현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, 이문서는 UTF-8 방식으로 인코딩 한다 라고 설정함.-->
	<!--현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다-->
	<!--UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할수 있는 방법이다.-->
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 기술의 한 종류인 [Include Directive]를 이용하여 common2.jsp 파일 내의 소스를 삽입하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="common3.jsp"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--게시판 목록 보기 화면 구성하는 HTML 태그 코딩하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!doctype html>
<html><head><title>게시판</title>
	<script>
		//************************************************
		// body 태그 안의 태그를 모두 실행한 후에 실행할 자스 코드 설정
		//************************************************
		$(document).ready(function(){
			//------------------------------------------
			// 한 페이지에서 보여줄 게시판 목록 행의 개수를 조절하는 
			// select 입력양식에 change 이벤트 발생 시 실행할 코드 설정
			//------------------------------------------
			$("[name=rowCntPerPage]").change(function(){
				// 선택된 페이지 번호를 1로 초기화 하기
				// <주의>이거 설정 안하면 선택 페이지 번호에 맞는 행의 범위가 맞지 않는다.
				$("[name=selectPageNo]").val("1");  
				document.boardListForm.submit();
			});			
			//------------------------------------------
			// [검색] 버튼 클릭 시 실행할 코드 설정
			//------------------------------------------
			$(".searchBoard").click(function(){
				if( $("[name=keyword]").val().split(" ").join()=="" ) { 
					alert("검색 단어가 없어 검색을 할 수 없습니다");
					return;
				}
				$("[name=selectPageNo]").val("1");
				document.boardListForm.submit();
			});	
			//------------------------------------------
			// [모두 검색] 버튼 클릭 시 실행할 코드 설정
			//------------------------------------------
			$(".searchBoardAll").click(function(){
				$("[name=keywordContent]").val("subject");
				$("[name=keyword]").val("");
				$("[name=selectPageNo]").val("1");
				document.boardListForm.submit();
			});
			
			//------------------------------------------
			// [게시판 목록] 행에 마우스 대면 게시판 내용물을 보여주는 div 태그 띄우는 이벤트 걸기
			//------------------------------------------
			$(".boardList tr:eq(0)").nextAll().hover(
				function(){
					var trObj = $(this);
					//--------------
					// hidden 태그에 저장된 게시판 내용물을 변수에 저장하기
					//--------------
					var contentV = trObj.find("[name=content]").val();   //#F5F5F
					$(".contentDiv").remove();
					//--------------
					// body 태그 안의 마지막에 div 태그 삽입하기
					//--------------
					$("body").append(
						"<div style='position:absolute;background-color:white;width:200;height:200;padding:10;border:1px solid black;' class=contentDiv>"
						+contentV+
						"</div>"
					);
					//--------------
					// body 태그 안의 마지막에 삽입된 div 태그의 CSS 값 설정하기
					//--------------
					$(".contentDiv").css({
						// mouseover 이벤트 발생 위치의 Y 좌표 설정
						"top":event.clientY+10,
						// mouseover 이벤트 발생 위치의 X 좌표 설정
						"left":event.clientX+10
					});
				}
				,function(){
					$(".contentDiv").remove();
				}
			);				
			//------------------------------------------ 
			// 이전 화면에서 입력.선택한 검색 관련 데이터를 재 입력하여 흔적 남기기
			// 흔적을 남겨야 무슨 조건으로 검색 했는지 알수 있다.
			//------------------------------------------
			$("[name=boardListForm] [name=selectPageNo]").val( "${empty boardSearchFormDTO.selectPageNo?'1':boardSearchFormDTO.selectPageNo}" );
			$("[name=boardListForm] [name=rowCntPerPage]").val( "${empty boardSearchFormDTO.rowCntPerPage?'15':boardSearchFormDTO.rowCntPerPage}" );
			$("[name=boardListForm] [name=keyword]").val( "${boardSearchFormDTO.keyword}" );
			<c:if test="${boardSearchFormDTO.keywordContent}">
				$("[name=boardListForm] [name=keywordContent]").val( "${boardSearchFormDTO.keywordContent}" );
			</c:if>
			//------------------------------------------
			// 자스 함수를 호출하여 게시판 목록의 홀짝수 행의 배경색, 마우스 대면 변하는 배경색 지정하기
			//------------------------------------------
			setTableTrBgColor4( $(".boardList tr:eq(0)").nextAll(), "white", "#EFEFEF", "#8F8F8F"); //#FFFFCE	
		});
		
		//************************************************
		// [1개의 게시판 내용물]을 보여주는 [게시판 상세 보기 화면]으로 이동하는 함수 선언
		//************************************************
		function goBoardContentForm( board_no ){
			//--------------
			// 클릭한 게시판 글의 PK 값을 name=boardContentForm 가진 
			// form 태그안의 name=b_no 을 가진 입력 양식에 삽입하기
			//--------------
			$("[name=boardContentForm] [name=board_no]").val(board_no);
			//--------------
			// 클릭한 게시판 글의 선택된 페이지 번호를 name=boardContentForm 가진 
			// 폼태그안의 name=selectPageNo 을 가진 입력 양식에 삽입하기
			//--------------
			/* $("[name=boardContentForm] [name=selectPageNo]").val(
				$("[name=boardListForm] [name=selectPageNo]").val()
			); */
			//--------------
			// name=boardContentForm 을 가진 form 태그안의 action 에 설정된 URL 로 이동하기
			// 이동 시 form 태그안의 모든 입력 양식이 파리미터값으로 전송된다.
			//--------------
			document.boardContentForm.submit();
		}

		//************************************************
		// [게시판 입력 화면]으로 이동하는 함수 선언
		//************************************************
		function goBoardRegForm(  ){
			//--------------
			// name=boardRegForm 을 가진 form 태그안의 action 에 설정된 URL 로 이동하기
			// 이동 시 form 태그안의 모든 입력 양식이 파리미터값으로 전송된다.
			//--------------
			document.boardRegForm.submit();
		}

	</script>
</head>

<body><center><br>

<!--*********************************************************************-->
<!--[게시판 목록]을 출력하는 form 태그 선언-->
<!--*********************************************************************-->
<form name="boardListForm" method="post" action="${path1}/boardListForm.do">
	
	<%-- 
	<!--*******************************************************************-->
	<!--페이징 번호 출력(s)-->
	<!--*******************************************************************-->
	<c:if test="${boardListAllCnt>0}">
		<c:set var="pageNoCntPerPage" value="10"/>
		<c:set var="lastPageNo" value="${boardListAllCnt/boardSearchFormDTO.rowCntPerPage + (boardListAllCnt%boardSearchFormDTO.rowCntPerPage==0?0:1)}"/>
		<c:set var="endPageNoPerPage" value="${boardSearchFormDTO.selectPageNo/pageNoCntPerPage + pageNoCntPerPage}"/>
		<c:set var="startPageNoPerPage" value="${endPageNoPerPage-pageNoCntPerPage+1}"/>
		
		<c:if test="${endPageNoPerPage>lastPageNo}">
			<c:set var="endPageNoPerPage" value="${lastPageNo}"/>
		</c:if>
		<!------------------------------->
		<c:if test="${startPageNoPerPage>pageNoCntPerPage}">
			<a href="javascript:$('[name=nowPageNo]').val('1');search( );">[처음] </a>
			<a href="javascript:$('[name=nowPageNo]').val('${startPageNoPerPage-1}');search( );">[이전]&nbsp;&nbsp;</a>
		</c:if>
		<!------------------------------->
		<c:forEach var="no" begin="${startPageNoPerPage}" end="${endPageNoPerPage}">
			<c:if test="${boardSearchFormDTO.selectPageNo!=no}">
				<a href="javascript:$('[name=selectPageNo]').val('${no}');document.boardListForm.submit( );">[${no}]</a>
			</c:if>
			<c:if test="${boardSearchFormDTO.selectPageNo==no}">
				${no}
			</c:if>
		</c:forEach>
		<!------------------------------->
		<c:if test="${endPageNoPerPage<lastPageNo}">
			<a href="javascript:$('[name=selectPageNo]').val('${endPageNoPerPage+1}');document.boardListForm.submit( );">&nbsp;&nbsp;[다음] </a>
			<a href="javascript:$('[name=selectPageNo]').val('${lastPageNo}');document.boardListForm.submit( );">[마지막] </a>
		</c:if>
		<!------------------------------->
	</c:if> 
	--%>
	
	<!-------------------------------------------------------------->
	<!-- [전체 글 수], [글쓰기] 링크 글씨 출력-->
	<!---------------------------------------------------------<a href="javascript:goBoardRegForm( );">[새 글쓰기]</a>----->
	<table class="tbcss1" border=1 cellpadding=5 bgcolor="#FAFAFA">
		<tr>
			<th width=420>[게시판]
			<th width=150>[전체 글 수] : ${requestScope.boardListAllCnt}
			<th width=100> <span style=cursor onclick="goBoardRegForm( );">[새 글쓰기]</span>
	</table>
	
	<!-------------------------------------------------------------->
	<!-- 자바스크립트 함수 호출로 [페이징 번호] 출력, [페이징 번호] 저장한 hidden 태그 출력하기--->
	<!-- 선택한 [페이징 번호] 저장할 hidden 태그 출력하기-->
	<!-- [페이지당 보여줄 행의 개수] 저장한 select 태그 출력하기-->
	<!-------------------------------------------------------------->
	<table border=0 class="pagingNos" >
		<tr>
			<td width=500 align=center>
				<script>
					//------------------------------------
					// 자스함수 printPagingNo 를 호출하여 아래 작업을 한다. (이 함수의 소스는 이해하지 말고 그냥 사용한다)
						//<1>[클릭 가능한 페이지 번호]와 [name=selectPageNo] 를 가진 hidden 태그를 출력
						//<2>페이지 번호를 클릭하면  [name=selectPageNo] 를 가진 hidden 태그에 클릭한 페이지 번호를 저장
						//<3>현재 이 페이지를 다시 호출하기
					//------------------------------------
				 document.write(
					getPagingNo(
							"${requestScope.boardListAllCnt}"          // 검색 결과 총 행 개수
							, "${boardSearchFormDTO.selectPageNo}"         //선택된 현재 페이지 번호
							, "${boardSearchFormDTO.rowCntPerPage}"        // 페이지 당 출력행의 개수
							, "15"                                     // 페이지 당 출력번호 개수
							, "document.boardListForm.submit( );"      // 페이지 번호 클릭후 실행할 자스 코드
					)
				);
				</script>
				<input type="hidden" name="selectPageNo">
			<td width=90 align=right>
				<select name="rowCntPerPage">
					<option value="10">10
					<option value="15">15
					<option value="20">20
					<option value="25">25
					<option value="30">30
					<option value="35">35
					<option value="40">40
				</select> 행보기
	</table>
	<!-------------------------------------------------------------->
	<!--[게시판 검색 결과물] 출력-->
	<!-------------------------------------------------------------->
	<table class="tbcss2 boardList"  border="1" bordercolor="#DDDDDD"  cellpadding="3"> 
		<tr bgcolor=#C6C6C6> 
			<th width="50">번호 
			<th width="250">제목 
			<th width="100">작성자
			<th width="150">작성일 
			<th width="50">조회수
		<!------------------------------------------>
		<c:forEach var="board" items="${boardList}"  varStatus="loopTagStatus">
			<tr align=center  style="cursor:pointer" onClick="goBoardContentForm(${board.BOARD_NO});">
				<td>${oracleDescStartRowNo-loopTagStatus.index}
				<td align=left>
					<c:forEach begin="0" end="${board.PRINT_LEVEL}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach> 
					<c:if test="${board.PRINT_LEVEL>0}">ㄴ</c:if>
					${board.SUBJECT} 
				<td>${board.WRITER} 
				<td>${board.REG_DATE} 
				<td>${board.READCOUNT}	
					<input type="hidden" name="content" value="${board.CONTENT}">
		</c:forEach>
		<!------------------------------------------>
		<!--위 반복문은 아래 코드와 동일하다.--->
		<!------------------------------------------>
		<%
			/* 
			int oracleDescStartRowNo = (Integer)request.getAttribute("boardList");
			List<Map<String,String>> boardList = (List<Map<String,String>>)request.getAttribute("boardList");
			if( boardList!=null ){
				for( int i=0 ; i<boardList.size() ; i++ ){
					Map<String,String> board = boardList.get(i);
					out.print("<tr align=center  style='cursor:pointer' onClick='goBoardContentForm("+board.get("b_no")+");'>");
					out.print("<td>"+(oracleDescStartRowNo-i) );
					out.print("<td align=left>" );
						for( int j=0 ; j<Integer.parseInt(board.get("print_level")) ; j++ ){
							out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" );
						}
						if( Integer.parseInt(board.get("print_level"))>0){ 
							out.print("ㄴ" );
						}
						out.print( board.get("subject")  );
					out.print("<td>"+board.get("writer")  );
					out.print("<td>"+board.get("reg_date") );
					out.print("<td>"+board.get("readcount") );
				}
			} 
			*/
		%>
		<!------------------------------------------>
	</table>	
	<c:if test="${boardListAllCnt==0}">
		<br>게시판에 저장된 글이 없습니다.<br>
	</c:if>
	<table><tr height=3><td></table>	
	
	<!-------------------------------------------------------------->
	<!-- [한 화면에 보여줄 게시판 글의 행 개수가 저장되는 [select 입력 양식] 선언. 
	<!-- 키위드 저장 [text 입력 양식] 선언.
	<!-- 선택된 페이지번호가 저장되는 [hidden 입력 양식] 선언.
	<!-------------------------------------------------------------->
	<select name="keywordContent">
		<option value="subject" selected>제목
		<option value="content">내용
		<option value="writer">작성자
	</select>
	<input type="text" name="keyword">
	<!-------------------------------------------------------------->	
	<!-- [button 입력 양식] 선언. 
	<!-------------------------------------------------------------->
	<input type="button" value="검색" class="searchBoard">&nbsp; 
	<input type="button" value="모두 검색 / 새로 고침" class="searchBoardAll">
</form>					

<!--*********************************************************************-->
<!--[선택한 게시판 상세보기 화면]으로 이동하는 주소를 가진 form 태그 선언하기-->
<!--이 form 태그 내부의 입력양식은 파라미터값으로 이동 페이지로 전달된다.-->
<!--*********************************************************************-->
<form name="boardContentForm" method="post" action="${path1}/boardContentForm.do">
	<!-------------------------------------------------------------->
	<!-- [게시판 글 고유번호]가 저장되는 [hidden 입력 양식] 선언. 
	<!-- [선택된 페이지번호]가 저장되는 [hidden 입력 양식] 선언. 
	<!-- [한 화면에 보여줄 게시판 글의 행 개수]가 저장되는 [hidden 입력 양식] 선언. 
	<!-------------------------------------------------------------->
	<input type="hidden" name="board_no">
	<input type="hidden" name="selectPageNo" value="${boardSearchFormDTO.selectPageNo}">
	<input type="hidden" name="rowCntPerPage" value="${boardSearchFormDTO.rowCntPerPage}">
</form>		

<!--*********************************************************************-->
<!--[게시판 등록 화면]으로 이동하는 주소를 가진 form 태그 선언하기-->
<!--이 form 태그 내부의 입력양식은 파라미터값으로 이동 페이지로 전달된다.-->
<!--*********************************************************************-->
<form name="boardRegForm" method="post" action="${path1}/boardRegForm.do">
	<input type="hidden" name="selectPageNo" value="${boardSearchFormDTO.selectPageNo}">
	<input type="hidden" name="rowCntPerPage" value="${boardSearchFormDTO.rowCntPerPage}">
</form>					

</body>
</html>
































