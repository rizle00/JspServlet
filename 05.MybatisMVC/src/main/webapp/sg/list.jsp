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
			
				<form action="list.sg" method="post">
			<div class="row g-3 align-items-center">
			
				<div class="col-auto">
				
					<select class="form-select" aria-label="Default select example" name ="option">
						<option value="all" ${option eq 'all'? 'selected' : '' } >전체</option>
						<option value="employee_id" ${option eq 'employee_id' ? 'selected' : ''} >사번</option>
						<option value="name" ${option eq 'name' ? 'selected' : '' } >이름</option>
						<option value="department_name" ${option eq 'department_name' ? 'selected' : '' } >부서명</option>
					</select>

				</div>
				<div class="col-auto">
					<input type="text"  class="form-control" name="keyword" placeholder="검색어를 입력하세요" value="${keyword }"
						/>
				</div>
				<div class="col-auto">
					<input type="submit" value="검색" class="btn btn-danger">
					
				</div>
			</div>
				</form>
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
						<th scope="col">수정</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="10" class="text-center">데이터가 없습니다.</td>
							</tr>

						</c:when>
						<c:otherwise>
					<c:forEach items="${list }" var="vo" varStatus="i">
						<tr>
							<th scope="row">${i.index+1 }</th>
							<td>${vo.employee_id }</td>
							<td>${vo.name }</td>
							<td>${vo.email }</td>
							<td><fmt:formatNumber value="${vo.salary*1290 }" type="currency"/></td>
							<td>${vo.commission_pct }</td>
							<td>${vo.department_id }</td>
							<td>${vo.department_name }</td>
							<td><a onclick="updateSg(${i.index+1},${vo.employee_id});"
										class="btn btn-secondary">수정</a></td>
									<td><a onclick="deleteSg(${vo.employee_id});"
										class="btn btn-primary">삭제</a></td>
						</tr>
					</c:forEach>
					</c:otherwise>
					</c:choose>
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
										placeholder="이름 입력" required="required">

								</div>
								<div class="mb-3">
									<label for="email" class="form-label">이메일</label> <input
										type="email" class="form-control" id="email" name="email"
										placeholder="이메일" required="required">
								</div>

								<div class="mb-3">
									<label for="phone" class="phone">월급</label> <input
										type="number" class="form-control" id="phone" name="salary"
										placeholder="월급" required="required">
								</div>

								<div class="mb-3">
									<label for="phone" class="phone">인센티브</label> <input
										type="number" step="0.01" class="form-control" id="phone"
										name="commission_pct" placeholder="인센티브">
								</div>
								<div class="mb-3">
									<label for="department_id" class="department_id">부서번호</label> <input type="text"
										class="form-control" id="department_id" name="department_id"
										placeholder="부서번호" readonly="readonly">
								</div>
								<select class="form-select"  onchange="select(this.value)" name ="option" id = "depart">
								<c:forEach items="${depart}" var="vo">
								<option value="${vo.department_id }">${vo.department_name }</option>
								</c:forEach>
					</select>
								
								
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
		
			<div class="modal fade" id="updateModal" tabindex="-1"
				aria-labelledby="updateModalLabel" aria-hidden=true>
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="updateModalLabel">정보 수정</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<form action="update.sg" method="post">
						<input type = hidden name = "employee_id">
							<div class="modal-body" >

								<div class="mb-3">
									<label for="name" class="form-label">이름</label> <input
										type="text" class="form-control" id="name" name="name"
										placeholder="이름 입력" >

								</div>
								<div class="mb-3">
									<label for="email" class="form-label">이메일</label> <input
										type="email" class="form-control" id="email" name="email"
										placeholder="이메일" >
								</div>

								<div class="mb-3">
									<label for="phone" class="phone">월급</label> <input
										type="number" class="form-control" id="phone" name="salary"
										placeholder="월급" >
								</div>

								<div class="mb-3">
									<label for="phone" class="phone">인센티브</label> <input
										type="number" step="0.01" class="form-control" id="phone"
										name="commission_pct" placeholder="인센티브">
								</div>
								<div class="mb-3">
									<label for="phone" class="phone">부서번호</label> <input
										type="number" class="form-control" id="phone"
										name="department_id" placeholder="부서번호" >
								</div>
								<select class="form-select"  onchange="select(this.value)" name ="option" id = "departU">
								<c:forEach items="${depart}" var="vo">
								<option value="${vo.department_id }">${vo.department_name }</option>
								</c:forEach>
					</select>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">취소</button>
								<input type="submit" class="btn btn-primary" value="수정" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript">
	function select(depart_id) {
		
		$('#insertModal input[name=department_id]').val(depart_id);
		$('#updateModal input[name=department_id]').val(depart_id);
		
	}
	function updateSg(idx, employee_id) {
		console.log(idx + " : " + employee_id);
		var name = $('table tr:eq('+ idx+') td:eq(1)').text();
		var email = $('table tr:eq('+ idx+') td:eq(2)').text();
		var salary = $('table tr:eq('+ idx+') td:eq(3)').text();
		var commission_pct = $('table tr:eq('+ idx+') td:eq(4)').text();
		var department_id = $('table tr:eq('+ idx+') td:eq(5)').text();
		var department_name = $('table tr:eq('+ idx+') td:eq(6)').text();
		$('#updateModal input[name=employee_id]').val(employee_id);
		$('#updateModal input[name=name]').val(name);
		$('#updateModal input[name=email]').val(email);
		$('#updateModal input[name=salary]').val(salary);
		$('#updateModal input[name=commission_pct]').val(commission_pct);
		$('#departU').val(department_id).prop("selected", true);
		$('#updateModal input[name=department_name]').val(department_name);
		/* $('#updateModal input[name=department_id]').val(department_id); */
		$('#updateModal').modal('show');
		
	} 
	function deleteSg(employee_id) {
		if(confirm('정말 삭제 하시겠습니까?')){
			location.href='delete.sg?employee_id='+employee_id;
		}
	}
	
		$('#insertModalBtn').on("click", function() {
			$('#insertModal').modal('show');

		})
	</script>
	<%@ include file="/customer/footer.jsp"%>

</body>

</html>