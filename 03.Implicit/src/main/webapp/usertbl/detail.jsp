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
	<form action="update" method="post"><!-- / <- 가 없으면 바로 추가됨  -->
  <div class="form-group">
    <label >이름</label>
    <%-- <input type="text" class="form-control" name="username" value = "${dto.username }" readonly="readonly"> --%>
    <input type="hidden" name="username" value="${dto.username }">
    <p>${dto.username }</p>    
  </div>
  <div class="form-group">
    <label >출생년도</label>
    <input type="number" class="form-control" name="birthyear" value = "${dto.birthday }">
  </div>
  <div class="form-group">
    <label >주소</label>
    <input type="text" class="form-control" name="address" value = "${dto.address }">
  </div>
  <div class="form-group">
    <label >전화</label>
    <input type="text" class="form-control" name="mobile" value = "${dto.mobile }">
  </div>
  <input type="submit" value="수정하기">
</form>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>