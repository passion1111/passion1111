<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지 처리 방식 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 페이지에 common.jsp 파일 내의 소스 삽입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="/WEB-INF/views/common2.jsp"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--[게시판 입력 결과에 따른 자스실행 코드 설정하기
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<script>

	<c:if test="${contactUpDelCnt>0}">
		alert("연락처 ${param.upDel=='up'?'수정':'삭제'} 성공!");
		$(".searchContact").click( );		
	</c:if>
	
	<c:if test="${contactUpDelCnt==0}">
		alert("연락처가 이미 삭제 되었습니다" );	
		$(".searchContact").click( );		
	</c:if>
	
	<c:if test="${contactUpDelCnt==-1}">
		alert("연락처 ${param.upDel=='up'?'수정':'삭제'} 실패! 관리자에 문의 요망!" );	
	</c:if>
	
</script>