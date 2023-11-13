<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 자바코드 + HTML 태그</h1>
	<% int vInt =10;
	String vStr ="테스트중입니다";
	double vDb = 3.14;
	ArrayList<String> list = new ArrayList<>();
	list.add("K");
	list.add("M");
	list.add("J");%>
	
	<p style="font-size:2em;">
	<%="vInt = "+vInt %><br>
	<%="vStr = "+vStr %><br>
	<%="vDb = "+vDb %><br>
	<%="list 0 = "+list.get(0) %><br>
	<%="list 1 = "+list.get(1) %><br>
	<%="list 2 = "+list.get(2) %><br>
	</p>
</body>
</html>