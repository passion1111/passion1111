<!-- updatePro.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.bit.board.model.*,java.sql.Timestamp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<<fmt:requestEncoding value="UTF-8"/>

<%-- <%
	request.setCharacterEncoding("utf-8");
%> --%>

<%-- <jsp:useBean id="vo" class="edu.bit.board.model.BoardVO">
	<jsp:setProperty name="vo" property="*" />
</jsp:useBean> --%>

<%
	/* String pageNum = request.getParameter("pageNum");
	BoardDAO dao = BoardDAO.getInstance();
	int check = dao.update(vo); //실제 변경 내용 반영 함수 */
	/* 
	if( check == 1 ){ */
%>	
<%--  <c:if test="${check==1 }"> --%>
	<meta http-equiv="Refresh" content="0; url=list.do?pageNum=${pageNum }">

<%-- <%	}else { %> --%>
<%-- </c:if> --%>
<c:if test="${check==0 }">	  <!-- alert가 먼저실행되고 먼저실행될려면 check==0을 먼저 판단해야만함. 그래서 check==0이 맞으면history go로 전페이지로 이동하게되고 안그러면 url list.do로 바로 이동하게되는 코드.-->
	<script type="text/javascript">
	<!--
		alert("비밀 번호가 맞지 않습니다.");
		history.go(-1);
	//-->
	</script>
</c:if>		
<%-- <% 	}//if end%>
 --%>















