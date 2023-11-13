<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>반복문</h3>
	<% for(int i=0; i<10; i++){%>
		<p>연속으로 출력하는게 가능한가?<%=i+1 %></p>
	<% }%>	
</body>
</html>