<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>For,If문</h1>

<% 
	int odd =0;
	int even =0;
 for(int i=1; i<=100; i++){ 

 if(i%2==0){ 
 even+=i; } else { 
	odd+=i; }
} %>

<p style="color: blue">홀수의 합 : <%=odd %> </p>
<p style="color: red">짝수의 합 : <%=even %> </p>
<p>총 합 : <%=odd+even %></p>
</body>
</html>