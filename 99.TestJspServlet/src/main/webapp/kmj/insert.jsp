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
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">추가
				화면</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<form action="newpage" method="post">
				<!-- / <- 가 없으면 바로 추가됨  -->
				<div class="form-group">
					<label>이름</label> <input type="text" class="form-control"
						name="username" placeholder="이름 입력" required="required">
				</div>
				<div class="form-group">
					<label>출생년도</label> <input type="number" class="form-control"
						name="birthyear" placeholder="생년 월일 입력" required="required">
				</div>
				<div class="form-group">
					<label>주소</label> <input type="text" class="form-control"
						name="address" placeholder="주소 입력" required="required">
				</div>
				<div class="form-group">
					<label>전화</label> <input type="text" class="form-control"
						name="mobile" placeholder="전화번호 입력">
				</div>
				<input type="submit" value="추가">
			</form>
		</div>
	</section>

	<%@ include file="/include/footer.jsp"%>
</body>
</html>