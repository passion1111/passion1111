

//**************************************************************
//  모든 정보 출력하는 함수 선언
//**************************************************************
function print_info_all(  ){
	checkNameVDupl();
	setDataAll(  )
	print_info_oracle_table();
	print_info_DTO(  );
	print_info_js_src();
	print_info_tag(  );
}


//**************************************************************
// 현재 화면 맨위로 이동 시키는 함수 선언. 
//**************************************************************
function goTop(  ){
	$("html,body").scrollTop(0);
}




//**************************************************************
//  % 센트 막대 그래프를 가로로 출력하는 함수 선언
//**************************************************************
function print_graph_percent1 (
	maxSize           // 그래프 막대 최대 길이
	, barWidth        // 그래프 막대 두께
	, fontSize        // 그래프 막대 안에 삽입되는 글자의 크기
	, barBgcolor      // 그래프 막대 배경색
	, ascDesc         // 그래프 나열 기준. 1이면 작은거 부터, 2면 큰거 부터 나열
	, arr2            // 그래프 막대에 대한 정보가 내장된 2차원배열
	//, tailStr         // 그래프 막대에 삽입되는 수치 뒤에 붙을 문자
){
	try{
		if( ascDesc!=0 && ascDesc!=1 && ascDesc!=2 ){
			alert( "print_graph1(~,~,~,~,~,~) 함수 호출시 5번째 값은 0 또는 1 또는 2이어야 합니다"); return;
		}
		var border = 0;
		//--------------------
		for( var i=0 ; i<arr2.length-1 ; ++i ){
			for( var j=i+1 ; j<arr2.length ; ++j ){
				var name1 = arr2[i][0];  var percent1 = arr2[i][1];   
				var name2 = arr2[j][0];  var percent2 = arr2[j][1]; 
				if( percent1>100 || percent2>100 ){
					alert( "print_graph1(~,~,~,~,~,~) 함수 호출시 6번째 배열안의 % 센트 수치는 100 이하 이어야 합니다"); return;
				}
				if( ascDesc==1 && percent1>percent2){    var tmp = arr2[i];   arr2[i] = arr2[j];   arr2[j] = tmp;   }
				if( ascDesc==2 && percent1<percent2){    var tmp = arr2[i];   arr2[i] = arr2[j];   arr2[j] = tmp;   }
			}
		}
		//--------------------
		var barSrc = [];
		for( var i=0 ; i<arr2.length ; ++i ){
			var name = arr2[i][0];
			var percent = arr2[i][1]; 
			var barLength = maxSize*(percent/100);  //alert(barLength);
			//-------------------------------------------
			barSrc.push( "<table cellpadding=5 cellspacing=0><tr><td width="+maxSize+" valign=middle>"
						   +"<table cellpadding=5 cellspacing=0 border="+border+" height="+barWidth+" width="+barLength+">" 
						   + "<tr><td align='right' bgcolor="+barBgcolor+"><font size="+fontSize+"><b>"+percent + "%</b></font></table></table>" );
		}
		//--------------------
		var tabSrc = [];
		tabSrc.push( "<table cellpadding=4 border=1 style='border-collapse:collapse;border:1px solid "+barBgcolor+";'><tr><td>" );
		tabSrc.push( "<table cellpadding=4 cellspacing=0 border="+border+">" );
		for( var i=0 ; i<arr2.length ; ++i ){
			var name = arr2[i][0];
			var percent = arr2[i][1]; 
			//-------------------------------------------
			tabSrc.push( "<tr><td align='right'><font size="+fontSize+"><b>"+name+"</b></font>");
			tabSrc.push(     "<td align='left'>"+barSrc[i] );  //
		}
		tabSrc.push( "</table></table>" );
		//--------------------
		document.write( tabSrc.join("") ); 
	}catch(e){   alert("print_graph111(~) 함수 호출 시 에러 발생!");    }
}

//**************************************************************
//  % 센트 막대 그래프를 세로로 출력하는 함수 선언
//**************************************************************
function print_graph_percent2 ( 
	maxSize           // 그래프 막대 최대 길이
	, barWidth        // 그래프 막대 두께
	, fontSize        // 그래프 막대 안에 삽입되는 글자의 크기
	, barBgcolor      // 그래프 막대 배경색
	, ascDesc         // 그래프 나열 기준. 0이면 정렬 없음,  1이면 작은거 부터 출력. 2면 크 거 부터 출력
	, arr2            // 그래프 막대에 대한 정보가 내장된 2차원배열
	//, tailStr         // 그래프 막대에 삽입되는 수치 뒤에 붙을 문자
){
	try{
		if( ascDesc!=0 && ascDesc!=1 && ascDesc!=2 ){
			alert( "print_graph1(~,~,~,~,~,~) 함수 호출시 5번째 값은 0 또는 1 또는 2이어야 합니다"); return;
		}
		var border = 0;
		var cellpadding = 6;
		//--------------------
		for( var i=0 ; i<arr2.length-1 ; ++i ){
			for( var j=i+1 ; j<arr2.length ; ++j ){
				var name1 = arr2[i][0];  var percent1 = arr2[i][1];   
				var name2 = arr2[j][0];  var percent2 = arr2[j][1]; 
				if( percent1>100 || percent2>100 ){
					alert( "print_graph1(~,~,~,~,~,~) 함수 호출시 6번째 배열안의 % 센트 수치는 100 이하 이어야 합니다"); return;
				}
				if( ascDesc==1 && percent1>percent2){    var tmp = arr2[i];   arr2[i] = arr2[j];   arr2[j] = tmp;   }
				if( ascDesc==2 && percent1<percent2){    var tmp = arr2[i];   arr2[i] = arr2[j];   arr2[j] = tmp;   }
			}
		}
		var barSrc = [];
		for( var i=0 ; i<arr2.length ; ++i ){
			var percent = arr2[i][1]; 
			var barLength = maxSize*(percent/100); 
			//-------------------------------------------
			barSrc.push( "<table cellpadding=5 cellspacing=0><tr><th height="+maxSize+" valign=bottom>"
							+"<table cellpadding=5 cellspacing=0 border="+border+" width="+barWidth+" height="+barLength+" bgcolor="+barBgcolor+">" 
							+ "<tr><td align='center' valign='top'><font size="+fontSize+"><b>"+percent+"%</b></font></table></table>" );
		}
		//--------------------
		var tabSrc = [];
		tabSrc.push( "<table cellpadding=4border=1 style='border-collapse:collapse;border:1px solid "+barBgcolor+";'><tr><td>" );
		tabSrc.push( "<table cellpadding=4 cellspacing=0 border="+border+">" );
		tabSrc.push( "<tr>" );
		for( var i=0 ; i<arr2.length ; ++i ){
			tabSrc.push( "<td align='center' valign=bottom>"+barSrc[i]);
		}
		tabSrc.push( "<tr>" );
		for( var i=0 ; i<arr2.length ; ++i ){
			var name = arr2[i][0]; 
			tabSrc.push( "<td align='center'><font size="+fontSize+"><b>"+name+"</b></font>");
		}
		tabSrc.push( "</table></table>" );
		//--------------------
		document.write( tabSrc.join("") ); 
	}catch(e){   alert("print_graph111(~) 함수 호출 시 에러 발생!");    }
}






//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
function setDataAll(  ){
		var no = 1;
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var bank = [];
		obj.each(function(i){
			var thisObj = $(this);
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");

			if( (":"+bank.join(":")).indexOf( (":"+nameV) )>=0 ){ return; }   bank.push( nameV );

			// if( nameV.prop("readonly")==true ) { alert(  nameV +" / "+ thisObj.prop("readonly") ); return; }
			//alert(  nameV +" / "+ thisObj.prop("readonly") )
			//-----
			if( typeV=="checkbox" || typeV=="radio") { thisObj.click(); }
			else if( nodeV=="select"){ 
				// thisObj.find("option:eq(1)").prop( "selected", "selected" ); 
				//alert( thisObj.find("option:eq(1)").val( ) )
				thisObj.val(
					thisObj.find("option:eq(1)").val( )
				);
			}
			else { 
				thisObj.val( "xxx"+ (no++) ); 
			}
		});		

}


//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
function print_info_DTO(  ){
		//-----------------------------------------------------
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; var blank2 = blank1 + blank1;   var blank3 = blank2 + blank1;
		var src = [];
		//-----------------------------------------------------
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var nameVs = [];  var nodeVs = [];  var typeVs = [];  var cntVs = [];  
		var banks1 = []; var banks2 = []; var banks3 = [];
		//-----------------------------------------------------
		obj.each(function(i){
			var thisObj = $(this);
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");
			//-----
			nameVs.push(  nameV  );  nodeVs.push(  nodeV  );  typeVs.push(  typeV  ); 
			cntVs.push(  $("body").find("[name='"+nameV+"']").length  );
		});		
		//-----------------------------------------------------
		src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>DTO 생성<tr><td>");
		//-----------------------------------------------------
		// n행 저장 DTO 소스 만들기
		//-----------------------------------------------------
		var cnt1 = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( nameVs[i].indexOf("[")>=0 && nameVs[i].indexOf("[")>=0 ){
				var nameV2 = nameVs[i].substring( 0, nameVs[i].indexOf("[") );
				var nameV3 = nameVs[i].substring(  nameVs[i].indexOf("]")+1 );
				if( (":"+banks1.join(":")).indexOf(":"+nameV2)>=0  ){  continue;;  }  
				//if(cnt1++==0) {
					src.push("//--------------------------------");
					src.push("// n행 저장 DTO");
					src.push("//--------------------------------");
					src.push("public class "+ nameV2.substr(0,1).toUpperCase() + nameV2.substr(1) + "{"); 
				//}    		
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if( nameVs[j].indexOf(nameV2+"[")==0 ){
						src.push( blank3 + "private String "+  nameVs[j].substring( nameVs[j].indexOf("]")+2 )+";" + blank2 + "// " + typeVs[i] + " 양식");
					}
				}
				banks1.push( nameV2 );
				src.push("}");
			}
		}
		//-----------------------------------------------------alert(nameV2)
		src.push("//--------------------------------");
		src.push("// DTO");
		src.push("//--------------------------------");
		src.push("public class Xxx{");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			var dataType = "String";
			if( nameVs[i].indexOf("[")>=0 && nameVs[i].indexOf("[")>=0 ){
				nameVs[i] = nameVs[i].substring( 0, nameVs[i].indexOf("[") );
				dataType = "List&lt;" + nameVs[i].substr(0,1).toUpperCase()+ nameVs[i].substr(1)+"&gt;"; 
			}
			if( typeVs[i]=="checkbox" && cntVs[i]>1 )                       { dataType = "List&lt;String&gt;"; }
			if( nameVs[i].indexOf("num")>=0 || nameVs[i].indexOf("no")>=0 ) { dataType = "int"; }
			if( (":"+banks2.join(":")).indexOf(":"+nameVs[i])>=0  ){  continue;;  }    
			//-----------------
			src.push( blank3 + "private "+dataType+" " + nameVs[i] + ";" + blank2 + "// " + typeVs[i] + " 양식");
			banks2.push( nameVs[i] );
		}
		src.push("}");
		//-----------------------------------------------------
		src.push( "</table>");
		//-----------------------------------------------------
		$("body").append(  src.join("<br>")  + "<br>");
}




//**************************************************************
// 배열 안에 중복된 데이터가 있으면 true 리턴하는 함수선언
//**************************************************************
function is_duple_of_arr( arr, data ){
	try{
		for( var i=0 ; i<arr.length ; ++i ){
			if( arr[i]==data ) { return true; }
		}
	}catch(e){
		alert("is_duple_of_arr(~,~) 함수 호출 시 에러 발생!");  
	}
	return false;
}

//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
function print_info_oracle_table(  ){
	try{
		//----------------------------------------------------- 
		// 각종 변수 선언.
		//----------------------------------------------------- 
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
		var blank2 = blank1 + blank1; var blank3 = blank2 + blank1; var blank4 = blank2 + blank2; var blank5 = blank3 + blank2;
		var src = [];
		var data1 = "";
		//---
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var nameVs = [];          var nodeVs = [];         var typeVs = [];        var cntVs = [];  
		var savedTabNs = [];      var savedTabTypes = [];  var savedcolNs = [];    var isFromcodeTabs = [];   var dataTypeVs = [];  var momTabNs = [];       
		var banks = [];
		//----------------------------------------------------- 
		// 입력 양식 관련 여러 데이터를 여러 배열에 저장하기
		//-----------------------------------------------------
		obj.each(function(i){
			var thisObj = $(this);
			//---
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");
			var cntV = $("body").find("[name='"+nameV+"']").length;
			var savedTabN = "xxx";
			var savedTabType = "main_tab";
			var savedcolN = nameV;
			var momTabN = "";
				if( nameV.indexOf("[")>=0 )       { 
						var tmp1 = nameV.substr(0, nameV.indexOf("[") ); 
						var tmp2 = nameV.substr(nameV.indexOf("]")+2 ); 
						//---
						savedTabN = "xxx_" + tmp1; 
						savedcolN = tmp2;
						savedTabType = "n_row_tab"; 
						momTabN = "xxx";
						//---
						if( typeV=="checkbox" && cntV>1 ) { 
							savedTabType = "n_row_tab_checkbox"; 
							savedTabN = "xxx_" + tmp1 + "_"+tmp2; 
							savedcolN = tmp2+"_code";
							momTabN = "xxx_" + tmp1 ;
						}
						else if( typeV=="radio" && cntV>1 ) { 
							savedcolN = tmp2+"_code";
						}
						else if(  nodeV=="select" &&  nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0    ) { 
							savedcolN = tmp2+"_code";
						}
				}
				else if( nameV.indexOf("[")<0 ){
						if(typeV=="checkbox" && cntV>1 ) { 
							savedTabN = "xxx_"+nameV;
							savedTabType = "main_tab_checkbox";
							savedcolN = nameV+"_code";
							momTabN = "xxx";
						} 
						else if( typeV=="radio" && cntV>1 ) { 
							savedcolN = nameV+"_code";
						} 
						else if(  nodeV=="select" &&  nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0    ) { 
							savedcolN = nameV+"_code";
						}
				}
			var isFromcodeTab = false;
				if( cntV>1 ) { isFromcodeTab = true; };
				if(  nodeV=="select" &&  nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0    ) { isFromcodeTab = true; };
			var dataTypeV = "varchar(50)";
				if( 
					nameV.indexOf("_no")>=0 
					|| ( (typeV=="checkbox" || typeV=="radio") && cntV>1 )
					|| ( nodeV=="select" && nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0   ) 
				){ 
					dataTypeV = "number(5)";
				}
			//----------------
			if( (":"+banks.join(":")).indexOf(":"+nameV)>=0  ){  return;  } banks.push( nameV );
			//----------------
			nameVs.push(  nameV  );          nodeVs.push(  nodeV  );                   typeVs.push(  typeV  );          cntVs.push( cntV  );
			savedTabNs.push(  savedTabN  );   savedTabTypes.push(  savedTabType  );    savedcolNs.push(  savedcolN  );   isFromcodeTabs.push( isFromcodeTab  ); dataTypeVs.push( dataTypeV  );
			momTabNs.push( momTabN  );
			//----------------
			
		});		

		src.push("<br><table border=1 cellpadding=2><tr><td bgcolor=lightblue colspan=10>테이블 생성 관련 입력 양식 태그 정보")
		src.push("<tr bgcolor=pink><th>번호<th>name값<th>태그명<th>태그타입명<th>개수<th>저장테이블타입<th>저장테이블명<th>저장컬럼명<th>엄마테이블명<th>code 테이블에서온거니?<th>자료형");

		var idx = nameVs.length;
		for( var i=0 ; i<nameVs.length ; i++ ){

			//if( i%2==1)
			//	src.push("<tr bgcolor=#D2D2D2>");
			//else
				src.push("<tr>");
			src.push("<td>"+idx--);
			src.push("<td>"+nameVs[i]);
			src.push("<td>"+nodeVs[i]);
			src.push("<td>"+typeVs[i]);
			src.push("<td>"+cntVs[i]);
			src.push("<td>"+savedTabTypes[i]);
			src.push("<td>"+savedTabNs[i]);
			src.push("<td>"+savedcolNs[i]);
			src.push("<td>"+momTabNs[i]);
			src.push("<td>"+isFromcodeTabs[i]);
			src.push("<td>"+dataTypeVs[i]);
		}
		src.push( "</table>");
		//-----------------------------------------------------
		// code 테이블 소스 생성
		//-----------------------------------------------------
		src.push("<br><table border=1 cellpadding=2><tr><td bgcolor=lightblue>테이블 생성 SQL<tr><td>")
		banks = [];
		src.push("//----------------------------------------------------------------");
		src.push("// code 테이블 소스 생성");
		src.push("//----------------------------------------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			//-----------------
			if(  isFromcodeTabs[i] ){    //alert(9);
				//-----------------
				if( (":"+banks.join(":")).indexOf(":"+savedcolNs[i])>=0 ){continue;} banks.push( savedcolNs[i] );
				//-----------------
				var colN = savedcolNs[i].replace("_code","");
				src.push( "create table code_"+colN+"(")
				src.push( blank1 + colN+"_code"+blank1+"number(5)")
				src.push( blank1 + ", " +colN+"_name"+blank1 + "varchar(50)");
				src.push( blank1 + ", primary key( " + colN + "_code )");
				src.push( ");")
				//-----------------
				if( nodeVs[i]=="select" ) {
					var no = 1;
					$("body").find("[name='"+nameVs[i]+"']").find("option").each(function(){
						var value = $(this).attr("value"); if(value=="")  {return;}
						src.push( "insert into code_" + colN + " values ( " + (no++) + ", '" + value+ "' );")
					})
				}
				//-----------------
				if( typeVs[i]=="checkbox" || typeVs[i]=="radio") {
					var no = 1;
					$("body").find("[name='"+nameVs[i]+"']").each(function(){
						var value = $(this).attr("value"); if(value=="")  {return;}
						src.push( "insert into code_" + colN + " values ( " + (no++) + ", '" + value+ "' );")
					})
				}
				src.push("//--------------------------------");
			}
		}
		//-----------------------------------------------------
		// 메인 테이블 소스 생성
		//-----------------------------------------------------
		banks = [];  
		var no = 1;
		src.push("//----------------------------------------------------------------");
		src.push("// 메인 테이블 소스 생성");
		src.push("//----------------------------------------------------------------");
		src.push("create table xxx(")
		src.push( blank2 + "xxx_no number(9)")
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="main_tab" ){
				src.push( blank2 + ", " + savedcolNs[i] + blank2 + dataTypeVs[i] + blank2 + "--<" + no++ + ">--");  //&lt;!  &gt;
			}  
		}
		src.push( blank2 +  "-----------------");
		src.push( blank2 +  ", primary key( xxx_no )");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="main_tab" && isFromcodeTabs[i] ){
					src.push( blank2 + ", foreign key " + savedcolNs[i] +" references code_" + savedcolNs[i].replace("_code","")+ "("+savedcolNs[i]+")");
			}
		}
		src.push( ");");
		
		var no = 1;
		src.push( "insert into xxx(" );
		src.push( blank2 + "xxx_no"  );
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="main_tab" ){
				src.push( blank2 + ", " + savedcolNs[i] + blank2 + "&lt;!--[" + no++ + "]--&gt;");  //&lt;!  &gt;
			}
		}
		src.push( ") values(" );
		src.push( blank2 + "( select nvl(max(xxx_no),0)+1 from xxx )"   );
		var no = 1;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="main_tab" ){
				src.push( blank2 + ", ${" + savedcolNs[i] +"}" + blank2 + "&lt;!--[" + no++ + "]--&gt;");  //&lt;!  &gt;
			}
		}
		src.push( ");" );



		//-----------------------------------------------------
		// [메인 테이블]  소속 [checkbox 관련 테이블] 생성 소스 생성
		//-----------------------------------------------------isFromcodeTabs
		src.push("//----------------------------------------------------------------");
		src.push("// [메인 테이블]  소속 [checkbox 관련 테이블] 생성 소스");
		src.push("//----------------------------------------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( savedTabTypes[i]=="main_tab_checkbox"  ) {			//alert(88);
				var colN = savedcolNs[i].replace("_code","");
				src.push("create table "+savedTabNs[i]+"(")
				src.push( blank2 + "xxx_no" + blank2 + "number(5)");
				src.push( blank2 + ", " + colN + "_code" + blank2 + "number(5)");
				src.push( blank2 +  "-----------------");
				src.push( blank2 + ", foreign key xxx_no references xxx(xxx_no)");
				src.push( blank2 + ", foreign key "+colN+"_code references code_"+colN+"("+colN+"_code)");
				src.push(");")
				src.push(  "---");
				src.push( "&lt;forEach collections=\""+ colN + "\" items=\"${" + colN + "_code\"}&gt;");
				src.push( blank2 + "insert into " + savedTabNs[i] + "(" );
				src.push( blank3 + "xxx_no"  );
				src.push( blank3 + "," + colN + "_code"  );
				src.push( blank2 + ") values(" );
				src.push(  blank3 + "(select max(xxx_no) from xxx)"   );
				src.push(  blank3 + ", ${" + colN + "_code}"   );
				src.push( blank2 + ");" );
				src.push( "&lt;/forEach&gt;");
				src.push(  "---");
			}
		}
		//-----------------------------------------------------
		// [메인 테이블]  소속 [n행 저장 테이블] 생성 소스 생성 
		//-----------------------------------------------------
		banks = [];
		var cnt1 = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="n_row_tab" ){
				//---
				if( (":"+banks.join(":")).indexOf(":"+savedTabNs[i])>=0 ){continue;} banks.push( savedTabNs[i] );
				//---
				src.push("//----------------------------------------------------------------");
				src.push("// [메인 테이블]  소속 [n행 저장 테이블] 생성 소스");
				src.push("//----------------------------------------------------------------");
				src.push("create tabe "+ savedTabNs[i] + "("); 
				src.push(blank3 + savedTabNs[i]+"_no"+blank1+"number(5)"); 
				src.push(blank3 + ", xxx_no"+blank1+"number(5)"); 
				//-----------------
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						src.push(  blank3 + ", " + savedcolNs[j] +blank1 + dataTypeVs[j] +blank1+"// " + typeVs[j] + " 양식"  );
					}
				}
				src.push( blank3 + "-------------------------");
				src.push( blank3 + ", primary key( "+savedTabNs[i]+"_no )");
				src.push( blank3 + ", foreign key xxx_no references xxx(xxx_no)");
				//-----------------
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] && isFromcodeTabs[j] ){
						var tmp = savedcolNs[j].replace( "_code", "" );
						src.push( blank3 + ", foreign key " + tmp +"_code references code_" + tmp + "("+tmp+"_code)" );
					}
				}
				src.push(");");
				//-----------------
				//-----------------
				src.push(  "---");
				src.push( "insert into " + savedTabNs[i] + "(" );
				src.push(  blank3 + savedTabNs[i]+"_no"  );
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						src.push(  blank3 + ", " + savedcolNs[j]   );
					}
				}
				src.push( ") values(" );
				src.push(  blank3 + "(select nvl(max("+savedTabNs[i]+"_no),0)+1 from "+ savedTabNs[i] +")"   );
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						if( dataTypeVs[j].indexOf("varchar")>=0 )  src.push(  blank3 + ", '데이터'"  );
						else                                       src.push(  blank3 + ", 데이터"  );
					}
				}
				src.push( ");" );
				src.push(  "---");
				//-----------------
				//-----------------
				/*src.push( "&lt;forEach collections=\"${"+ savedTabNs[i] + "}\" items=\"" + savedTabNs[i] + "\"&gt;");
				src.push( blank2 + "insert into " + savedTabNs[i] + "(" );
				src.push( blank3 + savedTabNs[i]+"_no"  );
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						src.push(  blank3 + ", " + savedcolNs[j]   );
					}
				}
				src.push( blank2 + ") values(" );
				src.push(  blank3 + "(select nvl(max("+savedTabNs[i]+"_no),0)+1 from "+ savedTabNs[i] +")"   );
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						src.push(  blank3 + ", ${" + savedcolNs[j] + "}" );
					}
				}
				src.push( blank2 + ");" );
				src.push( "&lt;/forEach&gt;");*/
				//-----------------
				//-----------------
				var tmp1 = nameVs[i].substring(0,nameVs[i].indexOf("[")) ;
				src.push( "&lt;forEach collections=\""+ tmp1 + "\" items=\"" + tmp1 + "\"&gt;");
				src.push( blank2 + "insert into " + savedTabNs[i] + "(" );
				src.push( blank3 + savedTabNs[i]+"_no"  );
				src.push( blank3 + ", xxx_no"  );
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						src.push(  blank3 + ", " + savedcolNs[j]   );
					}
				}
				src.push( blank2 + ") values(" );
				src.push(  blank3 + "(select nvl(max("+savedTabNs[i]+"_no),0)+1 from "+ savedTabNs[i] +")"   );
				src.push(  blank3 + ", (select max(xxx_no) from xxx)"   );
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						src.push(  blank3 + ", ${" + tmp1 +"."+savedcolNs[j] + "}" );
					}
				}
				src.push( blank2 + ");" );
				src.push( "&lt;/forEach&gt;");
				
			}
		}
		//-----------------------------------------------------
		// [n행 테이블] 소속 checkbox 관련 테이블 생성 소스 생성
		//-----------------------------------------------------
		src.push("//--------------------------------");
		src.push("// [메인 테이블]  소속, [n행 테이블] 소속, checkbox 관련 테이블 생성 소스");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( savedTabTypes[i]=="n_row_tab_checkbox"  ) { 
				var tmp1 = savedcolNs[i].replace("_code","");
				//---
				src.push("create table " + savedTabNs[i] + "(");                // alert(8);
				src.push( blank2 + momTabNs[i] + "_no" + blank1 + "number(5)"); 
				src.push( blank2 + ", " + tmp1 + "_code" + blank2 + "number(5)" );
				src.push( blank2 + "-----------------");
				src.push( blank2 + ", foreign key " + momTabNs[i] + "_no references " + momTabNs[i] + "(  " + momTabNs[i] + "_no )" );
				src.push( blank2 + ", foreign key " + tmp1 + "_code references code_" + tmp1 + "(" + tmp1 + "_code )" );
				src.push(");")
				src.push( "---");
				src.push( "insert into " + savedTabNs[i] + " values( (select max("+momTabNs[i] + "_no) from "+momTabNs[i] + ") , pk값2 ) ;" );
				src.push(  "---");
				//---
				//for( var j = 0 ; j<cntVs[i] ; j++ ){
				src.push( "&lt;forEach collections=\"${"+ tmp1 + "}\" items=\"" + tmp1 + "\"&gt;");
				src.push( blank2 + "insert into " + savedTabNs[i] + " values(" );
				src.push( blank4 + momTabNs[i] + "_no" );
				src.push( blank4 + ", " + tmp1 + "_code");
				src.push( blank2 + "values(" );
				src.push( blank4 + "(select max("+momTabNs[i] + "_no) from "+momTabNs[i] + ")" );
				src.push( blank4 + ", ${"+tmp1 + "}" );
				src.push( blank2 + ");" );
				src.push( "&lt;/forEach&gt;");
				//}
			}
		} 
		//-----------------------------------------------------
		// 소스 출력
		//-----------------------------------------------------
		src.push( "</table>");
		$("body").append(  src.join("<br>")  + "<br>");
	}catch(e){
		alert("print_info_oracle_table( ) 함수 호출 시 에러 발생!");  
	}
}







