<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 스크립트(선언, 표현)</h1>
	<%! String strVar = "Kmj"; %><!-- 전역변수 선언  -->
	<% String strLv = "지역변수"; %>
	
	<%=strVar %>
	<h1>HTML태그 strVar</h1>
	<h2>HTML태그 <%=strLv %></h2>
	<%! int sVal =0; %><!-- 스태틱 전역변수  -->
	<% int lVal = 0; %><!-- 지역변수 -->
	<h3>sVal <%=sVal++ %></h3>
	<h3>lVal <%=lVal++ %></h3>
	<% String [] strArr = {"J", "S", "P", "T", "A", "G"}; %>
	<p><%=strArr[0] + strArr[1] +strArr[2] +strArr[3] +strArr[4] + strArr[5]  %></p>
	<% %>
	
</body>
</html>