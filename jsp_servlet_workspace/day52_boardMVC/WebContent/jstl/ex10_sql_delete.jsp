<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sql 태그 예제-update</title>
</head>
<body>
 	<sql:update dataSource="jdbc:BoardDB">
 			delete  from board where num=?
 			<sql:param value="${3 }"/>
 	</sql:update>
 	
 		<sql:query var="rs" dataSource="jdbc:BoardDB">
 			select * from board order by num desc
 	</sql:query>
 	
 	<table border="1">
 		<tr> <!-- 필드명 -->
 			<c:forEach var="columnName" items="${rs.columnNames }">
				<th><c:out value="${columnName }"></c:out> 			
 			</c:forEach>
 		</tr>
			<c:forEach var="row" items="${rs.rowsByIndex }"> <!-- 레코드 수만 큼 반 복. -->
				<tr>
					<c:forEach var="column" items="${row }" varStatus="i"> <!-- 레코드의 필드 수 만큼 반복 -->
						<td>
							<c:if test="${column!=null }"> <!-- 해당 필드값이 비어있지않다면. -->
								<c:out value="${column }"/>
							</c:if>
						</td>
					</c:forEach>
				</tr>
			</c:forEach> 			
 	
 	</table>
</body>
</html>