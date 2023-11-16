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
	<%@ include file="/include/header.jsp"%>
	

	<table class="table">
		<thead>
			<tr>
				<th scope="col">이름</th>
				<th scope="col">출생년도</th>
				<th scope="col">주소</th>
				<th scope="col">전화번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
		<tr>
		<th scope ="row"><a href="detail?name=${dto.username}&mobile=${dto.mobile}">${dto.username}</a></td><!-- 파라미터  -->
		<td>${dto.birthday}</td>
		<td>${dto.address}</td>
		<td>${dto.mobile}</td>
		</tr>
	</c:forEach>
		</tbody>
	</table>
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>