<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<body>
	<%@ include file="/customer/header.jsp"%>

	<h1>스코프</h1>
	<%
		//페이지 내에서 데이터를 유지하기 위한 객체(PageContext) : 지역변수
		
		pageContext.setAttribute("pagectx", "PAGECONTEXT");
		request.setAttribute("jsprequest", "JSPREQUEST");
		session.setAttribute("jspsession", "JSPSESSION");
		application.setAttribute("jspappctx", "JSPAPPCTX"); 
	%>
	<p><%=request.getAttribute("request") %></p>
	<p><%=session.getAttribute("session") %></p>
	<p>${request }</p>
	<p>${session }</p>
	
	<a href="scope/test.jsp">다음 페이지에서 데이터를 가지고 있느닞 확인하기 위한 이동</a>
	<%@ include file="/customer/footer.jsp"%>

</body>

</html>