//**************************************************************
// [유효성 체크 자스 소스]를 출력하는 함수 선언
//**************************************************************
function print_info_js_src(  ){
	try{
		//-----------------------------------------------------
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
		var blank2 = blank1 + blank1; var blank3 = blank2 + blank1; var blank4 = blank2 + blank2; var blank5 = blank3 + blank2;
		var src = [];
		//-----------------------------------------------------
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var nameVs = [];  var nodeVs = [];  var typeVs = [];  var cntVs = [];  var banks = [];
		//-----------------------------------------------------
		obj.each(function(i){
			var thisObj = $(this);
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");
			if( (":"+banks.join(":")).indexOf(":"+nameV)>=0  ){  return;  }
			nameVs.push(  nameV  );  nodeVs.push(  nodeV  );  typeVs.push(  typeV  );  banks.push( nameV );
			cntVs.push(  $("body").find("[name='"+nameV+"']").length  );
		});		
		//-----------------------------------------------------
		src.push( "<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>유효성 자스 코드<tr><td>" );

		//-----------------------------------------------------
		// 비었을 경우 경고하고 종료하는 소스 생성. (단 그룹에 속하지 않은 태그만)
		//-----------------------------------------------------
		src.push( "function checkXXXForm( ) {" );
		src.push( blank1+"//--------------------------------------------" ); 
		src.push( blank1+"// 그룹에 속하지 않는 태그가 비었을 경우 경고하고 종료하기" );
		src.push( blank1+"//--------------------------------------------" );
		src.push( blank1 + "if( !checkEmpty([" );
		var cnt = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( nameVs[i].indexOf("[")<0  && nameVs[i].indexOf("']")<0 ) {
				if(cnt++==0)  { src.push( blank3 + "[ '"+nameVs[i]+"' , '별칭' ]" + blank2 + "// " + typeVs[i] + " 양식"); }
				else          { src.push( blank3 + ", [ '"+nameVs[i]+"' , '별칭' ]" + blank2 + "// " + typeVs[i]+ " 양식" ); }
			}
		}
		src.push( blank1+"]) ){ return; }" );

		//-----------------------------------------------------
		// 비었을 경우 경고하고 종료하는 소스 생성.(단 그룹에 속한 태그만)
		//-----------------------------------------------------
		banks = [];
		var cnt1 = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( nameVs[i].indexOf("[")>=0 && nameVs[i].indexOf("[")>=0 ){
				var nameV2 = nameVs[i].substring( 0, nameVs[i].indexOf("[") );
				var nameV3 = nameVs[i].substring(  nameVs[i].indexOf("]")+1 );
				if( (":"+banks.join(":")).indexOf(":"+nameV2)>=0  ){  continue;;  }  
				//-------------
				if( cnt1++==0 ) {
					src.push( blank1+"//--------------------------------------------" );
					src.push( blank1+"// 그룹에 속한 태그가 비었을 경우 경고하고 종료하기" );
					src.push( blank1+"//--------------------------------------------" );
				}
				src.push( blank1 + "for( var i=0 ; i &lt $(\"[name^='"+nameV2+"[']\").length ; i++ ){" );
				src.push( blank3 + "var tagNs1 = [ " );
				var cnt1 = 0;
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if( nameVs[j].indexOf(nameV2+"[")==0 ){
						if( cnt1++==0 )
							src.push( blank5 + "'" + nameVs[j].replace("[0]","['+i+']") +"'" + blank1 + "// "+typeVs[i] + " 양식");
						else
							src.push( blank5 + ", '" + nameVs[j].replace("[0]","['+i+']") +"'"+ blank1 + "// "+typeVs[i] + " 양식");
					}
				}
				src.push(blank3 + "];");
				//-------------
				src.push( blank3 + "var tagNs2 = [ " );
				cnt1 = 0;
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if( nameVs[j].indexOf(nameV2+"[")==0 ){
						if( cnt1++==0 )
							src.push( blank5 + "'" + nameVs[j].replace("[0]","['+i+']") +"'" + blank1 + "// 삭제 여부 점검");
						else
							src.push( blank5 + ", '" + nameVs[j].replace("[0]","['+i+']") +"'" + blank1  + "// 삭제 여부 점검");
					}
				}
				src.push( blank3 + "];");
				//-------------
				src.push( blank3 + "var alertMSG = '한 행의 ~,~,~ 는 모두 비거나 입력한다면 ~,~,~ 는 필수 입력 입니다.';" );
				src.push( blank3 + "if("+blank1+"!checkGroupEmpty( [ tagNs1 , tagNs2 , alertMSG ] )"+blank1+"){ return; }" );
				//-------------
				src.push( blank1 + "}" );
				banks.push( nameV2 );
			}
		}


		//-----------------------------------------------------
		// 패턴식 체크하고 오류 시 경고하고 종료하는 소스 생성.
		//-----------------------------------------------------
		var cnt = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( (typeVs[i]=="text" ||  typeVs[i]=="password") && nameVs[i].indexOf("[")<0 ) {
				if( cnt++==0 ) { 
					src.push( blank1 + "//--------------------------------------------" ); 
					src.push( blank1 + "// 그룹에 안 속한 태그의 패턴식 체크하고 오류 시 경우하고 종료하기" );
					src.push( blank1 + "// <참고>데이터가 비었으면 체크를 안함." );
					src.push( blank1 + "//--------------------------------------------" ); 
					src.push( blank1 + "if( !checkPattern([" ); 
					src.push( blank3 + "[ '"+nameVs[i]+"' , /^패턴식$/ , '경고메시지' ]" ); 
				}
				else           { 
					src.push( blank3 + ", [ '"+nameVs[i]+"' , /^패턴식$/ , '경고메시지' ]" ); 
				}
			}
		}
		if( cnt>0 ) { 
			src.push( blank1 + "]) ) { return; }" ); 
		}

		banks = [];
		var cnt1 = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( nameVs[i].indexOf("[")>=0 ) {
				var nameV2 = nameVs[i].substring( 0, nameVs[i].indexOf("[") );
				var nameV3 = nameVs[i].substring(  nameVs[i].indexOf("]")+1 );
				if( (":"+banks.join(":")).indexOf(":"+nameV2)>=0  ){  continue;;  }  
				src.push( blank1 + "//--------------------------------------------" ); 
				src.push( blank1 + "// 그룹에 속한 태그의 패턴식 체크하고 오류 시 경우하고 종료하기" );
				src.push( blank1 + "// <참고>데이터가 비었으면 체크를 안함." );
				src.push( blank1 + "//--------------------------------------------" ); 
				src.push( blank1 + "for( var i=0 ; i &lt; $(\"[name^='"+nameV2+"[']\").length ; i++ ){" ); 
				src.push( blank2 + "if( !checkPattern([" );
	
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if( nameVs[j].indexOf(nameV2+"[")==0 ){             //alert(nameV2)
						if(cnt1++==0)
							src.push( blank3 + "[ '"+  nameVs[j].replace("[0]","['+i+']")  +"' , /^패턴식$/ , '경고메시지' ]" ); 
						else
							src.push( blank3 + ", [ '"+  nameVs[j].replace("[0]","['+i+']")  +"' , /^패턴식$/ , '경고메시지' ]" ); 
					}
				}
				src.push( blank2 + "]) ) { return; }" ); 
				src.push( blank1 + "}" ); 
				banks.push( nameV2 );
			}
		}
		//-----------------------------------------------------
		// 기타 소스 생성.
		//-----------------------------------------------------
		src.push( blank1 + "//--------------------------------------------" ); 
		src.push( blank1 + "if( confirm('정말 거식 하시겠습니까?') ) { return }" );
		src.push( blank1 + "//--------------------------------------------" ); 
		src.push( blank1 + "// 비동기 방식으로 서버와 통신하기" ); 
		src.push( blank1 + "//--------------------------------------------" ); 
		src.push( blank1 + "$.ajax([" ); 
		src.push( blank3 + "url : '${path1}/xxx.do'" ); 
		src.push( blank3 + "type : post" ); 
		src.push( blank3 + ",data : $(\"[name='폼이름']\").serialize( )" ); 
		src.push( blank3 + ",success : function( html ){" ); 
		src.push( blank4 + "~" ); 
		src.push( blank3 + "}" ); 
		src.push( blank3 + ",error : function( ){" ); 
		src.push( blank4 + "~" ); 
		src.push( blank3 + "}" ); 
		src.push( blank1 + "]);" ); 
		src.push( "} // function checkXXXForm( ) {" );
		//-----------------------------------------------------
		// 소스 출력
		//-----------------------------------------------------
		$("body").append(  src.join("<br>") );
	}catch(e){
		alert("print_info_js_src( ) 함수 호출 시 에러 발생!");  ///title="아이디"
	}
}




//**************************************************************
// 모든 입력 양식의 정보를 출력하는 함수 선언
//**************************************************************
function print_info_tag(  ){
	var src = [];
	try{
		src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>입력 양식 태그정보");
		src.push("<tr bgcolor=gray><th>번호<th>소속폼태그명<th>태그명<th>타입<th>이름<th>값<th>체크여부");
		//----------------------------------
		var formNs = [];
		$("form").each(function(){
			var formObj = $(this);
			var formN = formObj.attr("name");
			formNs.push( formN );
		});
		for( var i=0 ; i<formNs.length ; i++ ) {
			var formObj = $("[name='"+formNs[i]+"']");
			var cnt = formObj.find("input, textarea, select").length;
			formObj.find( "input, textarea, select" ).each(function(j){
					src.push("<tr bgcolor="+(j%2==1?"#E0E0E0":"white")+">")
					var obj = $(this);
					var tagN = obj[0].nodeName.toLowerCase( );
					var typeN = (obj.attr("type")==undefined?"&nbsp;":" type="+obj.attr("type"));
					var nameV = (obj.attr("name")==undefined?"&nbsp;":" name="+obj.attr("name"));
					var value = (obj.val()==""?"&nbsp;":" value="+obj.val());
					
					if( tagN.indexOf("select")>=0 ) {
						tagN ="select";
						value = "";
						obj.find("option").each(function(){
							value = value + "&ltoption  value=\"" + $(this).val() + "\"&gt<br>";
						})
					}
					src.push("<th>"+ (cnt--) );
					src.push("<th>"+ formNs[i] );
					src.push("<td>"+ tagN );
					src.push("<td>"+ typeN );
					src.push("<td>"+ nameV );
					src.push("<td>"+ value );
					src.push("<td>"+ (obj.is(":checked")?"v":"&nbsp;") );
					//alert(nameV)
			});
		}
		//----------------------------------
		src.push("</table>")
	}catch(e){
		alert( "print_info_tag(~) 호출 시 에러발생!");
		src = [];
	}
	$("body").append(  src.join("") );
}



//**************************************************************
// 동일한 form 태그 내부에 입력양식 태그의 name 속성값이 2개 이상 동일할 때 false 리턴하는 함수 선언. 
//  (단 checkbox, radio 끼리는 제외) 
//**************************************************************
function checkNameVDupl(  ){
	var result = true;
	try{
		var banks1 = [];
		var formObj = $("form");
		for( var i=0 ; i<formObj.length ; i++ ){
			var nameV = formObj.eq(i).attr("name");
			if( (":"+banks1.join(":")+":").indexOf( ":"+ nameV + ":"  )>=0  ){
				alert( "<form name='"+nameV+"' ~> 라는 form 태그가 2개 이상 중복되었습니다. 수정요망!");
				$("body").empty();
				return false;
			}
			banks1.push( nameV );
		}
		for( var i=0 ; i<formObj.length ; i++ ){
			//----------------------
			var banks2 = [];
			var tmpObj1 = formObj.eq(i).find("input,select,textarea").not("[type=button],[type=submit],[type=reset],[type=checkbox],[type=radio]");
			for( var j=0 ; j<tmpObj1.length ; j++ ){
				var nameV = tmpObj1.eq(j).attr("name");
				if( (":"+banks2.join(":") ).indexOf( ":"+ nameV )>=0  ){
					alert( "<form name='"+formObj.eq(i).attr("name")+"' ~> 라는 form 태그 내부에   name="+nameV+" 을 가진 태그가 2개 이상 중복되었습니다. 수정요망!")
					return false;
				}
				banks2.push( nameV );
			}
			//alert(nameV);
			//----------------------
			var banks3 = [];
			var tmpObj2 = formObj.eq(i).find("[type=checkbox],[type=radio]");
			for( var j=0 ; j<tmpObj2.length ; j++ ){
				var nameV = tmpObj2.eq(j).attr("name");
				var nodeV = tmpObj2.eq(j)[0].nodeName.toLowerCase();
				banks3.push( nameV );
			}
			//----------------------
			for( var j=0 ; j<banks2.length ; j++ ){
				for( var k=0 ; k<banks3.length ; k++ ){
					if( banks2[j]==banks3[k] ){
						alert( "<form name='"+formObj.eq(i).attr("name")+"' ~> 라는 form 태그 내부에 checkbox 또는 radio 양색의 name="
														+banks2[j]+" 과  checkbox, radio 가 아닌 양식의 name 속성값이 중복되었습니다. 수정요망!")
						return false;
					}
				}
			}
		}
	}catch(e){
		result = false;
		alert( "checkNameVDupl(~) 호출 시 에러발생!");
	}
	return result;
}



//**************************************************************
// 입력 양식에  입력 데이터가 없거나 체크가 없으면 true 를 리턴하는 함수 선언
//**************************************************************
function isEmpty( formN, nameV ){
	var result = false;
	try{
		var obj = $("[name='"+formN+"'] [name='"+nameV+"']");
		if( obj.length==0 ){
			alert(nameV + "란 이름의 입력 양식이 없습니다.");
			return true;
		}
		if( obj.is(":checkbox") || obj.is(":radio") ){
			result = obj.filter(":checked").length==0?true:false;
		}
		else{
			result = obj.val().split(" ").join("")==""?true:false;
		}
	}catch(e){
		alert("isEmpty(~) 함수 호출 시 에러 발생!");
		result =  true;
	}
	return result;	
}
//**************************************************************
//입력 양식에  입력 데이터가 없거나 체크가 없으면 true 를 리턴하는 함수 선언
//**************************************************************
function checkEmpty( formNameV, arr2 ){
	var result = true;
	try{
		for( var i=0 ; i<arr2.length ; i++ ) {
			var nameV = arr2[i][0];      if( nameV.indexOf("[")>=0 ) continue;
			var aliasV = arr2[i][1];
			var obj = $("[name='"+formNameV+"'] [name='"+nameV+"']");
			//-----------------------------------
			if( obj.is(":checkbox") || obj.is(":radio")  ){
				if( obj.filter(":checked").length==0 ){
					alert( aliasV+" 1개 이상 체크 요망!"); result = false; break;
				}
			}else{
				if( obj.val().split(" ").join("")=="" ){
					alert( aliasV+" 입력바람"); result = false; break;
				}
			}
		}
	}catch(e){
		alert("checkEmpty(~) 함수 호출 시 에러 발생!");
		result =  false;
	}
	return result;	
}
//**************************************************************
// 여러 입력 양식 태그에 데이터 또는 체크가 없으면 경고하고 true 리턴하는 함수 선언
//**************************************************************
/*function checkEmpty( object ){
	var result = false;
	try{
		//---------------------------------
		for( var nameV in object ) {
			var alias = object[nameV];
			var obj = $("[name='"+nameV+"']");
			
			if( obj.length==0 ){
				alert( "<개발자 경고>"+nameV + " 라는 이름을 가진 입력양식이 없습니다");
				return true;
			}
			//----------------
			if( obj.is(":checkbox") || obj.is(":radio") ){
				if( obj.filter(":checked").length==0 ){
					alert( "["+alias+"] 은(는) 1개 이상 체크 요망!"); result = true; break;
				}
			}else{
				if( obj.val().split(" ").join("")=="" ){
					alert( "["+alias+"]  입력바람"); result = true; break;
				}
			}
		}
		//---------------------------------
	}catch(e){
		alert("checkEmpty(~) 함수 호출 시 에러 발생!"); result=true;
	}
	return result;	
}

function checkEmpty( object ){
	var result = false;
	try{
		for( var nameV in object ) {
			var alias = object[nameV];
			var obj = $("[name='"+nameV+"']");
			var isRC = (obj.is(":checkbox") || obj.is(":radio"))?true:false;
			if( isRC ){
				if( obj.filter(":checked")==0 ){
					alert( alias+" 1개 이상 체크 요망!");
					result = true;
					break;
				}
			}else{
				if( obj.val().split(" ").join("")=="" ){
					alert( alias+" 입력바람");
					result = true;
					break;
				}
			}
		}
	}catch(e){
		alert("checkEmpty(~) 함수 호출 시 에러 발생!");
		result =  true;
	}
	return result;	
}*/
//**************************************************************
// 입력 양식 태그에 DB 에서 구한 데이터를 넣어 주거나 체크해주는 함수 선언
//**************************************************************
function inputData( formN, nameV, data ){
	try{
		if( data==undefined || data==null || data=="" || data.split(" ").join("")=="" ) {
			return;
		}
		var formObj = $("[name='"+formN+"']");
		if( formObj.length==0 ){
			alert( "inputData(~,~,~) 함수 호출 시 ["+formN + "] 라는 폼태그가 없습니다.");
			return;
		}
		var obj = formObj.find("[name='"+nameV+"']");
		if( obj.length==0 ){
			alert( "inputData(~,~,~) 함수 호출 시 ["+formN + "] 라는 폼태그 내부에 [" +nameV + "]란 이름의 입력 양식이 없습니다.");
			return;
		}
		var isRC = (obj.is(":checkbox")||obj.is(":radio"))?true:false;
		if( isRC ) {
			obj.filter("[value='"+data+"']").click();
		}
		else{
			obj.val( data );
			//alert( obj.val( ) )
			if( formObj.find("[name='"+nameV+"']")[0].nodeName.toLowerCase().indexOf("select")>=0 && isData(obj.val( ))==false    ){
				//alert( "<select name="+nameV+" ~> 태그 안에  value="+data+" 을 가진 option 태그가 없습니다.");
				alert( "<select name="+nameV+" ~> 태그 안에 <option value="+data+"> 을 가진 option 태그가 없어 inputData(~,~,'"+data+"') 함수 호출로 데이터 입력이 안됩니다.");
			}
		}
	}catch(e){
		alert("inputData(~,~,~) 함수 호출 시 에러 발생!");
	}
}


