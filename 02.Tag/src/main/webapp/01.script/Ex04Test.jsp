<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%for(int i =2; i<10; i++){%>
	<tr><% for(int j=1; j<10; j++){%>
		<td><%=i+"x"+j+"="+(i*j)%></td>
	<%}%></tr>
<%} %>
</table>

<table border="1">
<%for(int i =1; i<10; i++){%>
	<tr><% for(int j=2; j<10; j++){%>
		<td><%=j+"x"+1+"="+(i*j)%></td>
	<%}%></tr>
<%} %>
</table>

<table border="1">
<%for(int i =2; i<10; i++){
if (i%2==0){%>
	<tr style="background: yellow">
	<% for(int j=1; j<10; j++){%>
	<td><%=i+"x"+j+"="+(i*j)%></td>
<%}%></tr>
<%} else { %>
<tr style="background: green">
	<% for(int j=1; j<10; j++){%>
	<td><%=i+"x"+j+"="+(i*j)%></td>
<%}%></tr>
<%}} %>	
</table>


</body>
</html>