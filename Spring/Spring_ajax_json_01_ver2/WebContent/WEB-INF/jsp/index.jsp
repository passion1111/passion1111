<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<script type="text/javascript">
 /* $(document).ready(function(){
  $("#ajaxBtn").click(function(){
   $.ajax({
    type:"post",
    url:"testJson.kosta",
    data:"command=testAjax2&name=java",
    success:function(data){ //callback  
       $("#menuView").empty();
       alert(data);
       var resv="";
       $.each(data.menu,function(index,value){
    	   console.log(index + "/" + value);
	       resv += value.firstName+"<br />";
    	   resv +=index;
       });
       
       $("#menuView").append(resv);
    }
   });
  });
 });  */
 //1단계
/* $(document).ready(function(){
	  $("#ajaxBtn").click(function(){
		  var deleteWidgetId = new Array(); //array created 
			 deleteWidgetId[0] = "a";//adding values 
			 deleteWidgetId[1] = "b"; 
	   $.ajax({
	    type:"post",
	    url:"testJson.kosta",
	    data:"command=testAjax2&name=java&arr="+deleteWidgetId,
	    success:function(data){ //callback  
	       $("#menuView").empty();
	       alert(data);
	       var resv="";
	       $.each(data.menu,function(index,value){
	    	   console.log(index + "/" + value);
		       resv += value+"<br />";
	    	   resv +=index;
	       });
	       
	       $("#menuView").append(resv);
	    }
	   });
	  });
	 }); 
	 */
//2단계
 /* $(document).ready(function(){
	  $("#ajaxBtn").click(function(){
	   $.ajax({
	    type:"post",
	    url:"testJson2.kosta",
	    data:"command=testAjax2&name=java",
	    success:function(data){ //callback  
	       $("#menuView").empty();
	       //alert(data);
	       var resv="";
	       $.each(data.menu,function(index,value){
	    	   console.log(index + "/" + value);
		       resv += value.beer+"<br />";
		       resv += value.food+"<br />";
	    	   resv +=index +"<br />";
	      });
	       
	       $("#menuView").append(resv);
	    }
	   });
	  });
	 });  */
//3단계
 /* $(document).ready(function(){
	 var deleteWidgetId = new Array(); //array created 
	 deleteWidgetId[0] = "a";//adding values 
	 deleteWidgetId[1] = "b"; 
  $("#ajaxBtn").click(function(){
   $.ajax({
    type:"post",
    url:"testJson3.kosta",
    data:{ deleteWidgetId : deleteWidgetId },
    success:function(data){ //callback  
       $("#menuView").empty();
       alert(data);
       var resv="";
       $.each(data.data,function(index,value){
    	   console.log(index + "/" + value);
	       resv += value.firstName+ + "/" +  value.email + "<br />";
    	   resv +=index;
       });
       
       $("#menuView").append(resv);
    }
   });
  });
 });  */
 
 /*  $(document).ready(function(){
	 var deleteWidgetId = new Array(); //array created 
	 deleteWidgetId[0] = "a";//adding values 
	 deleteWidgetId[1] = "b"; 
	 console.log(deleteWidgetId);
	 $("#ajaxBtn").click(function(){
	   $.ajax({
	    type:"POST",
	    url:"testJson4.kosta",
	    data: { deleteWidgetId : deleteWidgetId },
	    success:function(data){ //callback  
	        $("#menuView").empty();
	        alert(data);
	        var resv="";
	        $.each(data.data,function(index,value){
	     	   console.log(index + "/" + value);
	 	       resv += value.firstName+ + "/" +  value.email + "<br />";
	     	   resv +=index;
	        });
	        
	        $("#menuView").append(resv);
	     }
	    });
	   });
	  }); */ 
	  
	  $(document).ready(function(){
		  var search = {
			      "pname" : "bhanu",
			      "lname" :"prasad"
			   }
		  console.log(JSON.stringify(search));
		  $("#ajaxBtn").click(function(){
			   $.ajax({											//서버로 문자 데이터를 보내는 것이 아니라 브라우저로 요청시에는   html/text	
				 												// 서버 요청시에는 application/text, 서버요청시에 json으로 보내려면 application/json
				      type: "POST",                                     //보내는 데이터가 text면 application/text
				      contentType : 'application/json; charset=utf-8', //contentType 은 보내는 데이터가 json이면 application/json
				      dataType : 'json',   // dataType 은 호출되는 서버쪽의 함수의 리턴타입
				      url: "testJson6.kosta",
				      data: JSON.stringify(search), // Note it is important
				      success :function(result) {
				       // do what ever you want with data
				       alert(result);
				     }
				  });
			  
		  });
		  
		  
	  });
	/*   function searchText() {
		   var search = {
		      "pName" : "bhanu",
		      "lName" :"prasad"
		   }
		   $.ajax({
		      type: "POST",
		      contentType : 'application/json; charset=utf-8',
		      dataType : 'json',
		      url: "testJson6.kosta",
		      data: JSON.stringify(search), // Note it is important
		      success :function(result) {
		       // do what ever you want with data
		     }
		  });
		}
	   */
	   $(document).ready(function(){
		   var params = {'test1'   : 'test1', 'test2'   : 'test'};
		   console.log(JSON.stringify(params));
		   
		   $("#ajaxBtn2").click(function(){
			   $.ajax({
				    url: "testJson7.kosta", 
				   /*  headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json' 
				    }, */
				    contentType: 'application/json',
				    //mimeType: 'application/json',
				    type: 'POST',
				    data: JSON.stringify(params), 
				    dataType: 'json', 
				    //timeout: 2000, 
				    //async:false, 
				    //contentType: "application/json", 
				    errorMsg: "데이터 조회시 오류발생.",
				    success:function(jsonObj){
				 	console.log(jsonObj);
				    }
				   });
			   
		   });
		 
		
		   
		   
	   });
	   
	  
	  
</script>
</head>
<body>
<input type="button" value="spring-json test" id="ajaxBtn">
<input type="button" value="spring-json test" id="ajaxBtn2">
<br>
<span id="menuView"></span>

</body>
</html>






