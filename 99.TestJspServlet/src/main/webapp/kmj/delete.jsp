<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%@ include file="/include/header.jsp"%>
   <section class="page-section portfolio" id="portfolio">
            <div class="container">
                <!-- Portfolio Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">삭제 화면</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
               
                <table class="table">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">이름</th>
				<th scope="col">생년월일</th>
				<th scope="col">주소</th>
				<th scope="col">전화번호</th>
				<th scope="col">삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
		<tr>
		<td>${dto.idx}</td>
		<!-- </a> -->
		<td>${dto.username}</td>
		<td>${dto.birthyear}</td>
		<td>${dto.address}</td>
		<td>${dto.mobile}</td>
		<td><a href="delete?username=${dto.username}" class="btn btn-danger">삭제</a></td>
		</tr>
	</c:forEach>
		</tbody>
	</table>
	 </div>
        </section>
  <!-- <a href="newpage" class="btn btn-info">추가 화면</a> -->
	
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>