//**************************************************************
// 입력 양식 태그에 DB 에서 구한 데이터를 넣어 주거나 체크해주는 함수 선언
//**************************************************************
function isData( data ){
	return !(data==undefined || data==null ||  (data+"").split(" ").join("")=="");
}

//**************************************************************
//입력 양식 태그에 데이터를 비우거나 체크를 풀어주는 함수 선언
//**************************************************************
function setEmpty( formN, nameV ){
	try{
		var formObj = $("[name='"+formN+"']");
		if( formObj.length==0 ){
			alert( "setEmpty(~,~,~) 함수 호출 시 ["+formN + "] 라는 폼태그가 없습니다.");
			return;
		}
		var obj = formObj.find("[name='"+nameV+"']");
		if( obj.length==0 ){
			alert( "setEmpty(~,~,~) 함수 호출 시 ["+formN + "] 라는 폼태그 내부에 [" +nameV + "]란 이름의 입력 양식이 없습니다.");
			return;
		}
		//-----------------------
		var isRC = (obj.is(":checkbox")||obj.is(":radio"))?true:false;
		if( isRC ) {
			obj.filter(":checked").click();
		}
		else{
			obj.val( '' );
		}
	}catch(e){
		alert("setEmpty(~,~) 함수 호출 시 에러 발생!");
	}
}
//**************************************************************
//입력 양식 태그에 데이터를 비우거나 체크를 풀어주는 함수 선언
//**************************************************************
function setEmpty2( formN, nameVs ){
	try{
		var formObj = $("[name='"+formN+"']");
		for(var i=0 ; i<nameVs.length ; i++){
			if( formObj.is(":checkbox")|| formObj.is(":radio") ){
				formObj.find("[name='"+nameVs[i]+"']").filter( ":checked" ).click();
			}
			else{
				formObj.find("[name='"+nameVs[i]+"']").val( "" );
			}
		}
	}catch(e){
		alert("setEmpty2(~,~) 함수 호출 시 에러 발생!");
	}
}

//**************************************************************
// 모두다 비거나, 입력한다면 필수 입력양식은 모두 입력(체크)되도록 경고하고 true,false 리턴하는 함수 선언
//**************************************************************
function checkGroupEmpty( formN, arr2 ){
	var result = true;
	try{
		var cnt1 = 0;
		for( var i=0 ; i<arr2[0].length ; i++ ) {
			var nameV = arr2[0][i];
			if( !isEmpty(formN,nameV) ) { cnt1++; }
		}
		var cnt2 = 0;
		for( var i=0 ; i<arr2[1].length ; i++ ) {
			var nameV = arr2[1][i];
			if( !isEmpty(formN,nameV) ) { cnt2++; }
		}
		//alert( cnt1 +"/"+ cnt2)
		if(    !(cnt2==arr2[1].length || (cnt1+cnt2)==0)    ){
			alert( arr2[2] );
			result=false;				
		}
	}catch(e){
		alert("checkGroupEmpty(~) 함수 호출 시 에러 발생!"); result=false;
	}
	return result;	
	// 호출방법
	/*------------------------------------------
	checkGroupEmpty2( [ 
		['f_relation','f_name','is_with']                      // 그룹 내 모든 입력 양식명
		, ['f_relation','f_name']                              // 그룹 필수 입력 양식명
		, '모두 비거나 입력한다면 관계,이름 은 필수 입력하삼!' //  경고 메시지
	] );
	------------------------------------------*/
}

/*function checkGroupEmpty( 
		object1     // 필수 입력 입력 양식 name 값과, alias 값이 저장된 사용정 객체
		,object2    // 안 필수 입력 입력 양식 name 값과, alias 값이 저장된 사용정 객체
){
	var result = false;
	try{
		var totNameVs1 = []; var name1s = []; var totAliasVs1 = [];
		var totNameVs2 = []; var name2s = []; var totAliasVs2 = [];
		var cnt1 = 0; var cnt2 = 0;
		//---------------------------------
		for( var nameV in object1 ) {		
			totNameVs1.push(nameV);	
			totAliasVs1.push( object1[nameV] );
			if( isEmpty(nameV)==false ) { name1s.push(nameV); }
			cnt1++;
		}
		for( var nameV in object2 ) {		
			totNameVs2.push(nameV);
			totAliasVs2.push( object2[nameV] );
			if( isEmpty(nameV)==false ) { name2s.push(nameV); }
			cnt2++;
		}
		//alert(9);
		//---------------------------------
		if( (name1s.length>0 && name1s.length<totNameVs1.length) || (name1s.length==0 && name2s.length>0) ){
			alert( 
				"한 그룹의 [" + totAliasVs1.join(",") + "," + totAliasVs2.join(",") 
					+ "] 은 모두 비어 있거나 데이터 입력 시 ["+ totAliasVs1.join(",")+ "]은 필수 입력입니다."
			);
			result=true;
		}
	}catch(e){
		alert("checkGroupEmpty(~,~) 함수 호출 시 에러 발생!"); result=true;
	}
	return result;
	//------------------------------------------
	// 호출 방법
	//------------------------------------------
	//------------------------------------------
	//	function check2( ){
	//		if( checkGroupEmpty(
	//				{"uid":"아이디" ,"pwd":"암호"}
	//				,{"skill":"기술"}
	//		)) {return;}
	//		~
	//	}
	//------------------------------------------
}*/



//**************************************************************
// 년, 월에 해당하는 달의 마지막 날을 리턴하는 함수 선언
//**************************************************************
function getLastDay( y, m ){
	try{
		var formObj = $("[name='"+formN+"']");
		for(var i=0 ; i<tagNs.length ; i++){
			formObj.find("[name='"+tagNs[i]+"']").val( "" );
		}
	}catch(e){
		alert("getLastDay(~) 함수 호출 시 에러 발생!");
	}
}
//**************************************************************
// 년, 월, 일에 해당하는 요일 리턴하는 함수 선언
//**************************************************************
function getWeek( y, m, d ){
	try{
		//var idx = new Date(y, m, d).getDay();
		return ['일','월','화','수','목','금','토'][new Date(y, m, d).getDay()];
	}catch(e){
		alert("getWeek(~) 함수 호출 시 에러 발생!");
	}
}
//**************************************************************
// 년, 월, 일 select 입력양식에 오늘 년,월,일 을 넣어주는 함수 선언
// print_YM(~), print_YMYM(~),print_YMD(~),print_YMDYMD(~) 호출하는 함수임.
//**************************************************************
function set_to_today( formNameV, nameVs ){
	try{
		var formObj = $("[name='"+formNameV+"']");
		var d = new Date();
		for(var i=0 ; i<nameVs.length ; i++){
			if( i==0 )      { formObj.find("[name='"+nameVs[i]+"']").val(   d.getFullYear() ); 	}
			else if( i==1 ) { formObj.find("[name='"+nameVs[i]+"']").val(   ((d.getMonth()+1)<10?"0":"") +  (d.getMonth()+1)  ); 	}
			else if( i==2 ) { formObj.find("[name='"+nameVs[i]+"']").val(   (d.getDate()<10?"0":"") +  d.getDate()  ); 	}
		}
		var week = ['일','월','화','수','목','금','토'][d.getDay()];
		formObj.find( "."+nameVs.join("")+"_week").val( "("+week+")" );
		//formObj.find( "."+nameVs.join("")+"_week").html( "<center>("+week+")</center>" );
	}catch(e){
		alert("set_to_today(~) 함수 호출 시 에러 발생!");
	}
}
//**************************************************************
// 년,월 2개의 select 박스로 출력하고 이벤트 걸어주는 함수 선언
//**************************************************************
function print_YM( formN, nameVs, minYear, maxYear ){
	try{
		if( $("[name='"+formN+"']").length==0 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 "+formN+" 라는 폼이름이 존재하지 않습니다.")
			return;
		}
		if( nameVs.length!=2 ) {
			alert( "<개발자 경고>print_YM(~) 함수 호출 시 매개변수에는 배열변수가 2개인 배열이 들어와야 함다..")
			return;
		}
		if( maxYear=="올해" ) {maxYear=new Date().getFullYear();}
		if( maxYear=="내년" ) {maxYear=new Date().getFullYear()+1;}
		if( minYear=="올해" ) {minYear=new Date().getFullYear();}
		if( minYear=="내년" ) {minYear=new Date().getFullYear()+1;}
		//---------------------------------------
		var yearN = nameVs[0]; var monthN = nameVs[1]; 
		//--------------------------------------
		//var changeCode = " onChange=\"checkYM( '"+formN+"', ['"+yearN+"','"+monthN+"']  );\"";
		var code1 = "['"+yearN+"','"+monthN+"']";
		var code2 = "'"+formN+"', ['"+yearN+"','"+monthN+"']";
		//---------------------------------------
		var arr = [];
		//---------------------------------------
		//arr.push( "<select name='"+yearN+"' onChange=\"checkYM( '"+formN+"', ['"+yearN+"','"+monthN+"']  )\">" );
		//arr.push( "<select name='"+yearN+"' " + changeCode + ">" );
		arr.push( "<select name='"+yearN+"' onChange=\"checkYM( "+code2+  ");\">" );		
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}nameVs
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		//arr.push( "<select name='"+monthN+"' onChange=\"checkYM( '"+formN+"', ['"+yearN+"','"+monthN+"']  );\">" );
		//arr.push( "<select name='"+monthN+"' " + changeCode + ">" );
		arr.push( "<select name='"+monthN+"' onChange=\"checkYM( "+code2+  ");\">" );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );

		//arr.push( "<span style='cursor:pointer' onclick=\"set_to_today( "+code2+" );\">[이번달로]</span>&nbsp;&nbsp;" );
		//arr.push( "<span style='cursor:pointer' onclick=\"setEmpty2( '"+formN+"',['"+yearN+"','"+monthN+"']);\">[모두비움]</span>" );
		//---------------------------------------
		document.write( arr.join("") );
	}catch(e){
		alert("print_YM(~,~,~) 함수 호출 시 에러 발생!");
	}
}
//**************************************************************
// print_YM(~,~,~) 함수안에서 호출되는 함수 선언
//**************************************************************
function checkYM( formN, nameVs ){
	try{
		var formObj = $("[name='"+formN+"']");
		//-------------------------
		var yearObj = formObj.find("[name='"+nameVs[0]+"']"); var monthObj = formObj.find("[name='"+nameVs[1]+"']");
		//-------------------------
		var yearV = yearObj.val(); var monthV = monthObj.val();
		var num = (yearV==""?"0":"1") + (monthV==""?"0":"1");
		//-------------------------
		if( num=="01" ) {
			monthObj.val("");  alert("년도가 비어 월을 비움다");  		
		}
		if( num=="10" ) {
			//monthV = "01"; monthObj.val(monthV);
		}
		
	}catch(e){
		alert("checkYM(~) 함수 호출 시 에러 발생!");
	}
}

//**************************************************************
// 년,월 ~ 년,월 4개의 select 박스로 출력하고 이벤트 걸어주는 함수 선언
//**************************************************************
function print_YM_YM( formN, nameVs1, nameVs2, minYear, maxYear ){
	try{
		if( $("[name='"+formN+"']").length==0 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 "+formN+" 라는 폼이름이 존재하지 않습니다.")
			return;
		}
		if( nameVs1.length!=2) {
			alert( "<개발자 경고>print_YM_YM(~) 함수 호출 시 매개변수에는 배열변수가 3개인 배열이 들어와야 함다..")
			return;
		}
		if( nameVs2.length!=2 ) {
			alert( "<개발자 경고>print_YM_YM(~) 함수 호출 시 매개변수에는 배열변수가 3개인 배열이 들어와야 함다..")
			return;
		}
		//---------------------------------------
		if( maxYear=="올해" ) maxYear=new Date().getFullYear();
		if( maxYear=="내년" ) maxYear=new Date().getFullYear()+1;
		if( minYear=="올해" ) minYear=new Date().getFullYear();
		if( minYear=="내년" ) minYear=new Date().getFullYear()+1;
		//---------------------------------------
		var yearN1 = nameVs1[0]; var monthN1 = nameVs1[1]; 
		var yearN2 = nameVs2[0]; var monthN2 = nameVs2[1]; 
		var changeCode = " onChange=\"checkYMYM( '"+formN+"', ['"+yearN1+"','"+monthN1+"'], ['"+yearN2+"','"+monthN2+"']  )\">";
		//---------------------------------------
		//---------------------------------------
		var arr = [];
		//---------------------------------------
		arr.push( "<select name='"+yearN1+"' " + changeCode );
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		arr.push( "<select name='"+monthN1+"' " + changeCode );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );
		//---------------------------------------
		arr.push( "<span style='cursor:pointer' onclick=\"set_to_today( '"+formN+"',['"+yearN1+"','"+monthN1+"']);\">[이번달로]</span>&nbsp;&nbsp;~&nbsp;&nbsp;" );
		//---------------------------------------
		//---------------------------------------
		arr.push( "<select name='"+yearN2+"' " + changeCode );
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		arr.push( "<select name='"+monthN2+"' " + changeCode );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );
		//---------------------------------------
		arr.push( "<span style='cursor:pointer' onclick=\"set_to_today(  '"+formN+"', ['"+yearN2+"','"+monthN2+"']);\">[이번달로]</span>&nbsp;&nbsp;" );
		//---------------------------------------
		arr.push( "<span style='cursor:pointer' onclick=\"setEmpty2( '"+formN+"',['"+yearN1+"','"+monthN1+"','"+yearN2+"','"+monthN2+"']);\">[모두비움]</span>" );
		document.write( arr.join("") );
	}catch(e){
		alert("print_YM_YM(~,~,~) 함수 호출 시 에러 발생!");
	}
}
//**************************************************************
// print_YM_YM(~,~,~) 함수안에서 호출되는 함수 선언
//**************************************************************
function checkYMYM( formN, nameVs1, nameVs2 ){
	try{
		var formObj = $("[name='"+formN+"']");
		//-------------------------
		var yearObj1 = formObj.find("[name='"+nameVs1[0]+"']");
		var monthObj1 = formObj.find("[name='"+nameVs1[1]+"']");
		//---------
		var yearV1 = yearObj1.val();
		var monthV1 = monthObj1.val();
		//-------------------------
		var yearObj2 = formObj.find("[name='"+nameVs2[0]+"']");
		var monthObj2 = formObj.find("[name='"+nameVs2[1]+"']");
		//---------
		var yearV2 = yearObj2.val();
		var monthV2 = monthObj2.val();
		//-------------------------
		var num1 = (yearV1==""?"0":"1") + (monthV1==""?"0":"1");
		var num2 = (yearV2==""?"0":"1") + (monthV2==""?"0":"1");
		//-------------------------
		//-------------------------
		if( num1=="01" ) {
			monthObj1.val("");
			alert("년도가 비어 월일을 비움다");  //return;			
		}
		if( num1=="10" ) {
			monthV1 = "01"; monthObj1.val(monthV1);
		}
		//-------------------------
		//-------------------------
		if( num2=="01" ) {
			monthObj2.val("");
			alert("년도가 비어 월일을 비움다");  //return;			
		}
		if( num2=="10" ) {
			monthV2 = "12"; monthObj2.val(monthV2);
		}
		//-------------------------		
		//-------------------------
		if(  yearV1!="" && monthV1!="" && yearV2!="" && monthV2!="" ) {
			if( (yearV1+""+monthV1) > (yearV2+""+monthV2) ){
				yearObj1.val(""); monthObj1.val("");
				yearObj2.val(""); monthObj2.val("");
				alert("미니멈 년.월.일 이 멕시멈 년.월.일 보다 커서 모두 비움니다.");
				return;
			}
		}
		
	}catch(e){
		alert("checkYMYM(~) 함수 호출 시 에러 발생!");
	}
}

//**************************************************************
// 년,월,일 을 3개의 select 박스로 출력하고 이벤트 걸어주는 함수 선언
//**************************************************************
function print_YMD( formN, nameVs, minYear, maxYear ){
	try{
		if( $("[name='"+formN+"']").length==0 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 "+formN+" 라는 폼이름이 존재하지 않습니다.")
			return;
		}
		if( nameVs.length!=3 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 매개변수에는 배열변수가 3개인 배열이 들어와야 함다..")
			return;
		}
		if( maxYear=="올해" ) maxYear=new Date().getFullYear();
		if( maxYear=="내년" ) maxYear=new Date().getFullYear()+1;
		if( minYear=="올해" ) minYear=new Date().getFullYear();
		if( minYear=="내년" ) minYear=new Date().getFullYear()+1;
		//---------------------------------------
		var yearN = nameVs[0]; var monthN = nameVs[1]; var dayN = nameVs[2]; var weekN = nameVs.join("")+"_week";
		//--------------------------------------
		//---------------------------------------
		var arr = [];
		//---------------------------------------
		//var changeCode = " onChange=\"checkYMD( '"+formN+"', ['"+yearN+"','"+monthN+"','"+dayN+"']  );\"";
		
		arr.push( "<select name='"+yearN+"' onChange=\"checkYMD( '"+formN+"', ['"+yearN+"','"+monthN+"','"+dayN+"']  )\">" );
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		arr.push( "<select name='"+monthN+"' onChange=\"checkYMD( '"+formN+"', ['"+yearN+"','"+monthN+"','"+dayN+"']  )\">" );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );
		//---------------------------------------
		arr.push( "<select name='"+dayN+"' onChange=\"checkYMD( '"+formN+"', ['"+yearN+"','"+monthN+"','"+dayN+"']  )\">" );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=31 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>일" );
		//arr.push( "<span style='width:35;' class='"+weekN+"'></span>" );size='1' background-color:gray;
		arr.push( "<input type=text name='"+weekN+"' readonly class='"+weekN+"' style='width:28'> " );
		arr.push( "<span style='cursor:pointer' onclick=\"set_to_today( '"+formN+"',['"+yearN+"','"+monthN+"','"+dayN+"']);\">[오늘로]</span>" );
		arr.push( "<span style='cursor:pointer' onclick=\"setEmpty2( '"+formN+"',['"+yearN+"','"+monthN+"','"+dayN+"','"+weekN+"']);$('."+weekN+"').val('');\">[모두비움]</span>" );
		//---------------------------------------
		document.write( arr.join("") );
		//document.write( arr.join("") );
		//$(".vvv").append( arr.join("") );

	}catch(e){
		alert("printYMD(~,~,~) 함수 호출 시 에러 발생!");
	}
}
//**************************************************************
// printYMD(~,~,~) 함수안에서 호출되는 함수 선언
//**************************************************************
function checkYMD( formN, nameVs ){
	try{
		var formObj = $("[name='"+formN+"']");
		//-------------------------
		var yearObj = formObj.find("[name='"+nameVs[0]+"']");
		var monthObj = formObj.find("[name='"+nameVs[1]+"']");
		var dayObj = formObj.find("[name='"+nameVs[2]+"']");
		//-------------------------
		var yearV = yearObj.val();
		var monthV = monthObj.val();
		var dayV = dayObj.val();
		var num = (yearV==""?"0":"1") + (monthV==""?"0":"1") + (dayV==""?"0":"1");
		//-------------------------
		if( num=="001" || num=="010" || num=="011") {
			monthObj.val(""); dayObj.val("");  $( "."+nameVs.join("")+"_week").val( "" );
			alert("년도를 먼저 선택하십시요!");   //return;			
		}
		/*if( num=="100" ) {
			monthV = "01"; monthObj.val(monthV);
			dayV = "01";   dayObj.val(dayV);
		}
		if( num=="101" ) {
			monthV = "01"; monthObj.val(monthV);
		}	
		if( num=="110" ) {
			dayV = "01";   dayObj.val(dayV);
		}*/
		if( num=="101" ) {
			dayObj.val(""); $( "."+nameVs.join("")+"_week").val( "" );
			alert("월을 먼저 선택하십시요!");
		}
		$( "."+nameVs.join("")+"_week").html( "" );
		//-------------------------		
		if( yearV!="" && monthV!="" && dayV!="" ) {
			var lastDay = new Date( parseInt(yearV,10), parseInt(monthV,10), 0 ).getDate();
			dayObj.empty();
			dayObj.append( "<option value=''>" );
			for( var i=1 ; i<=lastDay ; i++ ){
				if(i<10) dayObj.append( "<option value=0"+ i +">0" + i );
				else     dayObj.append( "<option value="+ i +">" + i );
			}
			if( dayV>lastDay ) { dayV = lastDay; }
			monthObj.val(monthV); 
			dayObj.val(dayV);	
			var week = ['일','월','화','수','목','금','토'][new Date(parseInt(yearV,10),  parseInt(monthV,10)-1,  parseInt(dayV,10)).getDay()];
			$( "."+nameVs.join("")+"_week").val( "("+week+")" );
			//$( "."+nameVs.join("")+"_week").text( "("+week+")" );
		}
		
	}catch(e){
		alert("checkYMD(~) 함수 호출 시 에러 발생!");
	}
}


