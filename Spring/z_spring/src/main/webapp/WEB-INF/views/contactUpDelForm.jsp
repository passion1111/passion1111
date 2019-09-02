<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지 처리 방식 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 페이지에 common.jsp 파일 내의 소스 삽입-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@include file="common2.jsp"%>

<script>
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// 연락처 수정.삭제 입력양식의 유효성 체크하는 자바스크립트 함수 선언
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	function checkContactUpDelForm( formN, upDel ){
		var contactUpDelFormObj = $("[name="+formN+"]");
		try{
			//**********************************************
			// 수정 버튼을 클릭한 경우
			//**********************************************
			if(upDel=="up"){
				contactUpDelFormObj.find("[name=upDel]").val( 'up' );
				//---------------------------------------
				// 연락처명 유효성 체크
				//---------------------------------------
				var contact_name = contactUpDelFormObj.find("[name=contact_name]").val( ); // 입력한 연락처명 가져오기
				// 만약 연락처명이 한글 또는 영어가 아니면 경고하고, 지우고 ,함수 멈추기
				if( new RegExp(/^[가-힣a-zA-Z]/).test(contact_name)==false  ){
				   alert( "연락처명는 공백 없이 영대소문자 또는 한글만 입력돼야 합니다.");
				   contactUpDelFormObj.find("[name=contact_name]").val( "" );
				   return;
				}
				//---------------------------------------
				// 전화번호 유효성 체크
				//---------------------------------------
				var phone = contactUpDelFormObj.find("[name=phone]").val( );   // 입력한 전화번호 가져오기
				// 만약 연락처명이 한글 또는 영어가 아니면 경고하고, 지우고 ,함수 멈추기
				if( new RegExp( /^[0-9]+$/ ).test(phone)==false ){
				   alert("전화번호는 - 없이 숫자만 입력 요망!");
				   contactUpDelFormObj.find("[name=phone]").val( "" );
				   return;
				}
				//---------------------------------------
				// 사업분야 유효성 체크
				//---------------------------------------
				// 사업분야 체크개수 가져오기
				var saup_fieldCnt = contactUpDelFormObj.find("[name=saup_field]").filter(":checked").length;
				// 사업분야 체크개수가 0개면 경고하고, 함수 멈추기
				if( saup_fieldCnt==0 ){
				   alert( "연락처 사업분야는 반드시 1개 이상 체크해야합니다.");
				   return;
				}
				if(confirm("정말 수정할까요")==false ){ return; }
			}
			//**********************************************
			// 삭제 버튼을 클릭한 경우
			//**********************************************
			else{
				contactUpDelFormObj.find("[name=upDel]").val( 'del' );
				if(confirm("정말 삭제할까요")==false ){ return; }
			}

			//---------------------------------------
			// <방법1>현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/contactRegProc.do"  을 호출하여
			//        연락처 입력 후 응답 html 소스를 받아 실행하다
			//---------------------------------------
			//**********************************************
			// <방법1>현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/contactUpDelProc.do"  을 호출하여
			//        [연락처 수정/식제 행 적용 개수]가 있는 html 소스를 받는다.
			//**********************************************
			$.ajax({
				// ----------------------------
				// 호출할 서버쪽 URL 주소 설정
				// ----------------------------
				url : "${path1}/contactUpDelProc.do"
				// ----------------------------
				// 전송 방법 설정
				// ----------------------------
				,type : "post"
				//---------------------------------
				// 서버에 보낼 파라미터명과 파라미터값을 설정
				//---------------------------------
				,data : contactUpDelFormObj.serialize( )
				//---------------------------------
				// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
				// 익명함수의 매개변수 data 에는 contactUpDelProc.jsp 의 실행 결과물인 html 소스가 문자열로 들어옴.
				//---------------------------------
				,success : function( html ){
					// body 태그 마지막에 매개변수로 들어온 html 소스를 삽입한 후 실행하기
					$("body").append(html);
				}
				//---------------------------------
				// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정.
				//---------------------------------
				,error : function(  ){
					alert("서버와 통신 실패!");
				}
			});
			
			/*
			//**********************************************
			// <방법2>현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/contactUpDelProc2.do"  을 호출하여
			//        [연락처 수정/식제 행 적용 개수]를 받는다.
			//**********************************************
			$.ajax({
				// ----------------------------
				// 호출할 서버쪽 URL 주소 설정
				// ----------------------------
				url : "${path1}/contactUpDelProc2.do"
				// ----------------------------
				// 전송 방법 설정
				// ----------------------------
				,type : "post"
				//---------------------------------
				// 서버에 보낼 파라미터명과 파라미터값을 설정
				//---------------------------------
				,data : contactUpDelFormObj.serialize( )
				//---------------------------------
				// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
				// 익명함수의 매개변수 data 에는 contactUpDelProc2.jsp 의 실행 결과물인 html 소스가 문자열로 들어옴.
				//---------------------------------
				,success : function( upDelCnt ){
					if( upDelCnt>0 ){
						alert( "연락처 " + (upDel=='up'?'수정':'삭제') + " 성공!");
						$(".searchContact").click( );		
					}					
					else if( upDelCnt==0 ){
						alert( "연락처가 이미 삭제되었습니다" );	
						$(".searchContact").click( );		
					}						
					else if( upDelCnt==-1 ){
						alert( "연락처 " + (upDel=='up'?'수정':'삭제') + " 실패! 관리자에 문의 요망!" );	
					}
				}
				//---------------------------------
				// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정.
				//---------------------------------
				,error : function(  ){
					alert("서버와 통신 실패!");
				}
			});
			*/

		}catch(e){
			alert( "checkContactUpDelForm( ) 함수 예외 발생!" );
		}
	}

