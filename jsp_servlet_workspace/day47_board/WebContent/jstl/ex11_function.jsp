<!-- ex11_function.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>JSTL function 라이브러리의 함수 사용 예제</title>
</head>
<body>
	<h3>JSTL function 라이브러리의 함수 사용 예제</h3>
	
	<c:set var="str1" value="test String" />
	<c:set var="str2" value="<aaa>여기</aaa>를 클릭해서 다운로드" />
	<p> str1 출력 : ${ str1 }
	<p> str2 출력 : ${ fn:escapeXml(str2) }
	
	<c:if test="${ fn:contains(str1, 'test') }">
		<p> test 문자열 포함되어 있어요.
	</c:if>
	
	<p>indexOf(str1, 'S') : ${ fn:indexOf(str1, 'S') }
	<p>length(str2) : ${ fn:length(str2) }
	
	<c:set var="spStr" value="${fn:split(str1, ' ') }" />
	<p> fn:split(str1, ' ') 수행후 첫 원소값 : ${ spStr[1] }
	<p> join(str1, '-') : ${ fn:join(spStr, '-') }
	
	<p>replace(str1, 'test', '테스트') : 
			${ fn:replace(str1, 'test', '테스트') }</p>
			
	<p>startsWith(str1, 'test') : ${ fn:startsWith(str1, 'test') }</p>
	<p>substring(str1, 0, 3) : ${ fn:substring(str1, 0, 3) }</p>
	<p>substringAfter(str1, ' ') : ${ fn:substringAfter(str1, ' ') }</p>
	<p>substringBefore(str1, ' ') : ${ fn:substringBefore(str1, ' ') }</p>
	
	<p>toLowerCase(str1) : ${ fn:toLowerCase(str1) }</p>
	<p>toUpperCase(str1) : ${ fn:toUpperCase(str1) }</p>
</body>
</html>






<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL function 라이브러리 함수 사용 예제</title>
</head>
<body>
	<h3>JSTL function 라이브러리의 함수 사용 예제</h3>
	<c:set var="str1" value="test String"/>
	<c:set var="str2" value="<aaa>여기</aaa>를 클릭해서 다운로드"/>
	<p> str1 출력			<c:out value="${str1 }"></c:out>		
	<p> str2 출력 			<c:out value="${fn:escapeXml(str2) }"></c:out>
	<c:if test="${fn:contains(str1,'test') }">
	 <p> test 문자열 포함
	</c:if>
	
	<p>indexOf(str1,'s'):${ fn:indexOf(str1,'s') }
	<p>length(str2) : ${fn:length(str2) }
	
	<c:set var="spStr" value="${fn:split(str1,' ') }"/>
	<p> fn:split(str1,' ') 수행후  첫 원소값 : ${spStr[1] }
	<p>join(str1,'-') : ${fn:join(spStr, '-') }
	
	<p>replace(str1,'test','테스트') : ${fn:replace(str1,'test','테스트') }
	<p>startwith(str1,'test')  : ${fn:startsWith(str1,'test') }
	<p>substring(str1,0,2) :${fn:substring(str1,' ') }
	<p>substringafter(str1,' ' ): ${fn:substringAfter(str1,' ') }
	<p>substringBefore(str1,' ' ): ${fn:substringBefore(str1,' ') }

	<p>toLowercase(str1)  : ${fn:toLowerCase(str1) }
	<p>toUpperCase(str1)  :${ fn:toUpperCase(str1) }
</body>
</html> --%>