//**************************************************************
// 년,월,일 ~ 년,월,일 6개의 select 박스를 출력하고 이벤트 걸어주는 함수 선언
//**************************************************************
function print_YMD_YMD( formN, nameVs1, nameVs2, minYear, maxYear ){
	try{
		if( $("[name='"+formN+"']").length==0 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 "+formN+" 라는 폼이름이 존재하지 않습니다.")
			return;
		}
		if( nameVs1.length!=3 ) {
			alert( "<개발자 경고>print_YMD_YMD(~) 함수 호출 시 매개변수에는 배열변수가 3개인 배열이 들어와야 함다..")
			return;
		}
		if( nameVs2.length!=3 ) {
			alert( "<개발자 경고>print_YMD_YMD(~) 함수 호출 시 매개변수에는 배열변수가 3개인 배열이 들어와야 함다..")
			return;
		}
		//---------------------------------------
		if( maxYear=="올해" ) maxYear=new Date().getFullYear();
		if( maxYear=="내년" ) maxYear=new Date().getFullYear()+1;
		if( minYear=="올해" ) minYear=new Date().getFullYear();
		if( minYear=="내년" ) minYear=new Date().getFullYear()+1;
		//---------------------------------------
		var yearN1 = nameVs1[0]; var monthN1 = nameVs1[1]; var dayN1 = nameVs1[2]; var weekN1 = nameVs1.join("")+"_week";
		var yearN2 = nameVs2[0]; var monthN2 = nameVs2[1]; var dayN2 = nameVs2[2]; var weekN2 = nameVs2.join("")+"_week";
		var changeCode = " onChange=\"checkYMDYMD( '"+formN+"', ['"+yearN1+"','"+monthN1+"','"+dayN1+"'], ['"+yearN2+"','"+monthN2+"','"+dayN2+"']  )\">";
		//--------------------------------------
		$( "."+nameVs1.join("")+"_week").val( "" );
		$( "."+nameVs2.join("")+"_week").val( "" );
		//---------------------------------------
		//---------------------------------------
		var arr = [];
		//---------------------------------------
		arr.push( "<select name='"+yearN1+"' " + changeCode );
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		arr.push( "<select name='"+monthN1+"' " + changeCode );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );
		//---------------------------------------
		arr.push( "<select name='"+dayN1+"' " + changeCode );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=31 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>일" );
		arr.push( "<input type=text name='"+weekN1+"' readonly class='"+weekN1+"' style='width:28'> " );
		//arr.push( "<span style='width:35;' class='"+weekN1+"'></span>" );
		arr.push( "<span style='cursor:pointer' onclick=\"set_to_today('"+formN+"', ['"+yearN1+"','"+monthN1+"','"+dayN1+"']);\">[오늘로]</span>&nbsp;&nbsp;~&nbsp;&nbsp;" );
		//---------------------------------------
		//---------------------------------------
		arr.push( "<select name='"+yearN2+"' " + changeCode );
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		arr.push( "<select name='"+monthN2+"' " + changeCode );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );
		//---------------------------------------
		arr.push( "<select name='"+dayN2+"' " + changeCode );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=31 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>일" );
		arr.push( "<input type=text name='"+weekN2+"' readonly class='"+weekN2+"' style='width:28'> " );
		//arr.push( "<span style='width:35;' class='"+weekN2+"'></span>" );
		arr.push( "<span style='cursor:pointer' onclick=\"set_to_today( '"+formN+"',['"+yearN2+"','"+monthN2+"','"+dayN2+"']);\">[오늘로]</span>" );

		arr.push( "<span style='cursor:pointer' onclick=\"setEmpty2( '"+formN
				+"',['"+yearN1+"','"+monthN1+"','"+dayN1+"','"+yearN2+"','"+monthN2+"','"+dayN2+"','"+weekN1+"','"+weekN2+"']);"
				+"$( '."+nameVs1.join('')+"_week, ."+nameVs2.join('')+"_week').val('');\">[모두비움]</span>" );
		//---------------------------------------
		document.write( arr.join("") );
	}catch(e){
		alert("printYMD(~,~,~) 함수 호출 시 에러 발생!");
	}
}




//**************************************************************
// checkYMDYMD(~,~,~) 함수안에서 호출되는 함수 선언
//**************************************************************
function checkYMDYMD( formN, nameVs1, nameVs2 ){
	try{
		var formObj = $("[name='"+formN+"']");
		//-------------------------
		var yearObj1 = formObj.find("[name='"+nameVs1[0]+"']");
		var monthObj1 = formObj.find("[name='"+nameVs1[1]+"']");
		var dayObj1 = formObj.find("[name='"+nameVs1[2]+"']");
		//---------
		var yearV1 = yearObj1.val();
		var monthV1 = monthObj1.val();
		var dayV1 = dayObj1.val();
		//-------------------------
		var yearObj2 = formObj.find("[name='"+nameVs2[0]+"']");
		var monthObj2 = formObj.find("[name='"+nameVs2[1]+"']");
		var dayObj2 = formObj.find("[name='"+nameVs2[2]+"']");
		//---------
		var yearV2 = yearObj2.val();
		var monthV2 = monthObj2.val();
		var dayV2 = dayObj2.val();

		//-------------------------
		var num1 = (yearV1==""?"0":"1") + (monthV1==""?"0":"1") + (dayV1==""?"0":"1");
		var num2 = (yearV2==""?"0":"1") + (monthV2==""?"0":"1") + (dayV2==""?"0":"1");
		//-------------------------
		//-------------------------
		if( num1=="001" || num1=="010" || num1=="011") {
			monthObj1.val(""); dayObj1.val("");  $( "."+nameVs1.join("")+"_week").val( "" );
			alert("년도를 먼저 선택하십시요!"); //return;			
		}
		if( num1=="100" ) {
			monthV1 = "01"; monthObj1.val(monthV1);
			dayV1 = "01";   dayObj1.val(dayV1);
		}
		if( num1=="101" ) {
			monthV1 = "01"; monthObj1.val(monthV1);
		}	
		if( num1=="110" ) {
			dayV1 = "01";   dayObj1.val(dayV1);
		} 
		//$( "."+nameVs1.join("")+"_week").html( "" ); 
		$( "."+nameVs1.join("")+"_week").val( "" ); 
		//-------------------------		
		if( yearV1!="" && monthV1!="" && dayV1!="" ) {
			var lastDay = new Date( parseInt(yearV1,10), parseInt(monthV1,10), 0 ).getDate();
			dayObj1.empty();
			dayObj1.append( "<option value=''>" );
			for( var i=1 ; i<=lastDay ; i++ ){
				if(i<10) dayObj1.append( "<option value=0"+ i +">0" + i );
				else     dayObj1.append( "<option value="+ i +">" + i );
			}
			if( dayV1>lastDay ) { dayV1 = lastDay; }
			monthObj1.val( monthV1 ); 
			dayObj1.val( dayV1 );	
			var week1 = ['일','월','화','수','목','금','토'][new Date(parseInt(yearV1,10),  parseInt(monthV1,10)-1,  parseInt(dayV1,10)).getDay()];
			$( "."+nameVs1.join("")+"_week").val( "("+week1+")" )
			//$( "."+nameVs1.join("")+"_week").text( "("+week1+")" );
		}
		//-------------------------
		//-------------------------
		if( num2=="001" || num2=="010" || num2=="011") {
			monthObj2.val(""); dayObj2.val(""); $( "."+nameVs2.join("")+"_week").val( "" );
			alert("년도를 먼저 선택하십시요!");;  //return;			
		}
		if( num2=="100" ) {
			monthV2 = "12"; monthObj2.val(monthV2);
			dayV2 = "31";   dayObj2.val(dayV2);
		}
		if( num2=="101" ) {
			monthV2 = "01"; monthObj2.val(monthV2);
			//dayV2 = "01";   dayObj2.val(dayV2);
		}	
		if( num2=="110" ) {
			dayV2 = "01";   dayObj2.val(dayV2);
		} 
		//-------------------------		
		//$( "."+nameVs2.join("")+"_week").html( "" );
		$( "."+nameVs2.join("")+"_week").val( "" ); 
		if( yearV2!="" && monthV2!="" && dayV2!="" ) {
			var lastDay = new Date( parseInt(yearV2,10), parseInt(monthV2,10), 0 ).getDate();
			dayObj2.empty();
			dayObj2.append( "<option value=''>" );
			for( var i=1 ; i<=lastDay ; i++ ){
				if(i<10) dayObj2.append( "<option value=0"+ i +">0" + i );
				else     dayObj2.append( "<option value="+ i +">" + i );
			}
			if( dayV2>lastDay ) dayV2 = lastDay;
			monthObj2.val(monthV2); 
			dayObj2.val(dayV2);	
			var week2 = ['일','월','화','수','목','금','토'][new Date(parseInt(yearV2,10),  parseInt(monthV2,10)-1,  parseInt(dayV2,10)).getDay()];
			$( "."+nameVs2.join("")+"_week").val( "("+week2+")" )
			//$( "."+nameVs2.join("")+"_week").text( "("+week2+")" );
		}
		//-------------------------		
		//-------------------------
		if(  yearV1!="" && monthV1!="" && dayV1!=""&& yearV2!="" && monthV2!="" && dayV2!="" ) {
			if( (yearV1+""+monthV1+""+dayV1) > (yearV2+""+monthV2+""+dayV2) ){
				yearObj1.val(""); monthObj1.val(""); dayObj1.val(""); $( "."+nameVs1.join("")+"_week").val( "" );
				yearObj2.val(""); monthObj2.val(""); dayObj2.val(""); $( "."+nameVs2.join("")+"_week").val( "" );
				alert("미니멈 년.월.일 이 멕시멈 년.월.일 보다 커서 모두 비움니다.");
				return;
			}
		}
		
	}catch(e){
		alert("checkYMDYMD(~) 함수 호출 시 에러 발생!");
	}
}



















//**************************************************************
// 입력 양식에 입력된 문자열의 패턴을 체크하여 맞으면 true 를 리턴하는 함수 선언
//**************************************************************
function isValidPattern( formN, ynameV, patternObj ){
	try{
		var obj = $("[name='"+formN+"'] [name='"+nameV+"']");
		if( obj.length==0 ){
			alert(nameV + "란 이름의 입력 양식이 없습니다.");
			return false;
		}
		return new RegExp( patternObj ).test( obj.val() ); 
	}catch(e){
		alert("isValidPattern(~,~) 함수 호출 시 에러 발생!");
		return false;
	}
}

//**************************************************************
// body 태그 안의 form 태그, 입력양식 태그에 새로운 class="name속성값" 을 삽입하기
// <주의>스프링에서 사용하기 위해 name 속성값이 xxx[2].aaa 같은 형식이면 대괄호와 점 을 없앤 xxx2aaa 바꾸어 준다. 
//      class 속성값이 xxx[2].aaa 같은 형식이면 Jquery 에서 선택자로 쓸수가 없어 유효성 체크가 불가능하기 떄문이다.
//**************************************************************
function addClassN( ){
	try{
		$("body").find("input,select,textarea,form").not("[type=button],[type=submit],[type=reset]").each(function(){
			var nameV = $(this).attr("name");
				alert( nameV )
			if( nameV.indexOf("[")>=0 && nameV.indexOf("]")>=0 ) {
				while( nameV.indexOf("[")>=0 || nameV.indexOf("]")>=0 || nameV.indexOf(".")>=0 ) {
					nameV = nameV.replace("[","");
					nameV = nameV.replace("]","");
					nameV = nameV.replace(".","");
				}
			}
			if(nameV!=null  && nameV!=undefined && nameV!=""){
				$(this).addClass(nameV);
			}
		});
	}catch(e){
		alert("addClassN( ) 함수 호출 시 에러 발생!");
	}
}

//**************************************************************
// 기존 화면 위에 전체를 덮는 div 태그 생성하기. 삽입된 태그가 상단 왼쪽에 붙음.
//**************************************************************
function openFullScreenDiv1( 
		divClassN     // div 태그의 class 값
		, heightV     // 높이 값
		, widthV       // 너비값
		, topV         // 왼쪽 상단 모서리의 Y 좌표값
		, leftV        // 왼쪽 상다 모서리의 X 좌표값
		, bgcolorV     // 배경색
		, opacity      // 투명도 설정 <주의>투명도는 0 ~ 1. 사이의 값만 입력 가능.
		, insertHtml   // div 태그 내부의 삽입 html 소스      
){
	//alert( heightV +"/"+ widthV )
	try{
		$("."+divClassN).remove();
		$("body").append(
			"<div class='"+divClassN+"' " 
			 +	   "style='padding:7;position:absolute;top:"+topV+";left:"+leftV + ";width:"+widthV+";height:"+heightV
			 +                                    ";z-index:5; background-color:"+bgcolorV+";border:0px solid "+bgcolorV+"'>" 
			 + "<table border=0 cellpadding=5><tr><td valign='top'>" 
			 + insertHtml  
			 + "</table>"
			 + "</div>"
		);
		$("."+divClassN).fadeTo( 0, opacity );
	}catch(e){
		alert("openFullScreenDiv(~) 함수 호출 시 에러 발생...");
	}
	//------------------------------------------
	// 함수 호출 코딩예
	//------------------------------------------
	// <input type="button" value="asaas" onclick=" openFullScreenDiv('xxx','100%','100%',0,0,'pink', 2, 'asasasa')">
}
//**************************************************************
//기존 화면 위에 전체를 덮는 div 태그 생성하기. 삽입된 태그가 상단 가운데 붙음.
//**************************************************************
function openFullScreenDiv2( 
		divClassN     // div 태그의 class 값
		, heightV     // 높이 값
		, widthV       // 너비값
		, topV         // 왼쪽 상단 모서리의 Y 좌표값
		, leftV        // 왼쪽 상다 모서리의 X 좌표값
		, bgcolorV     // 배경색
		, opacity      // 투명도 설정 <주의>투명도는 0 ~ 1. 사이의 값만 입력 가능.
		, insertHtml   // div 태그 내부의 삽입 html 소스      
){
	try{
		$("."+divClassN).remove();
		$("body").append(
			"<div class='"+divClassN+"' " 
			 +	   "style='padding:7;position:absolute;top:"+topV+";left:"+leftV + ";width:"+widthV+";height:"+heightV
			 +                                    ";z-index:5; background-color:"+bgcolorV+";border:0px solid "+bgcolorV+"'>" 
			 + "<center><table border=0 cellpadding=5><tr><th valign='top'>" 
			 + insertHtml  
			 + "</table></center>"
			 + "</div>"
		);
		$("."+divClassN).fadeTo( 0, opacity );
	}catch(e){
		alert("openFullScreenDiv(~) 함수 호출 시 에러 발생...");
	}
	//------------------------------------------
	// 함수 호출 코딩예
	//------------------------------------------
	// <input type="button" value="asaas" onclick=" openFullScreenDiv('xxx','100%','100%',0,0,'pink', 2, 'asasasa')">
}



/*
function openDiv( 
		divClassN     // div 태그의 class 값
		, heightV     // 높이 값
		, widthV       // 너비값
		, topV         // 왼쪽 상단 모서리의 Y 좌표값
		, leftV        // 왼쪽 상다 모서리의 X 좌표값
		, bgcolorV     // 배경색
		, opacity      // 투명도 0~1. 사이의 값만 입력 가능.
		, insertHtml    // div 태그 내부의 삽입 html 소스
){
	try{
		$("."+divClassN).remove();
		$("body").append(
			"<div class='"+divClassN+"' " +
				"style='padding:7;position:absolute;height:"+heightV
					+";width:"+widthV+";top:"+topV+";left:"+leftV+";z-index:5; background-color:"+bgcolorV+";border:1px solid "+bgcolorV+"'>"
			 + insertHtml +
			"</div>"
		);
		$("."+divClassN).fadeTo( 0, opacity );
	}catch(e){
		alert("openDiv(~) 함수 호출 시 에러 발생...");
	}
}
*/

//**************************************************************width:100;height:100;
//붕 뜨는 div 태그 생성하여 삽입하기
//**************************************************************
function alertDiv1( 
		html    // div 태그 내부의 삽입 html 소스
){
	try{
		$("body").append(
			"<div class='alert2' style='padding:7;position:absolute;height:100%"
					+";width:100%;top:0;left:0;z-index:5; background-color:gray;border:1px solid gray'></div>"
		);
		$(".alert2").fadeTo( 0, 0.3 );
		
		$("body").append(
				"<center><div class='alert3' style='padding:7;position:absolute;top:300;left:600;z-index:6'><table border=0 bgcolor='gray' cellpadding=10><tr><th>"
				+html+
				"<br><br><input type='button' value='닫기' onclick='$(\".alert2,.alert3\").remove();'></table></div></center>"
		);
	}catch(e){
		alert("alert2(~) 함수 호출 시 에러 발생...");
	}
}

//**************************************************************width:100;height:100;
//붕 뜨는 div 태그 생성하여 삽입하기
//**************************************************************
function alertDiv2( 
		html    // div 태그 내부의 삽입 html 소스
){
	try{
		$("body").append(
				"<div class='alertDiv2' style='padding:7;position:absolute;height:100%"
						+";width:100%;top:0;left:0;z-index:5; background-color:gray;border:1px solid gray'></div>"
		);
		$(".alertDiv2").fadeTo( 0, 0.3 );
		
		$("body").append(
				"<center><div class='alertDiv3' id=r><b id=r1></b><b id=r2></b><b id=r3></b><b id=r4></b><div id=r5 style='height:300px'>"
				
				+html+"<br><br><input type='button' value='닫기' onclick='$(\".alertDiv2,.alertDiv3\").remove();'>"+
				
				"</div><b id=r4></b><b id=r3></b><b id=r2></b><b id=r1></b></div></center>"
		);
		$(".alertDiv3").css(  {"z-index":"7","position":"absolute","top":"300","left":"300"}  );
	}catch(e){
		alert("alert2(~) 함수 호출 시 에러 발생...");
	}
}



/*<html>
<head>
	<title>둥근 모서리 테두리</title>
	<style>
		p {
			background: #90D000;
			padding: 20px;
			width: 300px;
		}
		#round1 { border-radius: 50px; }
		#round2 { border-radius: 0px 20px 40px 60px; }  왼쪽 상단부터 시계방향으로 
		#round3 { border-radius: 0px 20px 40px; }
		#round4 { border-radius: 0px 20px; }
		#round5 { border-radius: 50px; 
					border-style: dotted;r}
	</style>
</head>
<body>
	<h3>둥근 모서리 테두리</h3>
	<p id="round1">반지름 50픽셀의 둥근 모서리</p>
	<p id="round2">반지름 0, 20, 40, 60 둥근 모서리</p>
	<p id="round3">반지름 0, 20, 40, 20 둥근 모서리</p>
	<p id="round4">반지름 0, 20, 0, 20 둥근 모서리</p>
	<p id="round5">반지름 50의 둥근 점선 모서리


</body>
</html>[출처] html 둥근 모서리 테두리 만들기|작성자 웹팝
*/





//**************************************************************
// 검색화면에서 검색 결과물의 페이징 번호 출력 소스 리턴
//**************************************************************
function getPagingNo(
	totRowCnt               // 검색 결과 총 행 개수
	, selectPageNo_str         // 선택된 현재 페이지 번호
	, rowCntPerPage_str     // 페이지 당 출력행의 개수
	, pageNoCntPerPage_str  // 페이지 당 출력번호 개수
	, jsCodeAfterClick      // 페이지 번호 클릭후 실행할 자스 코드
) {
	//--------------------------------------------------------------
	// name=nowPage을 가진 hidden 태그없으면 경고하고 중지하는 자바스크립트 소스 생성해 저장
	//--------------------------------------------------------------
	$(document).ready(function( ){
		if( $('[name=selectPageNo]').length==0 ){
			alert("name=nowPage 을 가진 hidden 태그가 있어야 가능함.');" );
		}
	});
	var arr = [];
	try{
		if( totRowCnt==0 ){	return ""; }	
		if( jsCodeAfterClick==null || jsCodeAfterClick.length==0){
			alert("getPagingNo(~) 함수의 5번째 인자는 존재하는 함수명이 와야 합니다");
			return "";
		}			
		//--------------------------------------------------------------
		// 페이징 처리 관련 데이터 얻기
		//--------------------------------------------------------------
		if( selectPageNo_str==null || selectPageNo_str.length==0 ) { 
			selectPageNo_str="1";  // 선택한 현재 페이지 번호 저장
		} 
		if( rowCntPerPage_str==null || rowCntPerPage_str.length==0 ) { 
			rowCntPerPage_str="10";  // 선택한 현재 페이지 번호 저장
		}
		if( pageNoCntPerPage_str==null || pageNoCntPerPage_str.length==0 ) { 
			pageNoCntPerPage_str="10";  // 선택한 현재 페이지 번호 저장
		}
		//---
		var selectPageNo = parseInt(selectPageNo_str, 10);
		var rowCntPerPage = parseInt(rowCntPerPage_str,10);
		var pageNoCntPerPage = parseInt(pageNoCntPerPage_str,10);
		if( rowCntPerPage<=0 || pageNoCntPerPage<=0 ) { return; }
		//--------------------------------------------------------------
		//최대 페이지 번호 얻기
		//--------------------------------------------------------------
		var maxPageNo=Math.ceil( totRowCnt/rowCntPerPage );   
			if( maxPageNo<selectPageNo ) { selectPageNo = 1; }

		//--------------------------------------------------------------
		// 선택된 페이지번호에 따라 출력할 [시작 페이지 번호], [끝 페이지 번호] 얻기
		//--------------------------------------------------------------
		var startPageNo = Math.floor((selectPageNo-1)/pageNoCntPerPage)*pageNoCntPerPage+1;  // 시작 페이지 번호
		var endPageNo = startPageNo+pageNoCntPerPage-1;                                      // 끝 페이지 번호
			if( endPageNo>maxPageNo ) { endPageNo=maxPageNo; }
			/*//--------------------------------------------------------------
			// <참고>위 코딩은 아래 코딩으로 대체 가능
			//--------------------------------------------------------------
			var startPageNo = 1;
			var endPageNo = pageNoCntPerPage;
			while( true ){
				if( selectPageNo <= endPageNo ){ startPageNo = endPageNo - pageNoCntPerPage + 1; break; }
				endPageNo = endPageNo + pageNoCntPerPage;
			}*/

		//---
		var cursor = " style='cursor:pointer' ";
		//arr.push( "<table border=0 cellpadding=3 style='font-size:13'  align=center> <tr>" );
		//--------------------------------------------------------------
		// [처음] [이전] 출력하는 자바스크립트 소스 생성해 저장
		//--------------------------------------------------------------
		//arr.push( "<td align=right width=110>&nbsp;" );
		if( startPageNo>pageNoCntPerPage ) {
			arr.push( "<span "+cursor+" onclick=\"$('[name=selectPageNo]').val('1');"
							+jsCodeAfterClick+";\">[처음]</span>" );
			arr.push( "<span "+cursor+" onclick=\"$('[name=selectPageNo]').val('"
				+(startPageNo-1)+"');"+jsCodeAfterClick+";\">[이전]</span>&nbsp;&nbsp;&nbsp;" );
		}
		//--------------------------------------------------------------
		// 페이지 번호 출력하는 자바스크립트 소스 생성해 저장
		//--------------------------------------------------------------
		//arr.push( "<td align=center>&nbsp;&nbsp;" );
		for( var i=startPageNo ; i<=endPageNo; ++i ){
			if(i>maxPageNo) {break;}
			if(i==selectPageNo || maxPageNo==1 ) {
				arr.push( "<b>"+i +"</b> " );
			}else{
				arr.push( "<span "+cursor+" onclick=\"$('[name=selectPageNo]').val('"
							+(i)+"');"+jsCodeAfterClick+";\">["+i+"]</span> " );
			}
		}
		//--------------------------------------------------------------
		// [다음] [마지막] 출력하는 자바스크립트 소스 생성해 저장
		//--------------------------------------------------------------
		//arr.push( "<td align=left width=110>&nbsp;&nbsp;" );
		if( endPageNo<maxPageNo ) {
			arr.push( "&nbsp;&nbsp;&nbsp;<span "+cursor+" onclick=\"$('[name=selectPageNo]').val('"
						+(endPageNo+1)+"');"+jsCodeAfterClick+";\">[다음]</span>" );
			arr.push( "<span "+cursor+" onclick=\"$('[name=selectPageNo]').val('"
						+(maxPageNo)+"');"+jsCodeAfterClick+";\">[마지막]</span>" );
		}
		//arr.push( "</table>" );
		return arr.join( "" );
	}catch(ex){
		alert("getPagingNo(~) 메소드 호출 시 예외발생!");
		return "";
	}
}

