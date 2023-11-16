<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div class="container px-5 my-5">
		<div class="text-center mb-5">
			<form action="ex02" method="post">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Email
						address</label> <input type="text" class="form-control" name="email" required="required"
						id="exampleInputEmail1" aria-describedby="emailHelp">
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<input type="password" class="form-control" name="pw" required="required"
						id="exampleInputPassword1">
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>
				</div>
				<input type="submit" class="btn btn-primary" value="전송">
			</form>
		</div>
	</div>
	<%@ include file="/include/footer.jsp"%>

</body>
</html>