</script>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--만약 수정할 연락처가 없으면 경고하고 검색 버튼 클릭하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<c:if test="${empty contact}">
	<script>
		alert("이미 삭제된 연락처 입니다.");
		$(".searchContact").click();
	</script>
</c:if>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--만약 수정/삭제할 연락처가 있으면 수정/삭제 화면 출력하기->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<c:if test="${!empty contact}">

	<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--->
	<!-- <수정/삭제 화면 출력 방법1>스프링 폼태그 사용 않고 [수정/삭제 연락처] 화면 출력하기->
	<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--->
	<%-- 
	<!-------------------------------------------------------->
	<div class="contactUpDelDiv" style="padding:3;background-color:#F6F6F6;border:1px solid gray">
	<!-------------------------------------------------------->
		<center><b>^</b>
		
		<form name="contactUpDelForm${contact.contact_no}" method="post"  action="${path1}/contactUpDelProc.do">
			<b>[연락처 수정/삭제]</b>
			<table cellpadding="5" class="tbcss1" border=1>
				<tr>
					<th>연락처명
					<td><input type="text" name="contact_name" size="15">
				<tr>
					<th>전화
					<td><input type="text" name="phone" size="15">
				<tr>
					<th>사업분야
					<td>
					   <!----------------------------------------->
					   <!--HttpServletRequest 객체에 saup_fieldList 라는 킷값으로 저장된 List<Map> 객체에 저장된 -->
					   <!--[사업분야번호]와 [사업분야이름]을 꺼내어 checkbox 양식에 name 속성값과 value 속성값으로 표현해 출력하기-->
					   <!----------------------------------------->
					   <c:forEach var="saup_field" items="${requestScope.saup_fieldList}">
							<input type="checkbox" name="saup_field"  value="${saup_field.saup_field_code}">${saup_field.saup_field_name}
					   </c:forEach>
				<tr>
					<th>등록일
					<td>${contact.reg_date}
			</table>
			<input type="hidden" name="contact_no">
			<input type="hidden" name="upDel">
			
			<table><tr height=2><td></table>
			
			<input type="button" value="수정" onClick="checkContactUpDelForm( 'contactUpDelForm${contact.contact_no}', 'up' )">
			<input type="button" value="삭제" onClick="checkContactUpDelForm( 'contactUpDelForm${contact.contact_no}', 'del' )">
			<span style="cursor:pointer" onclick="closeContactUpDelForm(${contact.contact_no});">[닫기]</span>
		</form>
		
		</center>
	<!-------------------------------------------------------->
	</div>
	<!-------------------------------------------------------->
	<script>
			var contactUpDelFormObj = $("[name=contactUpDelForm${contact.contact_no}]");
			contactUpDelFormObj.find("[name=contact_no]").val( "${contact.contact_no}");
			contactUpDelFormObj.find("[name=contact_name]").val( "${contact.contact_name}");
			contactUpDelFormObj.find("[name=phone]").val( "${contact.phone}");
		    <c:forEach var="saup_field" items="${contact.saup_field}">
		    	contactUpDelFormObj.find("[name=saup_field]").filter("[value=${saup_field}]").click( );
		    </c:forEach>
	</script> 
	--%>
		
	<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--->
	<!-- <수정/삭제 화면 출력 방법2>스프링 폼태그 사용한 [수정/삭제 연락처] 화면 출력하기->
	<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--->
	<!-------------------------------------------------------->
	<div class="contactUpDelDiv" style="padding:3;background-color:#F6F6F6;border:1px solid gray">
	<!-------------------------------------------------------->
		<center><b>^</b>
		
		<form:form  commandName="contact"  name="contactUpDelForm${contact.contact_no}" method="post" action="${path1}/contactUpDelProc.do">
			<!----------------------------------------->
			<!--<위 스프링 폼태그 코드 의미>-->
			<!----------------------------------------->
			<!--<form  name="contactUpDelForm${contact.contact_no}" method="post" action="${path1}/contactUpDelProc.do"> 와 동일하고-->
			<!--commandName="contact" 에 의해 contact 라는 킷값으로 저장된 DTO 객체의 속성변수 저장값을  -->
			<!--이 폼태그 내부의 [입력 양식]에 value 값으로 삽입한다. -->
			<!----------------------------------------->
			<b>[연락처 수정/삭제]</b>
			<table class="tbcss1" cellpadding="5" bordercolor="gray">
				<tr>
					<th>연락처명
					<td><form:input  path="contact_name"/>
					   <!----------------------------------------->
					   <!--<위 폼태그 코드 의미>-->
					   <!----------------------------------------->
					   <!--<input type="text" name="contact_name" value="${contact.contact_name}"> 로 변환되어 출력된다.-->
					   <!--contact 은 commandName="contact" 에서 contact 이다-->
					   <!----------------------------------------->
				<tr>
					<th>전화
					<td><form:input  path="phone"/>
					   <!----------------------------------------->
					   <!--<위 폼태그 코드 의미>-->
					   <!----------------------------------------->
					   <!--<input type="text" name="phone" value="${contact.phone}"> 로 변환되어 출력된다.-->
					   <!--contact 은 commandName="contact" 에서 contact 이다-->
					   <!----------------------------------------->
				<tr>
					<th>사업분야
					<td><form:checkboxes  path="saup_field" items="${saup_fieldMap}" />
					   <!----------------------------------------->
					   <!--<위 폼태그 코드 의미>-->
					   <!----------------------------------------->
					   <!--
					   	   만약 saup_fieldMap 란 키값으로 저장된 Map 객체의 소유 데이터가   1-IT  2-통신  3-금융  4-기타   이고,
					   	   만약 contact 란 키값으로 저장된 DTO 객체의 속성변수 saup_field 에 저장된 데이터가 2, 3 이라면 
					   	   아래와 같은 checkbox 로 변환되어 출력된다.
						   --------------------------------
						   <input type="checkbox" name="saup_field" value="1">IT
						   <input type="checkbox" name="saup_field" value="2" checked>통신
						   <input type="checkbox" name="saup_field" value="3" checked>금융
						   <input type="checkbox" name="saup_field" value="4">기타		  
					   -->
					   
			</table>
			
			<form:hidden path="contact_no"/>
				   <!----------------------------------------->
				   <!--<위 폼태그 코드 의미>-->
				   <!----------------------------------------->
				   <!--<input type="text" name="contact_no" value="${contact.contact_no}"> 로 변환되어 출력된다.-->
			       <!--contact 은 commandName="contact" 에서 contact 이다-->
				   <!----------------------------------------->
			<input type="hidden" name="upDel" value="up">
			
			<!----------->
			<div  style = "height:4"></div>
			<!----------->
			<input type="button" value="   수정   " onClick="checkContactUpDelForm(this.form.name, 'up')">
			<input type="button" value="   삭제   " onClick="checkContactUpDelForm(this.form.name, 'del')">
			<span style="cursor:pointer" onclick="closeContactUpDelForm(${contact.contact_no});">[닫기]</span>
		</form:form>
		
		</center>
	<!-------------------------------------------------------->
	</div>
	<!-------------------------------------------------------->

</c:if>



