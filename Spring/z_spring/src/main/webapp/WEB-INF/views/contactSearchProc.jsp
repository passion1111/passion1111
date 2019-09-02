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


<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--검색 결과물 출력하는 table 태그 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<table border=1 cellpadding=5 cellspacing=0 bordercolor=gray width=600  class="tbcss22 contactSearchResult">
	<!------------------------------------------>
	<!--검색 결과의 헤더 행 출력하기. 클릭하면 원하는 정렬 데이터를 hidden 태그에 담고 자기 자신으로 접속하기---->
	<!------------------------------------------>
	<tr bgcolor=#C6C6C6>
		<th>번호
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='contact_name desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val( 'contact_name asc' );$('.searchContact').click( );">▼연락처명
			</c:when>
			<c:when test="${param.sort=='contact_name asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('contact_name desc');$('.searchContact').click( );">▲연락처명
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('contact_name asc');$('.searchContact').click( );">연락처명
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='phone desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('phone asc');$('.searchContact').click( );">▼전화
			</c:when>
			<c:when test="${param.sort=='phone asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('phone desc');$('.searchContact').click( );">▲전화
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('phone asc');$('.searchContact').click( );">전화
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='4 desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('4 asc');$('.searchContact').click( );">▼사업분야
			</c:when>
			<c:when test="${param.sort=='4 asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('4 desc');$('.searchContact').click( );">▲사업분야
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('4 asc');$('.searchContact').click( );">사업분야
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='reg_date desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('reg_date asc');$('.searchContact').click( );">▼등록일
			</c:when>
			<c:when test="${param.sort=='reg_date asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('reg_date desc');$('.searchContact').click( );">▲등록일
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('reg_date asc');$('.searchContact').click( );">등록일
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<!--검색 결과물 출력 시작-->
		<!--검색 결과물 행의 짝수행, 홀수행 배경색 지정하기-->
		<!--검색 결과물 행에 mouseon, mouseout 이벤트 발생 시 배경색 지정하기-->
		<!--검색 결과물 행을 클릭하면 아래에 tr 태그 추가하고 수정/삭제 화면 삽입해주기-->
		<!------------------------------------->
		<c:forEach var="contact" items="${contactList}" varStatus="loopTagStatus">
		
			<%-- <tr align="center"  style="cursor:pointer"  class="contactTr contactTr${contact.contact_no}"> --%>
			
			<%-- 
			<tr align="center"  style="cursor:pointer"  class="contactTr${contact.contact_no}"
					onClick="openContactUpDelForm(${contact.contact_no})"
			> 
			--%>
			
			<%-- 
			<tr align="center"  style="cursor:pointer"  class="contactTr${contact.contact_no}"
					onClick="openContactUpDelForm(${contact.contact_no})"
					bgcolor="${loopTagStatus.count%2==1?'white':'lightblue'}"
					onMouseover = "$('.contactTr${contact.contact_no}').attr('bgcolor', 'yellow');"
					onMouseout = "$('.contactTr${contact.contact_no}').attr('bgcolor', '${loopTagStatus.count%2==1?'white':'lightblue'}');"
			> 
			--%>
			
			
			<tr align="center"  style="cursor:pointer"  
					class="contactTr contactTr${contact.contact_no}"
					onClick="openContactUpDelForm(${contact.contact_no})"> 
					
				<td>${oracleDescStartRowNo-loopTagStatus.index} <!-- 단순 내림 순서 번호 출력-->
				<td>${contact.contact_name}</td>       <!-- 연락처명 출력-->
				<td>${contact.phone}                   <!-- 전화번호 출력-->
				<td>${contact.saup_field}              <!-- 연락처 사업분야를 모아 컴마를 중간에 넣어 출력-->
				<td>${contact.reg_date}                <!-- 연락처 등록일 출력-->
					<%-- <input type="hidden" name="contact_no" value="${contact.contact_no}"> --%>
		</c:forEach>
		<!------------------------------------->
		<!--검색 결과물 출력 끝-->
		<!------------------------------------->
</table>
<table><tr><td height=4></table>

<!------------------------------------->
<c:if test="${empty contactList}">
	<b>검색 조건에 맞는 결과가 없습니다.</b><br>
</c:if>
<!------------------------------------->


<script>
	//------------------------------------------
	// 검색 결괴물의 총 개수를 class=contactListAllCnt_span 을 가진 span 태그 내부에 삽입하기
	//------------------------------------------
	$(".contactListAllCnt_span").text( "${contactListAllCnt}" );
	
	//------------------------------------------
	// 검색 결괴물에 맞는 페이징 번호를 얻어  class=paingNo_span 을 가진 span 태그 내부에 삽입하기
	//------------------------------------------
	$(".paingNo_span").html( 
		getPagingNo(
			'${contactListAllCnt}'               // 검색 결과 총 행 개수
			, $("[name=selectPageNo]").val()   // 선택된 현재 페이지 번호
			, $("[name=rowCntPerPage]").val()  // 페이지 당 출력행의 개수
			, "15"                             // 페이지 당 출력번호 개수
			, "$('.searchContact').click();"   // 페이지 번호 클릭후 실행할 자스 코드
		)
	);		
	//--------------------------------------------
	// HttpSession 객체 저장된 열었었던 수정삭제 화면의 연락처 번호를 꺼내어 수정.삭제 화면 열어주기
	//--------------------------------------------
	openContactUpDelFormAll( );

	//--------------------------------------------
	// [연락처] 검새 결과물의 배경색을 바꾸어 주는 함수 호출하기
	//--------------------------------------------
	setContactTrBgcolor( );	
</script>





























