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

	<section class="page-section">
		<div class="container">
			<button class="btn btn-danger align-middle" id="insertModalBtn" >사원
				추가</button>
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">사번</th>
						<th scope="col">이름</th>
						<th scope="col">이메일</th>
						<th scope="col">월급</th>
						<th scope="col">인센티브</th>
						<th scope="col">부서번호</th>
						<th scope="col">부서명</th>
						<th scope="col">매니저번호</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="vo" varStatus="i">
						<tr>
							<th scope="row">${i.index+1 }</th>
							<td>${vo.employee_id }</td>
							<td>${vo.name }</td>
							<td>${vo.email }</td>
							<td>${vo.salary }</td>
							<td>${vo.commission_pct }</td>
							<td>${vo.department_id }</td>
							<td>${vo.department_name }</td>
							<td>${vo.manager_id }</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="modal fade" id="insertModal" tabindex="-1"
				aria-labelledby="insertModalLabel" aria-hidden=true>
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="insertModalLabel">사원 추가</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<form action="insert.sg" method="post">
							<div class="modal-body">

								<div class="mb-3">
									<label for="name" class="form-label">이름</label> <input
										type="text" class="form-control" id="name" name="name"
										placeholder="이름 입력">

								</div>
								<div class="mb-3">
									<label for="email" class="form-label">이메일</label> <input
										type="email" class="form-control" id="email" name="email"
										placeholder="이메일">
								</div>

								<div class="mb-3">
									<label for="phone" class="phone">월급</label> <input
										type="number" class="form-control" id="phone" name="salary"
										placeholder="월급">
								</div>

								<div class="mb-3">
									<label for="phone" class="phone">인센티브</label> <input
										type="number" class="form-control" id="phone"
										name="commission_pct" placeholder="인센티브">
								</div>
								<div class="mb-3">
									<label for="phone" class="phone">부서번호</label> <input
										type="number" class="form-control" id="phone"
										name="department_id" placeholder="부서번호">
								</div>
								<div class="mb-3">
									<label for="phone" class="phone">부서명</label> <input type="text"
										class="form-control" id="phone" name="department_name"
										placeholder="부서명">
								</div>
								<div class="mb-3">
									<label for="phone" class="phone">매니저번호</label> <input
										type="number" class="form-control" id="phone"
										name="manager_id" placeholder="매니저번호">
								</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">취소</button>
								<input type="submit" class="btn btn-primary" value="추가" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript">
		$('#insertModalBtn').on("click", function() {
			$('#insertModal').modal('show');

		})
	</script>
	<%@ include file="/customer/footer.jsp"%>

</body>

</html>