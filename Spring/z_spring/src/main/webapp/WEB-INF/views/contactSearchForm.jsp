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

<script src="/erp/resources/jquery-1.11.0.min.js" type="text/javascript"></script>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--연락처 목록 보기 화면 구성하는 HTML 태그 코딩하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<html><head><title>연락처</title></head>
<script>

	//alert($);
	var contact_nos = [];
	//*************************************************
	// body 태그를 모두 실행한 후에 실행할 자스 코드 설정
	//*************************************************
	$(document).ready(function(){
			// 연락처 검색 결과물 출력 시 헤더를 빼고 짝수행,홀수행,마우스온했을때의 배경색 설정하는 함수 호출
			//setTableTrBgColor("contactSearchResult", "white", "#EFEFEF", "#8F8F8F"); //#FFFFCE
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
			contactSearchFormObj.find(".to_today1").click(function(){   // 오른쪽도 가능 contactSearchFormObj.find("[name=min_reg_month]").next().click(function(){
				var today=new Date();
				var year=today.getFullYear();
				var month=today.getMonth()+1;  if(month<10){month="0"+month}
				contactSearchFormObj.find("[name=min_reg_year]").val(year);
				contactSearchFormObj.find("[name=min_reg_month]").val(month);
				check_reg_date( );
			});
			contactSearchFormObj.find(".to_today2").click(function(){    // 오르쪽도 가능 contactSearchFormObj.find("[name=max_reg_month]").next().click(function(){
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
			contactSearchFormObj.find(".empty1").click(function(){   // 오른쪽도 가능  contactSearchFormObj.find("[name=min_reg_month]").next().next().click(function(){
				contactSearchFormObj.find("[name^=min_reg_]").val('');
			});
			contactSearchFormObj.find(".empty2").click(function(){   // 오른쪽도 가능  contactSearchFormObj.find("[name=max_reg_month]").next().next().click(function(){
				contactSearchFormObj.find("[name^=max_reg_]").val('');
			});

			contactSearchFormObj.find(".emptyAll").click(function(){
				contactSearchFormObj.find("[name^=min_reg_],[name^=max_reg_]").val('');
			});


			//-----------------------------------------------------
			// [행보기] 목록 상자에서 change 이벤트 시 실행할 구문 설정하기
			//-----------------------------------------------------
			contactSearchFormObj.find("[name=rowCntPerPage]").change(function(){
				//----------------
				// [검색] 버튼을 코딩으로 클릭하기
				//----------------
				contactSearchFormObj.find(".searchContact").click( );
					// 오른쪽도 가능 =>   contactSearchFormObj.find("[value*=검색]").not("[value*=모두검색]").click()
					// 오른쪽도 가능 =>   document.contactSearchForm.submit( );
			});
			
			
			//-----------------------------------------------------
			// [검색] 버튼 클릭 시 실행할 구문 설정하기
			//-----------------------------------------------------
			contactSearchFormObj.find(".searchContact").click(function(){
					//alert($("[name=contactSearchForm]").serialize( ));
					// ----------------------------
					// 현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/contactSearchProc.do"  을 호출하여
					// [연락처 검색 결과물]이 있는 html 소스를 받는다.
					// ----------------------------
					$.ajax({
						// ----------------------------
						// 호출할 서버쪽 URL 주소 설정
						// ----------------------------
						url : "${path1}/contactSearchProc.do"
						// ----------------------------
						// 전송 방법 설정
						// ----------------------------
						,type : "post"
						//---------------------------------
						// 서버에 보낼 파라미터명과 파라미터값을 설정
						//---------------------------------
						,data : $("[name=contactSearchForm]").serialize( )
						//---------------------------------
						// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
						// 익명함수의 매개변수 data 에는 contactRegProc.jsp 의 실행 결과물인 html 소스가 문자열로 들어옴.
						//---------------------------------
						,success : function( html ){
							//alert(  "${path1}/contactSearchProc.do" );
							//alert("${path1}/contactSearchProc.do"); return;
							//$(".contactList_div").html( "<textarea cols=500 rows=1000>"+html+"</textarea>" );
							$(".contactList_div").html( html );
						}
						//---------------------------------
						// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정.
						//---------------------------------
						,error : function(  ){
							alert("서버접속 실패! 관리자에게 문의 바람!");
						}
					});
			});

			//-----------------------------------------------------
			// [모두검색] 버튼에 클릭 이벤트 시 실행할 구문 설정하기
			//-----------------------------------------------------
			contactSearchFormObj.find(".searchContactAll").click(function(){ //오른쪽도 가능  contactSearchFormObj.find("[value*=모두검색]").click(function(){
				//----------------
				// input,select,textarea 양식 초기화 하기.
				//----------------
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
						":checkbox,:radio,[type=button],[name=rowCntPerPage],[name=selectPageNo]"
				).val('');
				
				//----------------
				// 체크된 입력 양식 체크 풀기.
				//----------------
				contactSearchFormObj.find(":checkbox,:radio").prop("checked", false);
				//----------------
				// [검색] 버튼을 코딩으로 클릭하기
				//----------------
				contactSearchFormObj.find(".searchContact").click( );
					// 오른쪽도 가능 =>   contactSearchFormObj.find("[value*=검색]").not("[value*=모두검색]").click()
					// 오른쪽도 가능 =>   document.contactSearchForm.submit( );
			});

			//-----------------------------------------------------
			// 파라미터값을 입력 양식에 삽입하여 [검색 조건] 및 기타 입력 양식에 이전 화면에서의 데이터 흔적 남기기.
			//-----------------------------------------------------
			/* contactSearchFormObj.find("[name=min_reg_year]").val( '${contactSearchDTO.min_reg_year}' );
			contactSearchFormObj.find("[name=min_reg_month]").val( '${contactSearchDTO.min_reg_month}' );
			contactSearchFormObj.find("[name=max_reg_year]").val( '${contactSearchDTO.max_reg_year}' );
			contactSearchFormObj.find("[name=max_reg_month]").val( '${contactSearchDTO.max_reg_month}' );
			//-----------
			contactSearchFormObj.find("[name=sort]").val( '${contactSearchDTO.sort}' );
			//contactSearchFormObj.find("[name=selectPageNo]").val( '${(empty contactSearchDTO.selectPageNo)?1:contactSearchDTO.selectPageNo}' );
			//contactSearchFormObj.find("[name=rowCntPerPage]").val( '${(empty contactSearchDTO.rowCntPerPage)?15:contactSearchDTO.rowCntPerPage}' );
			contactSearchFormObj.find("[name=selectPageNo]").val( '${contactSearchDTO.selectPageNo}' );
			contactSearchFormObj.find("[name=rowCntPerPage]").val( '${contactSearchDTO.rowCntPerPage}' ); 
			
			<c:forEach var="saup_field" items="${saup_fieldList}">
					$("[name=saup_field]").filter("[value=${saup_field}]").click();
			</c:forEach>
			
			//-----------
			contactSearchFormObj.find("[name=contactRegFormDiv_top]").val( '${param.contactRegFormDiv_top}' );
			contactSearchFormObj.find("[name=contactRegFormDiv_left]").val( '${param.contactRegFormDiv_left}' );
			contactSearchFormObj.find("[name=is_open_contactRegFormDiv]").val( '${param.is_open_contactRegFormDiv}' );*/

			//alert( "${param.contactRegFormDiv_top} / ${param.contactRegFormDiv_left}");
				//------------------------------------------------
				//<초 특급 주의>
				//------------------------------------------------
				// [선택한 페이지 번호]와 [보여줄 행의 개수] 는 반드시 무조건 디폴트 값을 설정한다.
				// 컨트롤러 클래스의 메소드의 매개변수로 DTO 객체가 설정되면
				// 파라미터명과 동일한 속성변수로 파라미터값이 저장되는데 파라미터값이 없으면 null 값이 저장된다.
				// 이때 속성변수 자료형이 int 일 경우 null 값이 저장될 수 없어 에러가 발생하기 떄문이다..
				//------------------------------------------------

			//alert( '${param.is_open_contactRegFormDiv}' );
			//--------------------------------------------------
			// 이전 페이지에서 연락처 입력 화면이 열려 있었으면 현대 페이지에서도 열기
			//--------------------------------------------------
			/* <c:if test="${param.is_open_contactRegFormDiv=='1'}">
				$(".openContactRegForm").click();
			</c:if>
			*/
			
			//clickOpenedContact( );
			
			contactSearchFormObj.find(".searchContact").click( );
			
			
	});  //$(document).ready(function(){
			
			

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
	// [연락처 등록 화면] 보이게 하는 함수선언
	// [연락처 등록] 버튼 클릭할 경우 호출되는 함수이다.
	//*************************************************
	function  openContactRegForm(  ){
		// [연락처 등록] 버튼 클릭 위치의 x, y 좌표 얻기
		var left = event.clientX; var top = event.clientY;
		$('.contactRegFormDiv').remove( );
		$.ajax({
			url : "${path1}/contactRegForm.do"
			, type : "post"
			//, data : {"contact_no":contact_no}
			, datatype : "html"
			, success : function(html) {
				//----------------------
				// div 태그 내부에 서버가 보내준 [연락처 등록 화면 html] 을 삽입하고
				// 이 div 태그를 body 태그 마지막에 삽입하여 실행한다.
				//----------------------
				$("body").append(
					"<div class='contactRegFormDiv' " +
						"style='display:block;padding:10;position:absolute;top:0;left;0:z-index:5; background-color:#F6F6F6;border:1px solid gray'><center>"
					 + html +
					"</center></div>"
				);
				//left = 0; top = 70; $(".contactRegFormDiv").css({'height':'100%','width':'100%'});
				//----------------------
				// 삽입되는 div 태그의 x, y 좌표를 [연락처 등록] 버튼 클릭 위치 근처로 설정하기
				//----------------------
				$(".contactRegFormDiv").css({'top':top,'left':left});
				//----------------------
				// 삽입되는 div 태그 보이기
				//----------------------				
				$(".contactRegFormDiv").show();
			}
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	}

	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// class=contactRegFormDiv 가진 div 태그 안보이게 하는 함수선언
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	function  closeContactRegForm(  ){
		//$("[name=contactSearchForm] [name=contactRegFormDiv_top]").val("");
		//$("[name=contactSearchForm] [name=contactRegFormDiv_left]").val("");
		document.contactRegForm.reset();
		$(".contactRegFormDiv").hide();
	}

	
	
	
	
	
	//*************************************************
	// [연락처 수정/삭제 화면] 보이게 하는 함수 선언
	//*************************************************
	function  openContactUpDelForm( contact_no ){
		//------------------------------------
		// 매개변수로 들어온 연락처 번호를 제외한 연락처 번호를 가진 [연락처 수정/삭제 화면]의 tr 태그 제거 하기
		//------------------------------------
		//$(".addedTr").not(".addedTr"+contact_no).remove();
		
		//------------------------------------
		// 원하는 [연락처 수정/삭제 화면]이 이미 열려 있으면 [연락처 수정/삭제 화면]의 tr 태그 제거 하기고 함수 종료
		//------------------------------------
		if( $(".addedTr"+contact_no).length>=1 ) {
			closeContactUpDelForm(contact_no);
			return;
		}
		//------------------------------------
		// 현재 화면에서 페이지 이동 없이 서버쪽 "${path1}/contactUpDelForm.do"  을 호출하여
		// [연락처 수정/삭제 화면] html 소스를 받아 클릭한 행의 다음 행에 [연락처 수정/삭제 화면] 추가해 보이기
		//------------------------------------
		$.ajax({
			url : "${path1}/contactUpDelForm.do"
			, type : "post"
			, data : {"contact_no":contact_no}
			, datatype : "html"
			, success : function(html) {
				/* //------------------
				// 자스 전역 배열객체에 열어줄 수정/삭제 연락처의 PK 값 저장하기
				//------------------
				var cnt = 0;
				for( var i=0 ; i<contact_nos.length ; ++i ){
					if( contact_nos[i]==contact_no ) { cnt++; }
				}
				if( cnt==0 ) { contact_nos.push(contact_no); } */

				//-----------------------
				// 클릭한 행의 바로 밑에 수정/삭제 화면이 내장된 tr 태그를 삽입하기
				//-----------------------
				$(".contactTr"+contact_no).after(
						"<tr class='addedTr addedTr"+contact_no+"'><td align=center colspan=6>"+html+"<br><br><br>"
				);
				//-----------------------
				// 화면 전체를  div 태그로 덮고 수정화면 출력하기
				//-----------------------
				/* openFullScreenDiv2( 
						"addedTr"+contact_no     // div 태그의 class 값
						, "100%"     // 높이 값
						, "100%"       // 너비값
						, "0"         // 왼쪽 상단 모서리의 Y 좌표값
						, "0"        // 왼쪽 상다 모서리의 X 좌표값
						, "white"     // 배경색
						, "1"      // 투명도 0~1. 사이의 값만 입력 가능.
						, html    // div 태그 내부의 삽입 html 소스
				) */ 
				
				//-----------------------
				// 삽입된 수정/삭제 화면을 감추고, 슬리이드 효과로 나타내기한다.
				//-----------------------
				$(".addedTr"+contact_no).find(".contactUpDelDiv").hide();
				$(".addedTr"+contact_no).find(".contactUpDelDiv").slideDown("slow");

				//-----------------------
				// 삽입된 수정/삭제 화면을 감추고, 슬리이드 효과로 나타내기한다.
				//-----------------------
				save_contactNo_to_session( contact_no )
				//-----------------------
				// 홀수행/짝수행 배경색을 새롭게 지정하기
				//-----------------------
				//setContactTrBgcolor();
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
		//del_contactNo_to_session( contact_no );
		$(".addedTr"+contact_no).remove();
		setTableTrBgColor("contactList", "white", "#EFEFEF", "#FFFFCE");
		$(".contactList tr").mouseover().mouseout();
	}
	
	//*************************************************
	// [연락처 수정/삭제 화면]을 삭제하는 함수 선언
	//*************************************************
	function  closeContactUpDelForm( contact_no ){
		//-------------------
		// 열려있는 수정/삭제 화면의 연락처 번호를 HttpSession 객체에서 삭제하기
		//-------------------
		del_contactNo_to_session( contact_no );
		//-------------------
		// 열려있는 수정/삭제 화면의 div 태그를 슬라이드 효과로 천천이 없앤 후
		// tr 태그를 없애기
		//-------------------
		$(".addedTr"+contact_no).find("div:eq(0)").slideUp(
				"slow"
				,function(){
					$(".addedTr"+contact_no).remove();
					//setTimeout(    function(){ setContactTrBgcolor( );} , 100    );
				}
		);
	}

	
	
	
	//*************************************************
	// [연락처] 검새 결과물의 배경색을 바꾸어 주는 함수 선언
	//*************************************************
	function  setContactTrBgcolor(  ){  //return;
		//-------------------------
		// 연락처 검색 테이블의 헤더 배경색 지정하기
		//-------------------------
		$(".contactTr:eq(0)").prev().find("th,td").css( "background-color","${trBgColor_head}");
		//-------------------------
		// 연락처 검색 테이블의 헤더 글자색 지정하기
		//-------------------------
		$(".contactTr:eq(0)").prev().find("th,td").css( "color","${trFontColor_head}");
		//-------------------------
		// 연락처 검색 테이블의 검색 결과믈 삽입 tr 태그의 배경색 지정하기
		//-------------------------
		setTableTrBgColor4( $(".contactTr"), "${trBgColor_odd}", "${trBgColor_even}", "${trBgColor_mouseover}"); 
	}
	
	
		
		
	//*************************************************
	// [HttpSession 객체]에 [수정/삭제 연락처]의 연락처 번호를 저장하기
	//*************************************************
	function  save_contactNo_to_session( contact_no ){
		//---------------------------------
		// {"contact_no":contact_no,"regGetDel":"reg"} 라는 데이터를 가지고
		// /contactNoBank.do 라는 가상주소로 접속하여 
		// HttpSession 객체에 열려진 연락처 수정/삭제 화면의 pk 값을 저장하기
		//---------------------------------
		$.ajax({
			url : "${path1}/contactNoBank.do"
			, type : "post"
			, data : {"contact_no":contact_no,"flag":"reg"}
			, success : function(html){ }
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	}
	//*************************************************
	// [HttpSession 객체]에 저장된 [수정/삭제 연락처]의 연락처 번호를 삭제 저장하기
	//*************************************************
	function  del_contactNo_to_session( contact_no ){
		//---------------------------------
		// {"contact_no":contact_no,"regGetDel":"del"} 라는 데이터를 가지고
		// /contactNoBank.do 라는 가상주소로 접속하여 
		// HttpSession 객체에 저장된 연락처 수정/삭제 화면의 pk 값을 삭제하기
		//---------------------------------
		$.ajax({
			url : "${path1}/contactNoBank.do"
			, type : "post"
			, data : {"contact_no":contact_no,"flag":"del"}
			, success : function(html){ }
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	}
	//*************************************************
	// [HttpSession 객체]에 저장된 [수정/삭제 연락처]의 연락처 번호를 가져와 보이게 하기
	//*************************************************
	function  openContactUpDelFormAll( ){
		$.ajax({
			url : "${path1}/contactNoBank.do"
			, type : "post"
			, data : {"flag":"get"}
			, success : function( contact_noList ){ 
				if( contact_noList!=null ) {
					for( var i=0 ; i<contact_noList.length ; i++ ){
						$(".contactTr"+contact_noList[i]).click();
					}
				}
			}
			, error : function() {
				alert("서버 접속 실패!");
			}
		});
	} 
	
</script>


<body><center><br>
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--[연락처 검색] 화면을 출력하는 form 태그 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmstyle="border-collapse:collapse;" bordercolor=gray border=3 cellpadding=15-->
<form  name="contactSearchForm" action="${path1}/contactSearchForm.do" method="post">
	<b>[연락처 검색]</b>
	<table class="tbcss0" ><tr><td align=center>
	<table class="tbcss1111">
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
			<td><input type="text" name="keyword1">
	</table>

	<div style="height:6"></div>

	<!--**********************************************-->
	<!--[검색 버튼], [모두검색 버튼], [연락처 등록 링크], [로그아웃 링크] 출력--->
	<!--**********************************************-->
	<input type=button value="                 검색                 " class="searchContact">&nbsp;&nbsp;
	<input type=button value="초기화 후 모두검색" class="searchContactAll">&nbsp;&nbsp;
	<span style="cursor:pointer" class="openContactRegForm" onclick="openContactRegForm();">[연락처 등록]</span>
	<!-- <span style="cursor:pointer" class="logout" onclick="logout(  )">[로그아웃]</span> -->
	&nbsp;&nbsp;&nbsp;
	</table>


	<!-- <span style="cursor:pointer" class="openContactRegForm" onclick="openDiv( 'xxx', '100%', '100%', 0, 0, 'lightblue',0.3, 'ppppppp' );">[가즈아]</span>
	<span style="cursor:pointer" class="openContactRegForm" onclick="alert2( '다시 검사 바랍니다.' );">[가즈아2]</span>
	<span style="cursor:pointer" class="openContactRegForm" onclick="alert3( '다시 검사 바랍니다.' );">[가즈아2]</span> -->

 
 
	<div style="height:6"></div>

	<!--**********************************************-->
	<!--[검색 수] 출력--->
	<!--**********************************************-->
	<font size="2"><b>[검색 개수 : <span class="contactListAllCnt_span"></span>개]</b></font>
	<table><tr><td height=1 width=650 bgcolor=white></table>

	<!--**********************************************-->
	<!-- 자바스크립트 함수 호출로 [페이징 번호] 출력. [페이지당 보여줄 행의 개수] 출력-->
	<!--**********************************************-->
	<table border=0 class="pagingNos">
		<tr>
			<td width=500 align=center>
				<span class="paingNo_span"></span>
				<!-- <script>
					printPagingNo(
						'${contactListAllCnt}'               // 검색 결과 총 행 개수
						, '${contactSearchDTO.selectPageNo}'    // 선택된 현재 페이지 번호
						, '${contactSearchDTO.rowCntPerPage}'   // 페이지 당 출력행의 개수
						, '15'                                  // 페이지 당 출력번호 개수
						//, "document.contactSearchForm.submit( );"// 페이지 번호 클릭후 실행할 자스 코드
						, "$('.searchContact').click();"   // 페이지 번호 클릭후 실행할 자스 코드
					);
				</script> -->
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
	<!--	[정렬값 저장 입력 hidden 양식], [선택한 페이지 번호 저장 hidden 양식],
	<!--	[연락처 등록 div 태그의 y 좌표 hidden 양식], [연락처 등록 div 태그의 x 좌표 hidden 양식] -->
	<!--**********************************************-->
	<input type="hidden" name="sort">
	<input type="hidden" name="selectPageNo" value="1">
</form>


<!--**********************************************-->
<!-- 연락처 검색물을 삽입해 넣을 div 태그 선언 
<!--**********************************************-->
<div class="contactList_div"></div>


</body>
</html>









































