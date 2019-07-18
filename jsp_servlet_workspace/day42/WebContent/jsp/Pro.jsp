<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
 <% 
 	int elements=0;
 	int sum=0;
 	for(int i=1;i<=100;i++){
 		if(i%3==0){
 			sum+=i;
 			elements++;
 		}
 		
 	}
 %>
	합은<%= sum %> 
	갯수는<%=elements %>

 
</body>
</html>