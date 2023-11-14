<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 디렉티브 태그의 인클루드 기능을 이용해서 페이지 붙이는 처리를 함.
		JSP(View)는 파라메터를 넘겨서 붙이는게 가능함. (<- 코드 처리를 JSP내부에서는 태그 형태로만 하는게 편함)
		Servlet(Controller)
		  -->
		  <jsp:include page="/include/header.jsp">
		  		<jsp:param value="kmj" name="name"/>
		  </jsp:include>
</body>
</html>