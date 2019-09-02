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
<%@include file="common2.jsp"%>

<html><head><title>연락검색</title></head>
<script>

	//*************************************************
	// body 태그를 모두 실행한 후에 실행할 자스 코드 설정
	//*************************************************
	$(document).ready(function(){
			//--------------------------------------------------
			// 연락처 검색 결과물 출력 시 짝수행,홀수행,마우스온했을때의 배경색 설정하는 함수 호출(단 헤더는 제외)
			//--------------------------------------------------
			/* setTableTrBgColor("contactSearchResult", "white", "#EFEFEF", "#8F8F8F"); //#FFFFCE */
			
			//--------------------------------------------------
			// name=contactSearchForm 을 가진 form 태그를 관리하는 JQuery 객체 구하기
			//--------------------------------------------------
			var contactSearchFormObj=$("[name=contactSearchForm]");
			
			//-----------------------------------------------------
			// 연락처 등록일 날짜 검색 조건 입력 양식에서 onChange 이벤트가 발생하면 실행할 코드 설정
			// name 속성값이 min_reg_ 또는 max_reg_ 로 시작하는 select 태그 4개에서 change 이밴트가 발생하면 실행할 코드 설정
			//-----------------------------------------------------
			contactSearchFormObj.find("[name^=min_reg_],[name^=max_reg_]").change(function(){
				check_reg_date( );
			});

			//-----------------------------------------------------
			// [이번달로] 글씨를 클릭하면 실행할 구문 설정
			//-----------------------------------------------------
			contactSearchFormObj.find(".to_today1").click(function(){
				var today=new Date();
				var year=today.getFullYear();
				var month=today.getMonth()+1;  if(month<10){month="0"+month}
				contactSearchFormObj.find("[name=min_reg_year]").val(year);
				contactSearchFormObj.find("[name=min_reg_month]").val(month);
				check_reg_date( );
			});
			contactSearchFormObj.find(".to_today2").click(function(){  
				var today=new Date();
				var year=today.getFullYear();
				var month=today.getMonth()+1;  if(month<10){month="0"+month}
				contactSearchFormObj.find("[name=max_reg_year]").val(year);
				contactSearchFormObj.find("[name=max_reg_month]").val(month);
				check_reg_date( );
			});

			//-----------------------------------------------------
			// [비움], [모두비움] 글씨를 클릭하면 실행할 구문 설정
			//-----------------------------------------------------
			contactSearchFormObj.find(".empty1").click(function(){   
				contactSearchFormObj.find("[name^=min_reg_]").val('');
			});
			contactSearchFormObj.find(".empty2").click(function(){ 
				contactSearchFormObj.find("[name^=max_reg_]").val('');
			});
			contactSearchFormObj.find(".emptyAll").click(function(){
				contactSearchFormObj.find("[name^=min_reg_],[name^=max_reg_]").val('');
			});

			//-----------------------------------------------------
			// [검색] 버튼에 클릭 실행할 구문 설정하기
			//-----------------------------------------------------
			contactSearchFormObj.find(".searchContact").click(function(){
				//오른쪽도 가능  contactSearchFormObj.find("[value*=검색]").not("[value*=모두검색]").click(function(){
				/* alert(
						"saup_field 선택 개수=>"+$("[name=saup_field]:checked").length +"\n"
						+ "min_reg_year=>"+$("[name=min_reg_year]").val() +"\n"
						 +"min_reg_month=>"+$("[name=min_reg_month]").val() +"\n"
						 +"max_reg_year=>"+$("[name=max_reg_year]").val() +"\n"
						 +"max_reg_month=>"+$("[name=max_reg_month]").val() +"\n"
						 +"sort=>"+$("[name=sort]").val() +"\n"
						 +"selectPageNo=>"+$("[name=selectPageNo]").val() +"\n"
				); */
				//contactSearchFormObj.find("[name=contactRegFormDiv_top],[name=contactRegFormDiv_left]").val('');
				document.contactSearchForm.submit( );
			});

			//-----------------------------------------------------
			// [모두검색] 버튼에 클릭 이벤트 시 실행할 구문 설정하기
			//-----------------------------------------------------
			contactSearchFormObj.find(".searchContactAll").click(function(){ //오른쪽도 가능  contactSearchFormObj.find("[value*=모두검색]").click(function(){
				// input,select,textarea 양식 초기화 하기.
				// 선택자  :checkbox,:radio,[type=button],[name=selectPageNo],[name=rowCntPerPage]에 해당하는 태그는 제외.
					//------------------------------------------------
					//<초 특급 주의>
					//------------------------------------------------
					// [선택한 페이지 번호]와 [보여줄 행의 개수] 는 값을 비우지 않는다.
					// 컨트롤러 클래스의 메소드의 매개변수로 DTO 객체가 설정되면
					// 파라미터명과 동일한 속성변수로 파라미터값이 저장되는데 파라미터값이 없으면 null 값이 저장된다.
					// 이때 속성변수 자료형이 int 일 경우 null 값이 저장될 수 없어 에러가 발생하기 떄문이다..
					//------------------------------------------------
				contactSearchFormObj.find("input,select,textarea").not(
						":checkbox,:radio,[type=button],[name=selectPageNo],[name=rowCntPerPage]"
				).val('');
				// 체크된 입력 양식 체크 풀기.
				contactSearchFormObj.find(":checkbox,:radio").prop("checked", false);
				// [검색] 버튼을 코딩으로 클릭하기
				contactSearchFormObj.find(".searchContact").click( );
					// 오른쪽도 가능 =>   contactSearchFormObj.find("[value*=검색]").not("[value*=모두검색]").click()
					// 오른쪽도 가능 =>   document.contactSearchForm.submit( );
			});

			//-----------------------------------------------------
			// [행보기] 목록 상자에서 change 이벤트 시 실행할 구문 설정하기
			//-----------------------------------------------------
			contactSearchFormObj.find("[name=rowCntPerPage]").change(function(){
				// [검색] 버튼을 코딩으로 클릭하기
				contactSearchFormObj.find(".searchContact").click( );
			});

			//--------------------------------------------------
			// 이전 페이지에서 연락처 입력 화면이 열려 있었으면 현재 페이지에서도 열기
			//--------------------------------------------------
			<c:if test="${!empty param.contactRegFormDiv_top}">
				$(".showContactRegForm").click();
			</c:if>

			//--------------------------------------------------
			// 이전 페이지에서 열었던 연락처 수정/삭제 화면 열기
			//--------------------------------------------------
			showContactUpDelForm( );
			
			//-----------------------------------------------------
			// 파라미터값을 입력 양식에 삽입하여 [검색 조건] 및 기타 입력 양식에 이전 화면에서의 데이터 흔적 남기기.
			//-----------------------------------------------------
			contactSearchFormObj.find("[name=min_reg_year]").val( '${param.min_reg_year}' );
			contactSearchFormObj.find("[name=min_reg_month]").val( '${param.min_reg_month}' );
			contactSearchFormObj.find("[name=max_reg_year]").val( '${param.max_reg_year}' );
			contactSearchFormObj.find("[name=max_reg_month]").val( '${param.max_reg_month}' );
			//-----------
			contactSearchFormObj.find("[name=sort]").val( '${param.sort}' );
			//contactSearchFormObj.find("[name=selectPageNo]").val( '${(empty contactSearchDTO.selectPageNo)?1:contactSearchDTO.selectPageNo}' );
			//contactSearchFormObj.find("[name=rowCntPerPage]").val( '${(empty contactSearchDTO.rowCntPerPage)?15:contactSearchDTO.rowCntPerPage}' );
			contactSearchFormObj.find("[name=selectPageNo]").val( '${contactSearchDTO.selectPageNo}' );
			contactSearchFormObj.find("[name=rowCntPerPage]").val( '${contactSearchDTO.rowCntPerPage}' );
			//-----------
			contactSearchFormObj.find("[name=contactRegFormDiv_top]").val( '${param.contactRegFormDiv_top}' );
			contactSearchFormObj.find("[name=contactRegFormDiv_left]").val( '${param.contactRegFormDiv_left}' );
				//------------------------------------------------
				//<초 특급 주의>
				//------------------------------------------------
				// [선택한 페이지 번호]와 [보여줄 행의 개수] 는 반드시 무조건 디폴트 값을 설정한다.
				// 컨트롤러 클래스의 메소드의 매개변수로 DTO 객체가 설정되면
				// 파라미터명과 동일한 속성변수로 파라미터값이 저장되는데 파라미터값이 없으면 null 값이 저장된다.
				// 이때 속성변수 자료형이 int 일 경우 null 값이 저장될 수 없어 에러가 발생하기 떄문이다..
				//------------------------------------------------
	});

	//*************************************************
	// 연락처 등록일 검색 조건 관련 태그에서 change 이멘트 발생 시 실행할 코드 설정
	//*************************************************
	function check_reg_date(){
		var contactSearchFormObj=$("[name=contactSearchForm]");
		//----------------------------------
		var min_reg_year = contactSearchFormObj.find("[name=min_reg_year]").val( );
		var min_reg_month = contactSearchFormObj.find("[name=min_reg_month]").val( );
		var max_reg_year = contactSearchFormObj.find("[name=max_reg_year]").val( );
		var max_reg_month = contactSearchFormObj.find("[name=max_reg_month]").val( );
		//----------------------------------
		if( (min_reg_year==null || min_reg_year.length==0) && (min_reg_month!=null && min_reg_month.length>0) ){
			alert("왼쪽 년도를 먼저 선택해야 합니다.");
			contactSearchFormObj.find("[name=min_reg_month]").val( "" );
			return;
		}
		if( (max_reg_year==null || max_reg_year.length==0) && (max_reg_month!=null && max_reg_month.length>0) ){
			alert("왼쪽 년도를 먼저 선택해야 합니다.");
			contactSearchFormObj.find("[name=max_reg_month]").val( "" );
			return;
		}
		//----------------------------------
		if( (min_reg_year!=null && min_reg_year.length>0) && (min_reg_month!=null && min_reg_month.length>0)
			&& (max_reg_year!=null && max_reg_year.length>0) &&  (max_reg_month!=null && max_reg_month.length>0) ){

			var max_date = contactSearchFormObj.find("[name=max_reg_year]").val(  )+contactSearchFormObj.find("[name=max_reg_month]").val(  );
			var min_date = contactSearchFormObj.find("[name=min_reg_year]").val(  )+contactSearchFormObj.find("[name=min_reg_month]").val(  );
			if( parseInt(max_date,10) < parseInt(min_date,10) ) {
				alert("[최소 년월]이 [최대 년월] 보다 큽니다. 재 선택 바람!");
				contactSearchFormObj.find("[name^=min_reg_]").val("");
				contactSearchFormObj.find("[name^=max_reg_]").val("");
				return;
			}
		}
		//----------------------------------
		if((min_reg_year!=null && min_reg_year.length>0)  && (min_reg_month==null || min_reg_month.length==0) ){
			contactSearchFormObj.find("[name=min_reg_month]").val( "01" );
		}
		if((max_reg_year!=null && max_reg_year.length>0)  && (max_reg_month==null || max_reg_month.length==0) ){
			contactSearchFormObj.find("[name=max_reg_month]").val( "12" );
		}
	}

	//*************************************************
	// 연락처 등록  유효성 체크 함수 선언
	//*************************************************
	function checkContactRegForm( ){
		var contactRegFormN = "[name=contactRegForm]";
		try{
			//---------------------------------------
			// 연락처명 유효성 체크
			//---------------------------------------
			var contact_name = $(contactRegFormN+" [name=contact_name]").val( ); // 입력한 연락처명 가져오기
			// 만약 연락처명이 한글 또는 영어가 아니면 경고하고, 지우고 ,함수 멈추기
			
			if( new RegExp(/^[가-힣a-zA-Z0-9]+$/).test(contact_name)==false  ){
			   alert( "연락처명는 공백 없이 영대소문자 또는 한글 또는 숫자만 입력돼야 합니다.");
			   $(contactRegFormN+" [name=contact_name]").val( "" );
			   return;
			}
			//---------------------------------------
			// 전화번호 유효성 체크
			//---------------------------------------
			var phone = $(contactRegFormN+" [name=phone]").val( );   // 입력한 전화번호 가져오기
			// 만약 연락처명이 한글 또는 영어가 아니면 경고하고, 지우고 ,함수 멈추기
			if( new RegExp( /^[0-9]+$/ ).test(phone)==false ){
			   alert("전화번호는 - 없이 숫자만 입력 요망!");
			   $(contactRegFormN+" [name=phone]").val( "" );
			   return;
			}
			//---------------------------------------
			// 사업분야 유효성 체크
			//---------------------------------------
			// 사업분야 체크개수 가져오기
			var saup_fieldCnt = $(contactRegFormN+" [name=saup_field]").filter(":checked").length;
			// 사업분야 체크개수가 0개면 경고하고, 함수 멈추기
			if( saup_fieldCnt==0 ){
			   alert( "연락처 사업분야는 반드시 1개 이상 체크해야합니다.");
			   return;
			}
			if(confirm("정말 등록할까요")==false ){ return; }

			//alert($(contactRegFormN).serialize( ) ); //return;
			//**********************************************
			// 현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/contactRegProc.do"  을 호출하여
			// 응답 html 소스를 받아 실행해뿐다
			//**********************************************
			$.ajax({
				// ----------------------------
				// 호출할 서버쪽 URL 주소 설정
				// ----------------------------
				url : "${path1}/contactRegProc.do"
				// ----------------------------
				// 전송 방법 설정
				// ----------------------------
				,type : "post"
				//---------------------------------
				// 서버에 보낼 파라미터명과 파라미터값을 설정
				//---------------------------------
				,data : $(contactRegFormN).serialize( )
				//---------------------------------
				// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
				// 익명함수의 매개변수 html 에는 서버가 보내준 html 소스가 문자열로 들어옴.
				//---------------------------------
				,success : function( html ){
					// body 태그 마지막에 매개변수로 들어온 html 소스를 삽입한 후 실행하기
					$("body").append(html);
				}
				//---------------------------------
				// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정.
				//---------------------------------
				,error : function(  ){
					alert("서버접속 실패! 관리자에게 문의 바람!");
				}
			});
		}catch(e){
			alert( "checkContactRegForm( ) 함수 예외 발생!" );
		}
	}
	
	
	
	//*************************************************
	// [연락처 등록 화면] 보이게 하는 함수선언
	// [연락처 등록] 버튼 클릭할 경우 호출되는 함수이다.
	//*************************************************
	function  showContactRegForm(  ){
		var left = event.clientX; 
		var top = event.clientY;
		
		<c:if test="${!empty param.contactRegFormDiv_top}">
			left = ${param.contactRegFormDiv_top}; 
			top =  ${param.contactRegFormDiv_left};
		</c:if>
		
		$('.contactRegFormDiv').remove( );
		$.ajax({
			url : "${path1}/contactRegForm.do"
			, type : "post"
			//, data : {"contact_no":contact_no}
			, datatype : "html"
			, success : function(html) {
				$("body").append(
					"<div class='contactRegFormDiv' " +
						"style='display:block;padding:10;position:absolute;top:0;left:0;z-index:5; background-color:#F6F6F6;border:1px solid gray'>"
					 + html +
					"</div>"
				);
				//alert( $(".contactRegFormDiv2").length );
				$(".contactRegFormDiv").css({'top':top,'left':left});
				$(".contactRegFormDiv").show();
			}
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	}

	//*************************************************
	// [연락처 수정/삭제]를 위해 추가된 tr 태그를 삭제하는 함수 선언
	//*************************************************
	function removeAddedTr( contact_no ){
		$(".addedTr"+contact_no).remove();
		deleteUpDelContactNo( contact_no );
		/* setTableTrBgColor("contactList", "white", "#EFEFEF", "#FFFFCE"); */
		/* $(".contactList tr").mouseover().mouseout(); */
	}
	//*************************************************
	// [연락처 수정/삭제 화면] 보이게 하는 함수 선언
	//*************************************************
	function  showContactUpDelForm( contact_no ){	
		
		var old_contact_nos = $("[name=contactSearchForm] [name=upDelContactNos]").val();
		$("[name=contactSearchForm] [name=upDelContactNos]").val( old_contact_nos+"."+contact_no );
		
		//----------------------------------
		// 기존에 열려 있는 다른 [연락처 수정/삭제 화면] 닫기
		//----------------------------------
		//$(".addedTr").not(".addedTr"+contact_no).remove();
		//----------------------------------
		// 원하는 [연락처 수정/삭제 화면]이 이미 열려 있으면 닫고 함수 종료
		//----------------------------------
		if( $(".addedTr"+contact_no).length>=1 ) {
			$(".addedTr"+contact_no).remove();
			deleteUpDelContactNo( contact_no );
			/* $(".contactList tr").mouseover().mouseout(); */
			return;
		}
		//----------------------------------
		// 현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/contactUpDelForm.do"  을 호출하여
		// [연락처 수정/삭제 화면] html 소스를 받아 클릭한 행의 다음 행에 [연락처 수정/삭제 화면] 추가해 보이기
		//----------------------------------
		$.ajax({
			url : "${path1}/contactUpDelForm.do"
			, type : "post"
			, data : {"contact_no":contact_no}
			, datatype : "html"
			, success : function(html) {
				$(".contactTr"+contact_no).after("<tr class='addedTr addedTr"+contact_no+"'><td align=center colspan=6>"+html);

				/* var upDelFormNameVal = $(".addedTr"+contact_no).find("td:eq(0)").find("form:eq(0)").attr("name");
				$(".addedTr"+contact_no).find("td:eq(0)").find("form:eq(0)").attr(
					"name"
					, upDelFormNameVal+contact_no
				);	 */

				/* setTableTrBgColor("contactList", "white", "#EFEFEF", "#FFFFCE");
				$(".contactList tr").mouseover().mouseout(); */
				
				
				saveUpDelContactNo( contact_no );
			}
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	}
	//*************************************************
	// 현재 보이는 [수정/삭제 연락처]의 연락처 번호를 [HttpSession 객체]에 저장
	//*************************************************
	function  saveUpDelContactNo( contact_no ){
		$.ajax({
			url : "${path1}/saveUpDelContactNo.do"
			, type : "post"
			, data : {"contact_no":contact_no}
			, success : function(data) {}
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	}
	//*************************************************
	// 안보이게할  [수정/삭제 연락처]의 연락처 번호를 [HttpSession 객체]에서 삭제 저장
	//*************************************************
	function  deleteUpDelContactNo( contact_no ){
		$.ajax({
			url : "${path1}/deleteUpDelContactNo.do"
			, type : "post"
			, data : {"contact_no":contact_no}
			, success : function(data) {}
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	}
	//*************************************************
	// [HttpSession 객체]에 저장된 [수정/삭제 연락처]의 연락처 번호를 가져와 보이게 하기
	//*************************************************
	function  showContactUpDelForm2( ){
		/* $.ajax({
			url : "${path1}/getUpDelContactNo.do"
			, type : "post"
			//, data : {"contact_no":contact_no}
			, success : function(html) {
				
				$("body").append(html);
				/* if(html!=null){
					for( var i=0 ; i<contact_noList.length ; i++ ){
						var cnt = $(".addedTr"+contact_noList[i]).length;
						$(".contactTr"+contact_noList[i]).click();
					}
				} */
				
			}
			, error : function() {
				alert("서버 접속 실패!");
			}
		}) */

		var old_contact_nos = $("[name=contactSearchForm] [name=upDelContactNos]").val();
		var arr = old_contact_nos.split(".");
		for( var i=0 ; i<arr.length ; i++){
			
		}
	}
</script>


<body><center><br>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--[연락처 검색] 화면을 출력하는 form 태그 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<form  name="contactSearchForm" action="${path1}/contactSearchForm.do" method="post">
	<table class=tbCss1 bordercolor=gray border=3 cellpadding=15><tr><th bgcolor=#FAFAFA>&nbsp;&nbsp;&nbsp;
	<b>[연락처 검색]</b>
	<table class="tbcss1" bordercolor=gray cellpadding=5>
		<tr>
			<th bgcolor=#D8D8D8>사업분야</th>
			<td>
				<c:forEach var="saup_field" items="${saup_fieldList}">
					<input type="checkbox" name="saup_field" value="${saup_field.saup_field_code}" >${saup_field.saup_field_name}
				</c:forEach>
		<tr>
			<th bgcolor=#D8D8D8>등록일
			<td>
				<select name="min_reg_year">
					<option value="">
					<script>
					   for( var i=2000 ; i<new Date( ).getFullYear( )+2 ; i++){
					       document.write( "<option value="+i+">"+i );
					   }
					</script>
				</select>년
				<select name="min_reg_month">
					<option value="">
					<script>
					   for( var i=1 ; i<=12 ; i++){
					       if(i<10){ document.write( "<option value='0"+i+"'>0"+i ); }
					       else   { document.write( "<option value='"+i+"'>"+i ); }
					   }
					</script>
				</select>월
				<span style="cursor:pointer" class="to_today1">[이번달로]</span>
				<span style="cursor:pointer" class="empty1">[비움]</span>
				~
				<select name="max_reg_year">
					<option value="">
					<script>
					   for( var i=2000 ; i<new Date( ).getFullYear( )+2 ; i++){
					       document.write( "<option value="+i+">"+i );
					   }
					</script>
				</select>년
				<select name="max_reg_month">
					<option value="">
					<script>
					   for( var i=1 ; i<=12 ; i++){
					       if(i<10){ document.write( "<option value='0"+i+"'>0"+i ); }
					       else   { document.write( "<option value='"+i+"'>"+i ); }
					   }
					</script>
				</select>월
				<span style="cursor:pointer" class="to_today2">[이번달로]</span>
				<span style="cursor:pointer" class="empty2">[비움]</span>&nbsp;&nbsp;
				<span style="cursor:pointer" class="emptyAll">[모두비움]</span>
		<tr>
			<th bgcolor=#D8D8D8>키워드</th>
			<td><form:input  path="keyword1"/>
	</table>

	<div style="height:6"></div>

	<!--**********************************************-->
	<!--[검색 버튼], [모두검색 버튼], [연락처 등록 링크], [로그아웃 링크] 출력--->
	<!--**********************************************-->
	<input type=button value="                 검색                 " class="searchContact">&nbsp;&nbsp;
	<input type=button value="모두검색" class="searchContactAll">&nbsp;&nbsp;
	<span style="cursor:pointer" class="showContactRegForm" onclick="showContactRegForm();">[연락처 등록]</span>
	<span style="cursor:pointer" class="logout" onclick="logout(  )">[로그아웃]</span>

	&nbsp;&nbsp;&nbsp;</table>

	<div style="height:6"></div>

	<!--**********************************************-->
	<!--[검색 수] 출력--->
	<!--**********************************************-->
	<font size="2"><b>[검색 개수 : ${contactSearchListCnt}개]</b></font>
	<table><tr><td height=1 width=650 bgcolor=white></table>

	<!--**********************************************-->
	<!-- 자바스크립트 함수 호출로 [페이징 번호] 출력. [페이지당 보여줄 행의 개수] 출력-->
	<!--**********************************************-->
	<table border=0 class="pagingNos">
		<tr>
			<td width=500 align=center>
				<script>
				 document.write(
					printPagingHtml2(
						'${contactSearchListCnt}'               // 검색 결과 총 행 개수
						, '${contactSearchDTO.selectPageNo}'    // 선택된 현재 페이지 번호
						, '${contactSearchDTO.rowCntPerPage}'   // 페이지 당 출력행의 개수
						, '15'                                  // 페이지 당 출력번호 개수
						//, "document.contactSearchForm.submit( );"// 페이지 번호 클릭후 실행할 자스 코드
						, "$('.searchContact').click();"   // 페이지 번호 클릭후 실행할 자스 코드
					)
				);
				</script>
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

	<!--**********************************************-->
	<!-- [hidden 입력 양식] 선언.
	<!--**********************************************-->
	<!--	[정렬값 저장 입력 hidden 양식]-->
	<!--	[선택한 페이지 번호 저장 hidden 양식] -->
	<!--	[연락처 등록 div 태그의 존재 여부 저장 hidden 양식]-->
	<!--	[연락처 등록 div 태그의 y 좌표 hidden 양식]-->
	<!--	[연락처 등록 div 태그의 x 좌표 hidden 양식] -->
	<!--**********************************************-->
	<input type="hidden" name="sort">
	<input type="hidden" name="selectPageNo">
	<!-- <input type="hidden" name="is_open_contactRegFormDiv" value="0"> -->
	<input type="hidden" name="contactRegFormDiv_top"  class="contactRegFormDiv_top" >
	<input type="hidden" name="contactRegFormDiv_left"  class="contactRegFormDiv_left">
	
	
	<input type="hidden" name="upDelContactNos" value=".">
</form>



<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--검색 결과물 출력하는 table 태그 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<table border=1 cellpadding=5 cellspacing=0 bordercolor=gray width=600  class="tbcss2 contactSearchResult">
	<!------------------------------------------>
	<!--검색 결과의 헤더 행 출력하기. 클릭하면 원하는 정렬 데이터를 hidden 태그에 담고 자기 자신으로 접속하기---->
	<!------------------------------------------>
	<tr bgcolor=#C6C6C6>
		<th>번호
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='contact_name desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val( 'contact_name asc' );document.contactSearchForm.submit( );">▼연락처명
			</c:when>
			<c:when test="${param.sort=='contact_name asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('contact_name desc');document.contactSearchForm.submit( );">▲연락처명
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('contact_name asc');document.contactSearchForm.submit( );">연락처명
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='phone desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('phone asc');document.contactSearchForm.submit( );">▼전화
			</c:when>
			<c:when test="${param.sort=='phone asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('phone desc');document.contactSearchForm.submit( );">▲전화
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('phone asc');document.contactSearchForm.submit( );">전화
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='4 desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('4 asc');document.contactSearchForm.submit( );">▼사업분야
			</c:when>
			<c:when test="${param.sort=='4 asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('4 desc');document.contactSearchForm.submit( );">▲사업분야
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('4 asc');document.contactSearchForm.submit( );">사업분야
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<c:choose>
			<c:when test="${param.sort=='reg_date desc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('reg_date asc');document.contactSearchForm.submit( );">▼등록일
			</c:when>
			<c:when test="${param.sort=='reg_date asc'}">
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('reg_date desc');document.contactSearchForm.submit( );">▲등록일
			</c:when>
			<c:otherwise>
				<th style="cursor:pointer"
					onclick="$('[name=sort]').val('reg_date asc');document.contactSearchForm.submit( );">등록일
			</c:otherwise>
		</c:choose>
		<!------------------------------------->
		<!--검색 결과물 출력-->
		<!------------------------------------->
		<c:forEach var="contact" items="${contactSearchList}" varStatus="loopTagStatus">
		
			<tr align="center"  style="cursor:pointer"  class="contactTr${contact.contact_no}"
					onClick="showContactUpDelForm(${contact.contact_no})"
					bgcolor="${loopTagStatus.count%2==1?'white':'lightblue'}"
					onMouseover = "$('.contactTr${contact.contact_no}').attr('bgcolor', 'yellow');"
					onMouseout = "$('.contactTr${contact.contact_no}').attr('bgcolor', '${loopTagStatus.count%2==1?'white':'lightblue'}');"
			>
			<%-- <tr align="center"  style="cursor:pointer"  class="contactTr${contact.contact_no}"
					onClick="showContactUpDelForm(${contact.contact_no})"> --%>
					
				<td>${contactSearchListCnt-(contactSearchDTO.startRowNo+loopTagStatus.index)+1} <!-- 단순 내림 순서 번호 출력-->
				<td>${contact.contact_name}</td>       <!-- 연락처명 출력-->
				<td>${contact.phone}                   <!-- 전화번호 출력-->
				<td>${contact.saup_field}              <!-- 연락처 사업분야를 모아 컴마를 중간에 넣어 출력-->
				<td>${contact.reg_date}                <!-- 연락처 등록일 출력-->

		</c:forEach>
</table>

<table><tr><td height=4></table>

<c:if test="${empty contactSearchList}">
	<b>검색 조건에 맞는 결과가 없습니다.</b><br>
</c:if>


<!--****************************************************************************************************************************-->
<div class=="contactRegFormDiv" style="diplay:none;padding:1;background-color:#F6F6F6;border:1px solid gray">
<!--****************************************************************************************************************************-->
	<!--**********************************************-->
	<!--[연락처 등록] 화면을 출력하는 form 태그 선언-->
	<!--**********************************************-->
	<form name="contactRegForm" method="post"  action="${path1}/contactRegProc.do">
		<b>[연락처 등록]</b>
		<table class="tbcss1" cellpadding="5" bordercolor="gray">
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
		</table>

		<table><tr height=2><td></table>

		<input type="button" value="   등록   " onClick="checkContactRegForm( )">
		<span style="cursor:pointer" onclick="hideContactRegFormDiv();">[닫기]</span>
	</form>
<!--****************************************************************************************************************************-->
</div>
<!--****************************************************************************************************************************-->




<!--****************************************************************************************************************************-->
<div class=="contactUpDelFormDiv" style="diplay:none;padding:1;background-color:#F6F6F6;border:1px solid gray">
<!--****************************************************************************************************************************-->
	<!--**********************************************-->
	<!-- 연락처 수정/삭제 화면 출력-->
	<!--**********************************************-->
	<form name="contactUpDelForm" method="post"  action="${path1}/contactUpDelProc.do">
		<b>[연락처 수정/삭제]</b>
		<table class="tbcss1" cellpadding="5" bordercolor="gray">
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
		<div style="height:6"></div>
		<input type="button" value="수정" onClick="checkContactUpDelForm( 'contactUpDelForm${contact.contact_no}', 'up' )">
		<input type="button" value="삭제" onClick="checkContactUpDelForm( 'contactUpDelForm${contact.contact_no}', 'del' )">
		
		<span style="cursor:pointer" onclick="$('.contactTr${contact.contact_no}').click();">[닫기]</span>
		<span style="cursor:pointer" onclick="$('.contactTr${contact.contact_no}').next().remove();">[닫기2]</span>
		<!-- <span style="cursor:pointer" class="logout" onclick="logout(  )">[로그아웃]</span> -->
	</form>
<!--****************************************************************************************************************************-->
</div>
<!--****************************************************************************************************************************-->




</body>
</html>









































