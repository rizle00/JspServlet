<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<body>
	<%@ include file="/customer/header.jsp"%>

	<div class="container">
  <div class="row">
  <form action="joinpage.me" class="col-xs-12 col-sm-12 col-md-12">
  <h2>회원가입</h2>
  <div class="form-group">
      <input type="text" class="form-control" id="user_id" placeholder="Enter id *" name="user_id" required>
      <label for="user_id">아이디</label>
    </div>
	
	<div class="form-group">
      <input type="password" class="form-control" id="user_pw" placeholder="Enter password *" name="user_pw" required>
      <label for="user_pw">비밀번호</label>
    </div>
    <div class="form-group">
      <input type="password" class="form-control" id="user_pwc" placeholder="repeat password *" required>
      <label for="user_pwc">비밀번호 확인</label>
    </div>
    <div class="form-group">
      <input type="text" class="form-control" id="name" placeholder="Enter Name *" name="name" required>
      <label for="name">이름</label>
    </div>
	
    	<div class="form-group">
      <input type="email" class="form-control" id="email" placeholder="Enter email *" name="email" required>
      <label for="email">이메일</label>
    </div>
    <a class="btn btn-danger align-middle" id="btn_post" >주소 찾기</a>
    <div class="form-group">
      <input type="text" class="form-control" id="address"  name="address" readonly="readonly">
      <label for="address">주소</label>
    </div><div class="form-group">
      <input type="text" class="form-control" id="post"  name="post" readonly="readonly">
      <label for="post">우편번호</label>
    </div>
	
    
    <a class="btn btn-success">회원가입 <i class="glyphicon glyphicon-send"></i></a>
  </form>
  </div>
</div>
	<%@ include file="/customer/footer.jsp"%>

</body>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

$('#btn_post').click(function () {
	
 new daum.Postcode({
        oncomplete: function(data) {
       // 	let address = data.userSelectedType == 'R' ? data.roadAddress : data.jibunAddress;
        	
        	$('#address').val(data.roadAddress);
        	$('#post').val(data.zonecode);
        }
    }).open();
});
</script>

</html>