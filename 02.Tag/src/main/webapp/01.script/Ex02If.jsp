<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>If문</h1>
<%! int iVar = 0; %>
<p><%=iVar++ %></p>
<%if(iVar%2==0) { %>
	<p>짝수<%=iVar %>
	<%} else { %>
	홀수<%=iVar %><%} %></p>
	
</body>
</html>