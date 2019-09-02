<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지 처리 방식 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 페이지에 common.jsp 파일 내의 소스 삽입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="/WEB-INF/views/common1.jsp"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--[수정 또는 삭제 결과에 따른 자스실행 코드 설정하기
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<script>
	<c:if test="${boardUpDelCnt>0}">
		alert("글 "+(upDel="up"?"수정":"삭제")+" 성공!");
		document.boardListForm.submit();					
	</c:if>
	<c:if test="${boardUpDelCnt==0}">
		alert("비밀번호가 틀립니다.");
		$("[name=pwd]").val("");					
	</c:if>
	<c:if test="${boardUpDelCnt<0}">
		alert("글 "+(upDel="up"?"수정":"삭제")+" 실패! 관리자에게 문의 바람");				
	</c:if>
</script>