function printPagingNo(
	totRowCnt               // 검색 결과 총 행 개수
	, selectPageNo_str         // 선택된 현재 페이지 번호
	, rowCntPerPage_str     // 페이지 당 출력행의 개수
	, pageNoCntPerPage_str  // 페이지 당 출력번호 개수
	, jsCodeAfterClick      // 페이지 번호 클릭후 실행할 자스 코드
) {
	document.write(
		getPagingNo(
			totRowCnt               // 검색 결과 총 행 개수
			, selectPageNo_str         // 선택된 현재 페이지 번호
			, rowCntPerPage_str     // 페이지 당 출력행의 개수
			, pageNoCntPerPage_str  // 페이지 당 출력번호 개수
			, jsCodeAfterClick      // 페이지 번호 클릭후 실행할 자스 코드
		) 
	);
}



//**************************************************************
function setTableTrBgColor( tableClassV, oddBgColor, evenBgColor, mouseOnBgColor ) {
//**************************************************************
	var trObjs = $("."+tableClassV+" tr:eq(0)").nextAll();
	//--------------------------------
	//기존 배경색 CSS 제거
	//--------------------------------
	trObjs.css('background', "none" );
	//--------------------------------
	//새로운 배경색 CSS 지정
	//--------------------------------
	trObjs.filter(":odd").css('background', evenBgColor );
	trObjs.filter(":even").css('background', oddBgColor );
	//----------------------
	trObjs.hover(
		function(){   
			$(this).css('background', mouseOnBgColor );
		}, 
		function(){   
			$(this).css('background', "none" );
			if( $(this).index()%2==0 ) {
				$(this).css('background', evenBgColor );
			}else{
				$(this).css('background', oddBgColor );
			}
		}
	); 
	//trObjs.mouseover().mouseout();
	trObjs.each(function(){
		$(this).mouseover();
		$(this).mouseout();
	})
}

//**************************************************************
function setTableTrBgColor4( trObjs, oddBgColor, evenBgColor, mouseOnBgColor ) {
//**************************************************************
	//--------------------------------
	// 홀수행, 짝수행 배경색 지정
	//--------------------------------
	trObjs.filter(":odd").attr('bgcolor', evenBgColor );
	trObjs.filter(":even").attr('bgcolor', oddBgColor );
	//----------------------
	// 이전에 hover 메소드에 의해 걸려있던 mouseenter, mouseleave 이벤트를 제거
	//----------------------
	trObjs.unbind('mouseenter mouseleave');
	//----------------------
	// 마우스를 땔때, 뺄대 배경색 지정하기
	//----------------------
	trObjs.hover(
		function(){   
			$(this).attr( 'bgcolor', mouseOnBgColor );
		}, 
		function(){   
			if( trObjs.index(this)%2==0 ) {
				$(this).attr('bgcolor', oddBgColor );
			}else{
				$(this).attr('bgcolor', evenBgColor );
			}
		}
	)
}
	
	


//**************************************************************
// n개 tr 태그의 배경색 지정,  tr 태그 내부 td/th 태그 안의 글자색 지정 함수 
//**************************************************************
function setColor_table( trObj, bgColor, fontColor ){
	trObj.each(function(){
		var thisTrObj = $(this);
		thisTrObj.attr( 'bgcolor', bgColor  );
		thisTrObj.find("th,td").each(function(){
			var tdThObj = $(this);
			tdThObj.html(
				"<font color="+fontColor+">"+tdThObj.html()+"</font>"
			);
		});	
	});
}


//**************************************************************
// n개의 tr 태그의 배경색 지정,  tr 태그 내부 td/th 태그 안의 글자색 지정 함수 
//**************************************************************
function setColor_searchTable( 
		trsObj
		, oddBgColor, evenBgColor, mouseOnBgColor
		, oddFontColor, evenFontColor, mouseOnFontColor
) {
	//alert(0)
	try{
		var odd_trObj = trsObj.filter(":even");
		var even_trObj = trsObj.filter(":odd");
		//--------------------------------
		// 홀/짝수행 배경색, 글자색 지정하기
		//--------------------------------
		setColor_table( odd_trObj, oddBgColor, oddFontColor );
		setColor_table( even_trObj, evenBgColor, evenFontColor );
		//--------------------------------
		if(mouseOnBgColor==null || mouseOnBgColor=="" || mouseOnFontColor==null || mouseOnFontColor=="") { return; }	
		//--------------------------------
		// 이전에 hover 메소드에 의해 걸려있던 mouseenter, mouseleave 이벤트를 제거
		//--------------------------------
		trsObj.unbind('mouseenter mouseleave');
		//--------------------------------
		// 마우스를 땔때, 뺄대 배경색, 글자색 지정하기
		//--------------------------------
		trsObj.hover(
			function(){   
				setColor_table( $(this), mouseOnBgColor, mouseOnFontColor );
			}, 
			function(){   
				if( trsObj.index(this)%2==0 ) {
					setColor_table( $(this), oddBgColor, oddFontColor );
				}else{
					setColor_table( $(this), evenBgColor, evenFontColor );
				}
			}
		)
		//alert( trsObj.parent().html() )
	}catch(e){
		alert("setColor_searchTable 함수 에러 발생..");
	}
}

//*********************************************
// 마지막 tr 행을 복사해 마지막 tr 다음에 추가하는 함수선언
//*********************************************
function addLastTr( idV  ){
		//alert( is_empty("relation_1/f_name_1/with_live_1") );
	try{
		// id=idV매개변수값 를 가진 태그를 관리하는 jQuery 객체 생성해 저장
		var tableObj = $("#"+idV);
		// id=idV매개변수값 를 가진 태그의 개수가 1이 아니면 경고 멈춤
		if( tableObj.length!=1 ) {
			 alert("id='"+idV + "' 을 가진 table 태그가 없어 addTr(~) 란 이름의 함수 호출 불가!"); 
			 return;
		}
		// 마지막 tr 태그를 관리하는 jQuery 객체 생성해 저장
		var trObj = tableObj.find("tr:eq(0)").siblings();
		var lastTrObj = trObj.last();

		//var lastTrObj = tableObj.find("tbody:eq(0) tr:eq(0)").siblings().last();

		if( trObj.length==0 ){
			//lastTrObj = tableObj.find("tr:eq(0)");
		}
		//---------------------------------
		// checkbox 와 radio 입력 양식을 가르키는 선택자 문자열 저장
		var cr_selector = "[type=checkbox],[type=radio]";
		// checkbox 와 radio 입력 양식을 제외한 입력 양식 태그를 가르키는 선택자 문자열 저장
		var not_cr_selector = "select,textarea,[type=text],[type=password],[type=hidden],[type=file]"
		// 모든 입력 양식 태그를 가르키는 선택자 문자열 저장
		var all_selector = cr_selector+ ","+not_cr_selector;
		//---------------------------------
		// 복사할 tr 태그 안의 입력 양식에  입력/선택 데이터의 개수 얻기
		//---------------------------------
		// 입력 양식에 데이터가 있을 때마다 1씩 증가해 저장하는 변수 선언
		var dataCnt = 0;
		var cnt1 = 0;
		lastTrObj.find(all_selector).each( function(i){
			// i번째 입력양식을 관리하는 JQuery 객체를 생성해서 저장
			var thisObj = $(this);
			var nameV = thisObj.attr("name");
			//var idV = thisObj.attr("id");
			if( nameV.indexOf("[")<0 &&  nameV.indexOf("]")<0  ) { cnt1++; }
			// i번째 입력양식이 checkbox 또는 radio 면
			if( thisObj.is(":radio") || thisObj.is(":checkbox") ){
				if( thisObj.filter(":checked").length>0){ dataCnt++;  }
			}
			// i번째 입력양식이 checkbox 도 아니고 radio 도 아니면
			else{
				// i번째 입력양식의 입력값이 있으면 dataCnt 변수안에 1증가
				var val = thisObj.val( ); 
				if( val.split(" ").join("")!="" ){ dataCnt++;  }
			}
		});
		if( cnt1>0 ) { alert("<개발자 경고>\naddTr(~) 함수 호출 시 복사 대상 한 행의 모든 입력양식 이름에는 [0]이 삽입되야합니다."); return; }
		// 복사할 행의 모든 입력 양식에 데이터가 없거나 체크가 안되어 있으면
		if(dataCnt==0 ) { alert("마지막 행에 테이터가 비어있어 행 추가 불가능!"); return; }
		//---------------------------------
		// 마지막 tr을 복제해서 마지막 tr 다음에 삽입하기
		//---------------------------------
		//lastTrObj.after( lastTrObj.clone() ); 

		var totTrCnt = trObj.length
			
		var copyTrSrc = lastTrObj.html(); 
		//alert("copyTrSrc=>\n"+copyTrSrc); 
		while( copyTrSrc.indexOf("["+(totTrCnt-1)+"]")>=0 ){
			copyTrSrc = copyTrSrc.replace("["+(totTrCnt-1)+"]","["+(totTrCnt)+"]");
		}
		//alert(copyTrSrc)
		lastTrObj.after( "<tr>"+copyTrSrc); 
		
		//alert(   "$([name=family["+(totTrCnt)+"].relation]).length =>" + $("[name='family["+(totTrCnt)+"].relation']").length      );

		//---------------------------------
		// 추가된 마지막 tr을 관리하는 JQuery 객체를 변수 lastTrObj 에 갱신해서 저장
		//---------------------------------
		lastTrObj = lastTrObj.next();  
		//---------------------------------
		// 추가된 tr 안의 입력 양식에 데이터 비우기 또는 체크 풀기
		//---------------------------------
		lastTrObj.find(not_cr_selector).val("");
		lastTrObj.find(cr_selector).filter(":checked").click( );
		//alert( "lastTrObj.html()=>"+lastTrObj.html() );tableObj
		//alert( "tableObj.html()=>\n"+tableObj.html() );
	}catch(e) {
		alert( "addTr(  '"+idV+"' ); 함수 예외발생!" ); 
	}
}
//*********************************************
//마지막 행을 삭제하는 함수선언
//*********************************************
function delLastTr( idV  ){
	try{
		// id=idV매개변수값 를 가진 태그를 관리하는 jQuery 객체 생성해 tableObj에 저장
		var tableObj = $("#"+idV);
		// id=idV매개변수값 를 가진 태그의 개수가 1이 아니면 경고 멈춤
		if( tableObj.length!=1 ) {
			 alert("id='"+idV + "' 을 가진 table 태그가 없어 delLastTr(~) 란 이름의 함수 호출 불가!"); 
			 return;
		}
		// 삭제할 마지막 tr 태그를 관리하는 jQuery 객체 생성해 저장
		// 마지막 tr 태그를 관리하는 jQuery 객체 생성해 저장
		var trObj = tableObj.find("tr:eq(0)").siblings();
		var lastTrObj = trObj.last();
		// 만약 tr 태그 1개 만 있으면 경고하고 중단
		if( trObj.length==1 ) { 
			 alert("마지막 남은 1개 행은 삭제가 불가능함!");   
			 return;
		}
		//---------------------------------
		// checkbox 와 radio 입력 양식을 가르키는 선택자 문자열 저장
		var cr_selector = "[type=checkbox],[type=radio]";
		// checkbox 와 radio 입력 양식을 제외한 입력 양식 태그를 가르키는 선택자 문자열 저장
		var not_cr_selector = "select,textarea,[type=text],[type=password],[type=hidden],[type=file]"
		// 모든 입력 양식 태그를 가르키는 선택자 문자열 저장
		var all_selector = cr_selector+ ","+not_cr_selector;
		//---------------------------------
		// 복사할 tr 태그 안의 입력 양식에  입력/선택 데이터의 개수 얻기
		//---------------------------------
		// 입력 양식에 데이터가 있을 때마다 1씩 증가해 저장하는 변수 선언
		var dataCnt = 0;
		lastTrObj.find(all_selector).each( function(i){
			// i번째 입력양식을 관리하는 JQuery 객체를 생성해서 저장
			var thisObj = $(this);
			// i번째 입력양식이 checkbox 또는 radio 면
			if( thisObj.is(":radio") || thisObj.is(":checkbox") ){
				if( thisObj.filter(":checked").length>0){ dataCnt++;  }
			}
			// i번째 입력양식이 checkbox 도 아니고 radio 도 아니면
			else{
				// i번째 입력양식의 입력값이 있으면 dataCnt 변수안에 1증가
				var val = thisObj.val( ); 
				if( val.split(" ").join("")!="" ){ dataCnt++;  }
			}
		});
		// 삭제할 tr 내부의 입력양식에 입력/선택 데이터가 있으면 confirm 상자띄우기
		if(dataCnt>0 ) {
			// confirm 상자에서 확인 버튼 누르면 함수 멈춤
			if( confirm("행에 데이터가 있음! 삭제할까요?")==false ) { return; }	
		}
		//---------------------------------
		// tr 을 삭제하기
		//---------------------------------	
		//alert( lastTrObj.html() )
		lastTrObj.remove();
	}catch(e) {
		alert( "delLastTr(  '"+idV+"' ); 함수 예외발생!" ); 
	}
}


//*********************************************
// 원하는 tr 태그 1개 행을 추가하는 함수선언.
//*********************************************
function addTr2(
	tab_idV    // "행추가내포한table태그id값"
	, idx      // [복사할tr인덱스번호]
){
	try{
		if( idx.indexOf("[")<0 || idx.indexOf("]")<0  ) {
			alert( "delTr(  ~, ~ ) 함수 호출 시 2번째 인자값은 [행인덱스번호]  형식이어야합니다!" ); return;
		}
		var tabObj = $("#"+tab_idV);
		var trsObj = tabObj.find("tr:eq(0)").nextAll();
		//-------------------------------------------
		// 행 추가하기
		//-------------------------------------------
		for( var i=0 ; i<trsObj.length ; i++){
			var trObj = trsObj.eq(i);
			var html =  trObj.html();
			if( html.indexOf(idx)>=0 ){
				var dataCnt = 0;
				trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(){
					var thisObj = $(this);
					if( thisObj.filter(":checkbox,:radio").length>0 ){
						dataCnt = dataCnt + thisObj.filter(":checked").length;
					}
					else{
						dataCnt = dataCnt + thisObj.val().split(" ").join("").length;
					}
				});
				if( dataCnt==0 ){
					alert( "행이 비어있어 행 추가 금지!" ); return;
				}
				trObj.after(   "<tr>"+html  ); 
				
				trObj.next().find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(){
					var thisObj = $(this);
					if( thisObj.filter(":checkbox,:radio").length>0 ){
						thisObj.filter(":checked").click();
					}
					else{
						thisObj.val("");
					}
				});
				break;
			}
		}
		trsObj = tabObj.find("tr:eq(0)").nextAll();
		//-------------------------------------------
		// 모든 각 행이 내포한   [인덱스번호]   를 일련번호로 수정하기
		//-------------------------------------------
		trsObj.each(function(i){
			var trObj = $(this);
			var html =  trObj.html();
			var str = "";
			var no = 0;
			while( true ){
				if( html.indexOf("["+ no +"]")>=0 ){ str = "["+ no +"]"; break; }
				no++;
			}
			var arr = html.split(str);  
			trObj.html(   arr.join("["+i+"]")  );
		});
		//alert( tabObj.html());
	}catch(e) {
		alert( "addTr(  ~, ~ ) 함수 예외발생!" ); 
	}
}







//*********************************************
// 원하는 tr 태그 1개 행을 추가하는 함수선언.
//*********************************************
function addTr(
	tab_idV    // "행추가내포한table태그id값"
	, idx      // [복사할tr인덱스번호]
){
	try{
		if( idx.indexOf("[")<0 || idx.indexOf("]")<0  ) {
			alert( "delTr(  ~, ~ ) 함수 호출 시 2번째 인자값은 [행인덱스번호]  형식이어야합니다!" ); return;
		}
		var tabObj = $("#"+tab_idV);
		var trsObj = tabObj.find("tr:eq(0)").nextAll();
		//-------------------------------------------
		// 행 추가하기
		//-------------------------------------------
		for( var i=0 ; i<trsObj.length ; i++){
			var trObj = trsObj.eq(i);  var html =  trObj.html();
			//---
			if( html.indexOf(idx)>=0 ){
				var dataCnt = 0;
				trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(){
					var thisObj = $(this);
					if( thisObj.filter(":checkbox,:radio").length>0 ){
						dataCnt = dataCnt + thisObj.filter(":checked").length;
					}
					else{
						dataCnt = dataCnt + thisObj.val().split(" ").join("").length;
					}
				});
				if( dataCnt==0 ){
					alert( "왼쪽 행이 비어있어 새로운 행 추가 금지!" ); return;
				}
				//---
				dataCnt = 0;
				if( trObj.next().length==1 ) {
					trObj.next().find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(){
						var thisObj = $(this);
						if( thisObj.filter(":checkbox,:radio").length>0 ){
							dataCnt = dataCnt + thisObj.filter(":checked").length;
						}
						else{
							dataCnt = dataCnt + thisObj.val().split(" ").join("").length;
						}
					});
					if( dataCnt==0 ){
						alert( "다음 행이 비어있어 새로운 행 추가 금지!" ); return;
					}
				}
				//---
				trObj.after(   "<tr>"+html  ); 
				break;
			}
			//---
		}
		trsObj = tabObj.find("tr:eq(0)").nextAll();
		//-------------------------------------------
		// 모든 각 행이 내포한   [인덱스번호]   를 일련번호로 수정하기
		//-------------------------------------------
		trsObj.each(function(i){
			var trObj = $(this);
			//----------
			var valueVs = [];
			trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(j){
				var thisObj = $(this);
				if( thisObj.filter(":checkbox,:radio").length>0 ){
					valueVs.push( thisObj.prop("checked") );
				}
				else{
					valueVs.push( thisObj.val( ) );
				}
			});
			//----------
			var html = trObj.html();   var str = "";   var no = 0;

			while( true ){
				if( html.indexOf("["+ no +"]")>=0 ){ 
					var arr = html.split("["+ no +"]");  
					trObj.html(   arr.join("["+i+"]")  );
					break; 
				}
				no++;
			}
			/*while( true ){
				if( html.indexOf("["+ no +"]")>=0 ){ 
					str = "["+ no +"]"; 
					break; 
				}
				no++;
			}
			var arr = html.split(str);  
			trObj.html(   arr.join("["+i+"]")  );*/
			//----------
			trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(j){
				var thisObj = $(this);
				if( thisObj.filter(":checkbox,:radio").length>0 ){
					thisObj.prop("checked", valueVs[j] );
				}
				else{
					thisObj.val( valueVs[j] );
				}
			});
		});
		alert( tabObj.html());
	}catch(e) {
		alert( "addTr(  ~, ~ ) 함수 예외발생!" ); 
	}
}














