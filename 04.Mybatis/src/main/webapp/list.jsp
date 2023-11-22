<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th scope="col">col1</th>
				<th scope="col">col2</th>
				<th scope="col">col3</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
		<tr>
		<td>${vo.col1}</td>
		<td>${vo.col2}</td>
		<td>${vo.col3}</td>
		</tr>
	</c:forEach>
		</tbody>
	</table>
</body>
</html>