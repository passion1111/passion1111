<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지 처리 방식 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지에서 사용할 [사용자 정의 태그]인 [JSTL의 C 코어 태그] 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지에서 사용할 [사용자 정의 태그]인 [spring 폼 태그] 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!-- JSTL 커스텀 태그를 사용하여 path1라는 자바 변수 선언하고 EL 로 [컨텍스트루트명] 저장하기-->
<!-- common1.jsp 페이지를 수입한 모든 JSP 페이지에서 달러표시{path1} 으로 꺼낼수 있다.-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<c:set var="path1" value="<%=request.getContextPath()%>"/>


<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지에서 사용할 [JQuery API] 수입-->
<!--<주의>아래에서 수입하는  jsp  또는 js 안에서 [JQuery 객체]를 사용하므로 먼저 [JQuery API]를 수입해야 한다.-->
<!--      안그러면 화면이 얼어버리는 증상이 나타난다.-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<script src="${path1}/resources/jquery-1.11.0.min.js" type="text/javascript"></script>





<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지에서 사용할 [CSS 파일] 수입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!-- <link href="${path1}/resources/style1.css" rel="stylesheet" type="text/css"> -->

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지에서 사용할 [공용 함수 내장된 common.js 파일]  수입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<script src="${path1}/resources/common.js" type="text/javascript"></script>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!-- css2.jsp 파일 내의 소스 삽입하기-->
<!-- <주의>아래 css2.jsp 안에서 JQuery 객체를 사용하므로 위 jquery-1.11.0.min.js 수입을 먼저해야 한다.-->
<!-- <주의>JSP 파일에서 JQeury 사용할 가능성이 있으므로 jquery-1.11.0.min.js 수입 이 후 JSP 파일을 수입해야 한다.-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="/WEB-INF/views/css1.jsp"%>


<!-- 
<style>
	#fixedDiv {position:fixed; _position:absolute; _z-index:-1; width:100%; height:30px;margin-top:0px;}
</style> -->