//*********************************************
// 원하는 tr 태그 1개 행을 삭제하는 함수선언
//*********************************************
function delTr( 
	tab_idV    // "행추가내포한table태그id값"
	, idx      // [삭제tr인덱스번호]
){
	try{
		if( idx.indexOf("[")<0 || idx.indexOf("]")<0  ) {
			alert( "delTr(  ~, ~ ) 함수 호출 시 2번째 인자값은 [행인덱스번호]  형식이어야합니다!" ); return;
		}
		var tabObj = $("#"+tab_idV);
		var trsObj = tabObj.find("tr:eq(0)").nextAll();
		if( trsObj.length==1 ) { return ; }
		//-------------------------------------------
		// 행 삭제하기
		//-------------------------------------------
		for( var i=0 ; i<trsObj.length ; i++){
			var trObj = trsObj.eq(i);
			var html =  trObj.html();
			if( html.indexOf(idx)>=0 ){
				var dataCnt = 0;
				trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(){
					var thisObj = $(this);
					if( thisObj.filter(":checkbox,:radio").length>0 ){
						dataCnt = dataCnt + thisObj.filter(":checked").length;
					}
					else{
						dataCnt = dataCnt + thisObj.val().split(" ").join("").length;
					}
				});
				if( dataCnt>0 ){
					if( confirm( "삭제 행에 데이터가 있습니다. 정말 삭제합니까?" )==false ) { return; }
				}
				trObj.remove();  break;
			}
		};
		trsObj = tabObj.find("tr:eq(0)").nextAll();
		//-------------------------------------------
		// 모든 각 행이 내포한   [인덱스번호]   를 일련번호로 수정하기
		//-------------------------------------------
		trsObj.each(function(i){
			var trObj = $(this);
			var valueVs = [];
			trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(j){
				var thisObj = $(this);
				if( thisObj.filter(":checkbox,:radio").length>0 ){
					valueVs.push( thisObj.prop("checked") );
					thisObj.filter(":checked").click();
				}
				else{
					valueVs.push( thisObj.val( ) );
					thisObj.val("");
				}
			});
			//----------
			var html	=  trObj.html();
			var str = "";
			var no = 0;
			while( true ){
				if( html.indexOf("["+ no +"]")>=0 ){ str = "["+ no +"]"; break; }
				no++;
			}
			var arr = html.split(str);  
			trObj.html(   arr.join("["+i+"]")  );
			//----------
			trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(j){
				var thisObj = $(this);
				if( thisObj.filter(":checkbox,:radio").length>0 ){
					thisObj.prop("checked", valueVs[j] );
				}
				else{
					thisObj.val( valueVs[j] );
				}
			});
		});
		//alert( tabObj.html());
	}catch(e) {
		alert( "delTr(  ~, ~ ) 함수 예외발생!" ); 
	}
}




//*********************************************
// 사용자 정의 다중행 tr 태그를 정리하는 함수 선언.
// 각 tr 태그 내부에 데이터가 전혀 없으면 tr 를 삭제하고 모든 tr 내부의 [인덱스번호]  를 일련번호로 세팅한다.
//*********************************************
function setGroupTr(
	tab_idV    // "행추가내포한table태그id값"
){
	try{
		var tabObj = $("#"+tab_idV);
		var trsObj = tabObj.find("tr:eq(0)").nextAll();     //alert(999);
		//-------------------------------------------
		// 비어 있는 행 삭제하기
		//-------------------------------------------
		for( var i=0 ; i<trsObj.length ; i++){
			var trObj = trsObj.eq(i);
			var html =  trObj.html();
			var dataCnt = 0;
			trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(){
				var thisObj = $(this);
				if( thisObj.filter(":checkbox,:radio").length>0 ){
					dataCnt = dataCnt + thisObj.filter(":checked").length;
				}
				else{
					dataCnt = dataCnt + thisObj.val().split(" ").join("").length;
				}
			});
			if( dataCnt==0 ){
				trObj.remove( );
			}
		};
		trsObj = tabObj.find("tr:eq(0)").nextAll(); 
		//-------------------------------------------
		// 모든 각 행이 내포한   [인덱스번호]   를 일련번호로 수정하기
		//-------------------------------------------
		trsObj.each(function(i){
			var trObj = $(this);
			var valueVs = [];
			trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(j){
				var thisObj = $(this);
				if( thisObj.filter(":checkbox,:radio").length>0 ){
					valueVs.push( thisObj.prop("checked") );
					//thisObj.filter(":checked").click();
				}
				else{
					valueVs.push( thisObj.val( ) );
					//thisObj.val("");
				}
			});
			//----------
			var html = trObj.html();   var str = "";   var no = 0;
			while( true ){
				if( html.indexOf("["+ no +"]")>=0 ){ str = "["+ no +"]"; break; }
				no++;
			}
			var arr = html.split(str);  
			trObj.html(   arr.join("["+i+"]")  );
			//----------
			trObj.find("select,input,textarea").not("[type=button],[type=reset],[type=submit]").each(function(j){
				var thisObj = $(this);
				if( thisObj.filter(":checkbox,:radio").length>0 ){
					thisObj.prop("checked", valueVs[j] );
				}
				else{
					thisObj.val( valueVs[j] );
				}
			});
		});
		//alert( tabObj.html());
	}catch(e) {
		alert( "setGroupTr(  ~, ~ ) 함수 예외발생!" ); 
	}
}












/*
//**************************************************************
function setTableTrBgColor5( trObjs,  headTrBgColor, oddTrBgColor, evenTrBgColor, mouseOnBgColor ) {
//**************************************************************
	
	trObjs.eq(0).siblings().first().attr('bgcolor', headTrBgColor );
	
	//trObjs = trObjs.eq(0).nextAll().not(exception_trObjs);
	
	//--------------------------------
	// 홀수행, 짝수행 배경색 지정
	//--------------------------------
	
	trObjs.filter(":odd").attr('bgcolor', evenTrBgColor );
	trObjs.filter(":even").attr('bgcolor', oddTrBgColor );
	//----------------------
	// 이전에 hover 메소드에 의해 걸려있던 mouseenter, mouseleave 이벤트를 제거
	//----------------------
	trObjs.unbind('mouseenter mouseleave');
	//----------------------
	// 마우스를 땔때, 뺄대 배경색 지정하기
	//----------------------
	trObjs.hover(
		function(){   
			$(this).attr( 'bgcolor', mouseOnBgColor );
		}, 
		function(){   
			if( trObjs.index(this)%2==0 ) {
				$(this).attr('bgcolor', oddTrBgColor );
			}else{
				$(this).attr('bgcolor', evenTrBgColor );
			}
		}
	)
}*/
/*
//**************************************************************
function setTableTrBgColor6( 
//**************************************************************
		trObjs
		, headTrBgColor,   oddTrBgColor,    evenTrBgColor,    mouseOnBgColor 
		, headTrFontColor, oddTrFontColor,  evenTrFontColor,  mouseOnFontColor 
) {
	//--------------------------------
	// 헤더가되는 첫번째 tr 태그의 배경색과 글자색을 지정
	//--------------------------------
	trObjs.eq(0).prev().find("th").each(function(){
		var thObj = $(this);
		thObj.attr( 'bgcolor', headTrBgColor  );
		thObj.html(
				"<font color="+headTrFontColor+">"+thObj.text()+"</font>"
		);
	})	
	//--------------------------------
	// 2번째 이후 tr 태그들의 홀수행, 짝수행 배경색 지정
	//--------------------------------	
	trObjs.filter(":odd").attr('bgcolor', evenTrBgColor );
	trObjs.filter(":even").attr('bgcolor', oddTrBgColor );
	
//	trObjs.filter(":odd").each(function(){
//		var odd_trObj = $(this);
//		odd_trObj.attr( 'bgcolor', evenTrBgColor  );
//		odd_trObj.find("td").each(function(){
//			var thObj = $(this);
//			thObj.html(
//					"<font color="+evenTrFontColor+">"+thObj.text()+"</font>"
//			);
//			
//		})	
//	})	
//	trObjs.filter(":even").each(function(){
//		var odd_trObj = $(this);
//		odd_trObj.attr( 'bgcolor', oddTrBgColor  );
//		odd_trObj.find("td").each(function(){
//			var thObj = $(this);
//			thObj.html(
//					"<font color="+oddTrFontColor+">"+thObj.text()+"</font>"
//			);
//		})	
//	})	
	//--------------------------------	
	// 2번째 이후 tr 태그들에 이전에 hover 메소드에 의해 걸려있던 mouseenter, mouseleave 이벤트를 제거
	//--------------------------------	
	trObjs.unbind('mouseenter mouseleave');
	//--------------------------------	
	// 2번째 이후 tr 태그들에 마우스를 댈때, 뺄대 배경색 지정하기
	//--------------------------------	
	trObjs.hover(
		function(){   
			$(this).attr( 'bgcolor', mouseOnBgColor );
		}, 
		function(){   
			if( trObjs.index(this)%2==0 ) {
				$(this).attr('bgcolor', oddTrBgColor );
			}else{
				$(this).attr('bgcolor', evenTrBgColor );
			}
		}
	)
}*/

/*
//**************************************************************
function setTableTrBgColor7( 
//**************************************************************
		trObjs
		, oddTrBgColor,    evenTrBgColor,    mouseOnBgColor 
		, oddTrFontColor,  evenTrFontColor,  mouseOnFontColor 
) {
	
	var odd_trObj = trObjs.filter(":even");
	var even_trObj = trObjs.filter(":odd");
	//--------------------------------
	// 2번째 이후 tr 태그들의 홀수행, 짝수행 배경색 지정
	//--------------------------------	
	odd_trObj.attr('bgcolor', oddTrBgColor );
	even_trObj.filter(":even").attr('bgcolor', evenTrBgColor );
	
	odd_trObj.find("td").each(function(){
			var thObj = $(this);
			thObj.html(
					"<font color="+oddTrFontColor+">"+thObj.text()+"</font>"
			);	
			alert( thObj.html() )
	})	
	
	return;
	even_trObj.find("td").each(function(){
			var thObj = $(this);
			thObj.html(
					"<font color="+evenTrFontColor+">"+thObj.text()+"</font>"
			);
	})
	//--------------------------------	
	// 2번째 이후 tr 태그들에 이전에 hover 메소드에 의해 걸려있던 mouseenter, mouseleave 이벤트를 제거
	//--------------------------------	
	trObjs.unbind('mouseenter mouseleave');
	//--------------------------------	
	// 2번째 이후 tr 태그들에 마우스를 댈때, 뺄대 배경색 지정하기
	//--------------------------------	
	trObjs.hover(
		function(){   
			var trObj = $(this);
			trObj.attr( 'bgcolor', mouseOnBgColor );
			trObj.find("td").each(function(){
				var thObj = $(this);
				thObj.html(
						"<font color="+mouseOnFontColor+">"+thObj.text()+"</font>"
				);					
			})	
		}, 
		function(){   
			var trObj = $(this);
			if( trObjs.index(this)%2==0 ) {
				trObj.attr('bgcolor', oddTrBgColor );
				trObj.find("td").each(function(){
					var thObj = $(this);
					thObj.html(
							"<font color="+oddTrFontColor+">"+thObj.text()+"</font>"
					);					
				})	
			}else{
				trObj.attr('bgcolor', evenTrBgColor );
				trObj.find("td").each(function(){
					var thObj = $(this);
					thObj.html(
							"<font color="+evenTrFontColor+">"+thObj.text()+"</font>"
					);					
				});
			}
		}
	)
}*/











//**************************************************************
// class=xxx 가진 영력을 보였다 안보였다 반복하기
//**************************************************************
function showHideLoop( classN, second ){
	$("."+classN).fadeOut(second, function(){ $("."+classN).fadeIn(); showHideLoop( classN ); } );
}


//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// 메뉴바 출력 함수 선언
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
function print_single_menubar(  
	menunbarBgColor 
	,mouseoverBgColor
	,mouseoverFontColor
	,mouseoutBgColor
	,mouseoutFontColor
	,menubarArr
){
	var menubars = [];
	try{
		
		//-------------------------------------	
		// 메뉴바 출력하기
		//-------------------------------------	
		/* menubars.push("<style>");
		menubars.push(".tbcss0, .tbcss0 td, .tbcss0 th{ ");
		menubars.push("	border-collapse: collapse; ");
		menubars.push("	border:0px solid gray;");
		menubars.push("	font-size: 9pt;
		menubars.push("	font-family: tahoma,굴림,돋움,verdana; ");
		menubars.push(" }");
		menubars.push("</style>"); */
		
		menubars.push("<table border=0 width='100%' bgcolor='"+menunbarBgColor+"' cellpadding=0 cellspacing=0><tr><td>");
		//---
		menubars.push("<table border=0 class='menubar' bgcolor='"+mouseoutBgColor+"' align='center' cellpadding=3");
		menubars.push("<tr>");		
		for( var i=0 ; i<menubarArr.length; i++ ){
			menubars.push("<th style='cursor:pointer;' onclick=\"location.href='"+menubarArr[i][0]+"';\">");
			menubars.push(   "&nbsp;&nbsp;&nbsp;"+menubarArr[i][1]+"&nbsp;&nbsp;&nbsp;");
		}
		menubars.push("</table></table>");	
		//-------------------------------------	
		// 메뉴바 html 소스 출력 얻기
		//-------------------------------------	
		$("body").prepend( menubars.join("") );		
		//-------------------------------------	
		// 현재 화면의 URL을 가진 메뉴바의 인덱스 번호 얻기
		//-------------------------------------	
		var nowPageURL = location.href;
		var choicedMenunarIdx = 0;
		//---
		for( var i=0 ; i<menubarArr.length ; i++ ){
			if( nowPageURL.lastIndexOf(menubarArr[i][0])>=0 ){
				choicedMenunarIdx = i; break;
			}
		}
		//-------------------------------------	
		// 메뉴바에 [마우스 오버], [마우스 아웃] 시 실행할 코딩 설정하기
		//-------------------------------------	
		var menubarThObjs = $(".menubar th");
		menubarThObjs.hover(
			function(){
				var thisObj = $(this);
				// [마우스 오버] 한 메뉴바의 배경색 지정
			    thisObj.css("background-color",mouseoverBgColor);
				// [마우스 오버] 한 메뉴바의 글자색 지정
				thisObj.html( "<font color="+mouseoverFontColor+"><b>" + thisObj.text() +"</b></font>" );
				// [마우스 오버] 한 메뉴바 형제 메뉴바의 배경색, 글자색 지정                                               
				thisObj.siblings().each(function(){
					$(this).css("background-color",mouseoutBgColor); 
					$(this).html( "<font color="+mouseoutFontColor+"><b>" + $(this).text() +"</b></font>" );
				});
			}
			,function(){	
				var thisObj = $(this);
				// [마우스 아웃] 한 메뉴바의 배경색 지정
				thisObj.css("background-color",mouseoutBgColor); 
				// [마우스 아웃] 한 메뉴바의 글자색 지정
				thisObj.html( "<font color="+mouseoutFontColor+"><b>" + thisObj.text() +"</b></font>" );
				// 선택된 메뉴바를 코딩으로 [마우스 오버]하기
				menubarThObjs.eq( choicedMenunarIdx ).mouseover();
			}
		);	
		//-------------------------------------	
		// 현재 화면의 URL을 가진 메뉴바를 코딩으로 [마우스 오버] 하기
		//-------------------------------------	
		menubarThObjs.eq( choicedMenunarIdx ).mouseover();
	}catch(e){
		alert( "printMenubar(~) 호출 시 예외 발생!" )
	}
}

/*

//**************************************************************
//검색화면에서 검색 결과물의 페이징 번호 출력 소스 리턴
//**************************************************************
function openClass(){
	$(".xxx").html(
		"<div "+
		"id='glass' onclick='alert('[입력 화면] 또는 [수정/삭제 화면]을 닫아야 [검색 화면]을 클릭할수 있습니다.')'"
		+"style='z-index:1;position:absolute;left:0;top:0;display:none;"
		+"filter:Alpha(Opacity='30');opacity:0.3;width:100%;height:100%;background-color:gray'>"
		+"</div>"
	);
	$(".glass").show();
	
}
//**************************************************************
function setTableTrBgColor( tableClassV, oddBgColor, evenBgColor, mouceOnBgColor ) {
//**************************************************************
	// id="staff" 가 있는 태그 후손의 <thead>안의 후손의 tr 요소들에 지정한 css 적용
	$("."+tableClassV+" thead tr").css('background', '#8A8AFF');
	// id="staff" 가 있는 태그 후손의 <tbody>안의 후손의 tr 중 [인덱스번호]가 
	//[홀수번째] tr 요소들에 지정한 css 적용
	$("."+tableClassV+" tbody tr:odd").css('background', '#AAAAAA');
	// id="staff" 가 있는 태그 후손의 <tbody>태그 후손의 tr 중 [인덱스번호]가 
	//[짝수번째] tr 요소들에 지정한 css 적용
	$("."+tableClassV+" tbody tr:even").css('background', '#FFFFFF');

	//$(선택자).hover( function (){코드1}, function (){코드2} ) 
	// => 선택자에 마우스 대면 코드1 실행, 띠면 코드2 실행.
	//-----------------------------------------------------
	// id="staff" 가 있는 태그 후손의 <tbody>태그 후손의 각 tr 에 마우스 대면
	// 설정한 배경색으로 바꾸고 띠면 원래로 돌아가도록 설정
	//-----------------------------------------------------
	$("."+tableClassV).find("tbody").find("tr").hover(
		//$("."+tableClassV+" tbody tr").hover(
		function(){   
			// 마우스를 갖다댄 tr 태그 후손의 td 태그에 class="style1" 삽입함.
			// class="style1" 삽입함으로서 <style> 태그에 설정한 CSS 가 적용됨.
			// this 는 마우스를 갖다댄 tr 태그
			$(this).find("td").addClass('style1'); 
		}, 
		function(){   
			//마우스를 뺀 tr 태그 안에 td 태그에 class="style1" 제거
			$(this).find("td").removeClass('style1');   
		}
	);  
	// id="staff" 가 있는 태그 후손의 <tbody>태그 후손의 각 tr 에 마우스 대면
	// 설정한 배경색으로 바꾸고 띠면 원래로 돌아가도록 설정
	$("."+tableClassV+" thead th").hover(
		function( ){  
			// 마우스가 올라간 th 태그의 형제 요소 중 순서번호 저장 
			var no=$(this).index()+1;          
				//var no=$(this).parent( ).children( ).index(this)+1;  도 가능                      
			// tbody 내부의 td 중에 각 td 가 속한 부모 태그의 no 번째 자식 td 태그를 골라
			// class=style1 를 삽입
			$("."+tableClassV+" tbody td:nth-child('+no+')").addClass('style1');
			//$("."+tableClassV+" tbody td:eq('+no+')").addClass('style1');
		}, 
		function( ){   
			// 마우스를 때면 class="style1"  속성을 제거
			$("."+tableClassV+" tbody tr").children( ).removeClass('style1');
			//$("."+tableClassV+" tbody td").removeClass('style1'); 도 가능
		}
	);  
}
*/


