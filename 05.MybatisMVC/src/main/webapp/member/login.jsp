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

	<section class="vh-100">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">


        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

          <form style="width: 23rem;" method="post" >


            <div class="form-outline mb-4">
              <input type="text" id="user_id" name="user_id" class="form-control form-control-lg" placeholder="아이디 입력"/>
              <label class="form-label" for="user_id">아이디</label>
            </div>

            <div class="form-outline mb-4">
              <input type="password" id="user_pw" name="user_pw" class="form-control form-control-lg" placeholder="비밀번호 입력" />
              <label class="form-label" for="user_pw">패스워드</label>
            </div>

            <div class="pt-1 mb-4">
              <a class="btn btn-info btn-lg btn-block" onclick="login();" >Login</a>
            </div>


          </form>

        </div>

      </div>
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
          alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
  </div>
</section>
<script type="text/javascript">
	function login() {
		if($('#user_id').val() == ''){
			alert('아이디를 입력하세요');
			$('#user_id').focus(); //커서 입력
			return;
		} else if($('#user_pw').val() == ''){
			alert('비밀번호를 입력하세요');
			$('#user_pw').focus(); //커서 입력
			return;
		}
		
		/* 페이지를 새로 요청 x -> Controller나 다른 API에 데이터만 따로 요청을 하는 형태 -> 비동기 통신
		XMLHttpRequest 객체, Http 객체 : 코드가 조금 복잡함.
		Jquery : Ajax
		type : method
		url : 어디에 요청할껀지
		data : 어떤것을 전송할건지
		success : 실행되는 펑션
		error : 실행되는 펑션 */
		
		$.ajax({
			type:'post',
			url: 'login.me',
			data: { user_id:$('#user_id').val(), user_pw:$('#user_pw').val()},
			success : function (response){
				console.log(response);
			},
			error : function (req, text){
				alert(req.status + '오류! 다시 로그인 시도를 해주세요')
			}
			
		})
	}
	

</script>
	<%@ include file="/customer/footer.jsp"%>

</body>

</html>