/*

//**************************************************************
//년,월,일 을 3개의 select 박스로 출력하고 이벤트 걸어주는 함수 선언
//**************************************************************
function printYMD( tagNs, minYear, maxYear ){
	try{
		if( tagNs.length!=3 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 매개변수에는 배열변수가 3개인 배열이 들어와야 함다..")
			return;
		}
		if( maxYear=="올해" ) maxYear=new Date().getFullYear();
		if( maxYear=="내년" ) maxYear=new Date().getFullYear()+1;
		if( minYear=="올해" ) minYear=new Date().getFullYear();
		if( minYear=="내년" ) minYear=new Date().getFullYear()+1;
		//---------------------------------------
		var yearN = tagNs[0]; var monthN = tagNs[1]; var dayN = tagNs[2];
		//--------------------------------------
		if( $("[name='"+yearN+"']").length>1  ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 배열변수 안의 "+yearN+" 라는 select 입력 양식 이름이 중복 되었음니다..")
			return;
		}
		if( $("[name='"+monthN+"']").length>1 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 배열변수 안의 "+monthN+" 라는 select 입력 양식 이름이 중복 되었음니다..")
			return;
		}
		if( $("[name='"+dayN+"']").length>1 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 배열변수 안의 "+dayN+" 라는 select 입력 양식 이름이 중복 되었음니다..")
			return;
		}
		//---------------------------------------
		var arr = [];
		//---------------------------------------
		arr.push( "<select name="+yearN+">" );
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		arr.push( "<select name="+monthN+">" );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );
		//---------------------------------------
		arr.push( "<select name="+dayN+">" );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=31 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>일 " );
		//---------------------------------------
		document.write( arr.join("") );
		//---------------------------------------
		var yearObj=$("[name='"+yearN+"']");  var monthObj=$("[name='"+monthN+"']");  var dayObj=$("[name='"+dayN+"']");	
		//---------------------------------------
		$(document).on( 
				"change"
				, "[name='"+yearN+"],[name='"+monthN+"],[name='"+dayN+"']"
				, function( ){ 
					//alert(11111);
					var yearV = yearObj.val();  var monthV = monthObj.val();  var dayV = dayObj.val();      
					//------------------------
					var tmp = "";
					if(yearV!="")  {tmp=tmp+"1";} else{tmp=tmp+"0"}
					if(monthV!="") {tmp=tmp+"1";} else{tmp=tmp+"0"}
					if(dayV!="")   {tmp=tmp+"1";} else{tmp=tmp+"0"} 
					//------------------------
					if( tmp=="100"  ){
						monthObj.val("01"); dayObj.val("01");
					}
					//------------------------
					if( tmp=="001" || tmp=="010" || tmp=="011" ){
						monthObj.val(""); dayObj.val(""); alert("년도가 비어 월,일을 비움다");  return;
					}
					if( tmp=="101" ){
						dayObj.val(""); alert("월이 비어 일을 비움다");  return;
					}
					//---------------------------------------
					if( tmp=="111" || tmp=="110" ){
						var lastDay = new Date( parseInt(yearV,10), parseInt(monthV,10), 0 ).getDate();
						//alert( yearV +"/"+ monthV+"/"+ lastDay );
						dayObj.empty();
						dayObj.append( "<option value=''>" );
						for( var i=1 ; i<=lastDay ; i++ ){
							if(i<10) dayObj.append( "<option value=0"+ i +">0" + i );
							else     dayObj.append( "<option value="+ i +">" + i );
						}
						dayObj.val(dayV);
					}
				} 
		);
	}catch(e){
		alert("printYMD(~,~,~) 함수 호출 시 에러 발생!");
	}
}

//**************************************************************
//년,월,일 을 3개의 select 박스로 출력하고 이벤트 걸어주는 함수 선언
//**************************************************************
function printYMD_rng( tagNs1, tagNs2, minYear, maxYear ){
	try{
		var name1 =  tagNs1.join("");
		var name2 =  tagNs2.join("");
		var name3 =  name1 + name2;
		printYMD( tagNs1, minYear, maxYear );
		document.write( " <span style='cursor:pointer' class='to_today_"+ name1 +"'>[오늘로]</span> " );
		document.write( " <span style='cursor:pointer' class='empty_" + name1 + "'>[비움]</span> " );
		document.write( " ~ " );
		printYMD( tagNs2, minYear, maxYear );
		document.write( " <span style='cursor:pointer' class='to_today_"+ name2 +"'>[오늘로]</span> " );
		document.write( " <span style='cursor:pointer' class='empty_" + name2 + "'>[비움]</span> " );
		
		//document.write( " <span style='cursor:pointer' class='to_today_"+ name3 +"'>[오늘로]</span> " );
		document.write( " <span style='cursor:pointer' class='empty_" + name3 + "'>&lt모두비움&gt</span> " );
		//---------------------------------------
		$(document).on( 
				"click"
				, ".to_today_"+name1
				, function( ){ 
					var d = new Date();
					$("[name='"+tagNs1[0]+"']" ).val( d.getFullYear() ); 
					$("[name='"+tagNs1[1]+"']" ).val( (d.getMonth()-1<10?'0':'') + d.getMonth() ); 
					$("[name='"+tagNs1[2]+"']" ).val( (d.getDate()<10?'0':'') + d.getDate() ); 
					$("[name='"+tagNs1[0]+"']" ).change();
				} 
		);
		$(document).on( 
				"click"
				, ".empty_"+name1
				, function( ){ 
					$("[name='"+tagNs1[0]+"']" ).val(""); $("[name='"+tagNs1[1]+"']" ).val(""); $("[name='"+tagNs1[2]+"']" ).val("");
				} 
		);
		//---------------------------------------
		$(document).on( 
				"click"
				, ".to_today_"+name2
				, function( ){ 
					var d = new Date();
					$("[name='"+tagNs2[0]+"']" ).val( d.getFullYear() ); 
					$("[name='"+tagNs2[1]+"']" ).val( (d.getMonth()-1<10?'0':'') + d.getMonth() ); 
					$("[name='"+tagNs2[2]+"']" ).val( (d.getDate()<10?'0':'') + d.getDate() ); 
					$("[name='"+tagNs2[0]+"']" ).change();
				} 
		);
		$(document).on( 
				"click"
				, ".empty_"+name2
				, function( ){ 
					$("[name='"+tagNs2[0]+"']" ).val(""); $("[name='"+tagNs2[1]+"']" ).val(""); $("[name='"+tagNs2[2]+"']" ).val("");
				} 
		);
		//---------------------------------------
		$(document).on( 
				"click"
				, ".empty_"+name3
				, function( ){ 
					$("[name='"+tagNs1[0]+"']" ).val(""); $("[name='"+tagNs1[1]+"']" ).val(""); $("[name='"+tagNs1[2]+"']" ).val("");
					$("[name='"+tagNs2[0]+"']" ).val(""); $("[name='"+tagNs2[1]+"']" ).val(""); $("[name='"+tagNs2[2]+"']" ).val("");
				} 
		);
		//---------------------------------------
		//---------------------------------------
		$(document).on( 
				"change"
				, "[name='"+tagNs1[0]+"],[name='"+tagNs1[2]+"],[name='"+tagNs1[2]+"],"
				    +"[name='"+tagNs2[0]+"],[name='"+tagNs2[2]+"],[name='"+tagNs2[2]+"']"
				, function( ){ 
					//alert(2);
					var year1 = $("[name='"+tagNs1[0]+"']" );
					var month1 = $("[name='"+tagNs1[1]+"']" );
					var day1 = $("[name='"+tagNs1[2]+"']" );
					var year2 = $("[name='"+tagNs2[0]+"']" );
					var month2 = $("[name='"+tagNs2[1]+"']" );
					var day2 = $("[name='"+tagNs2[2]+"']" );
					
					var str1 = "1" + year1.val( ) + month1.val( ) + day1.val( );
					var str2 = "1" + year2.val( ) + month2.val( ) + day2.val( );
					
					if( year1.val( )!="" && month1.val( )!="" && day1.val( )!=""
						&& year2.val( )!="" && month2.val( )!="" && day2.val( )!=""
					) {
							if( parseInt(str1,10)>parseInt(str2,10) ) {
								year1.val(''); month1.val(''); day1.val('');
								year2.val(''); month2.val(''); day2.val('');
								alert("미니멈 년.월.일 이 멕시멈 년.월.일 보다 커서 모두 비움니다.")
							}
					}
					
				} 
		);
	}catch(e){
		alert("printYMD_rng(~,~,~,~) 함수 호출 시 에러 발생!");
	}
}


//**************************************************************
//동일한 폼태그 내부에 같은 이름의 입력양식 개수리턴
//**************************************************************
function getTagNCnt( tagN ){
	var obj = $("[name='"+tagN+"']");
	while(true){
		if( obj.parent()[0].nodeName=="form"|| obj.parent()[0].nodeName=="FORM" ) {
			if( obj.parent().find( "[name='"+yearN+"']" ).length>1 ){
				alert("동일한 폼 태그 내부에 같은 이름의 입력 양식이 2개 이사 존재합니다.수정 요망");
			}
		}
	}
}



//**************************************************************
//년,월,일 을 3개의 select 박스로 출력하고 이벤트 걸어주는 함수 선언
//**************************************************************
function printYM( tagNs, minYear, maxYear ){
	try{
		if( tagNs.length!=2 ) {
			alert( "<개발자 경고>printYM(~) 함수 호출 시 매개변수에는 배열변수가 2개인 배열이 들어와야 함다..")
			return;
		}
		if( maxYear=="올해" ) maxYear=new Date().getFullYear();
		if( maxYear=="내년" ) maxYear=new Date().getFullYear()+1;
		if( minYear=="올해" ) minYear=new Date().getFullYear();
		if( minYear=="내년" ) minYear=new Date().getFullYear()+1;
		//---------------------------------------
		var yearN = tagNs[0]; var monthN = tagNs[1];
		//---------------------------------------
		if( $("[name='"+yearN+"']").length>1  ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 배열변수 안의 "+yearN+" 라는 select 입력 양식 이름이 중복 되었음니다..")
			return;
		}
		if( $("[name='"+monthN+"']").length>1 ) {
			alert( "<개발자 경고>printYMD(~) 함수 호출 시 배열변수 안의 "+monthN+" 라는 select 입력 양식 이름이 중복 되었음니다..")
			return;
		}
		//---------------------------------------
		var arr = [];
		//---------------------------------------
		arr.push( "<select name="+yearN+">" );
		arr.push( "<option value=''>" );
		if( minYear<=maxYear  ){
			for( var i=minYear ; i<=maxYear ; i++ ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		else{
			for( var i=minYear ; i>=maxYear ; i-- ){
				arr.push( "<option value="+ i +">" + i );
			}
		}
		arr.push( "</select>년 " );
		//---------------------------------------
		arr.push( "<select name="+monthN+">" );
		arr.push( "<option value=''>" );
		for( var i=1 ; i<=12 ; i++ ){
			if(i<10) arr.push( "<option value=0"+ i +">0" + i );
			else     arr.push( "<option value="+ i +">" + i );
		}
		arr.push( "</select>월 " );
		//---------------------------------------
		document.write( arr.join("") );
		//---------------------------------------
		var yearObj=$("[name='"+yearN+"']");  var monthObj=$("[name='"+monthN+"']");  
		//---------------------------------------
		$(document).on( 
				"change"
				, "[name='"+yearN+"],[name='"+monthN+"']"
				, function( ){ 
					var yearV = yearObj.val();  var monthV = monthObj.val();  
					//------------------------
					if( yearV=="" && monthV!="" ){
						monthObj.val("");alert("년도가 비어 월을 비움다");  return;
					}
				} 
		);
	}catch(e){
		alert("printYM(~,~,~) 함수 호출 시 에러 발생!");
	}
}

*/










//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
/*function print_info_oracle_table2(  ){
	try{
		//-----------------------------------------------------
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
		var blank2 = blank1 + blank1; var blank3 = blank2 + blank1; var blank4 = blank2 + blank2; var blank5 = blank3 + blank2;
		var src = [];
		//-----------------------------------------------------
		var formObj = $("body form");
		formObj.each(function(){
				var obj = $(this).find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
				var nameVs = [];  var nodeVs = [];  var typeVs = [];  var cntVs = [];  var banks = [];
				//-----------------------------------------------------
				obj.each(function(i){
					var thisObj = $(this);
					var nameV = thisObj.attr("name") ;
					var nodeV = thisObj[0].nodeName.toLowerCase();
					var typeV = thisObj.attr("type");
					if( (":"+banks.join(":")).indexOf(":"+nameV)>=0  ){  return;  }
					nameVs.push(  nameV  );  nodeVs.push(  nodeV  );  typeVs.push(  typeV  );  banks.push( nameV );
					cntVs.push(  $("body").find("[name='"+nameV+"']").length  );
				});		
				//-----------------------------------------------------
				src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>테이블 생성 SQL<tr><td>")
				for( var i = 0 ; i<nameVs.length ; i++ ){
					//-----------------
					if( (typeVs[i]=="radio" || typeVs[i]=="radio") && cntVs[i]==1 )  { continue; }
					if(  nodeVs[i]=="select" && (nameVs[i].indexOf("_year")>=0 || nameVs[i].indexOf("_month")>=0 || nameVs[i].indexOf("_day")>=0)    ) { continue; }
					if(  nodeVs[i]!="select" && cntVs[i]==1    ) { continue; }
					//-----------------
					src.push( "create table code_"+nameVs[i]+"(")
					src.push( blank1 + nameVs[i]+"_code"+blank1 +"number(5)")
					src.push( blank1 + ", " +nameVs[i]+"_name"+blank1 + "varchar(50)")
					src.push( blank1 + ", primary key( " + nameVs[i] + "_code )");
					src.push( ");")
					//-----------------
					if( nodeVs[i]=="select" ) {
						var no = 1;
						$("body").find("[name='"+nameVs[i]+"']").find("option").each(function(){
							var value = $(this).attr("value"); if(value=="")  {return;}
							src.push( "insert into code_" + nameVs[i] + " values ( " + (no++) + ", '" + value+ "' );")
						})
					}
					//-----------------
					if( typeVs[i]=="checkbox" || typeVs[i]=="radio") {
						var no = 1;
						$("body").find("[name='"+nameVs[i]+"']").each(function(){
							var value = $(this).attr("value"); if(value=="")  {return;}
							src.push( "insert into code_" + nameVs[i] + " values ( " + (no++) + ", '" + value+ "' );")
						})
					}
					src.push( "-----------------------------------------------------------------")
				}
				//-----------------------------------------------------
				src.push("create table xxx(")
				src.push( blank2 + "xxx_no number(9)")
				//-----------------------------------------------------
				for( var i = 0 ; i<nameVs.length ; i++ ){
					var nameV2 = nameVs[i];
					//-----------------
					if( typeVs[i]=="checkbox" && cntVs[i]>1    ) {  continue }
					if( typeVs[i]=="radio" && cntVs[i]>1 ) { 
						nameV2 = nameV2 + "_code"
					}
					if( nodeVs[i]=="select" && (nameV2.indexOf("_year")<0 && nameV2.indexOf("_month")<0 && nameV2.indexOf("_day")<=0)   ) { 
						nameV2 = nameV2 + "_code"
					}
					//-----------------
					if( nameV2.indexOf("_no")>=0 || nameV2.indexOf("_num")>=0 || nameV2.indexOf("_year")>=0 
						|| nameV2.indexOf("_month")>=0 || nameV2.indexOf("_day")>=0 || nameV2.indexOf("_code")>=0 
					) {
						src.push( blank2 + ", " + nameV2 + blank1 + blank1 + "number(5) ");
					}
					else {
						src.push( blank2 + ", " + nameV2 + blank1 + blank1 + "varchar(50) ");
					}
				}
				//-----------------------------------------------------
				src.push( ");");
				src.push( "</table>");
		});
		//-----------------------------------------------------
		$("body").append(  src.join("<br>")  + "<br>");
		//-----------------------------------------------------
	}catch(e){
		alert("print_src1( ) 함수 호출 시 에러 발생!");  
	}
}

//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
function print_info_oracle_table2(  ){
	try{
		//-----------------------------------------------------
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
		var blank2 = blank1 + blank1; var blank3 = blank2 + blank1; var blank4 = blank2 + blank2; var blank5 = blank3 + blank2;
		var src = [];
		var data1 = "";
		//-----------------------------------------------------
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var nameVs = [];  var nodeVs = [];  var typeVs = [];  var cntVs = [];  
		var banks = [];
		//-----------------------------------------------------
		obj.each(function(i){
			var thisObj = $(this);
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");
			if( (":"+banks.join(":")).indexOf(":"+nameV)>=0  ){  return;  }
			nameVs.push(  nameV  );  nodeVs.push(  nodeV  );  typeVs.push(  typeV  );  banks.push( nameV );
			cntVs.push(  $("body").find("[name='"+nameV+"']").length  );
		});		
		src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>테이블 생성 SQL<tr><td>")



		//-----------------------------------------------------
		// code 테이블 소스 생성
		//-----------------------------------------------------
		banks = [];
		src.push("//--------------------------------");
		src.push("// code 테이블 소스 생성");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			//-----------------
			if( (typeVs[i]=="radio" || typeVs[i]=="checkbox") && cntVs[i]==1 )  { continue; }
			if(  nodeVs[i]=="select" && (nameVs[i].indexOf("_year")>=0 || nameVs[i].indexOf("_month")>=0 || nameVs[i].indexOf("_day")>=0)    ) { continue; }
			if(  nodeVs[i]!="select" && cntVs[i]==1    ) { continue; }
			//-----------------
			var nameV = nameVs[i];
			//-----------------
			if( nameVs[i].indexOf("[")>=0 ) {
				nameV = nameVs[i].substring(  nameVs[i].indexOf("]")+2 );
			}
			//-----------------
			if( (":"+banks.join(":")).indexOf(":"+nameV)>=0  ){  continue;;  }		banks.push( nameV );
			//-----------------
			src.push( "create table code_"+nameV+"(")
			src.push( blank1 + nameV+"_code"+blank1 +"number(5)")
			src.push( blank1 + ", " +nameV+"_name"+blank1 + "varchar(50)")
			src.push( blank1 + ", primary key( " + nameV + "_code )");
			src.push( ");")
			//-----------------
			if( nodeVs[i]=="select" ) {
				var no = 1;
				$("body").find("[name='"+nameVs[i]+"']").find("option").each(function(){
					var value = $(this).attr("value"); if(value=="")  {return;}
					src.push( "insert into code_" + nameV + " values ( " + (no++) + ", '" + value+ "' );")
				})
			}
			//-----------------
			if( typeVs[i]=="checkbox" || typeVs[i]=="radio") {
				var no = 1;
				$("body").find("[name='"+nameVs[i]+"']").each(function(){
					var value = $(this).attr("value"); if(value=="")  {return;}
					src.push( "insert into code_" + nameV + " values ( " + (no++) + ", '" + value+ "' );")
				})
			}
			src.push("//--------------------------------");
			
		}





		//-----------------------------------------------------
		// 메인 테이블 소스 생성
		//-----------------------------------------------------
		src.push("//--------------------------------");
		src.push("// 메인 테이블 생성 소스");
		src.push("//--------------------------------");
		src.push("create table xxx(")
		src.push( blank2 + "xxx_no number(9)")
		for( var i = 0 ; i<nameVs.length ; i++ ){
			var nameV2 = nameVs[i];
			//-----------------
			if( typeVs[i]=="checkbox" && cntVs[i]>1    ) {  continue }
			if( nameV2.indexOf("[")>=0    )              {  continue }
			if( typeVs[i]=="radio" && cntVs[i]>1 ) { 
				nameV2 = nameV2 + "_code"
			}
			if( nodeVs[i]=="select" && (nameV2.indexOf("_year")<0 && nameV2.indexOf("_month")<0 && nameV2.indexOf("_day")<0)   ) { 
				nameV2 = nameV2 + "_code"
			}
			//-----------------
			if( nameV2.indexOf("_no")>=0 || nameV2.indexOf("_num")>=0 || nameV2.indexOf("_year")>=0 
				|| nameV2.indexOf("_month")>=0 || nameV2.indexOf("_day")>=0 || nameV2.indexOf("_code")>=0 
			) {
				src.push( blank2 + ", " + nameV2 + blank1 + blank1 + "number(5) ");
			}
			else {
				src.push( blank2 + ", " + nameV2 + blank1 + blank1 + "varchar(50) ");
			}
		}
		src.push( blank2 +  "-----------------");
		src.push( blank2 +  ", primary key( xxx_no )");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			var nameV2 = nameVs[i];
			//-----------------
			if( typeVs[i]=="checkbox" && cntVs[i]>1    ) {  continue }
			if( nameV2.indexOf("[")>=0    )              {  continue }
			if( (typeVs[i]=="radio" && cntVs[i]>1)
				||  (
						nodeVs[i]=="select" && (nameV2.indexOf("_year")<0 && nameV2.indexOf("_month")<0 && nameV2.indexOf("_day")<0)
					)
			) { 
				src.push( blank2 + ", foreign key " + nameV2 +"_code references code_" + nameV2 + "("+nameV2+"_code)");
			}
		}
		src.push( ");");
		//-----------------------------------------------------
		// n행 저장 테이블 소스 생성
		//-----------------------------------------------------
		banks = [];
		var banks2 = [];
		var cnt1 = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( nameVs[i].indexOf("[")>=0 && nameVs[i].indexOf("[")>=0 ){
				var nameV2 = nameVs[i].substring( 0, nameVs[i].indexOf("[") );
				//var nameV3 = nameVs[i].substring(  nameVs[i].indexOf("]")+1 );
				if( (":"+banks.join(":")).indexOf(":"+nameV2)>=0  ){  continue;;  }  
				//-----------------
				src.push("//--------------------------------");
				src.push("// n행 저장 테이블 생성 소스");
				src.push("//--------------------------------");
				src.push("create tabe "+ nameV2 + "("); 
				src.push(blank3 + "xxx_no"+blank1+"number(5)"); 
				//-----------------
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if( nameVs[j].indexOf(nameV2+"[")==0 ){
						var nameV4 = nameVs[j].substring(  nameVs[j].indexOf("]")+2 );
						if( 
							(typeVs[j]=="radio"&& cntVs[i]>1 )
							||(nodeVs[j]=="select" 
								&& (nameV4.indexOf("_year")<0 && nameV4.indexOf("_month")<0 && nameV4.indexOf("_day")<0 && nameV4.indexOf("salary")<0 && nameV4.indexOf("num")<0))
						){
							data1 = blank3 + ", " + nameV4+"_code"+blank1 + " number(5)" +blank1+"// " + typeVs[j] + " 양식";
							if( is_duple_of_arr( src, data1 )==false ) {
								src.push( data1 );
							}
						}else{
							data1 = blank3 + ", " + nameV4+blank1 + " varchar(50)" +blank1+"// " + typeVs[j] + " 양식";
							if( is_duple_of_arr( src, data1 )==false ) {
								src.push( data1 );
							}
						}
					}
				}
				src.push( blank3 + "-------------------------");
				src.push( blank3 + ", foreign key xxx_no references xxx(xxx_no)");
				//-----------------
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if( nameVs[j].indexOf(nameV2+"[")==0 ){
						var nameV4 = nameVs[j].substring(  nameVs[j].indexOf("]")+2 );
						if( 
							(typeVs[j]=="radio"&& cntVs[i]>1 )
							||(nodeVs[j]=="select" 
								&& (nameV4.indexOf("_year")<0 && nameV4.indexOf("_month")<0 && nameV4.indexOf("_day")<0 && nameV4.indexOf("salary")<0 && nameV4.indexOf("num")<0))
						){
							data1 = blank3 + ", foreign key " + nameV4 +"_code references code_" + nameV4 + "("+nameV4+"_code)";
							if( is_duple_of_arr( src, data1 )==false ) {
								src.push( data1 );
							}
						}
					}
				}
				banks.push( nameV2 );
				src.push(")");
			}
		}

		//-----------------------------------------------------
		// 서브 테이블 소스 생성
		//-----------------------------------------------------
		src.push("//--------------------------------");
		src.push("// checkbox 관련 테이블 생성 소스");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( typeVs[i]=="checkbox" && cntVs[i]>1 &&  nameVs[i].indexOf("[")<0  ) { 
				src.push("create table xxx_"+nameVs[i]+"(")
				src.push( blank2 + "xxx_no" + blank2 + "number(5)");
				src.push( blank2 + ", " + nameVs[i] + "_code" + blank2 + "number(5)");
				src.push( blank2 +  "-----------------");
				src.push( blank2 + ", foreign key xxx_no references xxx(xxx_no)");
				src.push( blank2 + ", foreign key "+nameVs[i]+"_code references code_"+nameVs[i]+"("+nameVs[i]+"_code)");
				src.push(");")
			}
		}
		//-----------------------------------------------------
		// 소스 출력
		//-----------------------------------------------------
		src.push( "</table>");
		$("body").append(  src.join("<br>")  + "<br>");
	}catch(e){
		alert("print_info_oracle_table( ) 함수 호출 시 에러 발생!");  
	}
}






//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
function print_info_oracle_table(  ){
	try{
		//-----------------------------------------------------
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
		var blank2 = blank1 + blank1; var blank3 = blank2 + blank1; var blank4 = blank2 + blank2; var blank5 = blank3 + blank2;
		var src = [];
		var data1 = "";
		//-----------------------------------------------------
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var nameVs = [];  var nodeVs = [];  var typeVs = [];  var colVs = [];  var colDataTypeVs = [];  var is_code_colVs = [];  var cntVs = [];  
		var banks = [];
		//-----------------------------------------------------
		// 입력 양식 관련 여러 데이터를 여러 배열에 저장하기
		//-----------------------------------------------------
		obj.each(function(i){
			var thisObj = $(this);
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");
			var cntV = $("body").find("[name='"+nameV+"']").length;
			var colV = nameV;
				if( nameV.indexOf("[")>=0 ) { colV = nameV.substr(  nameV.indexOf("]")+2 ); }
			var is_code_colV = false;
				if( typeV=="radio" && cntV>1 
						|| nodeV=="select" && nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0   && nameV.indexOf("salary")<0  ) { 
					colV = colV + "_code"; is_code_colV = true;
				}
			var colDataTypeV = "varchar(50)";
				if( 
					nameV.indexOf("_no")>=0 
					|| ( (typeV=="checkbox" || typeV=="radio") && cntV>1 )
					|| ( nodeV=="select" && nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0   ) 
				){ 
					colDataTypeV = "number(5)";
				}
			//----------------
			if( (":"+banks.join(":")).indexOf(":"+nameV)>=0  ){  return;  }
			//----------------
			nameVs.push(  nameV  );  nodeVs.push(  nodeV  );                 typeVs.push(  typeV  ); 
			colVs.push(  colV  );    colDataTypeVs.push(  colDataTypeV  );   is_code_colVs.push(  is_code_colV  );   cntVs.push( cntV  );
			banks.push( nameV );
		});		

		src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>테이블 생성 SQL<tr><td>")
		
		//-----------------------------------------------------
		// code 테이블 소스 생성
		//-----------------------------------------------------
		banks = [];
		src.push("//--------------------------------");
		src.push("// code 테이블 소스 생성");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			//-----------------
			if(  nodeVs[i]=="select" && (nameVs[i].indexOf("_year")>=0 || nameVs[i].indexOf("_month")>=0 || nameVs[i].indexOf("_day")>=0)    ) { continue; }
			if(  nodeVs[i]!="select" && cntVs[i]==1    ) { continue; }
			//-----------------
			if( (":"+banks.join(":")).indexOf(":"+colVs[i])>=0 ){continue;} banks.push( colVs[i] );
			//-----------------
			var colN = colVs[i].replace("_code","");
			src.push( "create table code_"+colN+"(")
			src.push( blank1 + colN+"_code"+blank1+"number(5)")
			src.push( blank1 + ", " +colN+"_name"+blank1 + "varchar(50)")
			src.push( blank1 + ", primary key( " + colN + "_code )");
			src.push( ");")
			//-----------------
			if( nodeVs[i]=="select" ) {
				var no = 1;
				$("body").find("[name='"+nameVs[i]+"']").find("option").each(function(){
					var value = $(this).attr("value"); if(value=="")  {return;}
					src.push( "insert into code_" + colN + " values ( " + (no++) + ", '" + value+ "' );")
				})
			}
			//-----------------
			if( typeVs[i]=="checkbox" || typeVs[i]=="radio") {
				var no = 1;
				$("body").find("[name='"+nameVs[i]+"']").each(function(){
					var value = $(this).attr("value"); if(value=="")  {return;}
					src.push( "insert into code_" + colN + " values ( " + (no++) + ", '" + value+ "' );")
				})
			}
			src.push("//--------------------------------");
		}
		//-----------------------------------------------------
		// 메인 테이블 소스 생성
		//-----------------------------------------------------
		banks = [];
		src.push("//--------------------------------");
		src.push("// 메인 테이블 생성 소스");
		src.push("//--------------------------------");
		src.push("create table xxx(")
		src.push( blank2 + "xxx_no number(9)")
		for( var i = 0 ; i<nameVs.length ; i++ ){
			var nameV2 = nameVs[i];
			//-----------------
			if( typeVs[i]=="checkbox" && cntVs[i]>1    ) {  continue }
			if( nameV2.indexOf("[")>=0    )              {  continue }
			//-----------------
			if( (":"+banks.join(":")).indexOf(":"+colVs[i])>=0 ){continue;} banks.push( colVs[i] );
			//-----------------
			src.push( blank2 + ", " + colVs[i] + blank2 + colDataTypeVs[i] );
		}
		src.push( blank2 +  "-----------------");
		src.push( blank2 +  ", primary key( xxx_no )");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( nameVs[i].indexOf("[")>=0    )              {  continue }
			if( is_code_colVs[i]==true ){
				src.push( blank2 + ", foreign key " + colVs[i] +" references code_" + nameVs[i] + "("+colVs[i]+")");
			}
		}
		src.push( ");");
		//-----------------------------------------------------
		// n행 저장 테이블 소스 생성
		//-----------------------------------------------------
		banks = [];
		var cnt1 = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( nameVs[i].indexOf("[")<0 && nameVs[i].indexOf("[")<0 ){ continue; }
			//---
			var nameV2 = nameVs[i].substring( 0, nameVs[i].indexOf("[") );
			//---
			if( (":"+banks.join(":")).indexOf(":"+nameV2)>=0 ){continue;} banks.push( nameV2 );
			//---
			src.push("//--------------------------------");
			src.push("// n행 저장 테이블 생성 소스");
			src.push("//--------------------------------");
			src.push("create tabe "+ nameV2 + "("); 
			src.push(blank3 + "xxx_no"+blank1+"number(5)"); 
			//-----------------
			for( var j = 0 ; j<nameVs.length ; j++ ){
				if( nameVs[j].indexOf(nameV2+"[")==0 ){
					src.push(  blank3 + ", " + colVs[j] +blank1 + colDataTypeVs[j] +blank1+"// " + typeVs[j] + " 양식"  );
				}
			}
			src.push( blank3 + "-------------------------");
			src.push( blank3 + ", foreign key xxx_no references xxx(xxx_no)");
			//-----------------
			for( var j = 0 ; j<nameVs.length ; j++ ){
				if( nameVs[j].indexOf(nameV2+"[")==0 ){
					var nameV4 = nameVs[j].substring(  nameVs[j].indexOf("]")+2 );
					if( is_code_colVs[j] ){
						src.push( blank3 + ", foreign key " + nameV4 +"_code references code_" + nameV4 + "("+nameV4+"_code)" );
					}
				}
			}
			src.push(")");
		}

		//-----------------------------------------------------
		// 서브 테이블 소스 생성
		//-----------------------------------------------------
		src.push("//--------------------------------");
		src.push("// checkbox 관련 테이블 생성 소스");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( typeVs[i]=="checkbox" && cntVs[i]>1  ) {			//alert(88);
			//if( typeVs[i]=="checkbox" && cntVs[i]>1 &&  nameVs[i].indexOf("[")<0  ) { 
				src.push("create table xxx_"+nameVs[i]+"(")
				src.push( blank2 + "xxx_no" + blank2 + "number(5)");
				src.push( blank2 + ", " + nameVs[i] + "_code" + blank2 + "number(5)");
				src.push( blank2 +  "-----------------");
				src.push( blank2 + ", foreign key xxx_no references xxx(xxx_no)");
				src.push( blank2 + ", foreign key "+nameVs[i]+"_code references code_"+nameVs[i]+"("+nameVs[i]+"_code)");
				src.push(");")
			}
		}

		//-----------------------------------------------------
		// 소스 출력
		//-----------------------------------------------------
		src.push( "</table>");
		$("body").append(  src.join("<br>")  + "<br>");
		return;
	}catch(e){
		alert("print_info_oracle_table2( ) 함수 호출 시 에러 발생!");  
	}
}

//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
function print_info_oracle_table2(  ){
	try{
		//-----------------------------------------------------
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
		var blank2 = blank1 + blank1; var blank3 = blank2 + blank1; var blank4 = blank2 + blank2; var blank5 = blank3 + blank2;
		var src = [];
		var data1 = "";
		//-----------------------------------------------------
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var nameVs = [];          var nodeVs = [];         var typeVs = [];        var cntVs = [];  
		var savedTabNs = [];      var savedTabTypes = [];  var savedcolNs = [];    var isFromcodeTabs = [];   var dataTypeVs = [];   
		var banks = [];

		//-----------------------------------------------------             alert(8)
		// 입력 양식 관련 여러 데이터를 여러 배열에 저장하기
		//----------------------------------------------------- main_tab  n_row_tab code_tab
		obj.each(function(i){
			var thisObj = $(this);
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");
			var cntV = $("body").find("[name='"+nameV+"']").length;
			//---
			var savedTabN = "xxx";
			var savedTabType = "main_tab";
			var savedcolN = nameV;
				if( nameV.indexOf("[")>=0 )       { 
					var tmp1 = nameV.substr(0, nameV.indexOf("[") ); 
					var tmp2 = nameV.substr(nameV.indexOf("]")+2 ); 
					//---
					if( typeV=="checkbox" && cntV>1 ) { 
						savedTabN = tmp1 + "_"+tmp2; 
						savedTabType = "n_row_tab_checkbox"; 
						savedcolN = tmp2+"_code";
						//isFromcodeTab = true;
					}
					else if( typeV=="radio" && cntV>1 ) { 
						savedTabN = tmp1; 
						savedTabType = "n_row_tab"; 
						savedcolN = tmp2+"_code";
						//isFromcodeTab = true;
					}
					else if(  nodeV=="select" &&  nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0    ) { 
						savedTabN = tmp1; 
						savedTabType = "n_row_tab";
						savedcolN = tmp2+"_code";
					}
					else{ 
						savedTabN = tmp1; 
						savedTabType = "n_row_tab"; 
						savedcolN = tmp2;
					}
				}
				else if( nameV.indexOf("[")<0 ){
					if(typeV=="checkbox" && cntV>1 ) { 
						savedTabN = "xxx_"+nameV;
						savedTabType = "main_tab_checkbox";
						savedcolN = nameV+"_code";
						//isFromcodeTab = true;
					} 
					else if( typeV=="radio" && cntV>1 ) { 
						savedcolN = nameV+"_code";
						//isFromcodeTab = true;
					} 
					else if(  nodeV=="select" &&  nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0    ) { 
						savedcolN = nameV+"_code";
					}
				}
			var isFromcodeTab = false;
				if( cntV>1 ) { isFromcodeTab = true; };
				if(  nodeV=="select" &&  nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0    ) { isFromcodeTab = true; };
			var dataTypeV = "varchar(50)";
				if( 
					nameV.indexOf("_no")>=0 
					|| ( (typeV=="checkbox" || typeV=="radio") && cntV>1 )
					|| ( nodeV=="select" && nameV.indexOf("_year")<0 && nameV.indexOf("_month")<0 && nameV.indexOf("_day")<0   ) 
				){ 
					dataTypeV = "number(5)";
				}
			//----------------
			if( (":"+banks.join(":")).indexOf(":"+nameV)>=0  ){  return;  }
			//----------------
			nameVs.push(  nameV  );          nodeVs.push(  nodeV  );                   typeVs.push(  typeV  );          cntVs.push( cntV  );
			savedTabNs.push(  savedTabN  );   savedTabTypes.push(  savedTabType  );    savedcolNs.push(  savedcolN  );   isFromcodeTabs.push( isFromcodeTab  ); dataTypeVs.push( dataTypeV  );
			//----------------
			banks.push( nameV );
		});		

		src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue colspan=10>테이블 생성 관련 입력 양식 태그 정보")
		src.push("<tr bgcolor=pink><th>번호<th>name값<th>태그명<th>태그타입명<th>개수<th>저장테이블타입<th>저장테이블명<th>저장컬럼명<th>code 테이블에서온거니?<th>자료형");

		var idx = nameVs.length;
		for( var i=0 ; i<nameVs.length ; i++ ){

			//if( i%2==1)
			//	src.push("<tr bgcolor=#D2D2D2>");
			//else
				src.push("<tr>");
			src.push("<td>"+idx--);
			src.push("<td>"+nameVs[i]);
			src.push("<td>"+nodeVs[i]);
			src.push("<td>"+typeVs[i]);
			src.push("<td>"+cntVs[i]);
			src.push("<td>"+savedTabTypes[i]);
			src.push("<td>"+savedTabNs[i]);
			src.push("<td>"+savedcolNs[i]);
			src.push("<td>"+isFromcodeTabs[i]);
			src.push("<td>"+dataTypeVs[i]);
		}
		src.push( "</table>");
		//-----------------------------------------------------
		// code 테이블 소스 생성
		//-----------------------------------------------------
		src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>테이블 생성 SQL<tr><td>")
		banks = [];
		src.push("//--------------------------------");
		src.push("// code 테이블 소스 생성");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			//-----------------
			if(  isFromcodeTabs[i] ){    //alert(9);
				//-----------------
				if( (":"+banks.join(":")).indexOf(":"+savedcolNs[i])>=0 ){continue;} banks.push( savedcolNs[i] );
				//-----------------
				var colN = savedcolNs[i].replace("_code","");
				src.push( "create table code_"+colN+"(")
				src.push( blank1 + colN+"_code"+blank1+"number(5)")
				src.push( blank1 + ", " +colN+"_name"+blank1 + "varchar(50)");
				src.push( blank1 + ", primary key( " + colN + "_code )");
				src.push( ");")
				//-----------------
				if( nodeVs[i]=="select" ) {
					var no = 1;
					$("body").find("[name='"+nameVs[i]+"']").find("option").each(function(){
						var value = $(this).attr("value"); if(value=="")  {return;}
						src.push( "insert into code_" + colN + " values ( " + (no++) + ", '" + value+ "' );")
					})
				}
				//-----------------
				if( typeVs[i]=="checkbox" || typeVs[i]=="radio") {
					var no = 1;
					$("body").find("[name='"+nameVs[i]+"']").each(function(){
						var value = $(this).attr("value"); if(value=="")  {return;}
						src.push( "insert into code_" + colN + " values ( " + (no++) + ", '" + value+ "' );")
					})
				}
				src.push("//--------------------------------");
			}
		}
		//-----------------------------------------------------
		// 메인 테이블 소스 생성
		//-----------------------------------------------------
		banks = [];
		src.push("//--------------------------------");
		src.push("// code 테이블 소스 생성");
		src.push("//--------------------------------");
		src.push("create table xxx(")
		src.push( blank2 + "xxx_no number(9)")
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="main_tab" ){
				var nameV2 = nameVs[i];
				//-----------------
				if( typeVs[i]=="checkbox" && cntVs[i]>1    ) {  continue }
				if( nameV2.indexOf("[")>=0    )              {  continue }
				//-----------------
				if( (":"+banks.join(":")).indexOf(":"+savedcolNs[i])>=0 ){continue;} banks.push( savedcolNs[i] );
				//-----------------
				src.push( blank2 + ", " + savedcolNs[i] + blank2 + dataTypeVs[i] );
			}
		}
		src.push( blank2 +  "-----------------");
		src.push( blank2 +  ", primary key( xxx_no )");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="main_tab" && isFromcodeTabs[i] ){
					src.push( blank2 + ", foreign key " + savedcolNs[i] +" references code_" + savedcolNs[i].replace("_code","")+ "("+savedcolNs[i]+")");
			}
		}
		src.push( ");");
		//-----------------------------------------------------
		// [메인 테이블] > [checkbox 테이블] 소스 생성
		//-----------------------------------------------------isFromcodeTabs
		src.push("//--------------------------------");
		src.push("// checkbox 관련 테이블 생성 소스");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( savedTabTypes[i]=="main_tab_checkbox"  ) {			//alert(88);
				var colN = savedcolNs[i].replace("_code","");
				src.push("create table xxx_"+colN+"(")
				src.push( blank2 + "xxx_no" + blank2 + "number(5)");
				src.push( blank2 + ", " + colN + "_code" + blank2 + "number(5)");
				src.push( blank2 +  "-----------------");
				src.push( blank2 + ", foreign key xxx_no references xxx(xxx_no)");
				src.push( blank2 + ", foreign key "+colN+"_code references code_"+colN+"("+colN+"_code)");
				src.push(");")
			}
		}
		//-----------------------------------------------------
		// [메인 테이블] > [n행 테이블] 소스 생성
		//-----------------------------------------------------
		banks = [];
		var cnt1 = 0;
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if(  savedTabTypes[i]=="n_row_tab" ){
				//---
				var nameV2 = nameVs[i].substring( 0, nameVs[i].indexOf("[") );
				//---
				if( (":"+banks.join(":")).indexOf(":"+nameV2)>=0 ){continue;} banks.push( nameV2 );
				//---
				src.push("//--------------------------------");
				src.push("// n행 저장 테이블 생성 소스");
				src.push("//--------------------------------");
				src.push("create tabe xxx_"+ savedTabNs[i] + "("); 
				src.push(blank3 + "xxx_"+savedTabNs[i]+"_no"+blank1+"number(5)"); 
				src.push(blank3 + ", xxx_no"+blank1+"number(5)"); 
				//-----------------
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
					//if( nameVs[j].indexOf(nameV2+"[")==0 ){
						src.push(  blank3 + ", " + savedcolNs[j] +blank1 + dataTypeVs[j] +blank1+"// " + typeVs[j] + " 양식"  );
					}
				}
				src.push( blank3 + "-------------------------");
				src.push( blank3 + ", primary key(  xxx_"+savedTabNs[i]+"_no )");
				src.push( blank3 + ", foreign key xxx_no references xxx(xxx_no)");
				//-----------------
				for( var j = 0 ; j<nameVs.length ; j++ ){
					if(  savedTabTypes[j]=="n_row_tab" && savedTabNs[j]==savedTabNs[i] ){
						var nameV4 = nameVs[j].substring(  nameVs[j].indexOf("]")+2 );
						if( isFromcodeTabs[j] ){
							src.push( blank3 + ", foreign key " + nameV4 +"_code references code_" + nameV4 + "("+nameV4+"_code)" );
						}
					}
				}
				src.push(");");
			}
		}
		//-----------------------------------------------------
		// [n행 테이블] 소속 checkbox 관련 테이블 생성 소스 생성
		//-----------------------------------------------------
		src.push("//--------------------------------");
		src.push("//  [n행 테이블] 소속 checkbox 관련 테이블 생성 소스");
		src.push("//--------------------------------");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			if( savedTabTypes[i]=="n_row_tab_checkbox"  ) {
				var colN = savedcolNs[i].replace("_code","");
				var tabN = "xxx_" + nameVs[i].substring(0,nameVs[i].indexOf("["));
				//---
				src.push("create table xxx_" + savedTabNs[i] + "(")
				src.push( blank2 + tabN + "_no" + blank1 + "number(5)"); 
				src.push( blank2 + ", " + colN + "_code" + blank2 + "number(5)" );
				src.push( blank2 + "-----------------");
				src.push( blank2 + ", foreign key xxx_" + tabN + "_no references xxx_" + tabN + "(  xxx_" + tabN + "_no )" );
				src.push( blank2 + ", foreign key " + colN + "_code references code_" + colN + "(" + colN + "_code )" );
				src.push(");")
			}
		}
		//-----------------------------------------------------
		// 소스 출력
		//-----------------------------------------------------
		src.push( "</table>");
		$("body").append(  src.join("<br>")  + "<br>");
		return;






	}catch(e){
		alert("print_info_oracle_table2( ) 함수 호출 시 에러 발생!");  
	}
}



*/



//**************************************************************
// [오라클 테이블 생성 소스]를 출력하는 함수 선언
//**************************************************************
/*function print_info_DTO2(  ){

		//-----------------------------------------------------
		var blank1 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; var blank2 = blank1 + blank1;   var blank3 = blank2 + blank1;
		var src = [];
		//-----------------------------------------------------
		var obj = $("body").find("input,select,textarea").not("[type=button],[type=submit],[type=reset]");
		var nameVs = [];  var nodeVs = [];  var typeVs = [];  var cntVs = [];  var xxxs = [];   
		var banks1 = []; var banks2 = [];
		//-----------------------------------------------------
		obj.each(function(i){
			var thisObj = $(this);
			var nameV = thisObj.attr("name") ;
			var nodeV = thisObj[0].nodeName.toLowerCase();
			var typeV = thisObj.attr("type");
			if( nameV.indexOf("[")>=0 || nameV.indexOf("[")>=0 ){ 
				var nameV2 = nameV.substring(0, nameV.indexOf("["));
				if( (":"+banks2.join(":")).indexOf(":"+nameV2)<0 ){
					xxxs.push( nameV2 );
					banks2.push(nameV2) 
				}
			}
			//-----
			if( (":"+banks1.join(":")).indexOf(":"+nameV)>=0  ){  return;  }
			//-----
			nameVs.push(  nameV  );  nodeVs.push(  nodeV  );  typeVs.push(  typeV  );  banks1.push( nameV );
			cntVs.push(  $("body").find("[name='"+nameV+"']").length  );
		});		
		//-----------------------------------------------------
		src.push("<br><table border=1 cellpadding=7><tr><td bgcolor=lightblue>DTO 생성<tr><td>");

		//-----------------------------------------------------
		// n행 저장 DTO 소스 만들기
		//-----------------------------------------------------
		for( var i = 0 ; i<xxxs.length ; i++ ){
			if(i==0) {
				src.push("//--------------------------------");
				src.push("// n행 저장 DTO");
				src.push("//--------------------------------");
				src.push("public class "+ xxxs[i].substr(0,1).toUpperCase() + xxxs[i].substr(1) + "{");
			}
			for( var j = 0 ; j<nameVs.length ; j++ ){
				if( nameVs[j].indexOf(xxxs[i]+"[")==0 ){
					src.push( blank3 + "private String "+  nameVs[j].substring( nameVs[j].indexOf("]")+2 )+";");
				}
			}
			src.push("}");
		}
		//-----------------------------------------------------
		src.push("//--------------------------------");
		src.push("// DTO");
		src.push("//--------------------------------");
		src.push("public class Xxx{");
		for( var i = 0 ; i<nameVs.length ; i++ ){
			var dataType = "String";
			if( typeVs[i]=="checkbox" && cntVs[i]>1 )                       { dataType = "List&lt;String&gt;"; }
			if( nameVs[i].indexOf("num")>=0 || nameVs[i].indexOf("no")>=0 ) { dataType = "int"; }
			//-----------------
			if( nameVs[i].indexOf("[")>=0 && nameVs[i].indexOf("]")>=0  ){
				src.push( blank3 + "private "+dataType+" " + nameVs[i] + ";");
			}
			else{
				src.push( blank3 + "private "+dataType+" " + nameVs[i] + ";");
			}
		}
		src.push("}");
		//-----------------------------------------------------
		src.push( "</table>");
		src.push( xxxs );
		//-----------------------------------------------------
		$("body").append(  src.join("<br>")  + "<br>");
}*/